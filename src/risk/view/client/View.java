package risk.view.client;

import risk.game.Country;
import risk.game.CountryPair;

public interface View {
    public void showReinforcementDialog(Country to);
    public void showAttackDialog(CountryPair cp);
    public void showRegroupDialog(CountryPair cp);
    public void addMessage(String msg);
}
