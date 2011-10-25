package risk.network;

import java.io.*;
import java.net.*;
import risk.common.Settings;

public class ClientSocket {
    private Socket socket;

    public void connect() throws IOException {
        String address = Settings.getInstance().getClientConnectAddr();
        int port = Settings.getInstance().getClientConnectPort();

        try {
            socket = new Socket(address, port);
        } catch (IOException e) {
            throw new IOException("Couldn't connect to " + address + ":" + port, e);
        }
    };

    public void close() throws IOException {
        if (socket.isClosed()) {
            return;
        }

        try {
            socket.close();
        } catch (IOException e) {
            throw new IOException("Couldn't close socket", e);
        }
    }

    public InputStream getInputStream() throws IOException {
        return socket.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return socket.getOutputStream();
    }
}
