package risk.protocol.command;

import risk.game.CountryPair;
import risk.protocol.CommandVisitor;

public class AttackStartCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;

    private CountryPair countryPair;
    
    public AttackStartCmd(CountryPair countryPair) {
        super();
        this.countryPair = countryPair;
    }

    public CountryPair getCountryPair() {
        return countryPair;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }
}
