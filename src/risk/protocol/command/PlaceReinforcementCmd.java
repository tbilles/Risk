package risk.protocol.command;

import risk.game.Country;
import risk.protocol.CommandVisitor;

public class PlaceReinforcementCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;
    private Country country;
    private int troops;

    public PlaceReinforcementCmd(Country country, int troops) {
        super();
        this.country = country;
        this.troops = troops;
    }

    public Country getCountry() {
        return country;
    }

    public int getTroops() {
        return troops;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

}
