package risk.protocol.command;

import risk.game.Player;
import risk.protocol.CommandVisitor;

public class GameEndedCmd extends Command {
    public static final int WIN = 0;
    public static final int QUIT = 1;
    private static final long serialVersionUID = Command.serialVersionUID;
    private Player player;
    private int reason;

    public GameEndedCmd(Player player, int reason) {
        super();
        this.player = player;
        this.reason = reason;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

    public Player getPlayer() {
        return player;
    }

    public int getReason() {
        return reason;
    }

}
