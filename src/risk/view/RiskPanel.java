package risk.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import risk.game.Controller;

public class RiskPanel extends JPanel {
    ControlPanel cp;
    GamePanel gp;

    public RiskPanel() {
        gp = new GamePanel();
        cp = new ControlPanel(this.gp);
        setLayout(new BorderLayout());
        //add(cp, BorderLayout.NORTH);
        add(gp, BorderLayout.CENTER);
        setVisible(true);
    }

    public void serverStarted() {
        cp.serverStarted();
    }

    public void clientStarted(Controller controller) {
        cp.clientStarted(controller);
    }
    public void changeToClientView(){
        gp.changeToClient();
    }
    public void changeToServerView(){
        gp.changeToServer();
    }
    public void changeToClientDebugView(){
        gp.changeToClientDebug();
    }
    public void changeToServerDebugView(){
        gp.changeToServerDebug();
    }
    public void gameFinished(){
        gp.changeToEmpty();
        gp.createNewClientPanel();
    }
}
