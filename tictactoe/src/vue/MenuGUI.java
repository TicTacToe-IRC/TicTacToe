package vue;

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

import launcher.LauncherGUI;
import controler.TicTacToeControler;

public class MenuGUI extends JFrame implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener, java.util.Observer{
	private JButton boutonJouer = new JButton("Jouer");
	private JButton boutonQuitter = new JButton("Quitter");
	private JLabel label = new JLabel("");
	public MenuGUI(java.lang.String name, TicTacToeControler chessGameControler, java.awt.Dimension boardSize){
		super(name);
		this.setSize(boardSize);
		init();
	}
	
	public void init(){
		JPanel panel = new JPanel();
		setLayout(new FlowLayout(0 , 250, 250));

		panel.add(boutonJouer);
		panel.add(boutonQuitter);
		boutonJouer.addActionListener(new Jouer());
		boutonQuitter.addActionListener(new Quitter());
		
		this.getContentPane().add(panel);
		this.getContentPane().add(label);
	}
	
	public class Jouer implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			label.setText("Vous avez cliqué sur " + arg0.getActionCommand());
			Dimension dim = new Dimension(700,700);
			JFrame paramGUI = new ParamGUI(dim);
			paramGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			paramGUI.setLocation(600, 10);
			paramGUI.setPreferredSize(dim);
			paramGUI.pack();
			paramGUI.setVisible(true);
			MenuGUI.this.setVisible(false);
		}
	}
	
	public class Quitter implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			label.setText("Vous avez cliqué sur " +arg0.getActionCommand());
			System.exit(0);
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
