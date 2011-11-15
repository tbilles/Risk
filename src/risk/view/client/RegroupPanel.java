package risk.view.client;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JButton;

import risk.game.CountryPair;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class RegroupPanel extends JPanel {
    String from, to;
    int fromBefore, fromAfter, toBefore, toAfter;
    ArrayList<String> regroup=new ArrayList<String>();

    /**
     * Create the panel.
     */
    public RegroupPanel(CountryPair cp) {
        from = cp.From.getName();
        to = cp.To.getName();
        fromBefore = cp.From.getTroops();
        toBefore = cp.To.getTroops();

        setLayout(new BorderLayout(0, 0));

        JLabel lblRegroupArmies = new JLabel("Regroup armies");
        lblRegroupArmies.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblRegroupArmies.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegroupArmies.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(lblRegroupArmies, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JSeparator separator = new JSeparator();
        panel.add(separator);

        JPanel panel_6 = new JPanel();
        panel.add(panel_6);

        JLabel lblfrom = new JLabel(from);
        panel_6.add(lblfrom);

        JLabel label_8 = new JLabel("->");
        panel_6.add(label_8);

        JLabel lblto = new JLabel(to);
        panel_6.add(lblto);

        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        panel.add(panel_1);

        JLabel label = new JLabel("Current armies:");
        panel_1.add(label);

        JLabel label_1 = new JLabel(fromBefore + "");
        panel_1.add(label_1);

        JLabel label_2 = new JLabel("Current armies:");
        panel_1.add(label_2);

        JLabel label_3 = new JLabel(toBefore + "");
        panel_1.add(label_3);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2);

        JLabel lblRegroup = new JLabel("Regroup:");
        panel_2.add(lblRegroup);

        for (int i = 1; i < fromBefore; i++) {
            regroup.add(i+"");
        }
        final JComboBox amountOfRegroup = new JComboBox(regroup.toArray());
        amountOfRegroup.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                int delta=Integer.parseInt(amountOfRegroup.getSelectedItem().toString());
            }
        });
        amountOfRegroup.setSelectedIndex(1);
        panel_2.add(amountOfRegroup);

        JPanel panel_3 = new JPanel();
        panel.add(panel_3);

        JLabel label_4 = new JLabel("Armies after regroup:");
        panel_3.add(label_4);

        int delta=Integer.parseInt(amountOfRegroup.getSelectedItem().toString());
        fromAfter=fromBefore-delta;
        toAfter=toBefore+delta;
        JLabel label_5 = new JLabel(fromAfter+"");
        panel_3.add(label_5);

        JLabel label_6 = new JLabel("Armies after regroup:");
        panel_3.add(label_6);

        JLabel label_7 = new JLabel(toAfter+"");
        panel_3.add(label_7);

        JSeparator separator_1 = new JSeparator();
        panel.add(separator_1);

        JPanel panel_4 = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
        flowLayout_2.setAlignment(FlowLayout.RIGHT);
        add(panel_4, BorderLayout.SOUTH);

        JPanel panel_5 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
        flowLayout_1.setAlignment(FlowLayout.RIGHT);
        panel_4.add(panel_5);

        JButton button = new JButton("ok");
        panel_5.add(button);

        JButton button_1 = new JButton("cancel");
        panel_5.add(button_1);

    }

}
