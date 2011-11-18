package risk.view.client;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import risk.common.RiskIO;
import risk.game.GameView;
import risk.game.Player;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collection;

public class FeedbackPanel extends JPanel {
    private JTextArea messages=new JTextArea();
    private ArrayList<JLabel> players=new ArrayList<JLabel>();
    JPanel playersPanel = new JPanel();
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
        playersPanel.setPreferredSize(new Dimension(128, 100));

        
        add(playersPanel);
        playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
        
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(messages);
        messages.setEditable(false);
        panel.add(scrollPane);

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

}
