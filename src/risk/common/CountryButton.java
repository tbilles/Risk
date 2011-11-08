package risk.common;

import javax.swing.JButton;

public class CountryButton extends JButton {
String country;
public CountryButton(String CountryName){
    super("");
    country=CountryName;
    setToolTipText(CountryName);
}
}
