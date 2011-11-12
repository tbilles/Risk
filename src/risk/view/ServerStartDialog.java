package risk.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.net.InetAddress;
import java.net.UnknownHostException;

import risk.common.Logger;
import risk.common.Settings;

public class ServerStartDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField serverNameTextField;
    private JTextField serverIPTextField;
    private JTextField txtPort;
    private final Action action = new SwingAction();
    private static boolean createServer = false;
    private final Action action_1 = new SwingAction_1();
    private String serverAddress = "Unknown", serverName = "Unknown";

    public static boolean isCreateServer() {
        return createServer;
    }

    /**
     * Create the dialog.
     */
    public ServerStartDialog(RiskFrame frame) {
        super(frame, "Start new client...", true);

        try {
            serverName=InetAddress.getLocalHost().getHostName();
            serverAddress=InetAddress.getLocalHost().getHostAddress();
            
          } catch (UnknownHostException e) {
            Logger.logexception(e, "ServerStartDialog couldn't get the local host's address and name");
          }
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100, 100, 300, 150);
        setLocationRelativeTo(frame);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(3, 2, 0, 0));
        {
            JLabel lblServerName = new JLabel("Server name:");
            contentPanel.add(lblServerName);
        }
        {
            serverNameTextField = new JTextField();
            serverNameTextField.setText(serverName);
            contentPanel.add(serverNameTextField);
            serverNameTextField.setColumns(10);
        }
        {
            JLabel lblServerIpAddress = new JLabel("Server IP address:");
            contentPanel.add(lblServerIpAddress);
        }
        {
            serverIPTextField = new JTextField();
            serverIPTextField.setText(serverAddress);
            contentPanel.add(serverIPTextField);
            serverIPTextField.setColumns(10);
        }
        {
            JLabel lblPort = new JLabel("Listening port:");
            contentPanel.add(lblPort);
        }
        {
            txtPort = new JTextField();
            txtPort.setText(Settings.getInstance().getServerListenPort() + "");
            contentPanel.add(txtPort);
            txtPort.setColumns(10);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setAction(action);
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setAction(action_1);
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
        setVisible(true);
    }

    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "Start server");
            putValue(SHORT_DESCRIPTION, "Save settings and start a new server");
        }

        public void actionPerformed(ActionEvent e) {
            createServer = true;
            try {
                int port = Integer.parseInt(txtPort.getText());
                Settings.getInstance().setServerListenPort(port);
                dispose();
            } catch (NumberFormatException nfe) {
                javax.swing.JOptionPane.showMessageDialog(txtPort,
                        "Invalid port number!", "Warning!",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private class SwingAction_1 extends AbstractAction {
        public SwingAction_1() {
            putValue(NAME, "Cancel");
            putValue(SHORT_DESCRIPTION, "Cancel and close this dialog");
        }

        public void actionPerformed(ActionEvent e) {
            createServer = false;
            dispose();
        }
    }
}
