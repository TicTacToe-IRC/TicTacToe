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
				panelJ1.setBorder(BorderFactory.createTitledBorder(controler.getNomJoueur1()));
		panelJ2 = new JPanel();
				panelJ2.setBorder(BorderFactory.createTitledBorder(controler.getNomJoueur2()));
				
		JLabel devise1 = new JLabel(controler.getDeviseJoueur1());
		JLabel devise2 = new JLabel(controler.getDeviseJoueur2());
				
				
		panelJ1.add(devise1, BorderLayout.SOUTH);
		panelJ2.add(devise2, BorderLayout.SOUTH);
			
		jp_east.add(boutonMenu);
		jp_east.add(panelJ1);
		jp_east.add(panelJ2);
		
		this.setLayout(new BorderLayout());
		this.add(new PlateauGUI(parent, controler),BorderLayout.CENTER);
		this.add(jp_east,BorderLayout.EAST);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub	
	}
}
