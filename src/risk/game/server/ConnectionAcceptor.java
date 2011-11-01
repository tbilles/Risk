package risk.game.server;

import java.net.Socket;

/**
 * An interface for objects that accepts incoming connections.
 * It provides the interface between the low level and a higher layer.
 */
public interface ConnectionAcceptor {
    public void newConnection(Socket s);
    public void stoppedListening();
}
