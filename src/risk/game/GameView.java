package risk.game;

import java.util.Collection;

import risk.game.Continent;

public interface GameView {
    // Will be filled with methods that are used to query the current game's
    // state.
    // getPlayers()
    // getMap()
    // getWinState()

    public Collection<Player> getPlayers();
    public Player getPlayer(String Name);
    
    public Country getCountry(String CountryName);

    public Collection<Continent> getContinents();
    public Collection<Country> getCountries();
}
