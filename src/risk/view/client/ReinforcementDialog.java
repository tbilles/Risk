package risk.view.client;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import risk.game.Country;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Action;

public class ReinforcementDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private final Action okAction = new SwingAction();
    private final Action cancelAction = new SwingAction_1();
    private Country c;
    private JComboBox numFortify;

    /**
     * Create the dialog.
     */
    public ReinforcementDialog(Country c, int availableTroops) {
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        this.c=c;
        setTitle("Fortify");
        setBounds(100, 100, 448, 106);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        {
            JLabel lblYouHave = new JLabel("Reinforcement to " + c.getName()
                    + ":");
            contentPanel.add(lblYouHave);
        }
        {
            ArrayList<String> temp=new ArrayList<String>();
            for (int i = 1; i <= availableTroops; i++) {
                temp.add(i+"");
            }
            numFortify = new JComboBox(temp.toArray());
            contentPanel.add(numFortify);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setAction(okAction);
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setAction(cancelAction);
                buttonPane.add(cancelButton);
            }
            setVisible(true);
        }
    }
    public int getSelectedTroopsNumber(){
        return Integer.parseInt(numFortify.getSelectedItem().toString());
    }

    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "Ok");
            putValue(SHORT_DESCRIPTION,
                    "Finish the fortify of the country and close this dialog.");
        }

        public void actionPerformed(ActionEvent e) {
            c.setTroops(getSelectedTroopsNumber());
            setVisible(false);
            dispose();
        }
    }

    private class SwingAction_1 extends AbstractAction {
        public SwingAction_1() {
            putValue(NAME, "Cancel");
            putValue(SHORT_DESCRIPTION,
                    "Cancel the fortify of the country and close this dialog.");
        }

        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
        }
    }
}
