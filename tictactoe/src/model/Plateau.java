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
		for(int z=0; z< lignes; z++){
			for(int y=0; y< hauteur; y++){
				for(int x=0; x< colonnes; x++){
					System.out.print(" | " + plateauJeu[x][y][z]);
				}
				System.out.println(" | hauteur" + y);
			}	
			System.out.println("");
		}
		System.out.println("");
	}

	public boolean placerPion(int x, int z, int idJoueur) throws Exception {
		int y = placementHauteur(x, z);
		if(y !=-1){
			//On place le pion du joueur "joueur"
			plateauJeu[x][y][z] = idJoueur;
			return true;
		}
		throw new Exception();
	}

	public int placementHauteur(int x, int z){

		/*Si on tente de mettre un pion hors du plateau OU que le batonnet sur 
		lequel on tente de placer le pion est rempli */
		if ((x<0 || x>3 || z<0 || z>3)){
			return -1;
		}
		else{
			int y=0;
			while(y<4 && plateauJeu[x][y][z]!=0){
				y++;
			}
			if(y<4){
				return y;
			}
			else{
				return -1;
			}
		}
	}

	public int switchJoueur(int idJoueur){
		if(idJoueur == 1){
			idJoueur = 2;
		}
		else{
			idJoueur = 1;
		}
		return idJoueur;
	}

	public boolean gagner(int x, int y, int z, int idJoueur){
			if((plateauJeu[0][y][z]== idJoueur && plateauJeu[1][y][z]== idJoueur
			&& plateauJeu[2][y][z]== idJoueur && plateauJeu[3][y][z]== idJoueur)
			|| (plateauJeu[x][0][z]== idJoueur && plateauJeu[x][1][z]== idJoueur
					&& plateauJeu[x][2][z]== idJoueur && plateauJeu[x][3][z]== idJoueur)){
				return true;
			}
			else 
				return false;	
	}
}
