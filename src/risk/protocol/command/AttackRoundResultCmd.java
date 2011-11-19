package risk.protocol.command;

import java.util.Collection;
import risk.protocol.CommandVisitor;

public class AttackRoundResultCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;
    
    private Collection<Integer> aDiceResults;
    private Collection<Integer> dDiceResults;
    
    public AttackRoundResultCmd(Collection<Integer> aDiceResults, Collection<Integer> dDiceResults) {
        super();
        this.aDiceResults = aDiceResults;
        this.dDiceResults = dDiceResults;
    }

    public Collection<Integer> getADiceResults() {
        return aDiceResults;
    }

    public Collection<Integer> getDiceResults() {
        return dDiceResults;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

}
