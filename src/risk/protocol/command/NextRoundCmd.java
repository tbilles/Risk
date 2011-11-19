package risk.protocol.command;

import java.util.Collection;

import risk.game.Player;
import risk.game.RoundPhase;
import risk.protocol.CommandVisitor;

public class NextRoundCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;
    private Collection<Player> players;
    private Collection<RoundPhase> phases;
    
    public NextRoundCmd(Collection<Player> players, Collection<RoundPhase> phases) {
        super();
        this.players = players;
        this.phases = phases;
    }

    public Collection<Player> getPlayers() {
        return players;
    }

    public Collection<RoundPhase> getRoundPhases() {
        return phases;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

}
