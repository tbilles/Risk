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

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.TextArea;

import javax.swing.UIManager;

public class FeedbackPanel extends JPanel {
    private JTextArea messages = new JTextArea();
    private ArrayList<JLabel> players = new ArrayList<JLabel>();
    private JPanel playersPanel = new JPanel();
    private Controller controller;
    private JButton btnFinishedMyTurn;
    private boolean gameStarted = false;
    private JScrollPane scrollPane;
    public void setController(Controller controller) {
        this.controller = controller;
    }

    private final Action action = new SwingAction();
    private JPanel panel_1;
    private JLabel lblMySecretMission;
    private JTextArea mission;

    /**
     * Create the panel.
     */
    public FeedbackPanel() {
        setPreferredSize(new Dimension(354, 667));
        setMinimumSize(new Dimension(128, 648));

        //JTextArea temp = RiskIO.getClientTextArea();
        //temp.setEditable(false);
        //temp.setRows(5);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 128, 0 };
        gridBagLayout.rowHeights = new int[] { 87, 78, 100, 91, 23, 0 };
        gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.5, 0.5, 0.0, 0.0, 0.0,
                Double.MIN_VALUE };
        setLayout(gridBagLayout);
        //JScrollPane sp = new JScrollPane(temp);
        //JPanel debugPanel = new JPanel();
        //GridBagConstraints gbc_debugPanel = new GridBagConstraints();
        //gbc_debugPanel.fill = GridBagConstraints.BOTH;
        //gbc_debugPanel.insets = new Insets(0, 0, 5, 0);
        //gbc_debugPanel.gridx = 0;
        //gbc_debugPanel.gridy = 0;
        //add(debugPanel, gbc_debugPanel);
        //debugPanel.setLayout(new BorderLayout());
        //debugPanel.add(sp, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridheight = 2;
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.insets = new Insets(0, 0, 5, 0);
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 0;
        add(panel, gbc_panel);
        panel.setLayout(new BorderLayout(0, 0));

        scrollPane = new JScrollPane();
        scrollPane.setAutoscrolls(true);
        scrollPane.setViewportView(messages);
        messages.setEditable(false);
        panel.add(scrollPane);

        GridBagConstraints gbc_playersPanel = new GridBagConstraints();
        gbc_playersPanel.fill=GridBagConstraints.BOTH;
        gbc_playersPanel.insets = new Insets(0, 0, 5, 0);
        gbc_playersPanel.gridx = 0;
        gbc_playersPanel.gridy = 2;
        add(playersPanel, gbc_playersPanel);
        playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
        
        panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 5, 0);
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 0;
        gbc_panel_1.gridy = 3;
        add(panel_1, gbc_panel_1);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{128};
        gbl_panel_1.rowHeights = new int[]{16, 0};
        gbl_panel_1.columnWeights = new double[]{1.0};
        gbl_panel_1.rowWeights = new double[]{0.0, 1.0};
        panel_1.setLayout(gbl_panel_1);
        
        lblMySecretMission = new JLabel("");
        GridBagConstraints gbc_lblMySecretMission = new GridBagConstraints();
        gbc_lblMySecretMission.anchor = GridBagConstraints.WEST;
        gbc_lblMySecretMission.insets = new Insets(0, 0, 5, 5);
        gbc_lblMySecretMission.gridx = 0;
        gbc_lblMySecretMission.gridy = 0;
        panel_1.add(lblMySecretMission, gbc_lblMySecretMission);
        
        mission = new JTextArea();
        mission.setBackground(UIManager.getColor("Panel.background"));
        mission.setLineWrap(true);
        mission.setEditable(false);
        GridBagConstraints gbc_textArea = new GridBagConstraints();
        gbc_textArea.insets = new Insets(0, 0, 0, 5);
        gbc_textArea.anchor = GridBagConstraints.NORTHWEST;
        gbc_textArea.fill = GridBagConstraints.BOTH;
        gbc_textArea.gridx = 0;
        gbc_textArea.gridy = 1;
        panel_1.add(mission, gbc_textArea);

        btnFinishedMyTurn = new JButton("Start Game");
        btnFinishedMyTurn.setAction(action);
        GridBagConstraints gbc_btnFinishedMyTurn = new GridBagConstraints();
        gbc_btnFinishedMyTurn.anchor = GridBagConstraints.CENTER;
        gbc_btnFinishedMyTurn.gridx = 0;
        gbc_btnFinishedMyTurn.gridy = 4;
        add(btnFinishedMyTurn, gbc_btnFinishedMyTurn);
        messages.setLineWrap(true);
        messages.setWrapStyleWord(true);

    }

    public void refresh(GameView view) {
        refreshPlayers(view);
        if (view.isGameStarted() && !gameStarted) {
            refreshStartButton();
            gameStarted = true;
        }
        if (gameStarted) {
            if (view.getMyPlayer() != view.getCurrentPlayer()) {
                btnFinishedMyTurn.setEnabled(false);
            } else {
                btnFinishedMyTurn.setEnabled(true);
            }
        }
        if(view.getMyPlayer()!=null && view.getMyPlayer().getSecretMission()!=null){
            lblMySecretMission.setText("My mission:");
            mission.setText(view.getMyPlayer().getSecretMission().toString());
        }
    }

    public void addMessage(Object message) {
        messages.append("►"+message.toString() + "\n");
    }

    public void addMessage(String message) {
        messages.append("►"+message + "\n");
        //Rectangle temp=scrollPane.getVisibleRect();
        //temp.y=messages.getHeight()-temp.height;
        //temp.x=messages.getWidth()-temp.width;
        //scrollPane.scrollRectToVisible(temp);
        messages.setCaretPosition(messages.getDocument().getLength());
    }

    private void refreshPlayers(GameView view) {
        players.clear();
        for (Player p : view.getPlayers()) {
            JLabel temp = new JLabel();
            temp.setForeground(p.getColor());
            if (view.getCurrentPlayer() == p) {
                temp.setText("►"+p.getName());
            }
            else{
                temp.setText(p.getName());
            }
            if(p==view.getMyPlayer()){
                Font f=temp.getFont(), tempFont;
                tempFont=new Font(f.getName(), Font.BOLD, f.getSize());
                temp.setFont(tempFont);                
            }
            else{
                Font f=temp.getFont(), tempFont;
                tempFont=new Font(f.getName(), Font.PLAIN, f.getSize());
                temp.setFont(tempFont);
            }
            players.add(temp);
        }
        playersPanel.removeAll();
        for (JLabel l : players) {
            playersPanel.add(l);
        }
        revalidate();
        repaint();
    }

    private void refreshStartButton() {
        btnFinishedMyTurn.setText("Finished");
        btnFinishedMyTurn
                .setToolTipText("Click this button if you have finished your turn");
    }

    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "Start Game");
            putValue(SHORT_DESCRIPTION,
                    "Click this button if you want to start the game, every player joined");
        }

        public void actionPerformed(ActionEvent e) {
            if (controller != null) {
                if (!gameStarted)
                    controller.onGameStartClick();
                else
                    controller.onEndTurnClick();
            }
        }
    }
}
