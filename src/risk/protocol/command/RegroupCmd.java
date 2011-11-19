package risk.protocol.command;

import risk.game.CountryPair;
import risk.protocol.CommandVisitor;
import risk.protocol.command.Command;

public class RegroupCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;

    private CountryPair cp;
    private int troops;
    
    public RegroupCmd(CountryPair cp, int troops) {
        super();
        this.cp = cp;
        this.troops = troops;
    }

    public CountryPair getCountryPair() {
        return cp;
    }

    public int getTroops() {
        return troops;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

}
