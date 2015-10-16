package model.observable;


import java.util.Observable;

import model.Couleur;
import model.Plateau;


public class TicTacToe extends Observable{
	
	private Plateau plateau;
	

	public TicTacToe() {
		super();
		this.plateau = new Plateau();
	}
}