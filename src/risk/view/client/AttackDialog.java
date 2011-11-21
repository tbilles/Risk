package risk.view.client;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import risk.game.Attack;
import risk.game.Controller;
import risk.game.CountryPair;

public class AttackDialog extends JDialog {

    private AttackPanel attackPanel;
    private final JPanel contentPanel = new JPanel();
    private Controller controller;
    private int viewerType;

    /**
     * Create the dialog.
     */
    public AttackDialog(Attack a, Controller controller, int viewerType) {
        this.controller = controller;
        this.viewerType = viewerType;
        setTitle("Attacking...");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showWarning();
            }
        });
        setBounds(100, 100, 289, 328);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        attackPanel = new AttackPanel(this, a, viewerType, controller);
        contentPanel.add(attackPanel);
        setVisible(true);
    }

    public void refresh(Attack attack) {
        attackPanel.refresh(attack);
    }

    private void showWarning() {
        if (viewerType == 0) {
            JOptionPane.showMessageDialog(this, "Figyelem!",
                    "Bocs, de ezt neked is végig kell nézni...", JOptionPane.PLAIN_MESSAGE);
        }
        if (viewerType == 1) {
            controller.onAttackRetreat();
            this.dispose();
        }
        if (viewerType == 2) {
            JOptionPane.showMessageDialog(this, "Küzdj és bízva bízzál!",
                    "Szép próbálkozás, de nem...", JOptionPane.PLAIN_MESSAGE);
        }
    }

}
