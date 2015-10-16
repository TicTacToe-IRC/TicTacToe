package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controler.TicTacToeControler;

public class MenuGUI extends JFrame implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener, java.util.Observer{
	private JButton boutonJouer = new JButton("Jouer");
	private JButton boutonQuitter = new JButton("Quitter");
	
	public MenuGUI(java.lang.String name, TicTacToeControler chessGameControler, java.awt.Dimension boardSize){
		super(name);
		this.setSize(boardSize);
		init();
	}
	
	public void init(){
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		panel.setLayout(new BorderLayout());
		panel2.setLayout(new BorderLayout());
		panel.add(boutonJouer);
		panel2.add(boutonQuitter);
		panel.setSize(350, 350);
		panel2.setSize(350, 350);
		panel.setLocation(100, 300);
		panel2.setLocation(600, 300);
		this.getContentPane().add(panel);
		this.getContentPane().add(panel2);
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
		// TODO Auto-generated method stub
		
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
