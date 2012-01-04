package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import modele.TripletFichier;
import modele.enregistreurs.EnregistreurBIN;
import modele.enregistreurs.EnregistreurGPH;
import modele.enregistreurs.EnregistreurSDF;
import modele.fichiers.FichierBIN;
import modele.fichiers.FichierGPH;
import modele.fichiers.FichierSDF;
import vue.FenetreExportationTripletFichier;
import vue.FenetreImportationTripletFichier;
import vue.FenetrePrincipale;
import vue.barreOutils.BarreOutils;
import vue.editeurs.Editeurs;

public class EcouteurBarreOutils implements ActionListener, FocusListener, ChangeListener
{

	/**
	 * <h4>EcouteurBarreOutils est la classe qui represente l'ecouteur de la
	 * classe BarreOutils</h4>
	 * <p>
	 * Cette classe contient :
	 * <ul>
	 * <li>une instance de classe BarreOutils</li>
	 * <li>une instance de classe de FenetrePrincipale, afin d'avoir acces à
	 * l'ensemble des tableaux.</li>
	 * <li>une instance de classe de FenetreImportationTriplet, fenetre
	 * d'importation d'un projet.</li>
	 * <li>une instance de classe de FenetreExportationTriplet, fenetre
	 * d'exportation d'un projet.</li>
	 * </ul>
	 * </p>
	 * 
	 * @see BarreOutils
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	/**
	 * La barre d'outil graphique, utile pour l'acces aux different attributs de
	 * la classe.
	 * 
	 * @see BarreOutils
	 */
	private BarreOutils							barreOutils;

	/**
	 * La fenetre principale, utile dans l'accès aux informations concernant les
	 * tableaux.
	 * 
	 * @see FenetrePrincipale
	 */
	private FenetrePrincipale					fenetrePrincipale;

	@SuppressWarnings("unused")
	/**
	 * La fenetre d'importation d'un projet, lancee a chaque clic sur le bouton "Importer" de la barre d'outil 
	 * @see FenetreImportationTripletFichier
	 */
	private FenetreImportationTripletFichier	fenetreImportation;

	@SuppressWarnings("unused")
	/**
	 * La fenetre d'exportation d'un projet, lancee a chaque clic sur le bouton "Exporter" de la barre d'outil
	 * @see FenetreExportationTripletFichier
	 */
	private FenetreExportationTripletFichier	fenetreExportation;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	/**
	 * Constructeur de la classe EcouteurBarreOutils.
	 * 
	 * @param fenetrePrincipale
	 *            la fenetre principale du programme.
	 */
	public EcouteurBarreOutils(FenetrePrincipale fenetrePrincipale)
	{
		this(fenetrePrincipale.getBarreOutils());
		this.fenetrePrincipale = fenetrePrincipale;
	}

	/**
	 * Constructeur de la classe EcouteurBarreOutils.
	 * 
	 * @param bo
	 *            la barre d'outil du programme.
	 */
	public EcouteurBarreOutils(BarreOutils bo)
	{
		barreOutils = bo;

		barreOutils.getNouveau().addActionListener(this);
		barreOutils.getImporter().addActionListener(this);
		barreOutils.getExporter().addActionListener(this);
		barreOutils.getRafraichir().addActionListener(this);
		barreOutils.getEnregistrerSousTriplet().addActionListener(this);
		barreOutils.getEnregistrerSous().addActionListener(this);

		barreOutils.getChampRecherche().addActionListener(this);
		barreOutils.getChampRecherche().addFocusListener(this);

		barreOutils.getSliderZoom().addChangeListener(this);
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	/**
	 * Methode Permettant d'enregistrer l'ensemble des tableaux d'un onglet (de
	 * 1 à 3).
	 */
	private void enregistrerSousTriplet()
	{

		int index = fenetrePrincipale.getConteneurGlobal().getEditeur().getSelectedIndex();

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
	 * Methode Permettant d'enregistrer un fichier à la fois (le tableau
	 * encadre).
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
				this.fenetrePrincipale.getConteneurGlobal().buildNavigateur();
				this.fenetrePrincipale.getConteneurGlobal().intiPositionConteneurGlobal();
			}
			else if (fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdGph()
					.getGphFile() != null
					&& fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdGph()
							.getGphFile().isFlank())
			{
				enregistrerGPH(index);
				this.fenetrePrincipale.getConteneurGlobal().buildNavigateur();
				this.fenetrePrincipale.getConteneurGlobal().intiPositionConteneurGlobal();
			}
			else if (fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdSdf()
					.getSdfFile() != null
					&& fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdSdf()
							.getSdfFile().isFlank())
			{
				enregistrerSDF(index);
				this.fenetrePrincipale.getConteneurGlobal().buildNavigateur();
				this.fenetrePrincipale.getConteneurGlobal().intiPositionConteneurGlobal();
			}

			else
			{
				lancerMessageErreur("Aucun tableau n'a été sélectionné");
			}
		}
		catch (IndexOutOfBoundsException arg0)
		{
			lancerMessageErreur("Aucun tableau n'a été selectionné depuis l'espace de travail.");
			// arg0.printStackTrace();

		}
	}

	/**
	 * Methode d'enregistrement du fichier SDF de l'onglet selectionne
	 * 
	 * @param indexOnglet
	 *            l'indice de l'onglet selectionne
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
	 *            l'indice de l'onglet selectionne
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
	 *            l'indice de l'onglet selectionne
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
	 * Methode Permettant de lancer un message d'erreur
	 * 
	 * @param message
	 *            contenu du message d'erreur.
	 */
	private void lancerMessageErreur(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Methode d'appel à la fenetre d'exportation d'un projet.
	 */
	private void exporterProjet()
	{
		try
		{
			String dossier = fenetrePrincipale.getConteneurGlobal().getNavigateur().getTree().getSelectionPath()
					.toString();
			dossier = dossier.substring(3, dossier.length() - 1);
			fenetreExportation = new FenetreExportationTripletFichier(fenetrePrincipale, dossier);
		}
		catch (NullPointerException eo)
		{
			lancerMessageErreur("Veuillez selectionner un projet avant de l'exporter");
		}
	}

	/**
	 * Methode creant un nouveau projet (creation d'un dossier et des 3 fichiers
	 * vierges), puis rafraichissment du Jtree.
	 */
	private void creerNouveauProjet()
	{
		String nomDossier = JOptionPane.showInputDialog(null, "Entrer le nom du dosier", "Nouveau",
				JOptionPane.PLAIN_MESSAGE);
		if (nomDossier != null && !nomDossier.isEmpty())
		{
			TripletFichier tripletVierge = new TripletFichier();
			tripletVierge.creerNouveauProjetVierge(nomDossier);
			this.fenetrePrincipale.getConteneurGlobal().buildNavigateur();
			this.fenetrePrincipale.getConteneurGlobal().intiPositionConteneurGlobal();
		}

	}

	// ----------------------------------------- //
	// ---------------- LISTENERS -------------- //
	// ----------------------------------------- //

	// ------- ACTION ------- //

	@Override
	/**
	 * Methode permettant de capter les evenements de type ActionEvent sur la barre d'outil du programme.
	 * @param e evenement d'un objet graphique provenant de la barre d'outil.
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == barreOutils.getNouveau())
		{
			creerNouveauProjet();
		}
		else if (e.getSource() == barreOutils.getImporter())
		{
			fenetreImportation = new FenetreImportationTripletFichier(fenetrePrincipale);
		}
		else if (e.getSource() == barreOutils.getExporter())
		{
			exporterProjet();
		}
		else if (e.getSource() == barreOutils.getRafraichir())
		{
			this.fenetrePrincipale.getConteneurGlobal().buildNavigateur();
			this.fenetrePrincipale.getConteneurGlobal().intiPositionConteneurGlobal();
		}
		else if (e.getSource() == barreOutils.getEnregistrerSousTriplet())
		{
			enregistrerSousTriplet();
		}
		else if (e.getSource() == barreOutils.getEnregistrerSous())
		{
			enregistrerSousUniteTriplet();
		}
		else if (e.getSource() == barreOutils.getChampRecherche())
		{
			int index = fenetrePrincipale.getConteneurGlobal().getEditeur().getSelectedIndex();
			TableRowSorter<TableModel> sorter = null;
			try{
				Editeurs ed = fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index);
				if (ed.getEdBin().getBinFile() != null && ed.getEdBin().getBinFile().isFlank())
				{
					sorter = new TableRowSorter<TableModel>(ed.getEdBin().getTableauBIN().getModel());
					ed.getEdBin().getTableauBIN().setRowSorter(sorter);
				}
				else if (ed.getEdGph().getGphFile() != null && ed.getEdGph().getGphFile().isFlank())
				{
					sorter = new TableRowSorter<TableModel>(ed.getEdGph().getTableauGPH().getModel());
					ed.getEdGph().getTableauGPH().setRowSorter(sorter);
				}
				else if (ed.getEdSdf().getSdfFile() != null && ed.getEdSdf().getSdfFile().isFlank())
				{
					sorter = new TableRowSorter<TableModel>(ed.getEdSdf().getTableauSDF().getModel());
					ed.getEdSdf().getTableauSDF().setRowSorter(sorter);
				}
			}catch (IndexOutOfBoundsException e1) {
				// TODO: handle exception
			}
			try
			{
				sorter.setRowFilter(RowFilter.regexFilter(barreOutils.getChampRecherche().getText()));
			}
			catch (NullPointerException e1)
			{
				lancerMessageErreur("Veuillez d'abord sélectionner une table !");
			}
		}
	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// --------------- MUTATEURS --------------- //
	// ----------------------------------------- //

	@Override
	public void focusGained(FocusEvent e)
	{
		if (e.getSource() == barreOutils.getChampRecherche())
		{
			barreOutils.getChampRecherche().setText("");
		}

	}

	@Override
	public void focusLost(FocusEvent e)
	{
		if (e.getSource() == barreOutils.getChampRecherche())
		{
			barreOutils.getChampRecherche().setText(barreOutils.CONTENU_RECHERCHE);
		}
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		if (e.getSource() == barreOutils.getSliderZoom())
		{
			int fontSize = barreOutils.getSliderZoom().getValue();
			int index = fenetrePrincipale.getConteneurGlobal().getEditeur().getSelectedIndex();
			Editeurs ed = null;

			try
			{
				ed = fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index);
			}
			catch (IndexOutOfBoundsException ea)
			{
				// TODO: handle exception
			}

			if (ed != null)
			{
				if (ed.getEdBin().getBinFile() != null && ed.getEdBin().getBinFile().isFlank())
				{
					ed.getEdBin().getTableauBIN().getCellRenderer().setFontSize(fontSize);
					ed.getEdBin().getTableauBIN().repaint();
				}
				else if (ed.getEdGph().getGphFile() != null && ed.getEdGph().getGphFile().isFlank())
				{
					ed.getEdGph().getTableauGPH().getCellRenderer().setFontSize(fontSize);
					ed.getEdGph().getTableauGPH().repaint();
				}
				else if (ed.getEdSdf().getSdfFile() != null && ed.getEdSdf().getSdfFile().isFlank())
				{
					ed.getEdSdf().getTableauSDF().getCellRenderer().setFontSize(fontSize);
					ed.getEdSdf().getTableauSDF().repaint();
				}
			}
			
			barreOutils.getInformationZoom().setText(String.valueOf(fontSize));
		}
	}

}
