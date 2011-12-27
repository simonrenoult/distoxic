package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import modele.TripletFichier;
import modele.enregistreurs.EnregistreurBIN;
import modele.enregistreurs.EnregistreurGPH;
import modele.enregistreurs.EnregistreurSDF;
import modele.fichiers.FichierBIN;
import modele.fichiers.FichierGPH;
import modele.fichiers.FichierSDF;
import vue.FenetreAPropos;
import vue.FenetreExportationTripletFichier;
import vue.FenetreImportationTripletFichier;
import vue.FenetrePrincipale;
import vue.menus.BarreMenu;
import vue.menus.MenuAPropos;
import vue.menus.MenuFichier;

public class EcouteurBarreMenu implements ActionListener
{
	/**
	 * <h4>EcouteurBarreMenu est la classe qui represente l'ecouteur de la classe BarreMenu</h4>
	 * <p>
	 * Cette classe contient : 
	 * <ul>
	 * <li>Une instance de classe FenetrePrincipale, representant la fenetre principale du programme.</li>
	 * <li>Une instance de classe de BarreMenu, afin d'avoir acces à l'ensemble des informations du menu graphique</li>
	 * <li>Une instance de classe de MenuFichier, referant au menu Fichier</li>
	 * <li>Une instance de classe de MenuAPropos, referant au menu A propos</li>
	 * <li>Une instance de classe de FenetreAPropos, fenetre communiquant les informations du logicle a l'utilisateur.</li>
	 * </ul>
	 * </p>
	 * 
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	/**
	 * Fenetre princiaple du programme
	 * @see FenetrePrincipale
	 */
	private FenetrePrincipale	fenetrePrincipale;
	/**
	 * Barre de menu du programme
	 * @see BarreMenu
	 */
	private BarreMenu			bm;
	/**
	 * Menu Fichier de la barre de menu
	 * @see MenuFichier
	 */
	private MenuFichier			mf;
	/**
	 * Menu A propos de la barre de menu
	 * @see MenuAPropos
	 */
	private MenuAPropos			ma;
	/**
	 * Fenetre dinformation du logiciel.
	 * @see FenetreAPropos
	 */
	private FenetreAPropos		fenetreAPropos;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	/**
	 * Constructeur principal de la classe EcouteurBarreMenu
	 * @param fenetrePrincipale fenetre principale du programme.
	 */
	public EcouteurBarreMenu(FenetrePrincipale fenetrePrincipale)
	{
		this.fenetrePrincipale = fenetrePrincipale;
		this.bm = fenetrePrincipale.getMenu();

		initListenersMenuFichier();
		initListenersMenuAPropos();
	}

	// ----------------------------------------- //
	// ------------ INITIALISEURS -------------- //
	// ----------------------------------------- //

	/**
	 * Methode d'ajout a l'ecoute des items de menu pour le menu Fichier.
	 */
	private void initListenersMenuFichier()
	{
		mf = (MenuFichier) bm.getMenuFichier();
		mf.getNouveau().addActionListener(this);
		// mf.getOuvrir().addActionListener(this);
		mf.getEnregistrer().addActionListener(this);
		mf.getEnregistrerSous().addActionListener(this);
		mf.getImporter().addActionListener(this);
		mf.getExporter().addActionListener(this);
		mf.getQuitter().addActionListener(this);
	}

	/**
	 * Methode d'ajout a l'ecoute des items de menu pour le menu Fichier.
	 */
	private void initListenersMenuAPropos()
	{
		ma = (MenuAPropos) bm.getMenuAPropos();
		ma.getAide().addActionListener(this);
		ma.getAPropos().addActionListener(this);
	}

	/**
	 * Methode lancant une boite de dialogue de type ERROR
	 * @param message message a faire communiquer.
	 */
	private void lancerMessageErreur(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Methode permettant d'enregistrer l'ensemble des tableaux d'un onglet (de 1 à 3).
	 */
	private void enregistrerSousTriplet()
	{

		int index = fenetrePrincipale.getConteneurGlobal().getEditeur().getSelectedIndex();
		// System.out.println("Onglet : "+index);
		System.out.println("Enregistrement de :");
		try
		{
			if (fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdBin().getBinFile() != null)
			{
				enregistrerBIN(index);
			}

			if (fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdGph().getGphFile() != null)
			{
				enregistrerGPH(index);
			}

			if (fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdSdf().getSdfFile() != null)
			{
				enregistrerSDF(index);
			}
			this.fenetrePrincipale.getConteneurGlobal().buildNavigateur();
			this.fenetrePrincipale.getConteneurGlobal().intiPositionConteneurGlobal();
		}
		catch (IndexOutOfBoundsException arg0)
		{
			lancerMessageErreur("Aucun tableau n'a été selectionné depuis l'espace de travail.");
		}
	}

	/**
	 * Methode permettant d'enregistrer un fichier à la fois (le tableau encadré).
	 */
	private void enregistrerSousUniteTriplet()
	{
		int index = fenetrePrincipale.getConteneurGlobal().getEditeur().getSelectedIndex();
		try
		{
			if (fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdBin().getBinFile() != null
					&& fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdBin()
							.getBinFile().isFlank())
			{
				enregistrerBIN(index);
			}
			else if (fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdGph()
					.getGphFile() != null
					&& fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdGph()
							.getGphFile().isFlank())
			{
				enregistrerGPH(index);
			}
			else if (fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdSdf()
					.getSdfFile() != null
					&& fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdSdf()
							.getSdfFile().isFlank())
			{
				enregistrerSDF(index);
			}
			else
			{
				lancerMessageErreur("Aucun tableau n'a été sélectionné");
			}
			this.fenetrePrincipale.getConteneurGlobal().buildNavigateur();
			this.fenetrePrincipale.getConteneurGlobal().intiPositionConteneurGlobal();
		}
		catch (IndexOutOfBoundsException arg0)
		{
			lancerMessageErreur("Aucun tableau n'a été selectionné depuis l'espace de travail.");

		}
	}

	/**
	 * Methode d'enregistrement du fichier SDF de l'onglet selectionne
	 * 
	 * @param indexOnglet
	 */
	private void enregistrerSDF(int indexOnglet)
	{
		FichierSDF fichierSdf = fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(indexOnglet)
				.getEdSdf().getSdfFile();
		String path = fichierSdf.getFichierSdfTmp().creerCheminNouveauFichier(fichierSdf.getFilePath());
		System.out.println(path);
		fichierSdf.setEnregistreurSDF(new EnregistreurSDF(fichierSdf.getFichierSdfTmp().getListeSDF(), path));

	}

	/**
	 * Methode d'enregistrement du fichier BIN de l'onglet selectionne
	 * 
	 * @param indexOnglet
	 */
	private void enregistrerBIN(int indexOnglet)
	{
		FichierBIN fichierBin = fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(indexOnglet)
				.getEdBin().getBinFile();
		String path = fichierBin.getFichierBinTmp().creerCheminNouveauFichier(fichierBin.getFilePath());
		System.out.println(path);
		fichierBin.setEnregistreurBIN(new EnregistreurBIN(fichierBin.getFichierBinTmp().getListeBINTmp(), path));
	}

	/**
	 * Methode d'enregistrement du fichier GPH de l'onglet selectionne
	 * 
	 * @param indexOnglet
	 */
	private void enregistrerGPH(int indexOnglet)
	{
		FichierGPH fichierGph = fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(indexOnglet)
				.getEdGph().getGphFile();
		String path = fichierGph.getFichierGphTmp().creerCheminNouveauFichier(fichierGph.getFilePath());
		System.out.println(path);
		fichierGph.setEnregistreurGPH(new EnregistreurGPH(fichierGph.getFichierGphTmp().getListeGPH(), path));
	}

	/**
	 * Methode d'appel à la fenetre d'exportation d'un projet.
	 */
	@SuppressWarnings("unused")
	private void exporterProjet()
	{
		try
		{
			String dossier = fenetrePrincipale.getConteneurGlobal().getNavigateur().getTree().getSelectionPath()
					.toString();
			dossier = dossier.substring(3, dossier.length() - 1);
			FenetreExportationTripletFichier fenetreExportation = new FenetreExportationTripletFichier(
					fenetrePrincipale, dossier);
		}
		catch (NullPointerException eo)
		{
			lancerMessageErreur("Veuillez selectionner un projet avant de l'exporter");
		}
	}

	/**
	 * Methode creant la un nouveau projet, puis rafraichissment de l'arbre grpahique.
	 */
	private void creerNouveauProjet()
	{
		String nomDossier = JOptionPane.showInputDialog("Nom du dossier à créer :");
		TripletFichier tripletVierge = new TripletFichier();
		tripletVierge.creerNouveauProjetVierge(nomDossier);
		this.fenetrePrincipale.getConteneurGlobal().buildNavigateur();
		this.fenetrePrincipale.getConteneurGlobal().intiPositionConteneurGlobal();
	}

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //

	@Override
	/**
	 * Methode permettant de capter les evenements de type ActionEvent sur un item du menu du programme.
	 * @param e evenement (clic) un item du menu du programme.
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == mf.getNouveau())
		{
			creerNouveauProjet();
		}

		else if (e.getSource() == mf.getEnregistrer())
		{
			enregistrerSousUniteTriplet();
		}
		else if (e.getSource() == mf.getEnregistrerSous())
		{
			enregistrerSousTriplet();
		}
		else if (e.getSource() == mf.getImporter())
		{
			@SuppressWarnings("unused")
			FenetreImportationTripletFichier fenetreImportation = new FenetreImportationTripletFichier(
					fenetrePrincipale);
		}
		else if (e.getSource() == mf.getExporter())
		{
			exporterProjet();
		}
		else if (e.getSource() == mf.getQuitter())
		{
			System.exit(0);
		}
		else if (e.getSource() == ma.getAPropos())
		{
			setFenetreAPropos(new FenetreAPropos(fenetrePrincipale));
			fenetrePrincipale.setEnabled(false);
		}
	}

	public FenetreAPropos getFenetreAPropos()
	{
		return fenetreAPropos;
	}

	public void setFenetreAPropos(FenetreAPropos fenetreAPropos)
	{
		this.fenetreAPropos = fenetreAPropos;
	}

}
