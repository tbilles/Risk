package risk.common;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private Image imgOriginal, imgResized;
    int originalHeight, originalWidth;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.imgOriginal = img;
        imgResized = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        originalWidth = img.getWidth(null);
        originalHeight = img.getHeight(null);
    }

    public Dimension resizeImage(int height, int width) {
        int heightTemp=height;
        int widthTemp=width;
        // code based on
        // http://tycoontalk.freelancer.com/coding-forum/63227-image-resizing-in-java.html
        // Make sure the aspect ratio is maintained, so the image is not skewed
        double thumbRatio = (double) widthTemp / (double) heightTemp;
        double imageRatio = (double) originalWidth / (double) originalHeight;
        if (thumbRatio < imageRatio) {
            heightTemp = (int) (widthTemp / imageRatio);
        } else {
            widthTemp = (int) (heightTemp * imageRatio);
        }
        
        // Draw the scaled image
        BufferedImage thumbImage = new BufferedImage(widthTemp, heightTemp,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = thumbImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(imgOriginal, 0, 0, widthTemp, heightTemp, null);
        
        imgResized=Toolkit.getDefaultToolkit().createImage(thumbImage.getSource());
        graphics2D.dispose();
        invalidate();
        repaint();
        Dimension d=new Dimension();
        d.width=widthTemp;
        d.height=heightTemp;
        return d;
    }


    public Dimension getOriginalSize() {
        Dimension size = new Dimension(originalWidth, originalHeight);
        return size;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(imgResized, 0, 0, null);
    }
}
