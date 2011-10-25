package risk.game.server;

import java.io.*;
import java.net.*;
import risk.Baby;
import risk.utils.RiskIO;

public class GameServer extends Thread {
    /**
     * A listener that accepts connections from clients.
     */
    //private ConnectionListener listener;

    /**
     * An array ConnectionHandlers that handles clients.
     */
    //private ConnectionHandler[] clientHandlers;
    
    // TODO: place this functionality to ConnectionListener
    @Override
    public void run() {
        ServerSocket sock = null;
        Socket clientSocket = null;
        try {
            try {
                sock = new ServerSocket(34343);

            } catch (IOException e) {
                RiskIO.serverPrintln("Couldn't listen on port.");
                // System.exit(-1);
                return;
            }

            try {
                clientSocket = sock.accept();
            } catch (IOException e) {
                RiskIO.serverPrintln("Couldn't accept on port.");
                // System.exit(-1);
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
                RiskIO.serverPrintln("IOexception");
                RiskIO.serverPrintln(e.getMessage());
                RiskIO.serverPrintln(e.getStackTrace());
            }
        } catch (InterruptedException ie) {

        } finally {
            try {
                if (clientSocket != null)
                    clientSocket.close();
                if (sock != null)
                    sock.close();
            } catch (IOException e) {
                RiskIO.serverPrintln("IOexception");
                RiskIO.serverPrintln(e.getMessage());
                RiskIO.serverPrintln(e.getStackTrace());
            }
        }

    }
}
