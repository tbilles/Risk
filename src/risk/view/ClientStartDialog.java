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
import javax.swing.JSeparator;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

import risk.common.Settings;

public class ClientStartDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField playerTextField;
    private JTextField serverIPTextField;
    private JTextField txtPort;
    private final Action action = new SwingAction();
    private static boolean createClient=false;
    private final Action action_1 = new SwingAction_1();

    public static boolean isCreateClient() {
        return createClient;
    }

    /**
     * Create the dialog.
     */
    public ClientStartDialog(RiskFrame frame) {
        super(frame, "Start new client...", true);
        
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100, 100, 300, 150);
        setLocationRelativeTo(frame);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(3, 2, 0, 0));
        {
            JLabel lblplayerName = new JLabel("Player name:");
            contentPanel.add(lblplayerName);
        }
        {
            playerTextField = new JTextField();
            playerTextField.setText(Settings.getInstance().getPlayerName());
            contentPanel.add(playerTextField);
            playerTextField.setColumns(10);
        }
        {
            JLabel lblServerIpAddress = new JLabel("Server IP address:");
            contentPanel.add(lblServerIpAddress);
        }
        {
            serverIPTextField = new JTextField();
            serverIPTextField.setText(Settings.getInstance().getClientConnectAddr());
            contentPanel.add(serverIPTextField);
            serverIPTextField.setColumns(10);
        }
        {
            JLabel lblPort = new JLabel("Listening port:");
            contentPanel.add(lblPort);
        }
        {
            txtPort = new JTextField();
            txtPort.setText(Settings.getInstance().getClientConnectPort()+"");
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
            putValue(NAME, "Start client");
            putValue(SHORT_DESCRIPTION, "Save settings and start a new client");
        }
        public void actionPerformed(ActionEvent e) {
                createClient=true;
                Settings.getInstance().setPlayerName(playerTextField.getText());
                Settings.getInstance().setClientConnectAddr(serverIPTextField.getText());
                try{
                    int port=Integer.parseInt(txtPort.getText());
                    Settings.getInstance().setClientConnectPort(port);
                    dispose();
                }
                catch(NumberFormatException nfe){
                    javax.swing.JOptionPane.showMessageDialog(txtPort, 
                            "Invalid port number!","Warning!",
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
                createClient=false;
                dispose();
        }
    }
}
