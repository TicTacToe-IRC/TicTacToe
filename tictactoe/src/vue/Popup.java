package vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Popup extends JDialog {
	private JFrame parent;
	
	public Popup(JFrame parent, String title, String txt, boolean modal){
		super(parent, title, modal);
		this.parent = parent;
		this.setSize(200, 100);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	    this.initComponent(txt);
	}
	
	private void initComponent(String txt){
		JLabel jl = new JLabel(txt);
		JButton brejouer = new JButton("Rejouer");
		brejouer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((MainFrame)parent).goTo("jeu");
				closePopup();
			}
		});
		JButton bmenu = new JButton("Menu");
		bmenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((MainFrame)parent).goTo("menu");
				closePopup();
			}
		});
		
		JPanel 	panelLabel = new JPanel();
				panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.PAGE_AXIS));
		
		JPanel 	panelBouton = new JPanel();
				panelBouton.setLayout(new BoxLayout(panelBouton, BoxLayout.LINE_AXIS));

		panelLabel.add(jl);
		panelBouton.add(brejouer);
		panelBouton.add(bmenu);
		this.getContentPane().add(panelLabel, BorderLayout.CENTER);
		this.getContentPane().add(panelBouton, BorderLayout.SOUTH);
	}
	
	public void showPopup(){
		this.setVisible(true);   
	}
	
	public void closePopup(){
		this.dispose();  
	}
}
