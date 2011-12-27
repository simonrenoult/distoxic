package modele.fichiersTmp;

import java.io.File;
import java.util.LinkedList;

import modele.composantsChimiques.FragmentMolecule;


public class FichierGphTmp
{
	/**
	 * <h4>FichierGphTmp est la classe temporaire servant de stockage de donnees.</h4>
	 * 
	 * <p>
	 * Classe possèdant un copie de la liste des molécules initialement parsée
	 * et se modifie en fonction des moficiations de l'utilisateur sur la jtable
	 * en vue de l'export ultérieur.
	 * </p>
	 * <p>
	 * Remarque : le fichier original ne doit pas etre ecrase, on fait donc une copie des donnees pour un enregistrement poss futur dans un fichier.gph_$
	 * </p>
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * Liste ou sont contenus l'ensemble des donnees d'un fichier.gph
	 */
	private LinkedList<FragmentMolecule>	listeGPH	= null;


// ----------------------------------------- //
// --------------CONSTRUCTEURS-------------- //
// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe FichierGphTmp
	 * @param listeGPH la liste original du fichier.gph chargee
	 */
	public FichierGphTmp(LinkedList<FragmentMolecule> listeGPH) {
		this.listeGPH = listeGPH;
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	/**
	 * Methode supprimant des donnees provenant de la suppression de la ligne position du tableau GPH
	 * @param position l'indice du numero de ligne.
	 */
	public void suppressionLigneLigneFichierBinTmp(int position)
	{
		listeGPH.remove(position);
	}

	/**
	 * Methode ajoutant simulant l'ajout d'une ligne provenant de l'ajout d'une ligne dans le tableau GPH
	 * @param position l'indice du numero de ligne.
	 */
	public void AjouterLigneLigneFichierBinTmp(int position, int numéro)
	{

	}
	
	/**
	 * Methode de modification d'une valeur de la liste provenant de la modification d'une cellule dans le tableau GPH
	 * @param positionLigne l'indice de la ligne
	 * @param positionColonne l'indice de la colonne
	 * @param valeur la valeur a modifier
	 */
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
	
	/**
	 * Methode de creation du chemin absolu du fichier de sauvegarde. 
	 * @param path le chemin absolu du fichier original
	 * @return le chemin absolu du fichier de sauvegarde.
	 */
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
		}
		nomFichier = tabNomFichier[0]+"_("+cpt+")"+".gph";
		
		return dossier.getPath()+File.separator+nomFichier;
	}

	/**
	 * Affichage console de la liste
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
