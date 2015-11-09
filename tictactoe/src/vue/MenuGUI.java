package vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import launcher.LauncherGUI;
import controler.TicTacToeControler;

public class MenuGUI extends JPanel{
	private Image background;
	private JButton boutonJouer = new JButton("Jouer");
	private JButton boutonQuitter = new JButton("Quitter");
	private JButton boutonStat = new JButton("Statistique");
	private JButton boutonPropos = new JButton("À propos");
	private JFrame parent;
	
	Panel panel;
	final static String s1 = "carte 1";
	final static String s2 = "carte 2";
	
	
	public MenuGUI(JFrame parent){
		super();
		this.parent = parent;
		init();
	}
	
	public void init(){
		File g = new File("");
		 String path = g.getAbsolutePath();
		try {
            this.background = ImageIO.read(new File(path+"/images/bois1.jpg"));
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
		
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		panel.add(boutonJouer);
		panel.add(boutonStat);
		panel.add(boutonPropos);
		panel.add(boutonQuitter);
		boutonJouer.addActionListener(new Jouer());
		boutonQuitter.addActionListener(new Quitter());
		boutonStat.addActionListener(new Stat());
		boutonPropos.addActionListener(new Propos());
		
		this.add(panel, BorderLayout.PAGE_END);
		
	}
	
	public class Jouer implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			((MainFrame) parent).goTo("param");
		}
	}
	
	public class Quitter implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
	
	public class Stat implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
	
	public class Propos implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
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

}