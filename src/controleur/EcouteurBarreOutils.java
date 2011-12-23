package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

import modele.TripletFichier;
import modele.WorkspaceModele;
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

public class EcouteurBarreOutils implements ActionListener
{
	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private BarreOutils							panel;
	private FenetrePrincipale					fenetrePrincipale;
	@SuppressWarnings("unused")
	private FenetreImportationTripletFichier	fenetreImportation;
	@SuppressWarnings("unused")
	private FenetreExportationTripletFichier	fenetreExportation;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	public EcouteurBarreOutils(FenetrePrincipale fenetrePrincipale)
	{
		this(fenetrePrincipale.getBarreOutils());
		this.fenetrePrincipale = fenetrePrincipale;
	}

	public EcouteurBarreOutils(BarreOutils bo)
	{
		panel = bo;
		panel.getNouveau().addActionListener(this);
		panel.getImporter().addActionListener(this);
		panel.getExporter().addActionListener(this);
		panel.getRafraichir().addActionListener(this);
		panel.getEnregistrerSousTriplet().addActionListener(this);
		panel.getEnregistrerSous().addActionListener(this);
		//panel.getImprimer().addActionListener(this);
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	/**
	 * Permet d'enregistrer l'ensemble des tableaux d'un onglet (de 1 à 3).
	 */
	private void enregistrerSousTriplet() {
		
		int index = fenetrePrincipale.getConteneurGlobal().getEditeur().getSelectedIndex();
		
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
				//enregistrerSDF(index);
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
				//enregistrerSDF(index);
			this.fenetrePrincipale.getConteneurGlobal().buildNavigateur();
			this.fenetrePrincipale.getConteneurGlobal().intiPositionConteneurGlobal();
		}
			
			else{
				lancerMessageErreur("Aucun tableau n'a été sélectionné");
			}
		}
		catch (IndexOutOfBoundsException arg0) {
			lancerMessageErreur("Aucun tableau n'a été selectionné depuis l'espace de travail.");
			arg0.printStackTrace();
			
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
		fichierSdf.setEnregistreurSDF(new EnregistreurSDF(fichierSdf.getFichierSdfTmp().getFragmentsMolecules(),path));
		
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
	 * Permet de lancer un message d'erreur
	 * @param message : contenu du message d'erreur.
	 */
	private void lancerMessageErreur(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Methode D'appel à la fenetre d'exportation d'un projet.
	 */
	private void exporterProjet(){
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
	// ---------------- LISTENERS -------------- //
	// ----------------------------------------- //

	// ------- ACTION ------- //

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == panel.getNouveau())
		{
			creerNouveauProjet();
		}
		else if (e.getSource() == panel.getImporter())
		{
			fenetreImportation = new FenetreImportationTripletFichier(fenetrePrincipale);
		}
		else if (e.getSource() == panel.getExporter())
		{
			exporterProjet();
		}
		else if (e.getSource() == panel.getRafraichir())
		{
			this.fenetrePrincipale.getConteneurGlobal().buildNavigateur();
			this.fenetrePrincipale.getConteneurGlobal().intiPositionConteneurGlobal();
		}
		else if (e.getSource() == panel.getEnregistrerSousTriplet())
		{
			enregistrerSousTriplet();
		}
		else if (e.getSource() == panel.getEnregistrerSous())
		{
			enregistrerSousUniteTriplet();
		}
	}
	
	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// --------------- MUTATEURS --------------- //
	// ----------------------------------------- //

}
