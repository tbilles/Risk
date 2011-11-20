package risk.protocol.command;

import risk.protocol.CommandVisitor;

public class NextPhaseCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;

    private int reinforcement;
    
    public NextPhaseCmd(int reinforcement) {
        super();
        this.reinforcement = reinforcement;
    }

    public int getReinforcement() {
        return reinforcement;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

}
