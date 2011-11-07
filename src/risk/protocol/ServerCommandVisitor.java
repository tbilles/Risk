package risk.protocol;

import risk.common.Logger;
import risk.game.*;
import risk.game.server.*;
import risk.protocol.command.*;

public class ServerCommandVisitor implements CommandVisitor {
    private ClientHandler clientHandler;
    private CommandSender cmdSender;
    private Game game;

    public ServerCommandVisitor(CommandSender cmdSender, Game game, ClientHandler clientHandler) {
        this.game = game;
        this.cmdSender = cmdSender;
        this.clientHandler = clientHandler;
    }

    @Override
    public void visit(HelloCmd cmd) {
        Logger.logdebug("Got HelloCmd!");

        // Get current players and send them to the new player
        Iterable<Player> players = game.getPlayers();
        for (Player p : players) {
            clientHandler.queueForSend(new PlayerJoinedCmd(p));
        }

        // Create new player and send it to everyone
        Player newPlayer = new Player(cmd.getName());
        game.addPlayer(newPlayer);
        clientHandler.setPlayer(newPlayer);
        cmdSender.sendCmd(new PlayerJoinedCmd(newPlayer), null);
    }

    @Override
    public void visit(PlayerJoinedCmd cmd) {
        Logger.logwarn("Server shouldn't receive PlayerJoinedCmd");
    }
}
