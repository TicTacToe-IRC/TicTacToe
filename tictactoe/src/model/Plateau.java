package model;

public class Plateau {

	private int lignes;
	private int colonnes;
	private int hauteur;
	private int[][][] plateauJeu;
	
	
	public Plateau(int l, int c, int h) {
		super();
		lignes = l;
		colonnes = c;
		hauteur = h;
		plateauJeu = new int[l][c][h];
		
		for(int i=0; i< plateauJeu.length; i++){
			for(int j=0; j< plateauJeu.length; j++)
				for(int k=0; k< plateauJeu.length; k++)
					plateauJeu[i][j][k] = 0;
		}
	}
	
	public void afficherPlateau(){
		/* Lignes = horizontales
		 * Colonnes = verticales */
		for(int i=0; i< lignes; i++){
			for(int j=0; j< colonnes; j++){
				for(int k=0; k< hauteur; k++){
					System.out.print(" | " + plateauJeu[i][j][k]);
				}
				System.out.println(" | hauteur" + j);
			}	
			System.out.println("");
		}
		System.out.println("");
	}
	
	public boolean placerPion(int x, int y, int idJoueur) throws Exception {
		int z = indicePlacement(x, y);
		if(z !=-1){
			//On place le pion du joueur "joueur"
					plateauJeu[x][y][z] = idJoueur;
					return true;
		}
		throw new Exception();
	}
	
	public int indicePlacement(int x, int y){
		
		/*Si on tente de mettre un pion hors du plateau OU que le batonnet sur 
		lequel on tente de placer le pion est rempli */
		if ((x<0 || x>3 || y<0 || y>3)){
				return -1;
		}
		else{
			int z=0;
			while(z<4 && plateauJeu[x][y][z]!=0){
				z++;
			}
			if(z<4){
				return z;
			}
			else{
				return -1;
			}
		}
	}
	
	
}
