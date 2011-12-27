package modele.fichiersTmp;

import java.io.File;
import java.util.LinkedList;

public class FichierBinTmp
{
	/**
	 * <h4>FichierBinTmp est la classe temporaire servant de stockage de donnees.</h4>
	 * 
	 * <p>
	 * Classe possèdant un copie de la liste des molécules initialement parsée
	 * et se modifie en fonction des moficiations de l'utilisateur sur la jtable
	 * en vue de l'export ultérieur.
	 * </p>
	 * 
	 * <p>
	 * Remarque : le fichier original ne doit pas etre ecrase, on fait donc une copie des donnees pour un enregistrement poss futur dans un fichier.bin_$
	 * </p>
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * Liste ou sont contenus l'ensemble des donnees d'un fichier.bin
	 */
	private LinkedList<LinkedList<Integer>>	listeBINTmp	= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe FichierBinTmp
	 * @param listeBIN la liste original du fichier.bin chargee
	 */
	public FichierBinTmp(LinkedList<LinkedList<Integer>> listeBIN)
	{
		listeBINTmp = listeBIN;
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	
	/**
	 * Methode supprimant des donnees provenant de la suppression de la ligne position du tableau BIN
	 * @param position l'indice du numero de ligne.
	 */
	public void suppressionLigneLigneFichierBinTmp(int position)
	{
		listeBINTmp.remove(position);
	}

	/**
	 * Methode ajoutant simulant l'ajout d'une ligne provenant de l'ajout d'une ligne dans le tableau BIN
	 * @param position l'indice du numero de ligne.
	 */
	public void ajouterLigneLigneFichierBinTmp(int position, int num)
	{
		LinkedList<Integer> element = new LinkedList<Integer>();
		element.add(-1);
		element.add(-2);
		listeBINTmp.add(position, element);
	}

	/**
	 * Methode de modification d'une valeur de la liste provenant de la modification d'une cellule dans le tableau BIN
	 * @param positionLigne l'indice de la ligne
	 * @param positionColonne l'indice de la colonne
	 * @param valeur la valeur a modifier
	 */
	public void mofifierValeurClasse(int positionLigne, int positionColonne, int valeur)
	{
		if (positionColonne == 1)
		{
			listeBINTmp.get(positionLigne).set(0, valeur);
		}
		else
		{
			// traitement sur les fragments incorpore a une molecule.
		}

	}

	
	public void ajoutFragment(int positionLigne, int valeurFragment)
	{
		int i = 0;
		while (i < listeBINTmp.get(positionLigne).size() && listeBINTmp.get(positionLigne).get(i) != valeurFragment)
		{
			i++;
		}
		if (i == listeBINTmp.get(positionLigne).size())
		{
			listeBINTmp.get(positionLigne).addLast(valeurFragment);
		}
	}

	/**
	 * Creation de la chaine a retourner pour le tooltip de chaque ligne du
	 * tableau BIN
	 * 
	 * @param indexMolecule
	 * @return
	 */
	public String afficherListeFragmentAssociee(int indexMolecule)
	{
		String line = "";
		// on echappe 0 car c'est la classe representative de la molecule.
		for (int i = 1 ; i < listeBINTmp.get(indexMolecule).size() ; i++)
		{
			if (i + 1 == listeBINTmp.get(indexMolecule).size())
			{
				line = line + listeBINTmp.get(indexMolecule).get(i).toString();
			}
			else
			{
				line = line + listeBINTmp.get(indexMolecule).get(i).toString() + ",";
			}
		}
		return line;
	}

	/**
	 * Affichage console de la liste
	 */
	public void afficherListeBIN()
	{
		for (LinkedList<Integer> liste : listeBINTmp)
		{
			System.out.println();
			System.out.println("________________________________");
			for (int i = 0 ; i < liste.size() ; i++)
			{
				System.out.print(liste.get(i).toString() + " ");
			}
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
		String tabNomFichier[] = nomFichier.split(".bin");
		
		File dossier = fichierReference.getParentFile();
		String listeDossier[] = dossier.list();
		int cpt = 0;
		for (int i = 0; i< listeDossier.length; i++){
			if (listeDossier[i].endsWith("bin")){
				cpt++;
			}
		}
		nomFichier = tabNomFichier[0]+"_("+cpt+")"+".bin";
		
		return dossier.getPath()+File.separator+nomFichier;
	}
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @return the listeBINTmp
	 */
	public LinkedList<LinkedList<Integer>> getListeBINTmp()
	{
		return listeBINTmp;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @param listeBINTmp
	 *            the listeBINTmp to set
	 */
	public void setListeBINTmp(LinkedList<LinkedList<Integer>> listeBINTmp)
	{
		this.listeBINTmp = listeBINTmp;
	}
}