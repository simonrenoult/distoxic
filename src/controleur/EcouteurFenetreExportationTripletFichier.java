package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import javax.swing.JFileChooser;
import modele.WorkspaceModele;
import modele.zip.Zip;
import vue.FenetreExportationTripletFichier;
import vue.FenetrePrincipale;

public class EcouteurFenetreExportationTripletFichier implements ActionListener {
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	@SuppressWarnings("unused")
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
	
	/**
	 * Export d'un projet archive contenu dans le workspace vers un repertoire choisi
	 */
	private void exoprterArchive(){
		String cheminExportation = retournerCheminDestination()+File.separator;
		Zip fichierZip = new Zip(fenetre.getProjectName(), cheminExportation);
		System.out.println("succes zip : "+fichierZip.zipAction());
	}
	
	/**
	 * Export d'un projet contenu dans le workspace vers un repertoire choisi
	 */
	private void exoprterDossier(){
		String cheminExportation = retournerCheminDestination();
		WorkspaceModele modele = new WorkspaceModele(1);
		modele.lireFichier();

		String cheminSource = modele.getWorkspacePath()+File.separator+fenetre.getProjectName();
		String cheminDestination = cheminExportation+File.separator+fenetre.getProjectName();
		
		//System.out.println("chemin source : "+cheminSource);
		//System.out.println("chemin Destination : "+cheminDestination);
		
		File dossier = new File(cheminDestination);
		dossier.mkdir();
		File[] fichiers = new File(cheminSource).listFiles();
		copieFichier(fichiers,dossier.getAbsolutePath());
		
	}
	
	/**
	 * Copie d'un contenu d'un repertoire vers un repertoire donne.
	 * @param fichiers
	 * @param dossier
	 */
	public void copieFichier(File[] fichiers,String dossier){
		FileChannel in = null; // canal d'entrée
		FileChannel out = null; // canal de sortie
		for(int i = 0; i<fichiers.length; i++){
			try {
				  // Init
				  in = new FileInputStream(fichiers[i].getAbsoluteFile()).getChannel();
				  out = new FileOutputStream(dossier+File.separator+fichiers[i].getName()).getChannel();
				  // Copie depuis le in vers le out
				  in.transferTo(0, in.size(), out);
				} catch (Exception e) {
				  e.printStackTrace(); // n'importe quelle exception
				} finally { // finalement on ferme
				  if(in != null) {
				  	try {
					  in.close();
					} catch (IOException e) {}
				  }
				  if(out != null) {
				  	try {
					  out.close();
					} catch (IOException e) {}
				  }
				}
		}
		
	}
	
	/**
	 * retourne le chemin d'enregistrement.
	 * @return
	 */
	public String retournerCheminDestination(){
		File fichier = null;;
		jf = new JFileChooser();
		jf.setCurrentDirectory(new File("."));
		jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int resultat1 = jf.showSaveDialog(fenetre);
		if (resultat1 == JFileChooser.APPROVE_OPTION){
			fichier = jf.getSelectedFile();
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
			exoprterDossier();
		}
		else if(e.getSource() == fenetre.getArchiveBouton()){
			exoprterArchive();
		}
		
		
	}
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	

	
}
