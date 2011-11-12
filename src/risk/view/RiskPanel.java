package risk.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import risk.game.GameView;

public class RiskPanel extends JPanel {
    ControlPanel cp;
    GamePanel gp;

    public RiskPanel() {
        gp = new GamePanel();
        cp = new ControlPanel(this.gp);
        setLayout(new BorderLayout());
        add(cp, BorderLayout.NORTH);
        add(gp, BorderLayout.CENTER);
        setVisible(true);
    }

    public void serverStarted() {
        cp.serverStarted();
    }

    public void clientStarted(GameView gView) {
        cp.clientStarted(gView);
    }
}
