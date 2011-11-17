package risk.view.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import risk.game.CountryPair;

public class RegroupDialog extends JDialog {
    private RegroupPanel panel;
    private final JPanel contentPanel = new JPanel();



    /**
     * Create the dialog.
     */
    public RegroupDialog(CountryPair cp) {
        setBounds(100, 100, 320, 160);
        setTitle("Regrouping...");
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel= new RegroupPanel(this, cp);
        contentPanel.add(panel);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
    }

}
