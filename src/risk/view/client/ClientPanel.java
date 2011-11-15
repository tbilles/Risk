package risk.view.client;

import java.awt.BorderLayout;

import risk.game.Controller;
import risk.game.Country;
import risk.game.CountryPair;
import risk.game.GameView;
import risk.game.Observer;
import risk.game.View;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class ClientPanel extends JPanel implements Observer, View {
    private MapPanel map = new MapPanel();
    private FeedbackPanel fbp = new FeedbackPanel();
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
        map.setController(controller);
    }

    public ClientPanel() {
        setLayout(new BorderLayout());
        add(map, BorderLayout.CENTER);
        add(fbp, BorderLayout.EAST);
    }

    public void refresh(GameView view) {
        map.refresh(view);
        fbp.refresh(view);
    }

    @Override
    public void showReinforcementDialog(Country to) {
        // TODO Auto-generated method stub

    }

    @Override
    public void showAttackDialog(CountryPair cp) {
        // TODO Auto-generated method stub

    }

    @Override
    public void showRegroupDialog(CountryPair cp) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Message!",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
