package risk.network;

import java.io.IOException;
import java.util.LinkedList;
import risk.common.Logger;
import risk.protocol.command.Command;

public class QueuedSender extends Thread implements IOutputQueue {
    private LinkedList<Command> queue = new LinkedList<Command>();
    private Object queueLock = new Object();
    private boolean shouldQuit = false;
    private NetworkClient nc;
    private int timeout;

    public QueuedSender(String threadName, NetworkClient nc, int timeout) {
        super(threadName);
        this.nc = nc;
        this.timeout = timeout;
    }

    @Override
    public void queueForSend(Command cmd) {
        queueForSend(cmd, false);
    }
    
    @Override
    public void queueForSend(Command cmd, boolean last) {
        synchronized (queueLock) {
            queue.add(cmd);
            if (last) {
                Logger.logdebug("Setting QueuedSender to quit");
                this.shouldQuit = true;
            }
            queueLock.notify();
            Logger.logdebug("Added command to queue");
            
        }
    }

    @Override
    public void run() {
        try {
            Logger.loginfo("QueuedSender started");
            while (!interrupted()) {
                Command cmd;
                synchronized (queueLock) {
                    if (queue.isEmpty()) {
                        try {
                            queueLock.wait(timeout);
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                    if (queue.isEmpty()) {
                        if (shouldQuit) {
                            Logger.logdebug("QueuedSender got quit command");
                            break;
                        } else {
                            continue;
                        }
                    }
                    Logger.logdebug("Removing command from queue");
                    cmd = queue.removeFirst();
                }
                try {
                    nc.writeCommand(cmd);
                } catch (IOException e) {
                    Logger.logexception(e, "Cannot send command");
                }
            }
        } catch (Exception e) {
            Logger.logexception(e, "Unhandled exception");
        } finally {
            Logger.loginfo("QueuedSender stops");
        }
    }
}
