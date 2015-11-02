package vue;

import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ParamGUI extends JFrame implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener, java.util.Observer{
	private JLabel jl;
	
	public void init() {
		jl = new JLabel("Fenêtre paramètres !");
		this.getContentPane().add(jl);
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
