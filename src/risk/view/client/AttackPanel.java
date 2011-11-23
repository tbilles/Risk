package risk.view.client;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;

import risk.common.Logger;
import risk.game.Attack;
import risk.game.Controller;
import risk.game.CountryPair;

import java.awt.FlowLayout;
import java.awt.Component;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.image.ColorModel;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.Action;

public class AttackPanel extends JPanel {
    private int fromCurrentArmies, toCurrentArmies;
    private AttackDialog parent;
    private JLabel thrownAttacker, thrownDefender, lblFromAfterArmies,
            lblToAfterArmies, lblFromCurrentArmies, lblToCurrentArmies;
    private JButton aThreeDice, aTwoDice, aOneDice, btnCancelAttack, dTwoDice,
            dOneDice;
    private Controller controller;
    private int viewerType;
    private Color defaultColor;
    private CountryPair cp;
    private final Action a3 = new SwingAction();
    private final Action a2 = new SwingAction_1();
    private final Action a1 = new SwingAction_2();
    private final Action aCancel = new SwingAction_3();
    private final Action d2 = new SwingAction_4();
    private final Action d1 = new SwingAction_5();

    /**
     * Create the panel. viewerType==0: all buttons disabled viewerType==1:
     * defender buttons disabled (attacker mode) viewerType==2: attacker buttons
     * disabled (defender mode)
     */
    public AttackPanel(AttackDialog ad, Attack a, int viewerType,
            Controller controller) {
        this.controller = controller;
        this.viewerType = viewerType;
        cp = a.getCountryPair();
        parent = ad;
        setLayout(new BorderLayout(0, 0));

        JLabel lblAttack = new JLabel("Attack");
        lblAttack.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblAttack.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblAttack, BorderLayout.NORTH);

        JPanel panel_11 = new JPanel();
        add(panel_11, BorderLayout.CENTER);
        GridBagLayout gbl_panel_11 = new GridBagLayout();
        gbl_panel_11.columnWidths = new int[] { 110, 110, 0 };
        gbl_panel_11.rowHeights = new int[] { 24, 24, 24, 24, 0, 0, 0, 0, 0, 0 };
        gbl_panel_11.columnWeights = new double[] { 0.5, 0.5, Double.MIN_VALUE };
        gbl_panel_11.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel_11.setLayout(gbl_panel_11);

        JLabel lblAttacker = new JLabel(cp.From.getOwner().getName());
        GridBagConstraints gbc_lblAttacker = new GridBagConstraints();
        gbc_lblAttacker.insets = new Insets(0, 0, 5, 5);
        gbc_lblAttacker.gridx = 0;
        gbc_lblAttacker.gridy = 0;
        panel_11.add(lblAttacker, gbc_lblAttacker);
        lblAttacker.setForeground(cp.From.getOwner().getColor());

        JLabel lblDefender = new JLabel(cp.To.getOwner().getName());
        GridBagConstraints gbc_lblDefender = new GridBagConstraints();
        gbc_lblDefender.insets = new Insets(0, 0, 5, 5);
        gbc_lblDefender.gridx = 1;
        gbc_lblDefender.gridy = 0;
        panel_11.add(lblDefender, gbc_lblDefender);
        lblDefender.setForeground(cp.To.getOwner().getColor());

        JLabel lblFrom = new JLabel(cp.From.getName());
        GridBagConstraints gbc_lblFrom = new GridBagConstraints();
        gbc_lblFrom.insets = new Insets(0, 0, 5, 5);
        gbc_lblFrom.gridx = 0;
        gbc_lblFrom.gridy = 1;
        panel_11.add(lblFrom, gbc_lblFrom);

        JLabel lblTo = new JLabel(cp.To.getName());
        GridBagConstraints gbc_lblTo = new GridBagConstraints();
        gbc_lblTo.insets = new Insets(0, 0, 5, 5);
        gbc_lblTo.gridx = 1;
        gbc_lblTo.gridy = 1;
        panel_11.add(lblTo, gbc_lblTo);

        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.anchor = GridBagConstraints.NORTH;
        gbc_panel_2.insets = new Insets(0, 0, 5, 5);
        gbc_panel_2.gridx = 0;
        gbc_panel_2.gridy = 2;
        panel_11.add(panel_2, gbc_panel_2);
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel label_2 = new JLabel("Current armies:");
        panel_2.add(label_2);

        lblFromCurrentArmies = new JLabel(cp.From.getTroops() + "");
        panel_2.add(lblFromCurrentArmies);

        JPanel panel_5 = new JPanel();
        GridBagConstraints gbc_panel_5 = new GridBagConstraints();
        gbc_panel_5.insets = new Insets(0, 0, 5, 5);
        gbc_panel_5.gridx = 1;
        gbc_panel_5.gridy = 2;
        panel_11.add(panel_5, gbc_panel_5);
        panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        JLabel label = new JLabel("Current armies:");
        panel_5.add(label);

        lblToCurrentArmies = new JLabel(cp.To.getTroops() + "");
        panel_5.add(lblToCurrentArmies);

        aThreeDice = new JButton("Attack with 3 dice");
        GridBagConstraints gbc_aThreeDice = new GridBagConstraints();
        gbc_aThreeDice.anchor = GridBagConstraints.NORTH;
        gbc_aThreeDice.insets = new Insets(0, 5, 5, 5);
        gbc_aThreeDice.gridx = 0;
        gbc_aThreeDice.gridy = 3;
        panel_11.add(aThreeDice, gbc_aThreeDice);
        aThreeDice.setAction(a3);

        dTwoDice = new JButton("Defend with 2 dice");
        GridBagConstraints gbc_dTwoDice = new GridBagConstraints();
        gbc_dTwoDice.anchor = GridBagConstraints.NORTH;
        gbc_dTwoDice.insets = new Insets(0, 0, 5, 5);
        gbc_dTwoDice.gridx = 1;
        gbc_dTwoDice.gridy = 3;
        panel_11.add(dTwoDice, gbc_dTwoDice);
        dTwoDice.setAction(d2);

        aTwoDice = new JButton("Attack with 2 dice");
        GridBagConstraints gbc_aTwoDice = new GridBagConstraints();
        gbc_aTwoDice.anchor = GridBagConstraints.NORTH;
        gbc_aTwoDice.insets = new Insets(0, 5, 5, 5);
        gbc_aTwoDice.gridx = 0;
        gbc_aTwoDice.gridy = 4;
        panel_11.add(aTwoDice, gbc_aTwoDice);
        aTwoDice.setAction(a2);

        dOneDice = new JButton("Defend with 1 dice");
        GridBagConstraints gbc_dOneDice = new GridBagConstraints();
        gbc_dOneDice.anchor = GridBagConstraints.NORTH;
        gbc_dOneDice.insets = new Insets(0, 0, 5, 5);
        gbc_dOneDice.gridx = 1;
        gbc_dOneDice.gridy = 4;
        panel_11.add(dOneDice, gbc_dOneDice);
        dOneDice.setAction(d1);

        aOneDice = new JButton("Attack with 1 dice");
        GridBagConstraints gbc_aOneDice = new GridBagConstraints();
        gbc_aOneDice.anchor = GridBagConstraints.NORTH;
        gbc_aOneDice.insets = new Insets(0, 5, 5, 5);
        gbc_aOneDice.gridx = 0;
        gbc_aOneDice.gridy = 5;
        panel_11.add(aOneDice, gbc_aOneDice);
        aOneDice.setAction(a1);

        defaultColor = aOneDice.getBackground();

        btnCancelAttack = new JButton("Cancel attack");
        GridBagConstraints gbc_btnCancelAttack = new GridBagConstraints();
        gbc_btnCancelAttack.anchor = GridBagConstraints.NORTH;
        gbc_btnCancelAttack.insets = new Insets(0, 5, 5, 5);
        gbc_btnCancelAttack.gridx = 0;
        gbc_btnCancelAttack.gridy = 6;
        panel_11.add(btnCancelAttack, gbc_btnCancelAttack);
        btnCancelAttack.setAction(aCancel);

        JPanel panel_7 = new JPanel();
        GridBagConstraints gbc_panel_7 = new GridBagConstraints();
        gbc_panel_7.anchor = GridBagConstraints.NORTH;
        gbc_panel_7.insets = new Insets(0, 5, 5, 5);
        gbc_panel_7.gridx = 0;
        gbc_panel_7.gridy = 7;
        panel_11.add(panel_7, gbc_panel_7);
        panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel label_4 = new JLabel("Thrown:");
        panel_7.add(label_4);

        thrownAttacker = new JLabel("");
        panel_7.add(thrownAttacker);

        JPanel panel_9 = new JPanel();
        GridBagConstraints gbc_panel_9 = new GridBagConstraints();
        gbc_panel_9.anchor = GridBagConstraints.NORTH;
        gbc_panel_9.insets = new Insets(0, 0, 5, 5);
        gbc_panel_9.gridx = 1;
        gbc_panel_9.gridy = 7;
        panel_11.add(panel_9, gbc_panel_9);
        panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel label_8 = new JLabel("Thrown:");
        panel_9.add(label_8);

        thrownDefender = new JLabel("");
        panel_9.add(thrownDefender);

        JPanel panel_8 = new JPanel();
        GridBagConstraints gbc_panel_8 = new GridBagConstraints();
        gbc_panel_8.anchor = GridBagConstraints.NORTH;
        gbc_panel_8.insets = new Insets(0, 0, 0, 5);
        gbc_panel_8.gridx = 0;
        gbc_panel_8.gridy = 8;
        panel_11.add(panel_8, gbc_panel_8);
        panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel label_6 = new JLabel("Died in last throw:");
        panel_8.add(label_6);

        lblFromAfterArmies = new JLabel("");
        panel_8.add(lblFromAfterArmies);

        JPanel panel_10 = new JPanel();
        GridBagConstraints gbc_panel_10 = new GridBagConstraints();
        gbc_panel_10.anchor = GridBagConstraints.NORTH;
        gbc_panel_10.insets = new Insets(0, 0, 0, 5);
        gbc_panel_10.gridx = 1;
        gbc_panel_10.gridy = 8;
        panel_11.add(panel_10, gbc_panel_10);
        panel_10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel label_10 = new JLabel("Died in last throw:");
        panel_10.add(label_10);

        lblToAfterArmies = new JLabel("");
        panel_10.add(lblToAfterArmies);
        setButtonsStatus(null);
    }

    public void refresh(Attack attack) {
        setButtonsStatus(attack);
        Collection<Integer> temp = attack.getaDiceResults();
        if (temp != null) {
            String tempS = "";
            for (Integer i : temp) {
                tempS += i + ";";
            }
            if (tempS.endsWith(";"))
                tempS.substring(0, tempS.length() - 1);
            thrownAttacker.setText(tempS);
            tempS = "";
            temp = attack.getdDiceResults();
            for (Integer i : temp) {
                tempS += i + ";";
            }
            if (tempS.endsWith(";"))
                tempS.substring(0, tempS.length() - 1);
            thrownDefender.setText(tempS);
        }
        int[] deltas = attack.calcLosses();
        int deltaA = deltas[0];
        int deltaD = deltas[1];
        lblFromCurrentArmies.setText(attack.getCountryPair().From.getTroops()
                + "");
        lblToCurrentArmies.setText(attack.getCountryPair().To.getTroops() + "");
        lblFromAfterArmies.setText(deltaA + "");
        lblToAfterArmies.setText(deltaD + "");

    }

    private void disableAllButtons() {
        dOneDice.setEnabled(false);
        dTwoDice.setEnabled(false);
        aOneDice.setEnabled(false);
        aTwoDice.setEnabled(false);
        aThreeDice.setEnabled(false);
        btnCancelAttack.setEnabled(false);
    }

    private void setButtonsStatus(Attack attack) {
        dOneDice.setEnabled(true);
        dOneDice.setBackground(defaultColor);
        dTwoDice.setEnabled(true);
        dTwoDice.setBackground(defaultColor);
        aOneDice.setEnabled(true);
        aOneDice.setBackground(defaultColor);
        aTwoDice.setEnabled(true);
        aTwoDice.setBackground(defaultColor);
        aThreeDice.setEnabled(true);
        aThreeDice.setBackground(defaultColor);
        btnCancelAttack.setEnabled(true);
        btnCancelAttack.setBackground(defaultColor);
        if (viewerType == 0) {
            disableAllButtons();
        }
        if (viewerType == 1) {
            if (attack == null || (attack.getAttackerDice() < 0)) {
                if (cp.From.getTroops() < 4)
                    aThreeDice.setEnabled(false);
                if (cp.From.getTroops() < 3)
                    aTwoDice.setEnabled(false);
                if (cp.From.getTroops() < 2)
                    aOneDice.setEnabled(false);
            } else {
                aThreeDice.setEnabled(false);
                aTwoDice.setEnabled(false);
                aOneDice.setEnabled(false);
                btnCancelAttack.setEnabled(false);
            }
            dOneDice.setEnabled(false);
            dTwoDice.setEnabled(false);
        }
        if (viewerType == 2) {
            if (attack != null && (attack.getDefenderDice() < 0)) {
                if (cp.To.getTroops() < 2)
                    dTwoDice.setEnabled(false);
                if (cp.To.getTroops() < 1)
                    dOneDice.setEnabled(false);
            } else {
                dTwoDice.setEnabled(false);
                dOneDice.setEnabled(false);
            }
            aOneDice.setEnabled(false);
            aTwoDice.setEnabled(false);
            aThreeDice.setEnabled(false);
            btnCancelAttack.setEnabled(false);
        }
        if (attack != null) {
            if (attack.getAttackerDice() > 0) {
                if (attack.getAttackerDice() == 0)
                    btnCancelAttack.setBackground(Color.LIGHT_GRAY);
                if (attack.getAttackerDice() == 1)
                    aOneDice.setBackground(Color.LIGHT_GRAY);
                if (attack.getAttackerDice() == 2)
                    aTwoDice.setBackground(Color.LIGHT_GRAY);
                if (attack.getAttackerDice() == 3)
                    aThreeDice.setBackground(Color.LIGHT_GRAY);
            }
            if (attack.getDefenderDice() > 0) {
                if (attack.getDefenderDice() == 1) {
                    dOneDice.setBackground(Color.LIGHT_GRAY);
                }
                if (attack.getDefenderDice() == 2) {
                    dTwoDice.setBackground(Color.LIGHT_GRAY);
                }
            }
        }

    }

    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "Attack with 3 dice");
            putValue(SHORT_DESCRIPTION, "Attack with 3 dice");
        }

        public void actionPerformed(ActionEvent e) {
            boolean b = controller.onAttack_AttackerChose(3);
            if (b) {
                disableAllButtons();
            }
        }
    }

    private class SwingAction_1 extends AbstractAction {
        public SwingAction_1() {
            putValue(NAME, "Attack with 2 dice");
            putValue(SHORT_DESCRIPTION, "Attack with 2 dice");
        }

        public void actionPerformed(ActionEvent e) {
            boolean b = controller.onAttack_AttackerChose(2);
            if (b) {
                disableAllButtons();
            }
        }
    }

    private class SwingAction_2 extends AbstractAction {
        public SwingAction_2() {
            putValue(NAME, "Attack with 1 dice");
            putValue(SHORT_DESCRIPTION, "Attack with 1 dice");
        }

        public void actionPerformed(ActionEvent e) {
            boolean b = controller.onAttack_AttackerChose(1);
            if (b) {
                disableAllButtons();
            }
        }
    }

    private class SwingAction_3 extends AbstractAction {
        public SwingAction_3() {
            putValue(NAME, "Cancel attack");
            putValue(SHORT_DESCRIPTION, "Cancel attack");
        }

        public void actionPerformed(ActionEvent e) {
            boolean b = controller.onAttackRetreat();
            if (b) {
                disableAllButtons();
            }
        }
    }

    private class SwingAction_4 extends AbstractAction {
        public SwingAction_4() {
            putValue(NAME, "Defend with 2 dice");
            putValue(SHORT_DESCRIPTION, "Defend with 2 dice");
        }

        public void actionPerformed(ActionEvent e) {
            boolean b = controller.onAttack_DefenderChose(2);
            if (b) {
                disableAllButtons();
            }
        }
    }

    private class SwingAction_5 extends AbstractAction {
        public SwingAction_5() {
            putValue(NAME, "Defend with 1 dice");
            putValue(SHORT_DESCRIPTION, "Defend with 1 dice");
        }

        public void actionPerformed(ActionEvent e) {
            boolean b = controller.onAttack_DefenderChose(1);
            if (b) {
                disableAllButtons();
            }
        }
    }
}
