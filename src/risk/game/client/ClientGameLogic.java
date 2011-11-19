package risk.game.client;

import risk.common.Logger;
import risk.game.*;
import risk.network.QueuedSender;
import risk.protocol.command.DoAttackCmd;
import risk.protocol.command.PlaceReinforcementCmd;
import risk.protocol.command.RegroupCmd;

public class ClientGameLogic implements Controller {
    private GameView gameView;
    private GameController gameCtrl;
    private View view;
    private QueuedSender sender;

    private CountryPair currentAttack;

    public ClientGameLogic(GameView gameView, GameController gameCtrl) {
        super();
        this.gameView = gameView;
        this.gameCtrl = gameCtrl;
    }

    public void setSender(QueuedSender sender) {
        this.sender = sender;
    }

    @Override
    public void onCountryClick(String country) {
        if (gameView.getCurrentPlayer() != gameView.getMyPlayer()) {
            return;
        }
        
        // Get some data to work eith
        Country c = gameView.getCountry(country);
        RoundPhase phase = gameView.getRoundPhase();
        RoundPhase nextPhase = gameView.getNextRoundPhase();

        Logger.logdebug("Country \"" + c.getName() + "\" clicked");
        
        // If in reinforcement phase, no second click needed
        if (phase == RoundPhase.REINFORCEMENT) {
            view.showReinforcementDialog(c, gameView.getAvailableReinforcement());
        } else {
            Country selected;
            // If this is a second click, on a selected country, unselect it
            if (c.isSelected()) {
                Logger.logdebug("Unselecting country " + c.getName());
                gameCtrl.cancelCountrySelection(c);
            } else if ((selected = gameView.getSelectedCountryNeighbour(c)) != null) {
                // If this is a second click on a neighbour country, then action is needed
                Logger.logdebug("Action needed, current round phase: " + phase.toString());
                // If the selected country is enemy, then attack
                if (phase == RoundPhase.ATTACK && c.getOwner() != gameView.getMyPlayer()) {
                    if (currentAttack != null) {
                        Logger.logerror("CurrentAttack not null, when initiating new attack!");
                    }
                    currentAttack = new CountryPair(selected, c);
                    Logger.logdebug("Attacking from " + selected.getName() + " to " + c.getName());
                    view.showAttackDialog(currentAttack);
                    sender.queueForSend(new DoAttackCmd(currentAttack.From, currentAttack.To));
                } else if ((phase == RoundPhase.REGROUP || nextPhase == RoundPhase.REGROUP) && c.getOwner() == gameView.getMyPlayer()) {
                    // If second click is on my country, then regroup
                    Logger.logdebug("Regrouping from " + selected.getName() + " to " + c.getName());
                    view.showRegroupDialog(new CountryPair(selected, c));
                } else {
                    // Something went wrong
                    Logger.logwarn("Invalid game phase!");
                }
                // After action unselect all countries.
                gameCtrl.cancelCountryNeighbourSelection(c);
            } else {
                // Otherwise select country
                Logger.logdebug("Selecting country " + c.getName());
                gameCtrl.selectCountry(c);
            }
        }
    }

    @Override
    public GameView getGameView() {
        return gameView;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public boolean onReinforcementDialogOK(Country c, int troops) {
        int availableReinforcement = gameView.getAvailableReinforcement();
        if (availableReinforcement >= troops) {
            sender.queueForSend(new PlaceReinforcementCmd(c, troops, null));
            return true;
        }
        return false;
    }

    @Override
    public boolean onAttackDialog(boolean continuing) {
        if (currentAttack == null) {
            Logger.logerror("CurrentAttack is null, when attackdialog was OKd");
            return true;
        }
        if (continuing) {
            Logger.logdebug("Continuing attack");
            sender.queueForSend(new DoAttackCmd(currentAttack.From, currentAttack.To));
        } else {
            currentAttack = null;
        }
        return true;
    }

    @Override
    public boolean onRegroupDialogOk(CountryPair cp, int troops) {
        if (troops > 0 && troops < cp.From.getTroops()) {
            sender.queueForSend(new RegroupCmd(cp, troops));
            return false;
        }
        return true;
    }

}
