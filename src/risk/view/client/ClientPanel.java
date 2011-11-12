package risk.view.client;

import java.awt.BorderLayout;

import risk.common.RiskIO;
import risk.common.ImagePanel;
import risk.game.GameView;
import risk.game.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ClientPanel extends JPanel implements Observer{
    MapPanel map=new MapPanel();
    FeedbackPanel fbp=new FeedbackPanel();
    public ClientPanel() {
        setLayout(new BorderLayout());
        add(map, BorderLayout.CENTER);
        add(fbp, BorderLayout.EAST);
    }
    public void refresh(GameView view){
        map.refresh(view);
        fbp.refresh(view);
    }
}
