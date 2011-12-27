/*
 * Panneau contenant les onglets.
 * Ces derniers incluent chacun trois �diteurs associ�s � un type de fichier pr�d�fini :
 *				- SDF ;
 *				- GPH ;
 *				- BIN ;
 */
package vue.editeurs;

import java.awt.Dimension;
import java.io.File;
import java.util.LinkedList;
import javax.swing.JTabbedPane;

import controleur.EcouteurEnteteOnglet;
import modele.TripletFichier;
import vue.ConteneurGlobal;

@SuppressWarnings("serial")
public class ConteneurEditeurs extends JTabbedPane
{
	/**
	 * <h4>ConteneurEditeurs est la classe permettant de decrire le stucture d'onglet (JTabbedPane). </h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //
	/**
	 * Constantes de classe
	 */
	public final static Integer			TAILLE_X	= 4 * ConteneurGlobal.TAILLE_X / 5;
	public final static Integer			TAILLE_Y	= ConteneurGlobal.TAILLE_Y;

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * Liste d'onglet de la strucure
	 * @see Editeurs
	 */
	private LinkedList<Editeurs>		editeurs;
	/**
	 * Liste d'entete d'onglet de la structure
	 * @see EnteteOnglet
	 */
	private LinkedList<EnteteOnglet>	enteteEditeurs;
	/**
	 * Ecouteur d'onglet
	 * @see EcouteurEnteteOnglet
	 */
	private EcouteurEnteteOnglet		emt;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	/**
	 * Constructeur principal de la classe ConteneurEditeurs
	 */
	public ConteneurEditeurs()
	{
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));

		editeurs = new LinkedList<Editeurs>();
		enteteEditeurs = new LinkedList<EnteteOnglet>();
		initListeners();
	}

	// ----------------------------------------- //
	// ----------------LISTENERS---------------- //
	// ----------------------------------------- //
	/**
	 * Ecoute de la strucutre a onglet.
	 */
	private void initListeners()
	{
		emt = new EcouteurEnteteOnglet(this);
	}
	
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	/**
	 * On créé un nouvel onglet. On envoi un triplet un objet de tripletFichier
	 * afin que chaque JPANEL descendant constuise sa JTable. On ajoute l'onglet
	 * créé aux tableaux d'onglet et on ajoute ce dernier onglet au graphique.
	 * 
	 * @param tripletFichier le modele comprenant au maximum trois fichiers : BIN,GPH et SDF
	 */
	public void addEditeur(TripletFichier tripletFichier)
	{
		Editeurs editeur = new Editeurs(tripletFichier);

		editeurs.add(editeur);

		this.add(editeurs.getLast());

		buildPaneHead(tripletFichier, editeurs.size() - 1);
		emt.rafraichir(this);
	}

	/**
	 * Permet de modifier directement un editeur en lui ajoutant le fichier
	 * selectionne.
	 * 
	 * @param tripletFichier le fichier a ajouter dans l'onglet (qui servira pour le tableau graphique associe)
	 * @param indexEditeur le numero de l'onglet selectionne
	 * @return booleen de confirmation d'ajout.
	 */
	public boolean modifierEditeur(TripletFichier tripletFichier, int indexEditeur)
	{
		if (tripletFichier.getBinFile() != null)
		{
			editeurs.get(indexEditeur).ajouterEditeurBin(tripletFichier, indexEditeur);
			return true;
		}
		else if (tripletFichier.getGphFile() != null)
		{
			editeurs.get(indexEditeur).ajouterEditeurGph(tripletFichier, indexEditeur);
			return true;
		}
		else if (tripletFichier.getSdfFile() != null)
		{
			editeurs.get(indexEditeur).ajouterEditeurSdf(tripletFichier, indexEditeur);
			return true;
		}
		return false;
	}

	/**
	 * Permet de creer l'entete de l'onglet.
	 * 
	 * @param tripletFichier pour le nom du dossier qui sera le libelle de l'onglet.
	 * @param indiceOnglet le numero de l'onglet selectionnee
	 */
	private void buildPaneHead(TripletFichier tripletFichier, int indiceOnglet)
	{
		EnteteOnglet eo = new EnteteOnglet(nomEditeur(tripletFichier));
		enteteEditeurs.addLast(eo);
		this.setTabComponentAt(indiceOnglet, eo);
	}

	/**
	 * Creation du nom de l'onglet : nom du dossier contenant les fichiers.
	 * 
	 * @param tripletFichier
	 * @return le nom du dossier du projet.
	 */
	public String nomEditeur(TripletFichier tripletFichier)
	{
		if (System.getProperty("os.name").toLowerCase().contains("linux")
				|| (System.getProperty("os.name").toLowerCase().contains("mac")))
		{
			String tab[] = tripletFichier.getDirectoryPath().split(File.separator);
			String projetcsName = tab[tab.length - 1];
			return projetcsName;
		}
		else if (System.getProperty("os.name").toLowerCase().contains("windows"))
		{
			// Il faut echeper le caractere \ !
			String tab[] = tripletFichier.getDirectoryPath().split(File.separator + File.separator);
			String projetcsName = tab[tab.length - 1];
			return projetcsName;
		}

		return "";

	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	/**
	 * @return the editeurs
	 */
	public LinkedList<Editeurs> getEditeurs()
	{
		return editeurs;
	}

	/**
	 * @param editeurs
	 *            the editeurs to set
	 */
	public void setEditeurs(LinkedList<Editeurs> editeurs)
	{
		this.editeurs = editeurs;
	}

	/**
	 * @return the enteteEditeurs
	 */
	public LinkedList<EnteteOnglet> getEnteteEditeurs()
	{
		return enteteEditeurs;
	}

	/**
	 * @param enteteEditeurs
	 *            the enteteEditeurs to set
	 */
	public void setEnteteEditeurs(LinkedList<EnteteOnglet> enteteEditeurs)
	{
		this.enteteEditeurs = enteteEditeurs;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

}