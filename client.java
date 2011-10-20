import java.io.*;
import java.net.*;

class client {
    public static void main(String[] args) {
        Socket sock = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            sock = new Socket("localhost", 34343);
            out = new PrintWriter(sock.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        } catch (IOException e) {
            System.err.println("IOEx");
            System.exit(-1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        try {
            if (args.length > 0 && args[0].compareTo("obj") == 0) {
                ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());

                System.out.println("Reading obj");

                try {
                    Person p;
                    while ((p = (Person)ois.readObject()) != null) {
                        System.out.println(p.toString());
                        p.Name = "00000";
                        p.Age = 0;
                    }
                } catch (Exception e) {
                    System.out.println("Exception");
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                    System.exit(-2);
                }
                
            } else {
                while ((userInput = stdIn.readLine()) != null) {
                    out.println(userInput);
                    System.out.println("echo: " + in.readLine());
                }
            }

            out.close();
            in.close();
            stdIn.close();
            sock.close();
        } catch (IOException e) {
            System.err.println("IOEx");
        }

    }
	
};
