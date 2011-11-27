package risk.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

import risk.game.Controller;
import risk.game.client.GameClient;
import risk.view.client.ClientDebugPanel;
import risk.view.client.ClientPanel;
import risk.view.server.*;

public class GamePanel extends JPanel {
    private CardLayout clay = new CardLayout();
    private ClientPanel cp;
    private ServerPanel sp;
    private ClientDebugPanel cdp;
    private ServerDebugPanel sdp;
    private JPanel empty;
    private Controller myController;

    public GamePanel() {

        setLayout(clay);
        empty = new JPanel();
        add(empty, "empty");
        cp = new ClientPanel();
        add(cp, "client");
        sp = new ServerPanel();
        add(sp, "server");
        cdp = new ClientDebugPanel();
        add(cdp, "clientDebug");
        sdp= new ServerDebugPanel();
        add(sdp, "serverDebug");
    }

    public void changeToEmpty() {
        clay.show(this, "empty");
    }

    public void changeToServer() {
        clay.show(this, "server");
    }

    public void changeToClient() {
        clay.show(this, "client");
    }
    
    public void changeToClientDebug(){
        clay.show(this, "clientDebug");
    }
    
    public void changeToServerDebug(){
        clay.show(this, "serverDebug");
    }

    public void clientStarted(Controller controller) {
        myController = controller;
        cp.setController(controller);
        myController.getGameView().registerObserver(cp);
        myController.getGameView().registerMsgListener(cp);
    }
    public void createNewClientPanel(){
        cp=new ClientPanel();
        this.add(cp, "client");
    }
}
