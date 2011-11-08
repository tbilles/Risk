package risk.game;

import java.util.Collection;

public interface GameView {
    // Will be filled with methods that are used to query the current game's
    // state.
    // getPlayers()
    // getMap()
    // getWinState()

    public Collection<Player> getPlayers();
    
    public Country getCountry(String CountryName);
    
    public void registerObserver(Observer o);
}
