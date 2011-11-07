package risk.protocol.command;

import risk.game.server.ClientHandler;

public class CommandFromClient {
    public Command cmd;
    public ClientHandler clientHandler;

    public CommandFromClient(Command cmd, ClientHandler clientHandler) {
        this.cmd = cmd;
        this.clientHandler = clientHandler;
    }
}
