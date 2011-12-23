package modele.fichiersTmp;

<<<<<<< HEAD
import java.io.File;
import java.util.ArrayList;
=======
>>>>>>> 71c4962a9aa83a3d1fd9e00f5765a44f2b1f33db
import java.util.LinkedList;

import modele.composantsChimiques.FragmentMolecule;

public class FichierGphTmp
{

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	private LinkedList<FragmentMolecule>	listeGPH	= null;

<<<<<<< HEAD
// ----------------------------------------- //
// --------------CONSTRUCTEURS-------------- //
// ----------------------------------------- //
	public FichierGphTmp(LinkedList<FragmentMolecule> listeGPH) {
		this.listeGPH = listeGPH;
=======
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	public FichierGphTmp(LinkedList<FragmentMolecule> listeGPH)
	{
		listeGPH = listeGPH;
>>>>>>> 71c4962a9aa83a3d1fd9e00f5765a44f2b1f33db
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	public void suppressionLigneLigneFichierBinTmp(int position)
	{
		listeGPH.remove(position);
	}

	public void AjouterLigneLigneFichierBinTmp(int position, int numéro)
	{

	}
<<<<<<< HEAD
	
	public void mofifierValeur( int positionLigne, int positionColonne, String valeur){
		
		switch(positionColonne){
		
		case 3 : listeGPH.get(positionLigne).getBalise("Classe").setValeur(valeur);
		break;
		case 4 : listeGPH.get(positionLigne).getBalise("Frequence").setValeur(valeur);
		break;
		case 5 : listeGPH.get(positionLigne).getBalise("Toxicite").setValeur(valeur);
		break;
		case 6 : listeGPH.get(positionLigne).getBalise("Emergence").setValeur(valeur);
		break; 
		
		}
	}
	
	public String creerCheminNouveauFichier(String path){
		File fichierReference = new File(path);
		String nomFichier = fichierReference.getName();
		System.out.println(nomFichier);
		String tabNomFichier[] = nomFichier.split(".gph");
		
		File dossier = fichierReference.getParentFile();
		String listeDossier[] = dossier.list();
		int cpt = 0;
		for (int i = 0; i< listeDossier.length; i++){
			if (listeDossier[i].endsWith("gph")){
				cpt++;
			}
=======

	public void mofifierValeur(int positionLigne, int positionColonne, int valeur)
	{

		switch (positionColonne)
		{

>>>>>>> 71c4962a9aa83a3d1fd9e00f5765a44f2b1f33db
		}
		
		
		nomFichier = tabNomFichier[0]+"_("+cpt+")"+".gph";
		
		return dossier.getPath()+File.separator+nomFichier;
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
	public LinkedList<FragmentMolecule> getListeGPH()
	{
		return listeGPH;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @param listeGPH
	 *            the listeGPH to set
	 */
	public void setListeGPH(LinkedList<FragmentMolecule> listeGPH)
	{
		this.listeGPH = listeGPH;
	}
}
