package risk.game;

import java.util.Collection;
import java.util.LinkedList;

public class Continent {
    /**
     * A list of countries in the continent.
     */
    private LinkedList<Country> countries;
    
    /**
     * The name of the continent.
     */
    private String name;
    
    public Continent(String name, Collection<Country> countries) {
        this.countries = new LinkedList<Country>(countries);
        this.name = name;
    }
}
