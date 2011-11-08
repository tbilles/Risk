package risk.game;

import java.util.LinkedList;

public class Map {
    /**
     * A list of continents.
     */
    private LinkedList<Continent> continents;
    
    public Map() {
        continents = new LinkedList<Continent>();
        
        initEurope();
    }

    private void initEurope() {
        LinkedList<Country> countries = new LinkedList<Country>();
        
        countries.add(new Country("Iceland"));
        countries.add(new Country("Scandinavia"));
        countries.add(new Country("Great Britain"));
        countries.add(new Country("Northern Europe"));
        countries.add(new Country("Western Europe"));
        countries.add(new Country("Southern Europe"));
        
        
        
        
        
        countries.add(new Country(""));
    }
}
