package risk.protocol;

import risk.protocol.command.Command;

public class NextPlayerCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

}
