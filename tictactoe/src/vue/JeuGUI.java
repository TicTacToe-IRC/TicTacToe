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
	private JButton boutonJouer = new JButton("Jouer");
	private JButton boutonQuitter = new JButton("Quitter");
	private JLabel label = new JLabel("TEst");
	public JeuGUI(java.lang.String name, TicTacToeControler chessGameControler, java.awt.Dimension boardSize){
		super(name);
		this.setSize(boardSize);
		init();
	}
	
	public void init(){
		JPanel panel = new JPanel();
		setLayout(new FlowLayout(0 , 250, 250));

		panel.add(boutonJouer);
		panel.add(boutonQuitter);
		//boutonJouer.addActionListener(new Jouer());
		boutonQuitter.addActionListener(new Quitter());
		
		//JPanel jp = new PlateauGUI();

		//this.setContentPane(new PlateauGUI());

		//this.getContentPane().add(jp);
		JPanel jp_east = new JPanel();
		jp_east.setLayout(new BoxLayout(jp_east, BoxLayout.PAGE_AXIS));
		//this.getContentPane().add(panel);
		//this.getContentPane().add(label);
		//applet.init();
		//applet.start();
		jp_east.add(panel);
		jp_east.add(label);
		this.setLayout(new BorderLayout());
		this.getContentPane().add(new PlateauGUI(),BorderLayout.CENTER);
		this.getContentPane().add(jp_east,BorderLayout.EAST);
	}
	
	public class Quitter implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			label.setText("Vous avez cliqué sur " +arg0.getActionCommand());
			System.exit(0);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
