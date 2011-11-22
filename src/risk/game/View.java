package risk.game;

public interface View {
    public void showReinforcementDialog(Country to, int availableTroops);
    public void showRegroupDialog(CountryPair cp);
}
