package risk.view.client;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import risk.game.Controller;
import risk.game.CountryPair;

public class RegroupDialog extends JDialog {
    private RegroupPanel panel;
    private final JPanel contentPanel = new JPanel();
    private Controller controller;



    /**
     * Create the dialog.
     */
    public RegroupDialog(CountryPair cp, Controller controller) {
        this.controller=controller;
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setBounds(100, 100, 360, 218);
        setTitle("Regrouping...");
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel= new RegroupPanel(this, cp, controller);
        contentPanel.add(panel);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setVisible(true);
    }

}
