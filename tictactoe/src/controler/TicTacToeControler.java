package controler;

import model.Plateau;
import model.observable.TicTacToe;

public class TicTacToeControler {
	private Plateau plateau;
	
	public TicTacToeControler(Plateau p){
		this.plateau = p;
	}
	
	public int placementOk(int x, int y){
		return plateau.placementHauteur(x,y);
	}
	
	public void placerPion(int x, int y, int z){
		plateau.placerPion(x, y, z);
	}
	
	public int getIdJoueur(){
		return plateau.getIdJoueurCourant();
	}
	
	public String getNomJoueur1() {
		return plateau.getNomJoueur1();
	}
	
	public String getNomJoueur2() {
		return plateau.getNomJoueur2();
	}
}
