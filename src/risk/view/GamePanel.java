package risk.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

import risk.game.GameView;
import risk.view.client.ClientPanel;
import risk.view.server.ServerPanel;

public class GamePanel extends JPanel {
    private CardLayout clay = new CardLayout();
    private ClientPanel cp;
    private ServerPanel sp;
    private JPanel empty;

    public GamePanel() {

        setLayout(clay);
        empty = new JPanel();
        add(empty, "empty");
        cp = new ClientPanel();
        add(cp, "client");
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
        clay.show(this, "client");
    }

    public void clientStarted(GameView gameView) {
        gameView.registerObserver(cp);
    }
}
