package risk.view.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import risk.game.CountryPair;

public class AttackDialog extends JDialog {

    private AttackPanel attackPanel;
    private final JPanel contentPanel = new JPanel();


    /**
     * Create the dialog.
     */
    public AttackDialog(CountryPair cp) {
        setTitle("Attacking...");
        setBounds(100, 100, 300, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        attackPanel= new AttackPanel(this, cp);
        contentPanel.add(attackPanel);
    }

}
