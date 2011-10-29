package risk.game.server;

import java.io.IOException;
import java.net.*;
import java.util.LinkedList;
import risk.common.Logger;
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
    
    private Object clientHandlerLock = new Object();
    private Object commandLock = new Object();

    public GameServer() {
        super("GameServerThread");
    }

    @Override
    public void run() {
        Logger.loginfo("Server started");
        listener = new ConnectionListener(Settings.getInstance().getServerListenPort(), this);
        listener.start();        
    }

    @Override
    public void newConnection(Socket s) {
        Logger.loginfo("New connection arrived from " + s.getInetAddress() + ":" + s.getPort());
        try {
            ClientHandler tmp = new ClientHandler(s, this);
            synchronized (clientHandlerLock) {
                clientHandlers.add(tmp);
                tmp.start();
            }
        } catch (IOException e) {
            Logger.logexception(e, "Client connection LOST!");
        }
    }

    @Override
    public void stoppedListening() {
        Logger.logdebug("Stopped listening.");
    }

    @Override
    public void QueueCommand(Command cmd, Player player) {
        synchronized (commandLock) {
            // TODO: add to command queue
        }
    }
}
