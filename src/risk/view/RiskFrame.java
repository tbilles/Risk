/**
 * 
 */
package risk.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import risk.common.Logger;
import risk.game.client.GameClient;
import risk.game.server.GameServer;
import risk.network.*;

/**
 * @author Tamas
 * 
 */
public class RiskFrame extends JFrame implements ActionListener {

    /* variable declarations */
    public static String appName = "Risk v0.01";
    GameClient client;
    GameServer server;
    /* menu */
    JMenuBar menu = new JMenuBar();
    JMenu game = new JMenu("Game");
    JMenuItem startServer = new JMenuItem("Start new server...");
    JMenuItem startClient = new JMenuItem("Connect to server...");

    RiskPanel rp;

    /**
     * @param args
     */
    public RiskFrame() {
        super(appName);
        setSize(1160, 790);
        setResizable(false);
        Logger.getInstance().initialize(true, "Risk.log");
        Logger.loginfo("Starting risk");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
                //
            }
        });
        setJMenuBar(menu);
        game.add(startClient).addActionListener(this);
        game.add(startServer).addActionListener(this);
        menu.add(game);
        setLayout(new BorderLayout());
        rp = new RiskPanel();
        add(rp, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        JFrame frame = new RiskFrame();
        frame.setVisible(true);
    }

    private void exit() {
        Logger.loginfo("Exit");
        if (server != null) {
            server.interrupt();
        }
        if (client != null) {
            client.interrupt();
        }
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startServer) {
            if (server == null) {
                server = new GameServer();
                server.start();
                rp.serverStarted();
            }
        }
        if (e.getSource() == startClient) {
            if (client == null) {
                ClientStartDialog csd=new ClientStartDialog(this);
                if(ClientStartDialog.isCreateClient()){
                    client = new GameClient();
                    client.start();
                    rp.clientStarted();
                }
            }
        }

    }

}
