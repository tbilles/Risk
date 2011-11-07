package risk.view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import risk.common.ImagePanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLayeredPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Dimension;

public class MapPanel extends JPanel {
    ImageIcon image=new ImageIcon(getClass().getResource("/risk/view/Risk_small_names.jpg"));
    JLayeredPane map= new JLayeredPane();
    /**
     * Create the panel.
     */
    public MapPanel() {
        setMaximumSize(new Dimension(1152, 648));
        setPreferredSize(new Dimension(1152, 648));
        setMinimumSize(new Dimension(1152, 648));
        
        setLayout(new BorderLayout());
        map.setPreferredSize(new Dimension(1152, 648));
        map.setMaximumSize(new Dimension(1152, 648));
        map.setMinimumSize(new Dimension(1152, 648));
        add(map, BorderLayout.CENTER);      
        
        ImagePanel backGround= new ImagePanel(image.getImage());
        backGround.setBounds(0, 0, 1152, 648);
        map.add(backGround);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        map.setLayer(buttonPanel, 1);
        buttonPanel.setBounds(0, 0, 1152, 648);
        map.add(buttonPanel);
        buttonPanel.setLayout(null);
        
        JButton btnAlaska = new JButton("23");
        btnAlaska.setForeground(Color.WHITE);
        btnAlaska.setBackground(Color.RED);
        btnAlaska.setBounds(86, 95, 50, 20);
        buttonPanel.add(btnAlaska);
        
        JButton btnNW_Ter = new JButton("");
        btnNW_Ter.setBounds(160, 82, 50, 20);
        buttonPanel.add(btnNW_Ter);
        
        JButton btnGreenLand = new JButton("");
        btnGreenLand.setBounds(416, 48, 50, 20);
        buttonPanel.add(btnGreenLand);
        
        JButton btnAlberta = new JButton("");
        btnAlberta.setBounds(185, 147, 50, 20);
        buttonPanel.add(btnAlberta);
        
        JButton btnOntario = new JButton("");
        btnOntario.setBounds(258, 136, 50, 20);
        buttonPanel.add(btnOntario);
        
        JButton btnE_Canada = new JButton("");
        btnE_Canada.setBounds(330, 166, 50, 20);
        buttonPanel.add(btnE_Canada);
        
        JButton btnW_USA = new JButton("");
        btnW_USA.setBounds(185, 214, 50, 20);
        buttonPanel.add(btnW_USA);
        
        JButton btnE_USA = new JButton("");
        btnE_USA.setBounds(279, 204, 50, 20);
        buttonPanel.add(btnE_USA);
        
        JButton btnCentral_America = new JButton("");
        btnCentral_America.setBounds(219, 291, 50, 20);
        buttonPanel.add(btnCentral_America);
        
        JButton btnVenezuela = new JButton("");
        btnVenezuela.setBounds(242, 323, 50, 20);
        buttonPanel.add(btnVenezuela);
        
        JButton btnBrazil = new JButton("");
        btnBrazil.setBounds(331, 401, 50, 20);
        buttonPanel.add(btnBrazil);
        
        JButton btnPeru = new JButton("");
        btnPeru.setBounds(267, 438, 50, 20);
        buttonPanel.add(btnPeru);
        
        JButton btnArgentina = new JButton("");
        btnArgentina.setBounds(272, 506, 50, 20);
        buttonPanel.add(btnArgentina);
        
        JButton btnNorth_Africa = new JButton("");
        btnNorth_Africa.setBounds(466, 370, 50, 20);
        buttonPanel.add(btnNorth_Africa);
        
        JButton btnSouth_Africa = new JButton("");
        btnSouth_Africa.setBounds(526, 528, 50, 20);
        buttonPanel.add(btnSouth_Africa);
        
        JButton btnEast_Africa = new JButton("");
        btnEast_Africa.setBounds(583, 404, 50, 20);
        buttonPanel.add(btnEast_Africa);
        
        JButton btnEgypt = new JButton("");
        btnEgypt.setBounds(540, 328, 50, 20);
        buttonPanel.add(btnEgypt);
        
        JButton btnCentral_Africa = new JButton("");
        btnCentral_Africa.setBounds(523, 420, 50, 20);
        buttonPanel.add(btnCentral_Africa);
        
        JButton btnMadagascar = new JButton("");
        btnMadagascar.setBounds(624, 495, 50, 20);
        buttonPanel.add(btnMadagascar);
        
        JButton btnScandinavia = new JButton("");
        btnScandinavia.setBounds(523, 95, 50, 20);
        buttonPanel.add(btnScandinavia);
        
        JButton btnIceland = new JButton("");
        btnIceland.setBounds(451, 116, 50, 20);
        buttonPanel.add(btnIceland);
        
        JButton btnGreat_Britain = new JButton("");
        btnGreat_Britain.setBounds(439, 177, 50, 20);
        buttonPanel.add(btnGreat_Britain);
        
        JButton btnW_Europe = new JButton("");
        btnW_Europe.setBounds(466, 214, 50, 20);
        buttonPanel.add(btnW_Europe);
        
        JButton btnS_Europe = new JButton("");
        btnS_Europe.setBounds(526, 224, 50, 20);
        buttonPanel.add(btnS_Europe);
        
        JButton btnN_Europe = new JButton("");
        btnN_Europe.setBounds(508, 163, 50, 20);
        buttonPanel.add(btnN_Europe);
        
        JButton btnRussia = new JButton("");
        btnRussia.setBounds(595, 163, 50, 20);
        buttonPanel.add(btnRussia);
        
        JButton btnMiddle_East = new JButton("");
        btnMiddle_East.setBounds(609, 285, 50, 20);
        buttonPanel.add(btnMiddle_East);
        
        JButton btnAfghanistan = new JButton("");
        btnAfghanistan.setBounds(670, 214, 50, 20);
        buttonPanel.add(btnAfghanistan);
        
        JButton btnIndia = new JButton("");
        btnIndia.setBounds(725, 316, 50, 20);
        buttonPanel.add(btnIndia);
        
        JButton btnChina = new JButton("");
        btnChina.setBounds(776, 256, 50, 20);
        buttonPanel.add(btnChina);
        
        JButton btnSiam = new JButton("");
        btnSiam.setBounds(806, 316, 50, 20);
        buttonPanel.add(btnSiam);
        
        JButton btnUral = new JButton("");
        btnUral.setBounds(698, 126, 50, 20);
        buttonPanel.add(btnUral);
        
        JButton btnSiberia = new JButton("");
        btnSiberia.setBounds(776, 116, 50, 20);
        buttonPanel.add(btnSiberia);
        
        JButton btnYakutsk = new JButton("");
        btnYakutsk.setBounds(856, 94, 50, 20);
        buttonPanel.add(btnYakutsk);
        
        JButton btnIrkutsk = new JButton("");
        btnIrkutsk.setBounds(827, 163, 50, 20);
        buttonPanel.add(btnIrkutsk);
        
        JButton btnMongolia = new JButton("");
        btnMongolia.setBounds(858, 211, 50, 20);
        buttonPanel.add(btnMongolia);
        
        JButton btnKamchatka = new JButton("");
        btnKamchatka.setBounds(965, 89, 50, 20);
        buttonPanel.add(btnKamchatka);
        
        JButton btnJapan = new JButton("");
        btnJapan.setBounds(929, 240, 50, 20);
        buttonPanel.add(btnJapan);
        
        JButton btnIndonesia = new JButton("");
        btnIndonesia.setBounds(812, 406, 50, 20);
        buttonPanel.add(btnIndonesia);
        
        JButton btnNew_Guinea = new JButton("");
        btnNew_Guinea.setBounds(929, 420, 50, 20);
        buttonPanel.add(btnNew_Guinea);
        
        JButton btnW_Australia = new JButton("");
        btnW_Australia.setBounds(815, 495, 50, 20);
        buttonPanel.add(btnW_Australia);
        
        JButton btnE_Australia = new JButton("");
        btnE_Australia.setBounds(920, 506, 50, 20);
        buttonPanel.add(btnE_Australia);
        
    }
}
