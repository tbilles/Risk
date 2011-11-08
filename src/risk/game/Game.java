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

    @Override
    public Country getCountry(String countryName) {      
        return map.getCountry(countryName);
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
