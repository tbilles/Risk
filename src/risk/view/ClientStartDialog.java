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

public class ClientStartDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField playerTextField;
    private JTextField serverIPtextField;
    private JTextField txtPort;

    /**
     * Create the dialog.
     */
    public ClientStartDialog(RiskFrame frame) {
        super(frame, "Start new client...", true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100, 100, 300, 150);
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
            contentPanel.add(playerTextField);
            playerTextField.setColumns(10);
        }
        {
            JLabel lblServerIpAddress = new JLabel("Server IP address:");
            contentPanel.add(lblServerIpAddress);
        }
        {
            serverIPtextField = new JTextField();
            contentPanel.add(serverIPtextField);
            serverIPtextField.setColumns(10);
        }
        {
            JLabel lblPort = new JLabel("Listening port:");
            contentPanel.add(lblPort);
        }
        {
            txtPort = new JTextField();
            contentPanel.add(txtPort);
            txtPort.setColumns(10);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

}
