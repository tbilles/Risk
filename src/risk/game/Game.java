package risk.game;

import java.util.Collection;
import java.util.LinkedList;

public class Game implements GameView, GameController {
    /**
     * The map that represent the current state of the world.
     */
    private Map map;

    /**
     * A list of players.
     */
    private LinkedList<Player> players;

    public void addPlayer(Player p) {
        players.add(p);
    }

    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public void reset() {
        players = new LinkedList<Player>();
        map = new Map();
    }
}
