package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
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

	/**
	 * Permet d'enregistrer un fichier à la fois (le tableau encadré).
	 */
	private void enregistrerSousUniteTriplet() {
		int index = fenetrePrincipale.getConteneurGlobal().getEditeur().getSelectedIndex();
		//System.out.println("Onglet : "+index);
		
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
			System.out.println("Aucun tableau n'a été sélectionné");
		}
	}
	
	/**
	 * Permet de lancer un message d'erreur
	 * @param message : contenu du message d'erreur.
	 */
	private void LancerMessageErreur(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
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

		}
		else if (e.getSource() == panel.getImporter())
		{
			fenetreImportation = new FenetreImportationTripletFichier(fenetrePrincipale);
		}
		else if (e.getSource() == panel.getExporter())
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
				LancerMessageErreur("Veuillez selectionner un projet avant de l'exporter");
			}
		}
		else if (e.getSource() == panel.getRafraichir())
		{
			this.fenetrePrincipale.getConteneurGlobal().buildNavigateur();
			this.fenetrePrincipale.getConteneurGlobal().intiPositionConteneurGlobal();
		}
		else if (e.getSource() == panel.getEnregistrerSousTriplet())
		{
			try{
				enregistrerSousTriplet();
			}
			catch (IndexOutOfBoundsException arg0) {
				LancerMessageErreur("Aucun tableau n'a été selectionné depuis l'espace de travail.");
				
			}
			
		}
		else if (e.getSource() == panel.getEnregistrerSous())
		{
			try{
				enregistrerSousUniteTriplet();
			}
			catch (IndexOutOfBoundsException arg0) {
				LancerMessageErreur("Aucun tableau n'a été selectionné depuis l'espace de travail.");
			}
		}
		

	}
	
	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// --------------- MUTATEURS --------------- //
	// ----------------------------------------- //

}
