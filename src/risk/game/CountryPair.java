package risk.game;

import java.io.Serializable;
import risk.protocol.command.Command;

public class CountryPair implements Serializable {
    private static final long serialVersionUID = Command.serialVersionUID;

    public Country From;
    public Country To;
    
    public CountryPair(Country from, Country to) {
        super();
        From = from;
        To = to;
    }
}
