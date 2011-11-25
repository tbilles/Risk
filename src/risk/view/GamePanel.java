package risk.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

import risk.game.Controller;
import risk.game.client.GameClient;
import risk.view.client.ClientDebugPanel;
import risk.view.client.ClientPanel;
import risk.view.server.ServerPanel;

public class GamePanel extends JPanel {
    private CardLayout clay = new CardLayout();
    private ClientPanel cp;
    private ClientDebugPanel cdp;
    private ServerPanel sp;
    private JPanel empty;
    private Controller myController;

    public GamePanel() {

        setLayout(clay);
        empty = new JPanel();
        add(empty, "empty");
        cp = new ClientPanel();
        add(cp, "client");
        cdp = new ClientDebugPanel();
        add(cdp, "clientDebug");
        sp = new ServerPanel();
        add(sp, "server");
    }

    public void changeToEmpty() {
        clay.show(this, "empty");
    }

    public void changeToServer() {
        clay.show(this, "server");
    }

    public void changeToClient() {
        cp=new ClientPanel();
        this.add(cp, "client");
        clay.show(this, "client");
    }
    
    public void changeToClientDebug(){
        clay.show(this, "clientDebug");
    }

    public void clientStarted(Controller controller) {
        myController = controller;
        cp.setController(controller);
        myController.getGameView().registerObserver(cp);
        myController.getGameView().registerMsgListener(cp);
    }
}
