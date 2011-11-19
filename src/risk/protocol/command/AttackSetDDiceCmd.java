package risk.protocol.command;

import risk.protocol.CommandVisitor;

public class AttackSetDDiceCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;

    private int dDice;
    
    public AttackSetDDiceCmd(int dDice) {
        super();
        this.dDice = dDice;
    }

    public int getDDice() {
        return dDice;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }
}
