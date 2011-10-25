package risk.game.server;

import java.io.*;
import java.net.*;
import risk.Baby;
import risk.common.Logger;
import risk.common.RiskIO;

public class GameServer extends Thread {
    /**
     * A listener that accepts connections from clients.
     */
    // private ConnectionListener listener;

    /**
     * An array ConnectionHandlers that handles clients.
     */
    // private ConnectionHandler[] clientHandlers;

    // TODO: place this functionality to ConnectionListener
    public GameServer() {
        super("GameServerThread");
    }

    @Override
    public void run() {
        ServerSocket sock = null;
        Socket clientSocket = null;
        try {
            try {
                sock = new ServerSocket(34343);
                sock.setSoTimeout(1000);

            } catch (IOException e) {
                Logger.logexception(e, "Couldn't listen on port.");
                return;
            }

            try {
                boolean b = true;
                while (b) {
                    try {
                        clientSocket = sock.accept();
                        if (clientSocket != null)
                            b = false;
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

            try {
                ObjectOutputStream ous = new ObjectOutputStream(
                        clientSocket.getOutputStream());
                Baby p = new Baby("Tamas99999", 10, true, false);

                while (p != null) {
                    if (interrupted()) {
                        break;
                    } else {
                        RiskIO.serverPrintln(p.toString());
                        ous.writeObject(p);
                        ous.reset();
                        p.Age = p.Age + 1;
                        p.Name = "." + p.Name;
                        p.canWalk = !p.canWalk;
                        p.criesOverNight = !p.criesOverNight;
                    }
                    Thread.sleep(1000);
                }
            } catch (IOException e) {
                Logger.logexception(e, "Couldn't write to socket.");
            }
        } catch (InterruptedException ie) {

        } finally {
            try {
                if (clientSocket != null)
                    clientSocket.close();
                if (sock != null)
                    sock.close();
            } catch (IOException e) {
                Logger.logexception(e, "Couldn't close sockets");
            }
        }

    }
}
