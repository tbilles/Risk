package risk.protocol.command;

import java.util.Collection;

import risk.game.Player;
import risk.game.RoundPhase;
import risk.protocol.CommandVisitor;

public class NextRoundCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;
    private Player nextPlayer;
    private Collection<RoundPhase> phases;
    
    public NextRoundCmd(Player nextPlayer, Collection<RoundPhase> phases) {
        super();
        this.nextPlayer = nextPlayer;
        this.phases = phases;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public Collection<RoundPhase> getRoundPhases() {
        return phases;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

}
