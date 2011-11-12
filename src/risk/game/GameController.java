package risk.game;

public interface GameController {
    // Will be filled with methods that control the game, give orders, take
    // actions
    // doAttack(Country from, Country to);
    // doRegroup(Country from, Country to, int howmanyunits);
    // connectToServer()
    // disconnect()

    public void addPlayer(Player p);
    public void initCountry(Country newCountry);

    public void cancelCountrySelection(Country c);
    public void selectCountry(Country c);
}
