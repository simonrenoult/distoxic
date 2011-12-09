package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import modele.FiltreZIP;
import modele.TripletFichier;
import modele.WorkspaceModele;
import modele.zip.UnZip;
import modele.zip.Zip;
import vue.FenetreExportationTripletFichier;
import vue.FenetreImportationTripletFichier;
import vue.FenetrePrincipale;
import vue.naviguateur.NavigateurFichiers;

public class EcouteurFenetreExportationTripletFichier implements ActionListener {
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private FenetrePrincipale fenetreprincipale;
	private FenetreExportationTripletFichier fenetre = null;
	private JFileChooser jf = null;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	public EcouteurFenetreExportationTripletFichier(FenetreExportationTripletFichier f){
		fenetre = f;
		fenetreprincipale = fenetre.getFenetrePrincipale();
		fenetre.getDossierBouton().addActionListener(this);
		fenetre.getArchiveBouton().addActionListener(this);
		fenetre.getExporterArchive().addActionListener(this);
		fenetre.getExporterDossier().addActionListener(this);
		init();
	}
	
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	private void init() {
		fenetre.getExporterArchive().setSelected(true);
		fenetre.getExporterDossier().setSelected(false);
		fenetre.getDossierBouton().setEnabled(false);
		
	}
	
	public String retournerCheminDestination(){
		File fichier = null;;
		jf = new JFileChooser();
		jf.setCurrentDirectory(new File("."));
		jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int resultat1 = jf.showSaveDialog(fenetre);
		if (resultat1 == JFileChooser.APPROVE_OPTION)
		{
			fichier = jf.getSelectedFile();
			//System.out.println(fichier.getAbsolutePath());
		}
		fenetre.setVisible(false);
		return fichier.getAbsolutePath();
	}
	
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fenetre.getExporterArchive()){
			fenetre.getExporterArchive().setSelected(true);
			fenetre.getExporterDossier().setSelected(false);
			fenetre.getDossierBouton().setEnabled(false);
			fenetre.getArchiveBouton().setEnabled(true);
		}
		else if (e.getSource() == fenetre.getExporterDossier()){
			fenetre.getExporterArchive().setSelected(false);
			fenetre.getExporterDossier().setSelected(true);
			fenetre.getDossierBouton().setEnabled(true);
			fenetre.getArchiveBouton().setEnabled(false);
		} 
		else if(e.getSource() == fenetre.getDossierBouton()){
			String cheminExportation = retournerCheminDestination();
			System.out.println("dossier copier-coller :"+fenetre.getProjectName());
			System.out.println("Destination           :"+cheminExportation);
			
		}
		else if(e.getSource() == fenetre.getArchiveBouton()){
			String cheminExportation = retournerCheminDestination()+File.separator;
			//System.out.println("dossier a zipper :"+fenetre.getProjectName());
			//System.out.println("Destination zip  :"+cheminExportation);
			Zip fichierZip = new Zip(fenetre.getProjectName(), cheminExportation);
			System.out.println("succes zip : "+fichierZip.zipAction());
			
			
		}
		
		
	}
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	

	
}
