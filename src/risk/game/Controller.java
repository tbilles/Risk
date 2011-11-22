package risk.game;

public interface Controller {
    public void onGameStartClick();
    public void onCountryClick(String country);
    public void onEndTurnClick();
    public GameView getGameView();
    
    /*
     * The on*Dialog() functions return a 'validness' boolean value.
     * When it is true, the event was handled correctly. In case of an error
     * false is returned. In this case the dialog should remain open, and show
     * some kind of error to the user.
     * Eg. In the reinforcement phase, the user received 6 units of troops,
     *     but in the dialog, he entered 9. An error will be returned. 
     */
    
    public boolean onReinforcementDialogOK(Country c, int troops);
    public boolean onRegroupDialogOk(CountryPair cp, int troops);
    public boolean onAttackRetreat();
    public boolean onAttack_AttackerChose(int attackerDice);
    public boolean onAttack_DefenderChose(int defenderDice);
    public void setView(View view);
}
