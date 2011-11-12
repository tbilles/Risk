package risk.view.client;

import javax.swing.JButton;

import risk.game.GameView;

public class CountryButton extends JButton {
String country;
public CountryButton(String CountryName){
    super("");
    country=CountryName;
    setToolTipText(CountryName);
}
public void refresh(GameView view){
    setBackground(view.getCountry(country).getOwner().getColor());
    setText(view.getCountry(country).getTroops()+"");
}
}
