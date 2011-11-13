package risk.game;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

import risk.protocol.command.Command;

public class Country implements Serializable {
    private static final long serialVersionUID = Command.serialVersionUID;
    
    public static final transient String ICELAND = "Iceland";
    public static final transient String SCANDINAVIA = "Scandinavia";
    public static final transient String GREATBRITAIN = "Great Britain";
    public static final transient String NORTHERNEUROPE = "Northern Europe";
    public static final transient String WESTERNEUROPE = "Western Europe";
    public static final transient String SOUTHERNEUROPE = "Southern Europe";
    public static final transient String ALASKA = "Alaska";
    public static final transient String NORTHWESTTERRITORY = "Northwest Territory";
    public static final transient String GREENLAND = "Greenland";
    public static final transient String ALBERTA = "Alberta";
    public static final transient String ONTARIO = "Ontario";
    public static final transient String EASTERNCANADA = "Eastern Canada";
    public static final transient String WESTERNUNITEDSTATES = "Western United States";
    public static final transient String EASTERNUNITEDSTATES = "Eastern United States";
    public static final transient String CENTRALAMERICA = "Central America";
    public static final transient String VENEZUELA = "Venezuela";
    public static final transient String BRAZIL = "Brazil";
    public static final transient String PERU = "Peru";
    public static final transient String ARGENTINA = "Argentina";
    public static final transient String EGYPT = "Egypt";
    public static final transient String NORTHAFRICA = "North Africa";
    public static final transient String EASTAFRICA = "East Africa";
    public static final transient String CENTRALAFRICA = "Central Africa";
    public static final transient String SOUTHAFRICA = "South Africa";
    public static final transient String MADAGASCAR = "Madagascar";
    public static final transient String RUSSIA = "Russia";
    public static final transient String URAL = "Ural";
    public static final transient String SIBERIA = "Siberia";
    public static final transient String YAKUTSK = "Yakutsk";
    public static final transient String KAMCHATKA = "Kamchatka";
    public static final transient String AFGHANISTAN = "Afghanistan";
    public static final transient String MIDDLEEAST = "Middle East";
    public static final transient String INDIA = "India";
    public static final transient String CHINA = "China";
    public static final transient String SIAM = "Siam";
    public static final transient String IRKUTSK = "Irkutsk";
    public static final transient String MONGOLIA = "Mongolia";
    public static final transient String JAPAN = "Japan";
    public static final transient String INDONESIA = "Indonesia";
    public static final transient String EASTERNAUSTRALIA = "Eastern Australia";
    public static final transient String WESTERNAUSTRALIA = "Western Australia";
    public static final transient String NEWGUINEA = "New Guinea";

    /**
     * The name of the country.
     */
    private String name;
    
    /**
     * The player who controls this country.
     */
    private Player owner;
    
    /**
     * A list of countries that are reachable from this country.
     */
    private LinkedList<Country> neighbours;
    
    /**
     * Indicates whether the country is selected or not.
     */
    private transient boolean selected;

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
    
    public void setOwner(Player owner) {
        this.owner = owner;
    }
    
    public String getName() {
        return name;
    }

    public void setTroops(int i) {
        troops = i;
    }
    
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Collection<Country> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(Country neighbour) {
        if (neighbours == null) {
            neighbours = new LinkedList<Country>();
        }
        
        this.neighbours.add(neighbour);
    }
}
