package risk.game;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Iterator;

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
    public Country getCountry(String countryName){
        for(Country c : countries){
            if(c.getName().equals(countryName)) return c;
        }
        return null;
    }
    
    public Collection<Country> getCountries() {
        return countries;
    }
}
