package risk.game.server;

import java.io.IOException;
import java.net.*;

import risk.common.Logger;

/**
 * This thread opens a ServerSocket on the specified ports, and waits for
 * incoming connections. ConnectionAcceptor is notified of every event.
 */
public class ConnectionListener extends Thread {
    /**
     * The socket which ConnectionListener opens and listens on.
     */
    private ServerSocket sock;
    
    /**
     * The port on which sock is opened.
     */
    private int listenPort;
    
    /**
     * ConnectionAcceptor is the object that handles incoming connections on a higher level.
     */
    private ConnectionAcceptor acceptor;
    
    public ConnectionListener(int port, ConnectionAcceptor acceptor) {
        super("GameServerListenerThread");
        listenPort = port;
        this.acceptor = acceptor;
    }
    
    @Override
    public void run() {
        try {
            // Open socket
            try {
                sock = new ServerSocket(listenPort);
                sock.setSoTimeout(1000);
            } catch (IOException e) {
                Logger.logexception(e, "Couldn't listen on port " + listenPort);
                return;
            }

            // Wait for incoming connections
            try {
                boolean b = true;
                while (b) {
                    try {
                        Socket clientSocket = sock.accept();
                        acceptor.newConnection(clientSocket);
                    } catch (SocketTimeoutException ste) {
                        if (interrupted()) {
                            return;
                        }
                    }
                }

            } catch (IOException e) {
                Logger.logexception(e, "Couldn't accept on port.");
                return;
            }
        } finally {
            try {
                if (sock != null)
                    sock.close();
            } catch (IOException e) {
                Logger.logexception(e, "Couldn't close sockets");
            }
            acceptor.stoppedListening();
        }
    }
}
