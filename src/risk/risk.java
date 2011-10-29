package risk;

import java.io.IOException;
import risk.common.Logger;
import risk.network.*;

class Risk {
    public static void main(String[] args) {
        Logger.getInstance().initialize(true, null);

        try {
            Logger.logdebug("Starting risk...");

            if (args.length > 0) {
                if (args[0].compareTo("server") == 0) {
                    // server s = new server();
                    // s.doit();
                } else if (args[0].compareTo("client") == 0) {
                    NetworkClient c = new NetworkClient(false);
                    // try {
                    // c.connect();
                    try {

                    } finally {
                        try {
                            c.close();
                        } catch (IOException e) {
                            Logger.logexception(e, "Can't close connection");
                        }
                    }
                    // } catch (IOException e) {
                    // Logger.logexception(e, "Can't connect to server");
                    // }

                    // c.doit();
                }
            }

            Logger.logdebug("Quitting...");
        } catch (NullPointerException e) {
            Logger.logexception(e, "Uncaught NullPointerException");
            // TODO: display a popup dialog that tells the user an unexpected
            // error has happened, and the application is quitting.
        } catch (RuntimeException e) {
            Logger.logexception(e, "Uncaught RuntimeException");
            // TODO: display a popup dialog that tells the user an unexpected
            // error has happened, and the application is quitting.
        }
    }

};
