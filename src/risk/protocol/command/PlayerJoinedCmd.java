package risk.protocol.command;

import risk.game.Player;
import risk.protocol.CommandVisitor;

public class PlayerJoinedCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;
    private Player player;
    private boolean controlledByMe;

    public PlayerJoinedCmd(Player player, boolean controlledByMe) {
        super();
        this.player = player;
        this.controlledByMe = controlledByMe;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isControlledByMe() {
        return controlledByMe;
    }
    
    @Override
    public void accept(CommandVisitor cv) {
        // TODO Auto-generated method stub
        cv.visit(this);
    }
}
