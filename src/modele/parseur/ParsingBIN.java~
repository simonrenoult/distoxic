package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParsingBINTest {
	public static int _CLASSEMAX = 6;
	public static int _CLASSEMIN = 1;
	
	private ArrayList<ArrayList<Integer>> ListeBIN= null;
	private Object[][] tableauBIN = null;
	
	ParsingBINTest(){
		ListeBIN= new ArrayList<ArrayList<Integer>>();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ParsingBINTest p1 = new ParsingBINTest();
		p1.lireFichier("files\\exemple_70_34\\exemple_70_34.bin");
		p1.trierListe();
		p1.CreationTableauxObjet();
		p1.affichercontenu();
		p1.afficherTableau();
	}

///////////////////////////////////////////////UTILISANT DES LISTES
	public void affichercontenu() {
		for(ArrayList<Integer> liste : ListeBIN){
			System.out.println();
			System.out.println("________________________________");
			for (int i = 0; i< liste.size(); i++){
				System.out.print(liste.get(i).toString()+" ");
			}
		}
		
		
	}
	
	public ArrayList<Integer> CreationListeLigne(String Line) {
		String[] tab = Line.split(" ");
		ArrayList<Integer> listeTemp= new ArrayList<Integer>();
		for (int i = 0; i< tab.length; i++){
			listeTemp.add(Integer.parseInt(tab[i]));
		}
		return listeTemp;
	}

	public void trierListe(){
		ArrayList<ArrayList<Integer>> ListeTemp =new ArrayList<ArrayList<Integer>>();
		
		
		int cpt = 1;
		for(int i = 0; i< _CLASSEMAX; i++ ){
			for (int j= 0; j< ListeBIN.size(); j++){
				if( ListeBIN.get(j).get(0) == cpt){
					ListeTemp.add(ListeBIN.get(j));
				}
			}
			cpt++;
		}
		
		ListeBIN = ListeTemp;
		
	}
	/////////////////////////////////////////////////UTILISANT DES TABLEAUX
	
	public void CreationTableauxObjet() {
		tableauBIN = new Object[ListeBIN.size()][3];
		for (int i = 0; i< tableauBIN.length; i++){
			tableauBIN[i][0] = i+1;
			tableauBIN[i][1] = ListeBIN.get(i).get(0);
			tableauBIN[i][2] = ListeBIN.get(i).size()-1;
		}
	}
	
	public void afficherTableau(){
		System.out.println("Numéro     Classe     Nombrefragments");
		for (int i = 0; i< tableauBIN.length; i++){
			System.out.println(tableauBIN[i][0]+"     "+tableauBIN[i][1]+"     "+tableauBIN[i][2]);
		}
	}

////////////////////////////////////////////////////TRAITEMENT DONNEES
	public void lireFichier(String filePath) {
		try{
			BufferedReader buff = new BufferedReader(new FileReader(filePath));
			try {
				String line;
				while ((line = buff.readLine()) != null) {
				ListeBIN.add(CreationListeLigne(line));
				}
			} 
			finally {
				buff.close();
		}
		} catch (IOException ioe) {
		// erreur de fermeture des flux
		System.out.println("Erreur --" + ioe.toString());
		}
		
		
		
		
	}





	
	
}
