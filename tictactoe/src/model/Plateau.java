package model;

public class Plateau {

	private String message;
	private int[][][] plateauJeu;
	
	Couleur bleu = new Couleur("bleu", 1, 1 ,1);
	Couleur rouge = new Couleur("rouge", 2, 2 ,2);
	
	public Plateau() {
		super();
	}
	
	public boolean placerPion(int x, int y, int joueur) {
		if(placementOk(x, y)){
			//On place le pion du joueur "joueur"
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean placementOk(int x, int y){
		
		if ((x<0 || x>3 || y<0 || y>3)||(plateauJeu[x][y][3] != 0)){
				return false;
		}
		else{
				return true;
		}
	}
/*	
	public int valeurCase(){
		
	}
*/	
	
	
}
