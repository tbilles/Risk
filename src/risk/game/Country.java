package risk.game;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

import risk.protocol.command.Command;

public class Country implements Serializable {
    private static final long serialVersionUID = Command.serialVersionUID;

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
