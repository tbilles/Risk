package risk.game;

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
}
