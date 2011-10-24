package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel implements ActionListener{

    GamePanel gamePanel;
    private boolean serverAvailable=false;
    private boolean clientAvailable=false;
    private boolean clientSelected=true;
    JButton change;
    
    public ControlPanel(GamePanel parent){
        gamePanel=parent;
        change=new JButton();
        change.setText("No client/server started");
        setLayout(new FlowLayout());
        add(change);
        change.addActionListener(this);
    }
    public void serverStarted(){
        serverAvailable=true;
        gamePanel.changeToServer();
        clientSelected=false;
        if(clientAvailable) change.setText("Váltás kliensre");
        else change.setText("Csak szerver fut");
    }
    public void clientStarted(){
        clientAvailable=true;
        gamePanel.changeToClient();
        clientSelected=true;
        if(serverAvailable) change.setText("Váltás szerverre)");
        else change.setText("Csak kliens fut");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==change){
            if(clientAvailable&&serverAvailable){
                if(clientSelected){
                    gamePanel.changeToServer();
                    change.setText("Váltás kliensre");
                    clientSelected=false;
                }
                else{
                    gamePanel.changeToClient();
                    change.setText("Váltás szerverre");
                    clientSelected=true;
                }
            }
        }
        
    }
}
