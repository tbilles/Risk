package risk.game;

import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;

import risk.game.Continent;

public interface GameView {
    // Will be filled with methods that are used to query the current game's
    // state.
    // getPlayers()
    // getMap()
    // getWinState()

    public Collection<Player> getPlayers();
    public Player getPlayer(String Name);
    public Player getCurrentPlayer();
    
    public Collection<Continent> getContinents();
    public Collection<Country> getCountries();
    public Country getCountry(String countryName);
    public Color getCountryColor(String countryName);
    public int getCountryTroops(String countryName);
    public boolean isCountrySelected(String name);
    public boolean isCountrySelected(Country c);
    public boolean isCountryNeighbourSelected(String name);
    public Country getSelectedCountryNeighbour(Country c);
    
    public void registerObserver(Observer o);
    
    public RoundPhase getRoundPhase();
    public int getRoundNumber();
    public Collection<RoundPhase> getRoundPhases();
    public int getAvailableReinforcement();
    public Player getMyPlayer();
}
