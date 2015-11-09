package vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Popup extends JDialog {
	private JFrame parent;
	
	public Popup(JFrame parent, String title, String txt, boolean modal){
		super(parent, title, modal);
		this.parent = parent;
		this.setSize(200, 80);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	    this.initComponent(txt);
	}
	
	private void initComponent(String txt){
		JLabel jl = new JLabel(txt);
		JButton b = new JButton("Ok");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((MainFrame)parent).goTo("menu");
				System.gc();
				closePopup();
			}
		});

		this.getContentPane().add(jl, BorderLayout.CENTER);
		this.getContentPane().add(b, BorderLayout.SOUTH);
	}
	
	public void showPopup(){
		this.setVisible(true);   
	}
	
	public void closePopup(){
		this.dispose();  
	}
}
