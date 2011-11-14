package risk.protocol.command;

import risk.game.Country;
import risk.protocol.CommandVisitor;

public class DoAttackCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;
    private Country from;
    private Country to;

    public DoAttackCmd(Country from, Country to) {
        super();
        this.from = from;
        this.to = to;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

}
