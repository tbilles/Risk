package risk.network;

import java.io.*;
import java.net.*;
import risk.common.Settings;

public class ServerSocket {
    private ServerSocket socket;

    public Socket acceptConnection() throws IOException {
        if (socket == null || socket.isClosed()) {
            int port = Settings.getInstance().getServerListenPort();
            try {
                socket = new ServerSocket(port);
            } catch (IOException e) {
                throw new IOException("Couldn't open server socket", e);
            }
        }

        Socket sock;
        try {
            sock = socket.accept();
        } catch (IOException e) {
            throw new IOException("Accept failed on server socket", e);
        }

        return sock;
    };

    public void close() throws IOException {
        if (socket == null || socket.isClosed()) {
            return;
        }

        try {
            socket.close();
        } catch (IOException e) {
            throw new IOException("Cannot close server socket", e);
        }
    }
}
