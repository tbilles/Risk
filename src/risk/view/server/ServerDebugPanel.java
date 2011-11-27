package risk.view.server;

import java.awt.BorderLayout;

import risk.common.RiskIO;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerDebugPanel extends JPanel {

    public ServerDebugPanel() {
        JTextArea temp = RiskIO.getServerTextArea();
        setLayout(new BorderLayout());
        JScrollPane sp=new JScrollPane();
        sp.setViewportView(temp);
        add(sp, BorderLayout.CENTER);
    }
}
