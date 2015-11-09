package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

public class StatRecord {
	private TreeMap<String,Statistics> stats = new TreeMap<String, Statistics>();
	private String filePath = "stats.data";
	
	private StatRecord() throws ClassNotFoundException, IOException {
		load();
	}
	
	private static StatRecord INSTANCE = null;
	
	public static StatRecord getInstance() throws ClassNotFoundException, IOException {
		if (INSTANCE == null) {
			INSTANCE = new StatRecord();
		}
		
		return INSTANCE;
	}
	
	public void addPartieGagnee(String nomJoueur) {
		if (stats.containsKey(nomJoueur)) {
			stats.get(nomJoueur).addPartieGagnee();
		}
		else {
			Statistics st = new Statistics();
			st.addPartieGagnee();
			stats.put(nomJoueur, st);
		}
	}
	
	public void addPartiePerdue(String nomJoueur) {
		if (stats.containsKey(nomJoueur)) {
			stats.get(nomJoueur).addPartiePerdue();
		}
		else {
			Statistics st = new Statistics();
			st.addPartiePerdue();
			stats.put(nomJoueur, st);
		}
	}
	
	public void addPartieNulle(String nomJoueur) {
		if (stats.containsKey(nomJoueur)) {
			stats.get(nomJoueur).addPartieNulle();
		}
		else {
			Statistics st = new Statistics();
			st.addPartieNulle();
			stats.put(nomJoueur, st);
		}
	}
	
	public int getNbPartiesGagnees(String nomJoueur) {
		return (stats.containsKey(nomJoueur) ? stats.get(nomJoueur).getNbPartiesGagnees() : -1);
	}
	
	public int getNbPartiesPerdues(String nomJoueur) {
		return (stats.containsKey(nomJoueur) ? stats.get(nomJoueur).getNbPartiesPerdues() : -1);
	}
	
	public int getNbPartiesNulles(String nomJoueur) {
		return (stats.containsKey(nomJoueur) ? stats.get(nomJoueur).getNbPartiesNulles() : -1);
	}
	
	public void store() throws IOException {
		FileOutputStream f_out = new FileOutputStream(filePath);
		ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
		obj_out.writeObject(stats);
		f_out.close();
	}
	
	public void load() throws IOException, ClassNotFoundException {
		FileInputStream f_in = new FileInputStream(filePath);
		ObjectInputStream obj_in = new ObjectInputStream(f_in);
		stats = (TreeMap<String, Statistics>) obj_in.readObject();
		f_in.close();
	}
}
