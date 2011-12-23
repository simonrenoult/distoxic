package controleur.menu;

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
	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private FenetrePrincipale	fenetrePrincipale;

	private BarreMenu			bm;
	private MenuFichier			mf;
	private MenuAPropos			ma;

	private FenetreAPropos		fenetreAPropos;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

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

	private void initListenersMenuFichier()
	{
		mf = (MenuFichier) bm.getMenuFichier();
		mf.getNouveau().addActionListener(this);
		//mf.getOuvrir().addActionListener(this);
		mf.getEnregistrer().addActionListener(this);
		mf.getEnregistrerSous().addActionListener(this);
		mf.getImporter().addActionListener(this);
		mf.getExporter().addActionListener(this);
		mf.getQuitter().addActionListener(this);
	}

	private void initListenersMenuAPropos()
	{
		ma = (MenuAPropos) bm.getMenuAPropos();
		ma.getAide().addActionListener(this);
		ma.getAPropos().addActionListener(this);
	}

	private void lancerMessageErreur(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Permet d'enregistrer l'ensemble des tableaux d'un onglet (de 1 à 3).
	 */
	private void enregistrerSousTriplet() {
		
		int index = fenetrePrincipale.getConteneurGlobal().getEditeur().getSelectedIndex();
		//System.out.println("Onglet : "+index);
		System.out.println("Enregistrement de :");
		try{
			if(fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdBin().getBinFile() != null){
				enregistrerBIN(index);
			}
			
			if(fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdGph().getGphFile() != null){
				enregistrerGPH(index);
			}
			
			if(fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdSdf().getSdfFile() != null){
				enregistrerSDF(index);
			}
			this.fenetrePrincipale.getConteneurGlobal().buildNavigateur();
			this.fenetrePrincipale.getConteneurGlobal().intiPositionConteneurGlobal();
		}
		catch (IndexOutOfBoundsException arg0) {
			lancerMessageErreur("Aucun tableau n'a été selectionné depuis l'espace de travail.");
		}
	}

	/**
	 * Permet d'enregistrer un fichier à la fois (le tableau encadré).
	 */
	private void enregistrerSousUniteTriplet() {
		int index = fenetrePrincipale.getConteneurGlobal().getEditeur().getSelectedIndex();
		try{
			if(fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdBin().getBinFile() != null &&
					fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdBin().getBinFile().isFlank()
						){
				enregistrerBIN(index);
			}
			else if(fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdGph().getGphFile() != null &&
				fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdGph().getGphFile().isFlank())  
					{
				enregistrerGPH(index);
			}
			else if (fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdSdf().getSdfFile() != null &&
					fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdSdf().getSdfFile().isFlank()
					){
				enregistrerSDF(index);
			}
			else{
				lancerMessageErreur("Aucun tableau n'a été sélectionné");
			}
			this.fenetrePrincipale.getConteneurGlobal().buildNavigateur();
			this.fenetrePrincipale.getConteneurGlobal().intiPositionConteneurGlobal();
		}
		catch (IndexOutOfBoundsException arg0) {
			lancerMessageErreur("Aucun tableau n'a été selectionné depuis l'espace de travail.");
			
		}
	}
	
	
	/**
	 * Methode d'enregistrement du fichier SDF de l'onglet selectionne
	 * @param indexOnglet
	 */
	private void enregistrerSDF(int indexOnglet){
		FichierSDF fichierSdf =  fenetrePrincipale.getConteneurGlobal().getEditeur().
				getEditeurs().get(indexOnglet).getEdSdf().getSdfFile();
		String path = fichierSdf.getFichierSdfTmp().creerCheminNouveauFichier(fichierSdf.getFilePath());
		System.out.println(path);
		fichierSdf.setEnregistreurSDF(new EnregistreurSDF(fichierSdf.getFichierSdfTmp().getListeSDF(),path));
		
	}
	
	/**
	 * Methode d'enregistrement du fichier BIN de l'onglet selectionne
	 * @param indexOnglet
	 */
	private void enregistrerBIN(int indexOnglet){
		FichierBIN fichierBin =  fenetrePrincipale.getConteneurGlobal().getEditeur().
				getEditeurs().get(indexOnglet).getEdBin().getBinFile();
		String path = fichierBin.getFichierBinTmp().creerCheminNouveauFichier(fichierBin.getFilePath());
		System.out.println(path);
		fichierBin.setEnregistreurBIN(new EnregistreurBIN(fichierBin.getFichierBinTmp().getListeBINTmp(),path));
	}
	
	/**
	 * Methode d'enregistrement du fichier GPH de l'onglet selectionne
	 * @param indexOnglet
	 */
	private void enregistrerGPH(int indexOnglet){
		FichierGPH fichierGph =  fenetrePrincipale.getConteneurGlobal().getEditeur().
				getEditeurs().get(indexOnglet).getEdGph().getGphFile();
		String path = fichierGph.getFichierGphTmp().creerCheminNouveauFichier(fichierGph.getFilePath());
		System.out.println(path);
		fichierGph.setEnregistreurGPH(new EnregistreurGPH(fichierGph.getFichierGphTmp().getListeGPH(),path));
	}
	
	
	
	/**
	 * Methode D'appel à la fenetre d'exportation d'un projet.
	 */
	@SuppressWarnings("unused")
	private void exporterProjet(){
		try
		{
			String dossier = fenetrePrincipale.getConteneurGlobal().getNavigateur().getTree().getSelectionPath()
					.toString();
			dossier = dossier.substring(3, dossier.length() - 1);
			FenetreExportationTripletFichier fenetreExportation = 
					new FenetreExportationTripletFichier(fenetrePrincipale, dossier);
		}
		catch (NullPointerException eo)
		{
			lancerMessageErreur("Veuillez selectionner un projet avant de l'exporter");
		}
	}
	
	/**
	 * Methode creant la un nouveau projet, puis rafraichissment du Jtree.
	 */
	private void creerNouveauProjet(){
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
