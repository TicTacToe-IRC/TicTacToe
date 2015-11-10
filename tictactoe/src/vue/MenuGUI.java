package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
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

public class MenuGUI extends JPanel{
	private Image background;
	private JButton boutonJouer = new JButton("Jouer");
	private JButton boutonQuitter = new JButton("Quitter");
	private JButton boutonStat = new JButton("Statistiques");
	private JButton boutonPropos = new JButton("A propos");
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
            this.background = ImageIO.read(new File(path+"/images/background-menu.jpg"));
        } 
        catch (IOException e) {
            try {
				throw new IOException(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
			
	    this.setLayout(new GridBagLayout());
	   
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    
	    gbc.insets = new Insets(5, 5, 5, 5);
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    gbc.ipady = 8;
	    gbc.ipadx = 68;
	    this.add(boutonJouer, gbc);
	    //---------------------------------------------
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    gbc.ipady = 8;
	    gbc.ipadx = 25;
	    this.add(boutonStat, gbc);
	    //---------------------------------------------
	    //Cette instruction informe le layout que c'est une fin de ligne
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    gbc.gridx = 1;	
	    gbc.gridy = 2;
	    gbc.ipady = 8;
	    gbc.ipadx = 38;
	    this.add(boutonPropos, gbc);
	    //---------------------------------------------
	    gbc.gridx = 1;
	    gbc.gridy = 3;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 2;
	    gbc.ipady = 8;
	    gbc.ipadx = 50;
	    //Celle-ci indique que la cellule se réplique de façon verticale
	    gbc.fill = GridBagConstraints.VERTICAL;
	    this.add(boutonQuitter, gbc);
		
		
		boutonJouer.addActionListener(new Jouer());
		boutonQuitter.addActionListener(new Quitter());
		boutonStat.addActionListener(new Stat());
		boutonPropos.addActionListener(new Propos());
		
		//this.add(panel, BorderLayout.PAGE_END);
		
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
			((MainFrame) parent).goTo("propos");
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