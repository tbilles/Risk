package risk.protocol.command;

import risk.game.Country;
import risk.game.Player;
import risk.protocol.CommandVisitor;

public class PlaceReinforcementCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;
    private Country country;
    private int troops;
    
    /**
     * Client->Server: the attribute is discarded, may be null.
     * Server->Client: the attribute is mandatory
     */
    private Player player;

    public PlaceReinforcementCmd(Country country, int troops, Player player) {
        super();
        this.country = country;
        this.troops = troops;
        this.player = player;
    }

    public Country getCountry() {
        return country;
    }

    public int getTroops() {
        return troops;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

}
