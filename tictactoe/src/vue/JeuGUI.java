package vue;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.j3d.utils.applet.MainFrame;

import launcher.LauncherGUI;
import controler.TicTacToeControler;

public class JeuGUI extends JFrame implements java.util.Observer{
	private TicTacToeControler controler;
	
	public JeuGUI(java.lang.String name, TicTacToeControler controler, java.awt.Dimension boardSize){
		super(name);
		this.setSize(boardSize);
		this.controler = controler;
		init();
	}
	
	public void init(){
		setLayout(new FlowLayout(0 , 250, 250));

		JPanel 	jp_east = new JPanel();
				jp_east.setPreferredSize(new Dimension(200,400));
				jp_east.setLayout(new BoxLayout(jp_east, BoxLayout.PAGE_AXIS));
		
		JPanel 	panelJ1 = new JPanel();
				panelJ1.setBorder(BorderFactory.createTitledBorder(controler.getNomJoueur1()));
		JPanel 	panelJ2 = new JPanel();
				panelJ2.setBorder(BorderFactory.createTitledBorder(controler.getNomJoueur2()));
		jp_east.add(panelJ1);
		jp_east.add(panelJ2);
		
		this.setLayout(new BorderLayout());
		this.getContentPane().add(new PlateauGUI(controler),BorderLayout.CENTER);
		this.getContentPane().add(jp_east,BorderLayout.EAST);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub	
	}
}
