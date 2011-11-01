package risk.game.server;

import java.io.IOException;
import java.net.*;
import java.util.LinkedList;
import risk.common.Logger;
import risk.common.RiskIO;
import risk.common.Settings;
import risk.game.Player;
import risk.protocol.command.Command;

public class GameServer extends Thread implements ConnectionAcceptor, CommandExecutor {
    /**
     * A listener that accepts connections from clients.
     */
    private ConnectionListener listener;

    /**
     * A list of ClientHandlers that handles clients.
     */
    private LinkedList<ClientHandler> clientHandlers = new LinkedList<ClientHandler>();
    
    /**
     * A ThreadGroup for the ClientHandler threads.
     */
    private ThreadGroup threadGroup = new ThreadGroup("ClientHandlerGroup");
    
    /**
     * This object protects the ClientHandler list from being accessed/modified
     * from more than one thread at the same time.
     */
    private Object clientHandlerLock = new Object();
    
    /**
     * This object protects the CommandQueue from being accessed/modified
     * from more than one thread at the same time.
     */
    private Object commandLock = new Object();

    public GameServer() {
        super("GameServerThread");
    }

    /**
     * Call this when the GameServer thread exits. This will do some cleanup
     * and interrupt other threads.
     */
    private void onExit() {
        Logger.loginfo("Exiting, interrupting server threads");
        if (listener != null) {
            try {
                listener.interrupt();
            } catch (SecurityException e) {
                Logger.logexception(e, "Insufficient permissions to interrupt thread");
            }
        }

        synchronized (clientHandlerLock) {
            for (ClientHandler ch : clientHandlers) {
                try {
                    ch.interrupt();
                } catch (SecurityException e) {
                    Logger.logexception(e, "Insufficient permissions to interrupt thread");
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            try {
                Logger.loginfo("Server started");

                // Start listener thread
                startListening();

                // Wait for incoming commands
                handleCommands();
            } finally {
                onExit();
            }
        } catch (Exception e) {
            Logger.logexception(e, "Unhandled exception");
        }
    }

    /**
     * This function starts the listener thread that will wait for incoming connections.
     */
    private void startListening() {
        Logger.logdebug("Starting listener thread");
        listener = new ConnectionListener(Settings.getInstance().getServerListenPort(), this);
        listener.start();
    }

    /**
     * This function waits for Commands being put to CommandQueue, and processes them.
     */
    private void handleCommands() {
        while (!interrupted()) {
            try {
                // TODO: replace with command handling
                sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    /**
     * This function is called by ConnectionListener upon a new connection.
     * It creates a new ClientHander for the connection.
     */
    @Override
    public void newConnection(Socket s) {
        Logger.loginfo("New connection arrived from " + s.getInetAddress() + ":" + s.getPort());
        try {
            ClientHandler tmp = new ClientHandler(threadGroup, s, this);
            synchronized (clientHandlerLock) {
                clientHandlers.add(tmp);
                tmp.start();
            }
        } catch (IOException e) {
            Logger.logexception(e, "Client connection LOST!");
        }
    }

    /**
     * This function is called by ConnectionListener when ConnectionListener exits.
     */
    @Override
    public void stoppedListening() {
        Logger.logdebug("Stopped listening.");
    }

    /**
     * This function allows incoming commands to be put in a queue, that will be
     * processed by the GameServer.
     */
    @Override
    public void QueueCommand(Command cmd, Player player) {
        synchronized (commandLock) {
            // TODO: add to command queue
        }
    }
}
