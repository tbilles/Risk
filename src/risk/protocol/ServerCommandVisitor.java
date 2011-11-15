package risk.protocol;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import risk.common.Logger;
import risk.game.*;
import risk.game.server.*;
import risk.protocol.command.*;

public class ServerCommandVisitor implements CommandVisitor {
    private ClientHandler clientHandler;
    private CommandSender cmdSender;
    private GameView gameView;
    private GameController gameCtrl;
    private ArrayList<Color> colors;
    private Iterator<Player> currentPlayerIterator;
    private RoundPhase roundPhase = null;

    public ServerCommandVisitor(CommandSender cmdSender, GameView gameView, GameController gameCtrl, ClientHandler clientHandler) {
        this.gameView = gameView;
        this.gameCtrl = gameCtrl;
        this.cmdSender = cmdSender;
        this.clientHandler = clientHandler;
        
        colors = new ArrayList<Color>();
        colors.add(new Color(200, 0, 0)); // Red
        colors.add(new Color(0, 0, 200)); // Blue
        colors.add(new Color(0, 200, 0)); // Green
        colors.add(new Color(200, 200, 0)); // Yellow
        colors.add(new Color(200, 0, 200)); // Magenta
        colors.add(new Color(0, 200, 200)); // Cyan
    }

    @Override
    public void visit(HelloCmd cmd) {
        Logger.logdebug("Got HelloCmd!");

        Player newPlayer = new Player(cmd.getName(), colors.get(gameView.getPlayers().size()));
        clientHandler.setPlayer(newPlayer);
        
        // Get current players and send them to the new player
        Iterable<Player> players = gameView.getPlayers();
        for (Player p : players) {
            clientHandler.queuePlayerJoinedForSend(p);
        }

        // Create new player and send it to everyone
        
        gameCtrl.addPlayer(newPlayer);
        cmdSender.sendPlayerJoinedCmd(newPlayer);
        
        // Check if all the players are here
        if (gameView.getPlayers().size() == 2) {
            startGame();
        }
    }

    @Override
    public void visit(PlayerJoinedCmd cmd) {
        WrongCommand(cmd);
    }

    @Override
    public void visit(GameStartedCmd cmd) {
        WrongCommand(cmd);
    }

    @Override
    public void visit(NextRoundCmd cmd) {
        WrongCommand(cmd);
    }

    @Override
    public void visit(CountyInitCmd cmd) {
        WrongCommand(cmd);
    }

    @Override
    public void visit(GameEndedCmd cmd) {
        WrongCommand(cmd);
    }

    private void WrongCommand(Command cmd) {
        Logger.logwarn("Server shouldn't receive " + cmd.toString());
    }

    private void startGame() {
        // Send game started notification
        cmdSender.sendCmd(new GameStartedCmd(), null);
        
        // Randomly give countries to players
        ArrayList<Country> countries = new ArrayList<Country>(gameView.getCountries());
        Collection<Player> players = gameView.getPlayers();
        
        Random r = new Random();
        Iterator<Player> playerIterator = players.iterator();
        while (!countries.isEmpty()) {
            Logger.logdebug("Countries: " + countries.size());
            // Generate random number
            int rand = r.nextInt(countries.size());
            // Set random country to be owned by the next player
            Country c = countries.get(rand); 
            Logger.logdebug("Country name: " + c.getName());
            c.setOwner(playerIterator.next());
            c.setTroops(1);
            // Remove Country from the 'unowned' countries list
            cmdSender.sendCmd(new CountyInitCmd(c), null);
            countries.remove(rand);
            // If the iterator has ended, reset it to start.
            if (!playerIterator.hasNext()) {
                playerIterator = players.iterator();
            }
        }
        
        newTurn();
    }
    
    private void newTurn() {
        if (currentPlayerIterator == null || !currentPlayerIterator.hasNext()) {
            currentPlayerIterator = gameView.getPlayers().iterator();
        }
        gameCtrl.setCurrentPlayer(currentPlayerIterator.next());
        roundPhase = RoundPhase.REINFORCEMENT;
        
        gameCtrl.setAvailableReinforcement(getReinforcement(gameView.getCurrentPlayer()));
        cmdSender.sendCmd(new NextRoundCmd(gameView.getCurrentPlayer(), gameView.getAvailableReinforcement()), null);
    }
    
    private int getReinforcement(Player p) {
        // TODO: get real number
        return 5;
    }

    @Override
    public void visit(DoAttackCmd cmd) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visit(PlaceReinforcementCmd cmd) {
        if (cmd.getPlayer() != gameView.getCurrentPlayer()) {
            // TODO: Error handling
            return;
        }
        
        if (cmd.getTroops() < 0 || cmd.getTroops() > gameView.getAvailableReinforcement()) {
            // TODO: Error handling
            return;
        }
        
        if (cmd.getCountry().getOwner() != cmd.getPlayer()) {
            // TODO: Error handling
            return;
        }
        
        gameCtrl.setAvailableReinforcement(gameView.getAvailableReinforcement() - cmd.getTroops());
        Country country = gameView.getCountry(cmd.getCountry().getName());
        gameCtrl.addTroopsToCountry(country, cmd.getTroops());
        cmdSender.sendCmd(new PlaceReinforcementCmd(country, cmd.getTroops(), gameView.getCurrentPlayer()), null);
    }
}
