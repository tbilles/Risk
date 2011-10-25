package risk.view;

import java.awt.BorderLayout;

import risk.utils.RiskIO;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ServerPanel extends JPanel {

    public ServerPanel(){
        JTextArea temp=RiskIO.getServerTextArea();
        setLayout(new BorderLayout());
        add(temp, BorderLayout.CENTER);
        
    }
}
