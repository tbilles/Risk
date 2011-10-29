package risk.game.server;

import java.net.Socket;

public interface ConnectionAcceptor {
    public void newConnection(Socket s);
    public void stoppedListening();
}
