package risk.network;

import java.io.*;
import java.net.*;
import risk.*;
import risk.common.Settings;

public class Client {
    private Socket socket;

    public boolean Connect() {
        String address = Settings.getInstance().getClientConnectAddr();
        int port = Settings.getInstance().getClientConnectPort();

        try {
            socket = new Socket(address, port);
        } catch (IOException e) {

            return false;
        }

        return true;
    };

    public void doit() {
        Socket sock = null;

        try {
            sock = new Socket("localhost", 34343);
        } catch (IOException e) {
            System.err.println("IOEx");
            System.exit(-1);
        }

        try {
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

            sock.close();
        } catch (IOException e) {
            System.err.println("IOEx");
        }

    }

};
