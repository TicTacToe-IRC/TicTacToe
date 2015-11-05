package main;

import java.util.Scanner;

import model.Couleur;
import model.Joueur;
import model.Plateau;

public class Java {
	public static void main(String[] args) {
		
		Couleur bleu = new Couleur("bleu", 1, 1 ,1);
		Couleur rouge = new Couleur("rouge", 2, 2 ,2);
		
		Joueur joueur1 = new Joueur("Dan", bleu, 1);
		Joueur joueur2 = new Joueur("PD", rouge, 2);
		
		System.out.println(joueur1.toString());
		System.out.println(joueur2.toString());
		
		
		Plateau plateau = new Plateau(4, 4, 4);
		
		//plateau.afficherPlateau();
		/*
		try {
			plateau.placerPion(3, 3, joueur1.getId());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		plateau.afficherPlateau();*/
		int joueurCourant = 2;
		int x=0, y=0, z=0;
		do{
			if(joueurCourant == joueur1.getId()){
				joueurCourant = joueur2.getId();
			}
			else{
				joueurCourant = joueur1.getId();
			}
			System.out.println("Joueur " + joueurCourant +", placez un pion");
			System.out.println("x: ");
			Scanner sc = new Scanner(System.in);
			x = sc.nextInt();
			System.out.print("z: ");
			z = sc.nextInt();
			
			try {
				y = plateau.placementHauteur(x, z);
				plateau.placerPion(x, z, joueurCourant);
				System.out.println(x + ", " + y +", "+ z);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			plateau.afficherPlateau();
		}
		while(!plateau.gagner(x, y, z, joueurCourant));

			System.out.println("Le joueur "+ joueurCourant + " a gagné");

	}
		
}
