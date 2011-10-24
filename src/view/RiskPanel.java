package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class RiskPanel extends JPanel {
   ControlPanel cp;
   GamePanel gp;
   
   public RiskPanel() {
       gp=new GamePanel();
       cp=new ControlPanel(this.gp);
       setLayout(new BorderLayout());
       add(cp, BorderLayout.NORTH);
       add(gp, BorderLayout.CENTER);
       setVisible(true);
}
   public void serverStarted(){
       cp.serverStarted();
   }
   public void clientStarted(){
       cp.clientStarted();
   }
}
