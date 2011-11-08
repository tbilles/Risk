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
        initNorthAmerica();
        initSouthAmerica();
        initAsia();
        initAfrica();
        initAustralia();
    }

    private void initEurope() {
        LinkedList<Country> countries = new LinkedList<Country>();
        countries.add(new Country("Iceland"));
        countries.add(new Country("Scandinavia"));
        countries.add(new Country("Great Britain"));
        countries.add(new Country("Northern Europe"));
        countries.add(new Country("Western Europe"));
        countries.add(new Country("Southern Europe"));
        
        continents.add(new Continent("Europe", countries));
    }
    
    private void initNorthAmerica() {
        LinkedList<Country> countries = new LinkedList<Country>();
        countries.add(new Country("Alaska"));
        countries.add(new Country("Nortwest Territory"));
        countries.add(new Country("Greenland"));
        countries.add(new Country("Alberta"));
        countries.add(new Country("Ontario"));
        countries.add(new Country("Eastern Canada"));
        countries.add(new Country("Westerns United States"));
        countries.add(new Country("Easterns United States"));
        countries.add(new Country("Central America"));
        
        continents.add(new Continent("North America", countries));
    }
    
    private void initSouthAmerica() {
        LinkedList<Country> countries = new LinkedList<Country>();
        countries.add(new Country("Venezuela"));
        countries.add(new Country("Brazil"));
        countries.add(new Country("Peru"));
        countries.add(new Country("Argentina"));

        continents.add(new Continent("South America", countries));
    }
    
    private void initAfrica() {
        LinkedList<Country> countries = new LinkedList<Country>();
        countries.add(new Country("Egypt"));
        countries.add(new Country("North Africa"));
        countries.add(new Country("East Africa"));
        countries.add(new Country("Central Africa"));
        countries.add(new Country("South Africa"));
        countries.add(new Country("Madagascar"));

        continents.add(new Continent("Africa America", countries));
    }
    
    private void initAsia() {
        LinkedList<Country> countries = new LinkedList<Country>();
        countries.add(new Country("Russia"));
        countries.add(new Country("Ural"));
        countries.add(new Country("Siberia"));
        countries.add(new Country("Yakutsk"));
        countries.add(new Country("Kamchatka"));
        countries.add(new Country("Afghanistan"));
        countries.add(new Country("Middle East"));
        countries.add(new Country("India"));
        countries.add(new Country("China"));
        countries.add(new Country("Siam"));
        countries.add(new Country("Irkutsk"));
        countries.add(new Country("Mongolia"));
        countries.add(new Country("Japan"));
        
        continents.add(new Continent("Asia", countries));
    }
    
    private void initAustralia() {
        LinkedList<Country> countries = new LinkedList<Country>();
        countries.add(new Country("Indonesia"));
        countries.add(new Country("Eastern Australia"));
        countries.add(new Country("Western Australia"));
        countries.add(new Country("New Guinea"));
        
        continents.add(new Continent("Australia", countries));
    }
}
