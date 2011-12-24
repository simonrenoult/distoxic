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
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer			TAILLE_X	= 4 * ConteneurGlobal.TAILLE_X / 5;
	public final static Integer			TAILLE_Y	= ConteneurGlobal.TAILLE_Y;

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private LinkedList<Editeurs>		editeurs;
	private LinkedList<EnteteOnglet>	enteteEditeurs;
	private EcouteurEnteteOnglet		emt;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

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
	 * @param tripletFichier
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
	 * @param tripletFichier
	 * @param indexEditeur
	 * @return
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
	 * @param tripletFichier
	 * @param indiceOnglet
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
	 * @param path
	 * @return
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