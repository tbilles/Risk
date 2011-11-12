package risk.network;

import java.io.IOException;

public class SocketClosedException extends IOException {
    private static final long serialVersionUID = 1L;

    public SocketClosedException() {
        super();
    }

    public SocketClosedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SocketClosedException(String message) {
        super(message);
    }

    public SocketClosedException(Throwable cause) {
        super(cause);
    }
}
