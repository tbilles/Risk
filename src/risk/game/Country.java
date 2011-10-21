package risk.game;

import java.awt.Polygon;

public class Country {
    /**
     * A polygon that represents the borders of this country.
     */
    private Polygon borders;

    /**
     * The player who controls this country.
     */
    private Player owner;

    /**
     * The number of units of soldiers stationed in this country.
     */
    private int troops;
}
