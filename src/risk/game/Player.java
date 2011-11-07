package risk.game;

import java.awt.Color;
import java.io.Serializable;

public class Player implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * The name (or nickname) of the player.
     */
    private String name;

    /**
     * The color of the player.
     */
    private Color color;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
