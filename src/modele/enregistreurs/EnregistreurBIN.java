package modele.enregistreurs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EnregistreurBIN implements EnregistreurGenerique {
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	public static int						_CLASSEMAX	= 6;
	public static int						_CLASSEMIN	= 1;
	public static String _SEPARATEURBIN = " ";

	private ArrayList<ArrayList<Integer>>	listeBIN	= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	public EnregistreurBIN(){

	}

	public EnregistreurBIN(ArrayList<ArrayList<Integer>> liste, String path){
		System.out.println("enregistrment du fichier BIN");
		listeBIN = liste;
		ecrireFichier(path);

	}
	public EnregistreurBIN(ArrayList<ArrayList<Integer>> liste){
		System.out.println("enregistrment du fichier BIN");
		listeBIN = liste;

	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	/**
	 * Methode principale d'ecriture sur fichier BIN. On ecrit chaque ligne correspondant à l'ensemble des
	 * fragments toxiques appartenant à une molécule.
	 * @param path
	 * @return
	 */
	@Override
	public boolean ecrireFichier(String path){

			try
			{
				BufferedWriter buff = new BufferedWriter(new FileWriter(path));
				try
				{
					for(int i = 0; i< listeBIN.size(); i++){
						ecrireLigne(buff, i);
					}
				}
				catch (Exception e) {
					return false;
				}
				finally
				{
					buff.close();
				}
			}
			catch (IOException ioe)
			{
				// erreur de fermeture des flux
				System.out.println("Erreur --" + ioe.toString());
				return false;
			}
		return true;
	}

	/**
	 * On ecrit sur fichier la ligne correspondant à l'ensemble des fragments toxiques d'une molécule.
	 * @param buff
	 * @param index
	 */
	public boolean ecrireLigne(BufferedWriter buff, int index){
		String line = "";
		for(int j = 0; j<listeBIN.get(index).size(); j++){
			line = line + String.valueOf(listeBIN.get(index).get(j)) + _SEPARATEURBIN ;
		}
		if(index < listeBIN.size()-1){
			//On ajoute \n à toute les lignes sauf la derniere.
			line = line + "\n";
		}

		try {
			buff.write(line);
		} catch (IOException e) {
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}