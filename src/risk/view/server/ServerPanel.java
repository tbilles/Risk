package risk.view.server;

import java.awt.BorderLayout;

import risk.common.RiskIO;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ServerPanel extends JPanel {

    public ServerPanel() {
        JTextArea temp = RiskIO.getServerTextArea();
        setLayout(new BorderLayout());
        add(temp, BorderLayout.CENTER);

    }
}
