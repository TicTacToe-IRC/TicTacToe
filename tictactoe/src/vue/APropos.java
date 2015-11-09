package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class APropos extends JPanel {

	private Image background;
	private JButton boutonQuitter = new JButton("Quitter");
	Panel panel;
	private JFrame parent;
	private JPanel jp1 = new JPanel();
		
	public APropos(JFrame parent){		
		super();
		this.parent = parent;
		init();
	}
	public class Retour implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			((MainFrame) parent).goTo("menu");
		}
	}
	public void init(){
		File g = new File("");
		String path = g.getAbsolutePath();
		try {
            this.background = ImageIO.read(new File(path+"/images/Apropos.jpg"));
            repaint();
        } 
        catch (IOException e) {
            try {
				throw new IOException(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	       }

	JButton retour = new JButton("Retour");
			retour.setPreferredSize(new Dimension(100, 30));
			retour.addActionListener(new Retour());
			
		this.setLayout(new BorderLayout());
		this.add(retour, BorderLayout.SOUTH);
	}
	@Override
    public void paintComponent(Graphics g){
        if(background!=null){
            Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        }
    }
}
