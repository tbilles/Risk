package risk.protocol.command;

import risk.game.Player;
import risk.protocol.CommandVisitor;

public class NewTurnCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;
    private Player nextPlayer;
    
    public NewTurnCmd(Player nextPlayer) {
        super();
        this.nextPlayer = nextPlayer;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

}
