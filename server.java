import java.io.*;
import java.net.*;

class server {
    public static void main(String[] args) {
        ServerSocket sock = null;

        try {
            sock = new ServerSocket(34343);

        } catch (IOException e) {
            System.err.println("Couldn't listen on port.");
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = sock.accept();
        } catch (IOException e) {
            System.err.println("Couldn't accept on port.");
            System.exit(-1);
        }


        try {
            System.out.println(args.length);
            System.out.println(args[0]);
            if (args.length > 0 && "obj".compareTo(args[0]) == 0) {
                System.out.println("Object writing");
                ObjectOutputStream ous = new ObjectOutputStream(clientSocket.getOutputStream());
                Child p = new Child("Tamás", 10, true);

                while (true) {
                    System.out.println(p.toString());
                    ous.writeObject(p);
                    ous.reset();
                    p.Age = p.Age+1;
                    p.Name = "." + p.Name;
                    p.canWalk = !p.canWalk;
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                    
                    }
                }
            } else {
    	        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    	        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    	        String inputLine, outputLine;
    	
    	        while ((inputLine = in.readLine()) != null) {
    	            outputLine = "server: " + inputLine;
    	            out.println(outputLine);
    	        }
	            
                out.close();
	            in.close();
            }
	
	        clientSocket.close();
	        sock.close();
        } catch (IOException e) {
            System.err.println("IOexception");
            System.err.println(e.getMessage());
            System.err.println(e.getStackTrace());
        }
    }
	
};
