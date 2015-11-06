package vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
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

import launcher.LauncherGUI;
import controler.TicTacToeControler;

public class MenuGUI extends JPanel{
	private JButton boutonJouer = new JButton("Jouer");
	private JButton boutonQuitter = new JButton("Quitter");
	private JLabel label = new JLabel("");
	private FcardLayout parent;
	
	Panel panel;
	final static String s1 = "carte 1";
	final static String s2 = "carte 2";
	
	
	public MenuGUI(FcardLayout parent){
		super();
		this.parent = parent;
		init();
	}
	
	public void init(){

		JPanel panel = new JPanel();
		setLayout(new FlowLayout(0 , 250, 250));

		panel.add(boutonJouer);
		panel.add(boutonQuitter);
		boutonJouer.addActionListener(new Jouer());
		boutonQuitter.addActionListener(new Quitter());
		
		this.add(panel);
		this.add(label);
		
	}
	
	public class Jouer implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			/*label.setText("Vous avez cliqué sur " + arg0.getActionCommand());

			JPanel paramGUI = new ParamGUI();
			paramGUI.setLocation(600, 10);
			paramGUI.setVisible(true);
			MenuGUI.this.setVisible(false);*/
			parent.setPanelByName("param");
		}
	}
	
	public class Quitter implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			label.setText("Vous avez cliqué sur " +arg0.getActionCommand());
			System.exit(0);
		}
	}

}