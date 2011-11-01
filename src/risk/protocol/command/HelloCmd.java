package risk.protocol.command;

import risk.game.Player;
import risk.protocol.CommandVisitor;

public class HelloCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;
    private String name;
    
    public HelloCmd(Player p) {
        name = p.getName();
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }
}
