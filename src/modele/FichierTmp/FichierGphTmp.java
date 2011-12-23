package modele.FichierTmp;

import java.util.ArrayList;
import java.util.LinkedList;

import modele.composantsChimiques.FragmentMolecule;

public class FichierGphTmp {

// ----------------------------------------- //
// ----------------ATRIBUTS----------------- //
// ----------------------------------------- //
	private LinkedList<FragmentMolecule>	listeGPH				= null;

// ----------------------------------------- //
// --------------CONSTRUCTEURS-------------- //
// ----------------------------------------- //
	public FichierGphTmp(LinkedList<FragmentMolecule> listeGPH) {
		listeGPH = listeGPH;
	}
// ----------------------------------------- //
// -------------INITIALISEURS--------------- //
// ----------------------------------------- //
	
	

// ----------------------------------------- //
// -----------------METHODES---------------- //
// ----------------------------------------- //
	
	public void suppressionLigneLigneFichierBinTmp(int position){
		listeGPH.remove(position);
	}
	
	public void AjouterLigneLigneFichierBinTmp(int position,int numéro ){
		
	}
	
	public void mofifierValeur( int positionLigne, int positionColonne, int valeur){
		
		switch(positionColonne){
		
		
		
		}
	}
	
	/**
	 * Permet d'afficher le tableau 2D � partir de la liste
	 */
	public void afficherTableau()
	{
		for (FragmentMolecule fragment : listeGPH)
		{
			System.out.println("\n_______________NOUVEAU FRAGMENT______________");
			System.out.print("Numero : " + fragment.getBalise("Numero").getValeur());
			System.out.print(", Nombre atome : " + fragment.getAtomes().size());
			System.out.println(", Nombre liaison : " + fragment.getListeLiaison().size());
			System.out.println("Classe : " + fragment.getBalise("Classe").getValeur());
			System.out.println("Frequence : " + fragment.getBalise("Frequence").getValeur());
			System.out.println("Toxicite : " + fragment.getBalise("Toxicite").getValeur());
			System.out.println("Emergence : " + fragment.getBalise("Emergence").getValeur());
		}
	}
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	

	/**
	 * @return the listeGPH
	 */
	public LinkedList<FragmentMolecule> getListeGPH() {
		return listeGPH;
	}

	

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @param listeGPH the listeGPH to set
	 */
	public void setListeGPH(LinkedList<FragmentMolecule> listeGPH) {
		this.listeGPH = listeGPH;
	}
}
