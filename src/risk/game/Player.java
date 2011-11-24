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
    
    /**
     * The goal of the player. If this mission is completed, the player wins.
     */
    private SecretMission mission;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }
    
    public Color getColor() {
        return color;
    }
    
    public SecretMission getSecretMission() {
        return this.mission;
    }

    public void setSecretMission(SecretMission mission) {
        this.mission = mission;
    }
}
