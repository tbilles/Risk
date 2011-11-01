package risk.view;

import java.awt.BorderLayout;

import risk.common.RiskIO;
import risk.common.ImagePanel;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ClientPanel extends JPanel {
    ImageIcon image=new ImageIcon(getClass().getResource("/risk/view/Risk_small.jpg"));
    ImagePanel mapPanel= new ImagePanel(image.getImage());
    public ClientPanel() {
        JTextArea temp = RiskIO.getClientTextArea();
        temp.setRows(3);
        JScrollPane sp=new JScrollPane(temp);
        setLayout(new BorderLayout());
        add(sp, BorderLayout.NORTH);
        add(mapPanel, BorderLayout.CENTER);

    }
}
