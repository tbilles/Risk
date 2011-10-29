package risk.network;

import java.io.*;
import java.net.*;
import risk.protocol.command.Command;

public class NetworkClient {
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private boolean serverSide;
    
    public NetworkClient(boolean serverSide) {
        this.serverSide = serverSide;
    }
    
    public NetworkClient(Socket socket) throws IOException {
        this.serverSide = serverSide;
        this.socket = socket; 
        try {
            // ObjectInputStream will block until the corresponding ObjectOutputStream is not created.
            // So we have to initialize them in opposite order in the server and the client.
            if (serverSide) {
                ois = new ObjectInputStream(socket.getInputStream());
                oos = new ObjectOutputStream(socket.getOutputStream());
            } else {
                oos = new ObjectOutputStream(socket.getOutputStream());
                ois = new ObjectInputStream(socket.getInputStream());
            }
        } catch (IOException e) {
            throw new IOException("Cannot get input/output stream for specified socket", e);
        }
    }

    public void connect(String address, int port) throws IOException {
        try {
            socket = new Socket(address, port);
            // ObjectInputStream will block until the corresponding ObjectOutputStream is not created.
            // So we have to initialize them in opposite order in the server and the client.
            if (serverSide) {
                ois = new ObjectInputStream(socket.getInputStream());
                oos = new ObjectOutputStream(socket.getOutputStream());
            } else {
                oos = new ObjectOutputStream(socket.getOutputStream());
                ois = new ObjectInputStream(socket.getInputStream());
            }
        } catch (IOException e) {
            throw new IOException("Couldn't connect to " + address + ":" + port, e);
        }
    };

    public void close() throws IOException {
        try {
            socket.close();
        } catch (IOException e) {
            throw new IOException("Couldn't close socket", e);
        }
    }

    public Command readCommand() throws IOException {
        Object o;
        try {
            o = ois.readObject();
        } catch (IOException e) {
            throw new IOException("Cannot read command object", e);
        } catch (ClassNotFoundException e) {
            throw new IOException("Read object but that's not Command!", e);
        }
        Command cmd = (Command)o;
        
        return cmd;
    }
    
    public void writeCommand(Command cmd) throws IOException {
        try {
            oos.writeObject(cmd);
        } catch (IOException e) {
            throw new IOException("Cannot write Command object to network", e);
        }
    }
}
