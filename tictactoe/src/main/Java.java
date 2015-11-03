package main;

import model.Couleur;
import model.Joueur;
import model.Plateau;

public class Java {
	public static void main(String[] args) {
		System.out.println("Coucou !\n");
		
		Couleur bleu = new Couleur("bleu", 1, 1 ,1);
		Couleur rouge = new Couleur("rouge", 2, 2 ,2);
		
		Joueur joueur1 = new Joueur("Dan", bleu, 1);
		Joueur joueur2 = new Joueur("PD", rouge, 2);
		
		System.out.println(joueur1.toString());
		
		
		Plateau plateau = new Plateau(4, 4, 4);
		
		plateau.afficherPlateau();
		
		try {
			plateau.placerPion(3, 3, joueur1.getId());
			plateau.placerPion(3, 3, joueur2.getId());
			plateau.placerPion(3, 3, joueur2.getId());
			plateau.placerPion(3, 3, joueur2.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		plateau.afficherPlateau();
		
		
	}
}
