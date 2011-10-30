package risk.game.server;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

import risk.common.Logger;
import risk.game.Player;
import risk.network.NetworkClient;
import risk.protocol.ServerProtocolHandler;
import risk.protocol.command.Command;

/**
 * ClientHandler handles a client connected to the server.
 */
public class ClientHandler extends Thread {
    private Player player;
    private NetworkClient nc;
    private ServerProtocolHandler sph;
    private static final int SOCKET_INTERRUPT_TIMEOUT = 1000;
    
    public ClientHandler(ThreadGroup tg, Socket s, CommandExecutor ce) throws IOException {
        super(tg, tg.getName() + s.getInetAddress() + ":" + s.getPort());
        Logger.loginfo("Created clientHandler for new client");
        nc = new NetworkClient(s, SOCKET_INTERRUPT_TIMEOUT, true);
        sph = new ServerProtocolHandler(nc);
    }
    
    @Override
    public void run() {
        try {
            Logger.loginfo("ClientHandler started");
            while (!interrupted()) {
                try {
                    Command cmd = nc.readCommand();
                    sph.onCommand(cmd);
                } catch (SocketTimeoutException e) {
                } catch (IOException e) {
                    Logger.logexception(e, "Couldn't read Command");
                }
            }
        } catch (Exception e) {
            Logger.logexception(e, "Uncaught exception!");
        } finally {
            Logger.loginfo("ClientHandler stops.");
        }
    }
}
