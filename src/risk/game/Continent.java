package risk.game;

import java.util.Collection;
import java.util.LinkedList;

public class Continent {
    public static final String ASIA = "Asia";
    public static final String AFRICA = "Africa";
    public static final String AUSTRALIA = "Australia";
    public static final String NORTHAMERICA = "North America";
    public static final String SOUTHAMERICA = "South America";
    public static final String EUROPE = "Europe";
    
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
    
    public String getName() {
        return name;
    }
}
