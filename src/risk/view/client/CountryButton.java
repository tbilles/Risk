package risk.view.client;

import java.awt.Color;
import javax.swing.JButton;
import risk.game.GameView;

public class CountryButton extends JButton {
    String country;

    public String getCountry() {
        return country;
    }

    public CountryButton(String CountryName) {
        super("");
        country = CountryName;
        setToolTipText(CountryName);
    }

    public void refresh(GameView view) {
        Color c = view.getCountryColor(country);
        if (c != null) {
            if (view.isCountrySelected(country)) {
                c = c.darker();
                c = c.darker();
                c = c.darker();
            } else if (view.isCountryNeighbourSelected(country)) {
                c = c.brighter();
                c = c.brighter();
                c = c.brighter();
            }
            setBackground(c);
            setText(view.getCountryTroops(country) + "");
        }
    }
}
