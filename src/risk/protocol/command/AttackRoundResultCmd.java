package risk.protocol.command;

import java.util.ArrayList;
import java.util.Collection;
import risk.protocol.CommandVisitor;

public class AttackRoundResultCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;
    
    private ArrayList<Integer> aDiceResults;
    private ArrayList<Integer> dDiceResults;
    
    public AttackRoundResultCmd(ArrayList<Integer> aDiceResults, ArrayList<Integer> dDiceResults) {
        super();
        this.aDiceResults = aDiceResults;
        this.dDiceResults = dDiceResults;
    }

    public ArrayList<Integer> getADiceResults() {
        return aDiceResults;
    }

    public ArrayList<Integer> getDDiceResults() {
        return dDiceResults;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

}
