package risk.view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import risk.common.ImagePanel;
import risk.game.GameView;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JLayeredPane;
import java.awt.Dimension;
import java.util.HashMap;

public class MapPanel extends JPanel {
    ImageIcon image=new ImageIcon(getClass().getResource("/risk/view/Risk_small_names.jpg"));
    JLayeredPane map= new JLayeredPane();
    HashMap<String, CountryButton> countryButtons=new HashMap<String, CountryButton>();
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
        
        CountryButton btnAlaska = new CountryButton("Alaska");
        btnAlaska.setBounds(86, 95, 50, 20);
        buttonPanel.add(btnAlaska);
        countryButtons.put("Alaska", btnAlaska);
        
        CountryButton btnNW_Ter = new CountryButton("Northwest Territory");
        btnNW_Ter.setBounds(160, 82, 50, 20);
        buttonPanel.add(btnNW_Ter);
        countryButtons.put("Northwest Territory", btnNW_Ter);
        
        CountryButton btnGreenLand = new CountryButton("Greenland");
        btnGreenLand.setBounds(416, 48, 50, 20);
        buttonPanel.add(btnGreenLand);
        countryButtons.put("Greenland", btnGreenLand);
        
        CountryButton btnAlberta = new CountryButton("Alberta");
        btnAlberta.setBounds(185, 147, 50, 20);
        buttonPanel.add(btnAlberta);
        countryButtons.put("Alberta", btnAlberta);
        
        CountryButton btnOntario = new CountryButton("Ontario");
        btnOntario.setBounds(258, 136, 50, 20);
        buttonPanel.add(btnOntario);
        countryButtons.put("Ontario", btnOntario);
        
        CountryButton btnE_Canada = new CountryButton("Eastern Canada");
        btnE_Canada.setBounds(330, 166, 50, 20);
        buttonPanel.add(btnE_Canada);
        countryButtons.put("Eastern Canada", btnE_Canada);
        
        CountryButton btnW_USA = new CountryButton("Western United States");
        btnW_USA.setBounds(185, 214, 50, 20);
        buttonPanel.add(btnW_USA);
        countryButtons.put("Western United States", btnW_USA);
        
        CountryButton btnE_USA = new CountryButton("Eastern United States");
        btnE_USA.setBounds(279, 204, 50, 20);
        buttonPanel.add(btnE_USA);
        countryButtons.put("Eastern United States", btnE_USA);
        
        CountryButton btnCentral_America = new CountryButton("Central America");
        btnCentral_America.setBounds(219, 291, 50, 20);
        buttonPanel.add(btnCentral_America);
        countryButtons.put("Central America", btnCentral_America);
        
        CountryButton btnVenezuela = new CountryButton("Venezuela");
        btnVenezuela.setBounds(242, 323, 50, 20);
        buttonPanel.add(btnVenezuela);
        countryButtons.put("Venezuela", btnVenezuela);
        
        CountryButton btnBrazil = new CountryButton("Brazil");
        btnBrazil.setBounds(331, 401, 50, 20);
        buttonPanel.add(btnBrazil);
        countryButtons.put("Brazil", btnBrazil);
        
        CountryButton btnPeru = new CountryButton("Peru");
        btnPeru.setBounds(267, 438, 50, 20);
        buttonPanel.add(btnPeru);
        countryButtons.put("Peru", btnPeru);
        
        CountryButton btnArgentina = new CountryButton("Argentina");
        btnArgentina.setBounds(272, 506, 50, 20);
        buttonPanel.add(btnArgentina);
        countryButtons.put("Argentina", btnArgentina);
        
        CountryButton btnNorth_Africa = new CountryButton("North Africa");
        btnNorth_Africa.setBounds(466, 370, 50, 20);
        buttonPanel.add(btnNorth_Africa);
        countryButtons.put("North Africa", btnNorth_Africa);
        
        CountryButton btnSouth_Africa = new CountryButton("South Africa");
        btnSouth_Africa.setBounds(526, 528, 50, 20);
        buttonPanel.add(btnSouth_Africa);
        countryButtons.put("South Africa", btnSouth_Africa);
        
        CountryButton btnEast_Africa = new CountryButton("East Africa");
        btnEast_Africa.setBounds(583, 404, 50, 20);
        buttonPanel.add(btnEast_Africa);
        countryButtons.put("East Africa", btnEast_Africa);
        
        CountryButton btnEgypt = new CountryButton("Egypt");
        btnEgypt.setBounds(540, 328, 50, 20);
        buttonPanel.add(btnEgypt);
        countryButtons.put("Egypt", btnEgypt);
        
        CountryButton btnCentral_Africa = new CountryButton("Central Africa");
        btnCentral_Africa.setBounds(523, 420, 50, 20);
        buttonPanel.add(btnCentral_Africa);
        countryButtons.put("Central Africa", btnCentral_Africa);
        
        CountryButton btnMadagascar = new CountryButton("Madagascar");
        btnMadagascar.setBounds(624, 495, 50, 20);
        buttonPanel.add(btnMadagascar);
        countryButtons.put("Madagascar", btnMadagascar);
        
        CountryButton btnScandinavia = new CountryButton("Scandinavia");
        btnScandinavia.setBounds(523, 95, 50, 20);
        buttonPanel.add(btnScandinavia);
        countryButtons.put("Scandinavia", btnScandinavia);
        
        CountryButton btnIceland = new CountryButton("Iceland");
        btnIceland.setBounds(451, 116, 50, 20);
        buttonPanel.add(btnIceland);
        countryButtons.put("Iceland", btnIceland);
        
        CountryButton btnGreat_Britain = new CountryButton("Great Britain");
        btnGreat_Britain.setBounds(439, 177, 50, 20);
        buttonPanel.add(btnGreat_Britain);
        countryButtons.put("Great Britain", btnGreat_Britain);
        
        CountryButton btnW_Europe = new CountryButton("Western Europe");
        btnW_Europe.setBounds(466, 214, 50, 20);
        buttonPanel.add(btnW_Europe);
        countryButtons.put("Western Europe", btnW_Europe);
        
        CountryButton btnS_Europe = new CountryButton("Southern Europe");
        btnS_Europe.setBounds(526, 224, 50, 20);
        buttonPanel.add(btnS_Europe);
        countryButtons.put("Southern Europe", btnS_Europe);
        
        CountryButton btnN_Europe = new CountryButton("Northern Europe");
        btnN_Europe.setBounds(508, 163, 50, 20);
        buttonPanel.add(btnN_Europe);
        countryButtons.put("Northern Europe", btnN_Europe);
        
        CountryButton btnRussia = new CountryButton("Russia");
        btnRussia.setBounds(595, 163, 50, 20);
        buttonPanel.add(btnRussia);
        countryButtons.put("Russia", btnRussia);
        
        CountryButton btnMiddle_East = new CountryButton("Middle East");
        btnMiddle_East.setBounds(609, 285, 50, 20);
        buttonPanel.add(btnMiddle_East);
        countryButtons.put("Middle East", btnMiddle_East);
        
        CountryButton btnAfghanistan = new CountryButton("Afghanistan");
        btnAfghanistan.setBounds(670, 214, 50, 20);
        buttonPanel.add(btnAfghanistan);
        countryButtons.put("Afghanistan", btnAfghanistan);
        
        CountryButton btnIndia = new CountryButton("India");
        btnIndia.setBounds(725, 316, 50, 20);
        buttonPanel.add(btnIndia);
        countryButtons.put("India", btnIndia);
        
        CountryButton btnChina = new CountryButton("China");
        btnChina.setBounds(776, 256, 50, 20);
        buttonPanel.add(btnChina);
        countryButtons.put("China", btnChina);
        
        CountryButton btnSiam = new CountryButton("Siam");
        btnSiam.setBounds(806, 316, 50, 20);
        buttonPanel.add(btnSiam);
        countryButtons.put("Siam", btnSiam);
        
        CountryButton btnUral = new CountryButton("Ural");
        btnUral.setBounds(698, 126, 50, 20);
        buttonPanel.add(btnUral);
        countryButtons.put("Ural", btnUral);
        
        CountryButton btnSiberia = new CountryButton("Siberia");
        btnSiberia.setBounds(776, 116, 50, 20);
        buttonPanel.add(btnSiberia);
        countryButtons.put("Siberia", btnSiberia);
        
        CountryButton btnYakutsk = new CountryButton("Yakutsk");
        btnYakutsk.setBounds(856, 94, 50, 20);
        buttonPanel.add(btnYakutsk);
        countryButtons.put("Yakutsk", btnYakutsk);
        
        CountryButton btnIrkutsk = new CountryButton("Irkutsk");
        btnIrkutsk.setBounds(827, 163, 50, 20);
        buttonPanel.add(btnIrkutsk);
        countryButtons.put("Irkutsk", btnIrkutsk);
        
        CountryButton btnMongolia = new CountryButton("Mongolia");
        btnMongolia.setBounds(858, 211, 50, 20);
        buttonPanel.add(btnMongolia);
        countryButtons.put("Mongolia", btnMongolia);
        
        CountryButton btnKamchatka = new CountryButton("Kamchatka");
        btnKamchatka.setBounds(965, 89, 50, 20);
        buttonPanel.add(btnKamchatka);
        countryButtons.put("Kamchatka", btnKamchatka);
        
        CountryButton btnJapan = new CountryButton("Japan");
        btnJapan.setBounds(929, 240, 50, 20);
        buttonPanel.add(btnJapan);
        countryButtons.put("Japan", btnJapan);
        
        CountryButton btnIndonesia = new CountryButton("Indonesia");
        btnIndonesia.setBounds(812, 406, 50, 20);
        buttonPanel.add(btnIndonesia);
        countryButtons.put("Indonesia", btnIndonesia);
        
        CountryButton btnNew_Guinea = new CountryButton("New Guinea");
        btnNew_Guinea.setBounds(929, 420, 50, 20);
        buttonPanel.add(btnNew_Guinea);
        countryButtons.put("New Guinea", btnNew_Guinea);
        
        CountryButton btnW_Australia = new CountryButton("Western Australia");
        btnW_Australia.setBounds(815, 495, 50, 20);
        buttonPanel.add(btnW_Australia);
        countryButtons.put("Western Australia", btnW_Australia);
        
        CountryButton btnE_Australia = new CountryButton("Eastern Australia");
        btnE_Australia.setBounds(920, 506, 50, 20);
        buttonPanel.add(btnE_Australia);
        countryButtons.put("Eastern Australia", btnE_Australia);
        
    }
    public void refresh(GameView view){
        for(CountryButton cb : countryButtons.values()){
            cb.refresh(view);
        }
    }
}
