package risk;

import risk.network.*;

class Risk {
    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].compareTo("server") == 0) {
                server s = new server();
                s.doit();
            } else if (args[0].compareTo("client") == 0) {
                client c = new client();
                c.doit();
            }
        }
    }
	
};
