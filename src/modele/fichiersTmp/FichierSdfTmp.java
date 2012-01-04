package modele.fichiersTmp;

import java.io.File;
import java.util.LinkedList;

import modele.composantsChimiques.Balise;
import modele.composantsChimiques.FragmentMolecule;


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
	private boolean suppressionColonne = false;

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
	 * Methode d'ajout de colonne dans la liste temporaire
	 * @param nomColonne le nom de la colonne
	 */
	public void ajouterColonne(String nomColonne){
		for (FragmentMolecule molecule : listeSDF){
			molecule.getBalises().addLast(new Balise(nomColonne, "N/A"));
		}
	}
	
	/**
	 * Methode de suppression de colonne dans la liste temporaire
	 * @param nomColonne le nom de la colonne
	 */
	public void SupprimerColonne(String nomColonne){
		for (FragmentMolecule molecule : listeSDF){
			molecule.supprimerBalises(nomColonne);
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

	/**
	 * Methode supprimant des donnees provenant de la suppression de la ligne position du tableau SDF
	 * @param position l'indice du numero de ligne.
	 */
	public void suppressionLigneLigneFichierBinTmp(int positionLigne)
	{
		listeSDF.remove(positionLigne);
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

	public void afficherBaliseParMolecule(){
		String line = "";
		int cpt=0;
		for (FragmentMolecule molecule : listeSDF){
			line = "";
			for (int i = 0; i< molecule.getBalises().size(); i++){
				if (i ==0){
					line = line + cpt+" : ";
				}
				line = line + molecule.getBalises().get(i).getIntitule()+",";
			}
			System.out.println(line);
			cpt++;
		}
	}

	/**
	 * @return the suppressionColonne
	 */
	public boolean isSuppressionColonne()
	{
		return suppressionColonne;
	}

	/**
	 * @param suppressionColonne the suppressionColonne to set
	 */
	public void setSuppressionColonne(boolean suppressionColonne)
	{
		this.suppressionColonne = suppressionColonne;
	}	
		
	

}
