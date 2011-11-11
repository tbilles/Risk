package risk.game;

import java.awt.Polygon;

public class Country {
    /**
     * The name of the country.
     */
    private String name;
    
    public String getName() {
        return name;
    }

    /**
     * The player who controls this country.
     */
    private Player owner;

    public Player getOwner() {
        return owner;
    }

    public int getTroops() {
        return troops;
    }

    /**
     * The number of units of soldiers stationed in this country.
     */
    private int troops;
    
    public Country(String name) {
        this.name = name;
    }
}
