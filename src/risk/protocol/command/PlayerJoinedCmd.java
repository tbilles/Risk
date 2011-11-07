package risk.protocol.command;

import risk.game.Player;
import risk.protocol.CommandVisitor;

public class PlayerJoinedCmd extends Command {
    private Player player;

    public PlayerJoinedCmd(Player player) {
        super();
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void accept(CommandVisitor cv) {
        // TODO Auto-generated method stub
        cv.visit(this);
    }
}
