package risk.game;

import java.util.LinkedList;

public class Game {
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

    public LinkedList<Player> getPlayers() {
        return players;
    }
}
