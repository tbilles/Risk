package risk.view;

import java.awt.BorderLayout;

import risk.utils.RiskIO;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ClientPanel extends JPanel {

    public ClientPanel() {
        JTextArea temp = RiskIO.getClientTextArea();
        setLayout(new BorderLayout());
        add(temp, BorderLayout.CENTER);

    }
}
