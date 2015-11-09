package model;

public class Statistics {
	private int nbPartiesGagnees;
	private int nbPartiesPerdues;
	private int nbPartiesNulles;
	
	public int getNbPartiesGagnees() {
		return nbPartiesGagnees;
	}

	public void addPartieGagnee() {
		this.nbPartiesGagnees ++;
	}

	public int getNbPartiesPerdues() {
		return nbPartiesPerdues;
	}

	public void addPartiePerdue() {
		this.nbPartiesPerdues ++;
	}

	public int getNbPartiesNulles() {
		return nbPartiesNulles;
	}

	public void addPartieNulle() {
		this.nbPartiesNulles ++;
	}
	
	
}
