package risk.protocol.command;

import risk.game.Country;
import risk.protocol.CommandVisitor;

public class CountyInitCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;
    private Country country;

    public CountyInitCmd(Country country) {
        super();
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }
}
