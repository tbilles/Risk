package risk.game.server;

import java.io.IOException;
import java.net.*;

import risk.common.Logger;

public class ConnectionListener extends Thread {
    private ServerSocket sock;
    private int listenPort;
    private ConnectionAcceptor acceptor;
    
    public ConnectionListener(int port, ConnectionAcceptor acceptor) {
        super("GameServerListenerThread");
        listenPort = port;
        this.acceptor = acceptor;
    }
    
    @Override
    public void run() {
        try {
            try {
                sock = new ServerSocket(listenPort);
                sock.setSoTimeout(1000);
            } catch (IOException e) {
                Logger.logexception(e, "Couldn't listen on port " + listenPort);
                return;
            }

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
