package risk.game.client;

import risk.common.Logger;
import risk.game.*;

public class ClientGameLogic implements Controller {
    private GameView gameView;
    private GameController gameCtrl;

    public ClientGameLogic(GameView gameView, GameController gameCtrl) {
        super();
        this.gameView = gameView;
        this.gameCtrl = gameCtrl;
    }

    @Override
    public void onCountryClick(Country c) {
        Logger.logdebug("Country \"" + c.getName() + "\" clicked");
        if (c.isSelected()) {
            gameCtrl.cancelCountrySelection(c);
        } else if (c.isNeightbourSelected()) {
            // Do something like attack or regroup
        } else {
            gameCtrl.selectCountry(c);
        }
        
    }

    @Override
    public GameView getGameView() {
        return gameView;
    }

}
