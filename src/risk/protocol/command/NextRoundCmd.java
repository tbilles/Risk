package risk.protocol.command;

import risk.game.Player;
import risk.protocol.CommandVisitor;

public class NextRoundCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;
    private Player nextPlayer;
    private int reinforcement;
    
    public NextRoundCmd(Player nextPlayer, int reinforcement) {
        super();
        this.nextPlayer = nextPlayer;
        this.reinforcement = reinforcement;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public int getReinforcement() {
        return reinforcement;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

}
