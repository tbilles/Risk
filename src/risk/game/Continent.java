package risk.game;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Iterator;

public class Continent {
    /**
     * A list of countries in the continent.
     */
    private LinkedList<Country> countries;
    
    public Continent(Collection<Country> countries) {
        this.countries = new LinkedList<Country>(countries);
    }
    public Country getCountry(String countryName){
        for(Country c : countries){
            if(c.getName().equals(countryName)) return c;
        }
        return null;
    }
}
