package risk.game;

import java.util.Collection;
import java.util.LinkedList;

public class Continent {
    /**
     * A list of countries in the continent.
     */
    private LinkedList<Country> countries;
    
    public Continent(Collection<Country> countries) {
        this.countries = new LinkedList<Country>(countries);
    }
}
