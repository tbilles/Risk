package risk;

import risk.network.*;

class Risk {
    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].compareTo("server") == 0) {
                Server s = new Server();
                s.start();
            } else if (args[0].compareTo("client") == 0) {
                Client c = new Client();
                c.start();
            }
        }
    }

};
