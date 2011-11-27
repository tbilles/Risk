package risk.view.server;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ServerPanel extends JPanel {
    private JLabel lblServer;

    public String getServerState() {
        return lblServer.getText();
    }

    public void setServerState(String state) {
        lblServer.setText(state);
    }

    /**
     * Create the panel.
     */
    public ServerPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{184,0};
        gridBagLayout.rowHeights = new int[]{14, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        lblServer = new JLabel("Server is running");
        GridBagConstraints gbc_lblServer = new GridBagConstraints();
        gbc_lblServer.insets = new Insets(0, 0, 0, 5);
        gbc_lblServer.gridx = 0;
        gbc_lblServer.gridy = 0;
        add(lblServer, gbc_lblServer);
    }

}
