package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import modele.TripletFichier;
import modele.WorkspaceModele;
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
		//System.out.println("Onglet : "+index);
		System.out.println("Enregistrement de :");
		try{
			if(fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdBin().getBinFile() != null){
				System.out.println("Enregistrement BIN de l'onglet "+index);
				System.out.println("Adresse mère du fichier :"+fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().
										get(index).getEdBin().getBinFile().getFilePath());
			}
			
			if(fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdGph().getGphFile() != null){
				System.out.println("Enregistrement GPH de l'onglet "+index);
				System.out.println("Adresse mère du fichier :"+fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().
						get(index).getEdGph().getGphFile().getFilePath());
			}
			
			if(fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdSdf().getSdfFile() != null){
				System.out.println("Enregistrement SDF de l'onglet "+index);
				System.out.println("Adresse mère du fichier :"+fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().
						get(index).getEdSdf().getSdfFile().getFilePath());
			}
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
				System.out.println("Enregistrement BIN de l'onglet "+index);
			}
			else if(fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdGph().getGphFile() != null &&
				fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdGph().getGphFile().isFlank())  
					{
				System.out.println("Enregistrement GPH de l'onglet "+index);
			}
			else if (fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdSdf().getSdfFile() != null &&
					fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdSdf().getSdfFile().isFlank()
					){
				System.out.println("Enregistrement SDF de l'onglet "+index);
			}
			else{
				lancerMessageErreur("Aucun tableau n'a été sélectionné");
			}
		}
		catch (IndexOutOfBoundsException arg0) {
			lancerMessageErreur("Aucun tableau n'a été selectionné depuis l'espace de travail.");
			
		}
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
