package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Couleur;
import controler.TicTacToeControler;

public class JeuGUI extends JPanel implements java.util.Observer{
	private TicTacToeControler controler;
	private JFrame parent;
	
	JPanel 	panelJ1, panelJ2;
	
	public JeuGUI(JFrame jf, TicTacToeControler controler){
		this.parent = jf;
		this.controler = controler;
		init();
	}
	
	public void init(){
		setLayout(new FlowLayout(0 , 250, 250));

		JPanel 	jp_east = new JPanel();
				jp_east.setPreferredSize(new Dimension(200,400));
				jp_east.setLayout(new BoxLayout(jp_east, BoxLayout.PAGE_AXIS));
		
		JButton boutonMenu = new JButton("Menu");
				boutonMenu.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						((MainFrame) parent).goTo("menu");
					}
				});
		JPanel 	panelMenu = new JPanel();
				panelMenu.add(boutonMenu, BorderLayout.CENTER);
				panelMenu.setPreferredSize(boutonMenu.getSize());
		panelJ1 = new JPanel();
				panelJ1.setLayout(new BorderLayout());
				panelJ1.setBackground(Color.WHITE);
				panelJ1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2),controler.getNomJoueur1() ));
		panelJ2 = new JPanel();
				panelJ2.setLayout(new BorderLayout());
				panelJ2.setBorder(BorderFactory.createTitledBorder(controler.getNomJoueur2()));
				
		JLabel devise1 = new JLabel("<html><i>\""+controler.getDeviseJoueur1()+"\"</i></html>");
		JLabel devise2 = new JLabel("<html><i>\""+controler.getDeviseJoueur2()+"\"</i></html>");
				
		
			
		Couleur cj1 = controler.getCouleurJoueur1();
		Couleur cj2 = controler.getCouleurJoueur2();
		
		JPanel couleurJ1, couleurJ2;
		couleurJ1 = new JPanel();
		couleurJ1.setBackground(new Color(cj1.getR(),cj1.getG(),cj1.getB()));
		couleurJ1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		couleurJ2 = new JPanel();
		couleurJ2.setBackground(new Color(cj2.getR(),cj2.getG(),cj2.getB()));
		couleurJ2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JLabel lcolor1 = new JLabel(cj1.getNom()+"  ");
		lcolor1.setBackground(null);
		JLabel lcolor2 = new JLabel(cj2.getNom()+"  ");
		lcolor2.setBackground(null);
		
		JPanel pcolor1 = new JPanel();
		pcolor1.setLayout(new BoxLayout(pcolor1, BoxLayout.LINE_AXIS));
		pcolor1.add(lcolor1);
		pcolor1.add(couleurJ1);
		JPanel pcolor2 = new JPanel();
		pcolor2.setLayout(new BoxLayout(pcolor2, BoxLayout.LINE_AXIS));
		pcolor2.add(lcolor2);
		pcolor2.add(couleurJ2);
		

		JButton bFinTour1 = new JButton("Fin du tour");
		JButton bGagner1 = new JButton("J'ai gagné");
		JButton bFinTour2 = new JButton("Fin du tour");
		JButton bGagner2 = new JButton("J'ai gagné");
		
		JPanel panelAnnonce1 = new JPanel();
		panelAnnonce1.setBackground(null);
		panelAnnonce1.setLayout(new BoxLayout(panelAnnonce1, BoxLayout.PAGE_AXIS));
		panelAnnonce1.add(bFinTour1);
		panelAnnonce1.add(bGagner1);
		
		JPanel panelAnnonce2 = new JPanel();
		panelAnnonce2.setBackground(null);
		panelAnnonce2.setLayout(new BoxLayout(panelAnnonce2, BoxLayout.PAGE_AXIS));
		panelAnnonce2.add(bFinTour2);
		panelAnnonce2.add(bGagner2);
		
		panelJ1.add(pcolor1, BorderLayout.NORTH);
		panelJ2.add(pcolor2, BorderLayout.NORTH);	
		
		panelJ1.add(panelAnnonce1, BorderLayout.CENTER);
		panelJ2.add(panelAnnonce2, BorderLayout.CENTER);	
		
		panelJ1.add(devise1, BorderLayout.SOUTH);
		panelJ2.add(devise2, BorderLayout.SOUTH);
		
		jp_east.add(boutonMenu);
		jp_east.add(panelJ1);
		jp_east.add(panelJ2);
		
		this.setLayout(new BorderLayout());
		this.add(new PlateauGUI(parent, this, controler),BorderLayout.CENTER);
		this.add(jp_east,BorderLayout.EAST);
	}
	
	public void switchPanel(){
		if(panelJ1.getBackground().equals(Color.WHITE)){
			System.out.println("ICI");
			panelJ1.setBackground(null);
			panelJ1.setBorder(BorderFactory.createTitledBorder(controler.getNomJoueur1()));
			panelJ2.setBackground(Color.WHITE);
			panelJ2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2),controler.getNomJoueur2() ));
			panelJ1.repaint();
			panelJ1.revalidate();
			panelJ2.repaint();
			panelJ2.revalidate();
		} else {
			panelJ1.setBackground(Color.WHITE);
			panelJ1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2),controler.getNomJoueur1() ));
			panelJ2.setBackground(null);
			panelJ2.setBorder(BorderFactory.createTitledBorder(controler.getNomJoueur2()));
			panelJ1.repaint();
			panelJ1.revalidate();
			panelJ2.repaint();
			panelJ2.revalidate();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub	
	}
}
