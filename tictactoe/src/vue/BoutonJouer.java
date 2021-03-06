package vue;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class BoutonJouer extends JButton{

	private Image background;

	private BoutonJouer() {
		super();
		init();
	}
	private static BoutonJouer Instance= new BoutonJouer();
	
	public void init(){
		File g = new File("");
		 String path = g.getAbsolutePath();
		try {
           this.background = ImageIO.read(new File(path+"/images/boutons/jouer.png"));
       } 
       catch (IOException e) {
           try {
				throw new IOException(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       }
	}

	@Override
	public void paintComponent(Graphics g){
	    if(background!=null){
	        Graphics2D g2d = (Graphics2D)g;
	        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	        g2d.drawImage(background, 0, 0, getWidth(), getHeight(), null);
	    }
	}
	
	public static BoutonJouer getInstance(){
		return Instance;
	}
}