package risk.game.server;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

import risk.common.Logger;
import risk.game.Player;
import risk.network.IOutputQueue;
import risk.network.NetworkClient;
import risk.network.QueuedSender;
import risk.network.SocketClosedException;
import risk.protocol.command.Command;
import risk.protocol.command.CommandFromClient;
import risk.protocol.command.PlayerJoinedCmd;

/**
 * ClientHandler handles a client connected to the server.
 */
public class ClientHandler extends Thread implements IOutputQueue {
    private Player player;
    private NetworkClient nc;
    private CommandExecutor commandExecutor;
    private ConnectionAcceptor connectionAcceptor;
    private static final int SOCKET_INTERRUPT_TIMEOUT = 1000;
    private static final int SENDER_INTERRUPT_TIMEOUT = 1000;
    private QueuedSender queuedSender;
    
    public ClientHandler(ThreadGroup tg, Socket s, CommandExecutor commandExecutor, ConnectionAcceptor connectionAcceptor) throws IOException {
        super(tg, "");
        String threadName = tg.getName() + s.getInetAddress() + ":" + s.getPort();
        setName(threadName);
        Logger.loginfo("Created clientHandler for new client");
        nc = new NetworkClient(s, SOCKET_INTERRUPT_TIMEOUT, true);
        this.commandExecutor = commandExecutor;
        this.connectionAcceptor = connectionAcceptor;
        queuedSender = new QueuedSender(threadName + "-sender", nc, SENDER_INTERRUPT_TIMEOUT);
        queuedSender.start();
    }
    
    @Override
    public void run() {
        try {
            try {
                Logger.loginfo("ClientHandler started");
                while (!interrupted()) {
                    try {
                        Command cmd = nc.readCommand();
                        commandExecutor.QueueCommand(new CommandFromClient(cmd, this));
                    } catch (SocketTimeoutException e) {
                    } catch (SocketClosedException e) {
                        Logger.loginfo("Client closed socket");
                        break;
                    } catch (IOException e) {
                        Logger.logexception(e, "Couldn't read Command");
                        break;
                    }
                }
            } finally {
                onExit();
            }
        } catch (Exception e) {
            Logger.logexception(e, "Uncaught exception!");
        }
    }

    private void onExit() {
        Logger.loginfo("ClientHandler stops.");
        if (queuedSender != null) {
            queuedSender.interrupt();
        }
        connectionAcceptor.connectionLost(this);
    }

    public void queuePlayerJoinedForSend(Player p) {
        queueForSend(new PlayerJoinedCmd(p, p.getName().compareTo(player.getName()) == 0));
    }
    
    @Override
    public void queueForSend(Command cmd) {
        queuedSender.queueForSend(cmd);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
