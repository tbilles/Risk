package risk.protocol.command;

import risk.protocol.CommandVisitor;

public class AttackSetADiceCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;

    private int aDice;
    
    public AttackSetADiceCmd(int aDice) {
        super();
        this.aDice = aDice;
    }

    public int getADice() {
        return aDice;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }
}
