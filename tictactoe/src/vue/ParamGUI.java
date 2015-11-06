package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ParamGUI extends JFrame {
	private JLabel jl, jl1, jl2;
	private JTextField nom;
	private JPanel jp1 = new JPanel(), jp2 = new JPanel(), jp3 = new JPanel() , jp4 = new JPanel();
	private JTextField nom1 = new JTextField(), 
			nom2 = new JTextField(); 
	
	public ParamGUI(Dimension dim) {
		super("ParamÃ¨tres du jeu");
		this.setSize(dim);
		init();
	}
	
	public void init() {
		jl = new JLabel("");
		jl1 = new JLabel("");
		jl2 = new JLabel("");
		
		this.getContentPane().add(jl);
		
		/* Joueur 1 */
		this.getContentPane().setLayout(new BorderLayout());
		nom1.setPreferredSize(new Dimension(150,30));
		
		/*
		JPanel b1 = new JPanel();
		 b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
		 b1.add(nom1);
		 b1.add(valider);
		 
		JPanel b2 = new JPanel();
		 b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
		 jl = jl1;
		 b2.add(jl);*/
		 
		//jp1.setLayout(new BoxLayout(jp1, BoxLayout.PAGE_AXIS));
		jl = jl1;
		nom = nom1;
		jp1.add(nom1);
		jp1.add(jl);
		this.getContentPane().add(jp1, BorderLayout.WEST);
		
		/* Joueur 2 */
		nom2.setPreferredSize(new Dimension(150,30));
		
		jl = jl2;
		nom = nom2;
		jp2.add(jl);
		jp2.add(nom2);
		this.getContentPane().add(jp2, BorderLayout.EAST);
		
		/* Validation */
		
		JButton valider = new JButton("Valider");
		valider.setPreferredSize(new Dimension(100, 30));
		valider.addActionListener(new Valider());
		jp3.add(valider);
		this.getContentPane().add(jp3, BorderLayout.SOUTH);

		/* Victoire */
		
		JCheckBox gagner = new JCheckBox ("Option : 'J'ai gagné'");
		gagner.setPreferredSize(new Dimension(200, 30));
		gagner.addActionListener(new Gagner());
		jp4.add(gagner);
		this.getContentPane().add(jp4, BorderLayout.NORTH);
	}
	
	public class Valider implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(nom.getText());
			jl1.setText("Vous avez saisi " + nom1.getText());
			jl2.setText("Vous avez saisi " + nom2.getText());
		}
	}

	
	public class Gagner implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
}
