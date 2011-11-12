package risk.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Game implements GameView, GameController {
    /**
     * The map that represent the current state of the world.
     */
    private Map map = new Map();

    /**
     * A list of players.
     */
    
    private ArrayList<Observer> observers=new ArrayList<Observer>();
    private LinkedList<Player> players = new LinkedList<Player>();

    public void addPlayer(Player p) {
        players.add(p);
    }

    public Collection<Player> getPlayers() {
        return players;
    }
    
    public Player getPlayer(String Name) {
        for (Player p : players) {
            if (p.getName().compareTo(Name) == 0) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Country getCountry(String countryName) {      
        return map.getCountry(countryName);
    }

    @Override
    public Collection<Continent> getContinents() {
        return map.getContinents();
    }
    
    @Override
    public Collection<Country> getCountries() {
        ArrayList<Country> countries = new ArrayList<Country>();
        Collection<Continent> continets = getContinents();
        for (Continent c : continets) {
            countries.addAll(c.getCountries());
        }
        return countries;
    }

    @Override
    public void initCountry(Country newCountry) {
        Country oldCountry = getCountry(newCountry.getName());
        Player newOwner = getPlayer(newCountry.getOwner().getName());
        oldCountry.setOwner(newOwner);
        oldCountry.setTroops(newCountry.getTroops());
    }
    
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    
    private void modelChanged(){
        for(Observer o : observers){
            o.refresh(this);
        }
    }
}
