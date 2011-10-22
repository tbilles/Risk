package risk;

import risk.common.Logger;
import risk.network.*;

class Risk {
    public static void main(String[] args) {
        Logger.getInstance().initialize(true, null);
        
        Logger.logdebug("Starting risk...");
        
        if (args.length > 0) {
            if (args[0].compareTo("server") == 0) {
                server s = new server();
                s.doit();
            } else if (args[0].compareTo("client") == 0) {
                Client c = new Client();
                c.doit();
            }
        }
        
        Logger.logdebug("Quitting...");
    }

};
