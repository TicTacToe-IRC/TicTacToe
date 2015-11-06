package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Couleur;

public class ParamGUI extends JPanel {
	private JLabel jl, jl1, jl2, jl3, jl4;
	private JTextField nom;
	private JPanel jp1 = new JPanel(), jp2 = new JPanel(), jp3 = new JPanel();  
	private JTextField nom1 = new JTextField(), 
			nom2 = new JTextField(); 
	private JComboBox<String> colorList1 = new JComboBox<String>();
	private JComboBox<String> colorList2 = new JComboBox<String>();
	private Object lastItem1, lastItem2;
	private int lastPosition1, lastPosition2;
	private JLabel couleur1 = new JLabel(), couleur2 = new JLabel();
	private JTextField attaque1 = new JTextField(), attaque2 = new JTextField();
	
	private FcardLayout parent;
	
	private List<Couleur> couleurs = 
		Arrays.asList(
			new Couleur("Blanc",255,255,255),
			new Couleur("Noir",0,0,0),
			new Couleur("Rouge",255,0,0),
			new Couleur("Vert",0,255,0),
			new Couleur("Bleu",0,0,255),
			new Couleur("Marron",88,41,0),
			new Couleur("Gris",96,96,96),
			new Couleur("Jaune",255,255,0),
			new Couleur("Orange",237,127,16),
			new Couleur("Rose",253,108,158),
			new Couleur("Violet",102,0,153)
		);
	
	public ParamGUI(FcardLayout parent) {
		this.parent = parent;
		init();
	}
	
	public void init() {
		jl = new JLabel("");
		jl1 = new JLabel("");
		jl2 = new JLabel("");
		
		this.add(jl);
		
		/* Joueur 1 */
		this.setLayout(new BorderLayout());
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
		
		jp1.setLayout(new GridLayout(10,10));
		jp2.setLayout(new GridLayout(10,10));
		
		jp1.add(nom1);
		jp1.add(jl);
		this.add(jp1, BorderLayout.WEST);
		
		/* Joueur 2 */
		nom2.setPreferredSize(new Dimension(150,30));
		
		jl = jl2;
		nom = nom2;
		jp2.add(nom2);
		jp2.add(jl);
		
		Collections.sort(couleurs);
		
		addColors(colorList1);
		addColors(colorList2);
		
		colorList1.setSelectedIndex(0);
		lastItem2 = colorList2.getItemAt(0);
		lastPosition2 = 0;
		colorList2.removeItemAt(0);
		colorList2.setSelectedIndex(0);
		lastItem1 = colorList1.getItemAt(1);
		lastPosition1 = 1;
		colorList1.removeItemAt(1);
		
		couleur1.setForeground(getColorAt(0));
		couleur2.setForeground(getColorAt(1));
		
		couleur1.setText(couleurs.get(0).getNom());
		couleur2.setText(couleurs.get(1).getNom());
		
		colorList1.addActionListener(new PickList(1));
		colorList2.addActionListener(new PickList(2));
		
		jl3 = new JLabel("Phrase d'attaque :");
		jl4 = new JLabel("Phrase d'attaque :");
		
		jp1.add(colorList1);
		jp1.add(couleur1);
		jp1.add(jl3);
		jp1.add(attaque1);
		
		jp2.add(colorList2);
		jp2.add(couleur2);
		jp2.add(jl4);
		jp2.add(attaque2);
		
		this.add(jp2, BorderLayout.EAST);
		
		/* Validation */
		
		JButton valider = new JButton("Valider");
		valider.setPreferredSize(new Dimension(100, 30));
		valider.addActionListener(new Valider());
		
		JButton retour = new JButton("Retour");
		retour.setPreferredSize(new Dimension(100, 30));
		retour.addActionListener(new Retour());
		
		jp3.add(retour);
		jp3.add(valider);
		
		/* Victoire */
		
		JCheckBox gagner = new JCheckBox ("Option : 'J'ai gagné'");
		gagner.setPreferredSize(new Dimension(200, 30));
		gagner.addActionListener(new Gagner());
		jp3.add(gagner);
		
		this.add(jp3, BorderLayout.SOUTH);
		
	}
	
	public void addColors(JComboBox<String> cb) {
		for (int i = 0; i<couleurs.size(); i++) {
			cb.addItem((String)couleurs.get(i).getNom());
		}
	}
	
	public Color getColorAt(int index) {
		Couleur c = couleurs.get(index);
		return new Color(c.getR(),c.getG(),c.getB());
	}
	
	public int getIndexOfColor(Object item) {
		String coul = (String) item;
		int i = 0;
		while (i<couleurs.size() && couleurs.get(i).getNom() != coul) {
			i++;
		}
		return i;
	}
	
	public class PickList implements ActionListener{
		private JComboBox<String> cbA, cbO;
		private Integer lastPosition;
		private Object lastItem;
		private JLabel couleur;
		public PickList(int ind) {
			if (ind == 1) {
				this.cbA = colorList1;
				this.cbO = colorList2;
				this.lastItem = lastItem2;
				this.lastPosition = lastPosition2;
				this.couleur = couleur1;
			}
			else {
				this.cbA = colorList2;
				this.cbO = colorList1;
				this.lastItem = lastItem1;
				this.lastPosition = lastPosition1;
				this.couleur = couleur2;
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object item = cbA.getSelectedItem();
			int index = getIndexOfColor(item);
		    couleur.setForeground(getColorAt(index));
		    couleur.setText(couleurs.get(index).getNom());
		    cbO.insertItemAt((String)lastItem,lastPosition);
			cbO.removeItem(item);
			lastItem = item;
			lastPosition = index;
		}
		
	}
	
	public class Valider implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {

		}
	}
	
	public class Retour implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			parent.setPanelByName("menu");
		}
	}
	
	public class Gagner implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {

		}
	}
}