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
    public ClientPanel() {
        JTextArea temp = RiskIO.getClientTextArea();
        temp.setRows(3);
        JScrollPane sp=new JScrollPane(temp);
        setLayout(new BorderLayout());
        add(sp, BorderLayout.NORTH);
        add(map, BorderLayout.CENTER);
    }
    public void refresh(GameView view){
        map.refresh(view);
    }
}
