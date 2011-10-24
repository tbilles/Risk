package risk.network;

import java.io.*;
import java.net.*;
import risk.*;
import utils.RiskIO;

public class Client extends Thread {

    public Client() {
        super();
    }

    @Override
    public void run() {
        Socket sock = null;
        try {
            try {
                sock = new Socket("localhost", 34343);
            } catch (IOException e) {
                RiskIO.clientPrintln("IOEx");
                // System.exit(-1);
                return;
            }

            try {
                ObjectInputStream ois = new ObjectInputStream(
                        sock.getInputStream());

                RiskIO.clientPrintln("Reading obj");

                try {
                    Person p;
                    while ((p = (Person) ois.readObject()) != null) {
                        RiskIO.clientPrintln(p.toString());
                        p.Name = "00000";
                        p.Age = 0;
                    }
                } catch (Exception e) {
                    RiskIO.clientPrintln("Exception");
                    RiskIO.clientPrintln(e.getMessage());
                    RiskIO.clientPrintln(e.getStackTrace());
                    // System.exit(-2);
                }
            } catch (IOException e) {
                RiskIO.clientPrintln("IOEx");
            }

        } catch (Exception e) {
        } finally {
            try {
                sock.close();
            } catch (IOException e) {
                RiskIO.clientPrintln("IOEx");
            }
        }

    }
}
