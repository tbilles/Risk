package risk.protocol.command;

import risk.protocol.CommandVisitor;
import risk.protocol.command.Command;

public class EndTurnCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

}
