package risk.protocol;

import risk.common.Logger;
import risk.game.Game;
import risk.protocol.command.*;

public class ClientCommandVisitor implements CommandVisitor {
    private Game game;

    public ClientCommandVisitor(Game game) {
        super();
        this.game = game;
    }

    @Override
    public void visit(HelloCmd cmd) {
        Logger.logwarn("Client shouldn't receive HelloCmd");
    }

    @Override
    public void visit(PlayerJoinedCmd cmd) {
        Logger.logdebug("Got PlayerJoinedCmd: " + cmd.getPlayer().getName());
        game.addPlayer(cmd.getPlayer());
    }

}
