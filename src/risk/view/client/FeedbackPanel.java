package risk.view.client;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import risk.common.RiskIO;
import risk.game.Controller;
import risk.game.GameView;
import risk.game.Player;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collection;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Label;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class FeedbackPanel extends JPanel {
    private JTextArea messages=new JTextArea();
    private ArrayList<JLabel> players=new ArrayList<JLabel>();
    JPanel playersPanel = new JPanel();
    private Controller controller;
    public void setController(Controller controller) {
        this.controller = controller;
    }

    private final Action action = new SwingAction();
    /**
     * Create the panel.
     */
    public FeedbackPanel() {
        setPreferredSize(new Dimension(128, 648));
        setMinimumSize(new Dimension(128, 648));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JTextArea temp = RiskIO.getClientTextArea();
        temp.setEditable(false);
        temp.setRows(5);
        JScrollPane sp = new JScrollPane(temp);
        JPanel debugPanel = new JPanel();
        add(debugPanel);
        debugPanel.setLayout(new BorderLayout());
        debugPanel.add(sp, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(messages);
        messages.setEditable(false);
        panel.add(scrollPane);
        playersPanel.setPreferredSize(new Dimension(128, 100));

        
        add(playersPanel);
        playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
        
        JPanel myCardsPanel = new JPanel();
        myCardsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(myCardsPanel);
        myCardsPanel.setLayout(new MigLayout("", "[44px][5px][47px]", "[22px][14px][14px][14px]"));
        
        Label label = new Label("My risk cards:");
        label.setFont(new Font("Dialog", Font.BOLD, 12));
        myCardsPanel.add(label, "cell 0 0 3 1,alignx center,aligny top");
        
        JLabel lblNewLabel = new JLabel("Infantry:");
        myCardsPanel.add(lblNewLabel, "cell 0 1,alignx left,aligny top");
        
        JLabel lblNewLabel_2 = new JLabel("0");
        myCardsPanel.add(lblNewLabel_2, "cell 2 1,alignx left,aligny top");
        
        JLabel lblNewLabel_1 = new JLabel("Cavalry:");
        myCardsPanel.add(lblNewLabel_1, "cell 0 2,alignx center,aligny top");
        
        JLabel lblNewLabel_3 = new JLabel("0");
        myCardsPanel.add(lblNewLabel_3, "cell 2 2,alignx left,aligny top");
        
        JLabel lblA = new JLabel("Artillery:");
        myCardsPanel.add(lblA, "cell 0 3,alignx center,aligny top");
        
        JLabel lblNewLabel_4 = new JLabel("0");
        myCardsPanel.add(lblNewLabel_4, "cell 2 3,alignx left,aligny top");
        
        JButton btnFinishedMyTurn = new JButton("Finished my turn");
        btnFinishedMyTurn.setAction(action);
        add(btnFinishedMyTurn);

    }

    public void refresh(GameView view) {
        refreshPlayers(view.getPlayers());

    }
    public void addMessage(Object message){
        messages.append(message.toString()+"\n");
    }

    public void addMessage(String message){
        messages.append(message+"\n");
    }
    private void refreshPlayers(Collection<Player> playerCollection) {
        players.clear();
        for(Player p: playerCollection){
            JLabel temp=new JLabel(p.getName());
            temp.setForeground(p.getColor());
            players.add(temp);
        }
        playersPanel.removeAll();
        for(JLabel l: players){
            playersPanel.add(l);
        }
    }

    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "Finished");
            putValue(SHORT_DESCRIPTION, "Click this button, if you have finished your turn");
        }
        public void actionPerformed(ActionEvent e) {
            if(controller!=null)controller.onEndTurnClick();
        }
    }
}
