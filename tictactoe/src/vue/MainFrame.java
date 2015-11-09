package vue;

import java.awt.Dimension;

import javax.swing.JFrame;

import controler.TicTacToeControler;

public class MainFrame extends JFrame {
	TicTacToeControler controler;
	
	public MainFrame(String title, Dimension dim, TicTacToeControler controler) {
		super(title);
		this.setTitle(title);
	    this.setSize(dim);
	    this.controler = controler;
	    
	    init();
	}
	
	public void init(){
		this.getContentPane().add(new MenuGUI(this));
	}
	
	public void goTo(String s){
		this.getContentPane().removeAll();
		if(s.equals("menu")){
			this.getContentPane().add(new MenuGUI(this));
		} else if(s.equals("param")){
			this.getContentPane().add(new ParamGUI(this, controler));
		} else if(s.equals("loading")){
			loading();
			//goTo("jeu");
		} else if(s.equals("jeu")){
			System.gc();
			this.getContentPane().add(new JeuGUI(this, controler));
		} else if(s.equals("propos")){
			this.getContentPane().add(new APropos(this));
		}
		this.repaint();
		this.validate();
	}
	
	public void loading(){
		this.getContentPane().removeAll();
		this.getContentPane().add(Loading.getInstance());
		this.repaint();
		this.validate();
	}

}
