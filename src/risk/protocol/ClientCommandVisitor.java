package risk.protocol;

import risk.common.Logger;
import risk.game.Country;
import risk.game.GameController;
import risk.game.GameView;
import risk.protocol.command.*;

public class ClientCommandVisitor implements CommandVisitor {
    private GameView gameView;
    private GameController gameCtrl;

    public ClientCommandVisitor(GameView gameView, GameController gameCtrl) {
        super();
        this.gameView = gameView;
        this.gameCtrl = gameCtrl;
    }

    @Override
    public void visit(HelloCmd cmd) {
        Logger.logwarn("Client shouldn't receive HelloCmd");
    }

    @Override
    public void visit(PlayerJoinedCmd cmd) {
        Logger.logdebug("Got PlayerJoinedCmd: " + cmd.getPlayer().getName());
        gameCtrl.addPlayer(cmd.getPlayer());
    }

    @Override
    public void visit(GameStartedCmd cmd) {
        Logger.logdebug("Game started");
    }

    @Override
    public void visit(NewTurnCmd cmd) {
        Logger.logdebug("New turn started for player " + cmd.getNextPlayer().getName());
    }

    @Override
    public void visit(CountyInitCmd cmd) {
        Logger.logdebug("Got CountryInitCmd!");
        Country newCountry = cmd.getCountry();
        gameCtrl.initCountry(newCountry);
    }

    @Override
    public void visit(GameEndedCmd cmd) {
        String reason = cmd.getReason() == GameEndedCmd.WIN ? "won" : "quit";
        Logger.logdebug("Got GameEnded command: " + cmd.getPlayer().getName() + " has " + reason);
    }

    @Override
    public void visit(DoAttackCmd cmd) {
        WrongCommand(cmd);
        
    }

    @Override
    public void visit(PlaceReinforcementCmd cmd) {
        WrongCommand(cmd);
    }
    
    private void WrongCommand(Command cmd) {
        Logger.logwarn("Clienet shouldn't receive " + cmd.toString());
    }
}
