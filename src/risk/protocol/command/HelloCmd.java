package risk.protocol.command;

import risk.game.Player;
import risk.protocol.CommandVisitor;

public class HelloCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;
    private String name;
    
    public HelloCmd(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }
}
