package risk.game;

import java.awt.Polygon;

public class Country {
    /**
     * The name of the country.
     */
    private String name;
    
    /**
     * The player who controls this country.
     */
    private Player owner;

    /**
     * The number of units of soldiers stationed in this country.
     */
    private int troops;
    
    public Country(String name) {
        this.name = name;
    }
}
