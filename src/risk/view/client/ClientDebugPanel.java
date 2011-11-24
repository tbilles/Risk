package risk.view.client;

import java.awt.BorderLayout;

import risk.common.RiskIO;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ClientDebugPanel extends JPanel {

    public ClientDebugPanel() {
        JTextArea temp = RiskIO.getClientTextArea();
        setLayout(new BorderLayout());
        JScrollPane sp=new JScrollPane();
        sp.setViewportView(temp);
        add(sp, BorderLayout.CENTER);
    }
}
