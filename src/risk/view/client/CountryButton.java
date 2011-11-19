package risk.view.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JButton;
import risk.game.GameView;

public class CountryButton extends JButton {
    String country;
    double relativeX, relativeY;

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
    /*
     * The position of each button was set in MapPanel for a 1152*548 pixel sized map.
     * setRelativePosition calculates the relative position from those settings.
     */
    public void setRelativePosition(){
        Rectangle r=getBounds();
        relativeX=(double)r.x/(double)1152;
        relativeY=(double)r.y/(double)648;
    }
    public void setCurrentPosition(int width, int height){
        Rectangle r=getBounds();
        r.x=(int)(relativeX*width);
        r.y=(int)(relativeY*height);
        setBounds(r);
    }
    
}
