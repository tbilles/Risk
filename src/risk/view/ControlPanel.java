package risk.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import risk.game.GameView;

public class ControlPanel extends JPanel implements ActionListener {

    GamePanel gamePanel;
    private boolean serverAvailable = false;
    private boolean clientAvailable = false;
    private boolean clientSelected = true;
    JButton change;

    public ControlPanel(GamePanel parent) {
        gamePanel = parent;
        change = new JButton();
        change.setText("No client/server started");
        setLayout(new FlowLayout());
        add(change);
        change.addActionListener(this);
    }

    public void serverStarted() {
        serverAvailable = true;
        gamePanel.changeToServer();
        clientSelected = false;
        if (clientAvailable)
            change.setText("Change to client");
        else
            change.setText("Only server is running");
    }

    public void clientStarted(GameView gameView) {
        clientAvailable = true;
        gamePanel.clientStarted(gameView);
        gamePanel.changeToClient();
        clientSelected = true;
        if (serverAvailable)
            change.setText("Change to server");
        else
            change.setText("Only client is running");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            if (clientAvailable && serverAvailable) {
                if (clientSelected) {
                    gamePanel.changeToServer();
                    change.setText("Change to client");
                    clientSelected = false;
                } else {
                    gamePanel.changeToClient();
                    change.setText("Change to server");
                    clientSelected = true;
                }
            }
        }

    }
}
