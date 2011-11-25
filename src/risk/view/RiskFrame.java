/**
 * 
 */
package risk.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import risk.common.Logger;
import risk.game.client.GameClient;
import risk.game.server.GameServer;

/**
 * @author Tamas
 * 
 */
public class RiskFrame extends JFrame implements ActionListener, NotifyView {

    /* variable declarations */
    public static String appName = "Risk v0.9";
    GameClient client;
    GameServer server;
    /* menu */
    JMenuBar menu = new JMenuBar();
    JMenu game = new JMenu("Game");
    JMenuItem startServer = new JMenuItem("Start new server...");
    JMenuItem startClient = new JMenuItem("Connect to server...");
    JMenu view = new JMenu("View");
    JRadioButtonMenuItem clientView = new JRadioButtonMenuItem("Client");
    JRadioButtonMenuItem clientDebugView = new JRadioButtonMenuItem(
            "Client debug view");
    JRadioButtonMenuItem serverDebugView = new JRadioButtonMenuItem(
            "Server debug view");
    RiskPanel rp;

    /**
     * @param args
     */
    public RiskFrame() {
        super(appName);
        game.setMnemonic('G');
        startServer.setMnemonic('S');
        startClient.setMnemonic('C');
        view.setMnemonic('V');
        setSize(1280, 660);
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
        ButtonGroup viewButtons = new ButtonGroup();
        viewButtons.add(clientView);
        viewButtons.add(clientDebugView);
        viewButtons.add(serverDebugView);
        clientView.setEnabled(false);
        clientDebugView.setEnabled(false);
        serverDebugView.setEnabled(false);
        view.add(clientView).addActionListener(this);
        view.add(clientDebugView).addActionListener(this);
        view.add(serverDebugView).addActionListener(this);
        menu.add(view);
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
            if (server != null) {
                int answer = JOptionPane
                        .showConfirmDialog(
                                this,
                                "A server is already running. Do you want to finish it, and start a new client?",
                                "Warning!", JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    // the current server should be terminated correctly
                    server.interrupt();
                    server = null;
                }
            }
            if (server == null) {
                ServerStartDialog ssd = new ServerStartDialog(this);
                if (ServerStartDialog.isCreateServer()) {
                    server = new GameServer();
                    server.start();
                    rp.serverStarted();
                    serverDebugView.setEnabled(true);
                    serverDebugView.setSelected(true);
                }
            }
        }
        if (e.getSource() == startClient) {
            if (client != null) {
                int answer = JOptionPane
                        .showConfirmDialog(
                                this,
                                "A client is already running. Do you want to finish it, and start a new client?",
                                "Warning!", JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    // the current client should be terminated correctly
                    client.interrupt();
                    client = null;
                }
            }
            if (client == null) {
                ClientStartDialog csd = new ClientStartDialog(this);
                if (ClientStartDialog.isCreateClient()) {
                    client = new GameClient(this);
                    client.start();
                }
            }
        }
        if(e.getSource() == clientView){
            rp.changeToClientView();
        }
        if(e.getSource() == clientDebugView){
            rp.changeToClientDebugView();
        }
        if(e.getSource()== serverDebugView){
            rp.changeToServerDebugView();
        }

    }

    @Override
    public void gameStarted() {
        rp.clientStarted(client.getController());
        clientView.setEnabled(true);
        clientView.setSelected(true);
        clientDebugView.setEnabled(true);
    }

    @Override
    public void gameFinished() {
        rp.gameFinished();
        client = null;
    }

    @Override
    public void popupMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Warning", JOptionPane.ERROR_MESSAGE);
    }

}
