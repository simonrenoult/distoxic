package src.modele.fichiersTmp;

import java.io.File;
import java.util.LinkedList;

import src.modele.composantsChimiques.Balise;
import src.modele.composantsChimiques.FragmentMolecule;


public class FichierSdfTmp
{

	/**
	 * <h4>FichierSdfTmp est la classe temporaire servant de stockage de donnees.</h4>
	 * <p>
	 * Classe possèdant un copie de la liste des molécules initialement parsée
	 * et se modifie en fonction des moficiations de l'utilisateur sur la jtable
	 * en vue de l'export ultérieur.
	 * </p>
	 * 
	 * <p>
	 * Remarque : le fichier original ne doit pas etre ecrase, on fait donc une copie des donnees pour un enregistrement poss futur dans un fichier.sdf_$
	 * </p>
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //
	/**
	 * Liste ou sont contenus l'ensemble des donnees d'un fichier.sdf
	 */
	private LinkedList<FragmentMolecule>	listeSDF;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe FichierSdfTmp
	 * @param listeSDF la liste original du fichier.sdf chargee
	 */
	public FichierSdfTmp(LinkedList<FragmentMolecule> listeSDF)
	{
		this.listeSDF = listeSDF;
	}

	/**
	 * Constructeur par defaut de la classe FichierSdfTmp
	 */
	public FichierSdfTmp()
	{
		this(new LinkedList<FragmentMolecule>());
	}

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //
	/**
	 * Methode de modification d'une valeur de la liste provenant de la modification d'une cellule dans le tableau GPH
	 * @param positionLigne l'indice de la ligne
	 * @param intituleColonne l'indice de la colonne
	 * @param contenuCellule la valeur a modifier
	 */
	public void modifierValeurClasse(Integer positionLigne, String intituleColonne, String contenuCellule)
	{
		if(listeSDF.get(positionLigne).getBalise(intituleColonne) != null)
			listeSDF.get(positionLigne).getBalise(intituleColonne).setValeur(contenuCellule);
		else
			listeSDF.get(positionLigne).getBalises().add(new Balise(intituleColonne, contenuCellule));
		
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
		String tabNomFichier[] = nomFichier.split(".sdf");
		
		File dossier = fichierReference.getParentFile();
		String listeDossier[] = dossier.list();
		int cpt = 0;
		for (int i = 0; i< listeDossier.length; i++){
			if (listeDossier[i].endsWith("sdf")){
				cpt++;
			}
		}
		
		
		nomFichier = tabNomFichier[0]+"_("+cpt+")"+".sdf";
		
		return dossier.getPath()+File.separator+nomFichier;
	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// -------------- MUTATEURS --------------- //
	// ----------------------------------------- //
	/**
	 * @return the fragmentsMolecules
	 */
	public LinkedList<FragmentMolecule> getListeSDF() {
		return listeSDF;
	}

	/**
	 * @param fragmentsMolecules the fragmentsMolecules to set
	 */
	public void setListeSDF(
			LinkedList<FragmentMolecule> listeSDF) {
		this.listeSDF = listeSDF;
	}

}
