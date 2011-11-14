package risk.game;

public interface View {
    public void showReinforcementDialog(Country to);
    public void showAttackDialog(CountryPair cp);
    public void showRegroupDialog(CountryPair cp);
    public void addMessage(String msg);
}
