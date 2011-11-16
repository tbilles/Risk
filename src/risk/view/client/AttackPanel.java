package risk.view.client;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;

import risk.game.CountryPair;

import java.awt.FlowLayout;
import java.awt.Component;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class AttackPanel extends JPanel {
    private int fromCurrentArmies, toCurrentArmies; 
    /**
     * Create the panel.
     */
    public AttackPanel(CountryPair cp) {
        setLayout(new BorderLayout(0, 0));
        
        JLabel lblAttack = new JLabel("Attack");
        lblAttack.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblAttack.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblAttack, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{102, 0};
        gbl_panel_1.rowHeights = new int[]{0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);
        
        JLabel lblAttacker = new JLabel(cp.From.getOwner().getName());
        lblAttacker.setForeground(cp.From.getOwner().getColor());
        GridBagConstraints gbc_lblAttacker = new GridBagConstraints();
        gbc_lblAttacker.insets = new Insets(0, 0, 5, 0);
        gbc_lblAttacker.gridx = 0;
        gbc_lblAttacker.gridy = 0;
        panel_1.add(lblAttacker, gbc_lblAttacker);
        
        JLabel lblFrom = new JLabel(cp.From.getName());
        GridBagConstraints gbc_lblFrom = new GridBagConstraints();
        gbc_lblFrom.insets = new Insets(0, 0, 5, 0);
        gbc_lblFrom.gridx = 0;
        gbc_lblFrom.gridy = 1;
        panel_1.add(lblFrom, gbc_lblFrom);
        
        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.insets = new Insets(0, 0, 5, 0);
        gbc_panel_2.gridx = 0;
        gbc_panel_2.gridy = 2;
        panel_1.add(panel_2, gbc_panel_2);
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel label_2 = new JLabel("Current armies:");
        panel_2.add(label_2);
        
        JLabel lblFromCurrentArmies = new JLabel(cp.From.getTroops()+"");
        panel_2.add(lblFromCurrentArmies);
        
        JButton AThreeDice = new JButton("Attack with 3 dice");
        GridBagConstraints gbc_AThreeDice = new GridBagConstraints();
        gbc_AThreeDice.insets = new Insets(0, 0, 5, 0);
        gbc_AThreeDice.gridx = 0;
        gbc_AThreeDice.gridy = 3;
        panel_1.add(AThreeDice, gbc_AThreeDice);
        
        JButton ATwoDice = new JButton("Attack with 2 dice");
        GridBagConstraints gbc_ATwoDice = new GridBagConstraints();
        gbc_ATwoDice.insets = new Insets(0, 0, 5, 0);
        gbc_ATwoDice.gridx = 0;
        gbc_ATwoDice.gridy = 4;
        panel_1.add(ATwoDice, gbc_ATwoDice);
        
        JButton AOneDice = new JButton("Attack with 1 dice");
        GridBagConstraints gbc_AOneDice = new GridBagConstraints();
        gbc_AOneDice.insets = new Insets(0, 0, 5, 0);
        gbc_AOneDice.gridx = 0;
        gbc_AOneDice.gridy = 5;
        panel_1.add(AOneDice, gbc_AOneDice);
        
        JButton btnCancelAttack = new JButton("Cancel attack");
        GridBagConstraints gbc_btnCancelAttack = new GridBagConstraints();
        gbc_btnCancelAttack.insets = new Insets(0, 0, 5, 0);
        gbc_btnCancelAttack.gridx = 0;
        gbc_btnCancelAttack.gridy = 6;
        panel_1.add(btnCancelAttack, gbc_btnCancelAttack);
        
        JPanel panel_6 = new JPanel();
        GridBagConstraints gbc_panel_6 = new GridBagConstraints();
        gbc_panel_6.insets = new Insets(0, 0, 5, 0);
        gbc_panel_6.fill = GridBagConstraints.BOTH;
        gbc_panel_6.gridx = 0;
        gbc_panel_6.gridy = 7;
        panel_1.add(panel_6, gbc_panel_6);
        
        JPanel panel_7 = new JPanel();
        GridBagConstraints gbc_panel_7 = new GridBagConstraints();
        gbc_panel_7.insets = new Insets(2, 0, 5, 0);
        gbc_panel_7.fill = GridBagConstraints.BOTH;
        gbc_panel_7.gridx = 0;
        gbc_panel_7.gridy = 8;
        panel_1.add(panel_7, gbc_panel_7);
        panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel label_4 = new JLabel("Thrown:");
        panel_7.add(label_4);
        
        JLabel thrownAttacker = new JLabel("6;3;2");
        panel_7.add(thrownAttacker);
        
        JPanel panel_8 = new JPanel();
        GridBagConstraints gbc_panel_8 = new GridBagConstraints();
        gbc_panel_8.insets = new Insets(0, 0, 5, 0);
        gbc_panel_8.fill = GridBagConstraints.BOTH;
        gbc_panel_8.gridx = 0;
        gbc_panel_8.gridy = 9;
        panel_1.add(panel_8, gbc_panel_8);
        panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel label_6 = new JLabel("Armies after throwing:");
        panel_8.add(label_6);
        
        JLabel lblFromAfterArmies = new JLabel("?");
        panel_8.add(lblFromAfterArmies);
        
        JPanel panel_3 = new JPanel();
        panel.add(panel_3);
        GridBagLayout gbl_panel_3 = new GridBagLayout();
        gbl_panel_3.columnWidths = new int[]{102, 0};
        gbl_panel_3.rowHeights = new int[]{0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        panel_3.setLayout(gbl_panel_3);
        
        JLabel lblDefender = new JLabel(cp.To.getOwner().getName());
        lblDefender.setForeground(cp.To.getOwner().getColor());
        GridBagConstraints gbc_lblDefender = new GridBagConstraints();
        gbc_lblDefender.insets = new Insets(0, 0, 5, 0);
        gbc_lblDefender.gridx = 0;
        gbc_lblDefender.gridy = 0;
        panel_3.add(lblDefender, gbc_lblDefender);
        
        JLabel lblTo = new JLabel(cp.To.getName());
        GridBagConstraints gbc_lblTo = new GridBagConstraints();
        gbc_lblTo.insets = new Insets(0, 0, 5, 0);
        gbc_lblTo.gridx = 0;
        gbc_lblTo.gridy = 1;
        panel_3.add(lblTo, gbc_lblTo);
        
        JPanel panel_5 = new JPanel();
        GridBagConstraints gbc_panel_5 = new GridBagConstraints();
        gbc_panel_5.insets = new Insets(0, 0, 5, 0);
        gbc_panel_5.gridx = 0;
        gbc_panel_5.gridy = 2;
        panel_3.add(panel_5, gbc_panel_5);
        panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        
        JLabel label = new JLabel("Current armies:");
        panel_5.add(label);
        
        JLabel lblToCurrentArmies = new JLabel(cp.To.getTroops()+"");
        panel_5.add(lblToCurrentArmies);
        
        JButton DTwoDice = new JButton("Defend with 2 dice");
        GridBagConstraints gbc_DTwoDice = new GridBagConstraints();
        gbc_DTwoDice.insets = new Insets(0, 0, 5, 0);
        gbc_DTwoDice.gridx = 0;
        gbc_DTwoDice.gridy = 3;
        panel_3.add(DTwoDice, gbc_DTwoDice);
        
        JButton DOneDice = new JButton("Defend with 1 dice");
        GridBagConstraints gbc_DOneDice = new GridBagConstraints();
        gbc_DOneDice.insets = new Insets(0, 0, 5, 0);
        gbc_DOneDice.gridx = 0;
        gbc_DOneDice.gridy = 4;
        panel_3.add(DOneDice, gbc_DOneDice);
        
        JPanel panel_4 = new JPanel();
        GridBagConstraints gbc_panel_4 = new GridBagConstraints();
        gbc_panel_4.insets = new Insets(0, 0, 5, 0);
        gbc_panel_4.fill = GridBagConstraints.BOTH;
        gbc_panel_4.gridx = 0;
        gbc_panel_4.gridy = 5;
        panel_3.add(panel_4, gbc_panel_4);
        
        JPanel panel_9 = new JPanel();
        GridBagConstraints gbc_panel_9 = new GridBagConstraints();
        gbc_panel_9.anchor = GridBagConstraints.SOUTH;
        gbc_panel_9.insets = new Insets(33, 0, 5, 0);
        gbc_panel_9.gridx = 0;
        gbc_panel_9.gridy = 7;
        panel_3.add(panel_9, gbc_panel_9);
        panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel label_8 = new JLabel("Thrown:");
        panel_9.add(label_8);
        
        JLabel ThrownDeffender = new JLabel("6;3;2");
        panel_9.add(ThrownDeffender);
        
        JPanel panel_10 = new JPanel();
        GridBagConstraints gbc_panel_10 = new GridBagConstraints();
        gbc_panel_10.anchor = GridBagConstraints.SOUTH;
        gbc_panel_10.insets = new Insets(0, 0, 5, 0);
        gbc_panel_10.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel_10.gridx = 0;
        gbc_panel_10.gridy = 8;
        panel_3.add(panel_10, gbc_panel_10);
        panel_10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel label_10 = new JLabel("Armies after throwing:");
        panel_10.add(label_10);
        
        JLabel lblToAfterArmies = new JLabel("?");
        panel_10.add(lblToAfterArmies);

    }

}
