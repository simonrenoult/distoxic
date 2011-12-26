package src.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import javax.swing.JFileChooser;

import src.modele.WorkspaceModele;
import src.modele.zip.Zipper;
import src.vue.FenetreExportationTripletFichier;
import src.vue.FenetrePrincipale;

public class EcouteurFenetreExportationTripletFichier implements ActionListener {
	/**
	 * <h4>EcouteurFenetreExportationTripletFichier est la classe qui represente l'ecouteur de la classe ExportationTripletFichier</h4>
	 * <p>
	 * Cette classe contient : 
	 * <ul>
	 * <li>une instance de classe de FenetrePrincipale</li>
	 * <li>une instance de classe de FenetreExportationTriplet, fenetre d'exportation d'un projet.</li>
	 * <li>une instance de classe de JFileChooser, permettant la selection du dossier dans lequel ajouter l'export.</li>
	 * </ul>
	 * </p>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	@SuppressWarnings("unused")
	/**
	 * Fenetre principale du programme.
	 * @see FenetrePrincipale
	 */
	private FenetrePrincipale fenetreprincipale;
	/**
	 * Fenetre d'export d'un projet.
	 * @see FenetreExportationTripletFichier
	 */
	private FenetreExportationTripletFichier fenetre = null;
	/**
	 * Fenetre de selection de l'emplacement pour l'export.
	 * @see JFileChooser
	 */
	private JFileChooser jf = null;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe EcouteurFenetreExportationTripletFichier
	 * @param f fenetre d'export d'un projet.
	 */
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
	/**
	 * Methode d'initialisation de la fenetre d'export. L'export se fait par archive ou dossier. On privilegie l'archive.
	 */
	private void init() {
		fenetre.getExporterArchive().setSelected(true);
		fenetre.getExporterDossier().setSelected(false);
		fenetre.getDossierBouton().setEnabled(false);
		
	}
	
	/**
	 * Methode d'export d'un projet archive contenu dans le workspace vers un repertoire choisi
	 */
	private void exoprterArchive(){
		String cheminExportation = retournerCheminDestination()+File.separator;
		Zipper fichierZip = new Zipper(fenetre.getProjectName(), cheminExportation);
		System.out.println("succes zip : "+fichierZip.zipAction());
	}
	
	/**
	 * Methode d'export d'un projet contenu dans le workspace vers un repertoire choisi
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
	 * Methode de copie d'un contenu d'un repertoire vers un repertoire donne.
	 * @param fichiers les fichiers a copier.
	 * @param dossier le dossier de destination.
	 */
	public void copieFichier(File[] fichiers,String dossier){
		FileChannel in = null; // canal d'entree
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
	 * Methode retournant le chemin d'enregistrement grace a la selection du repertoire de destination.
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
	/**
	 * Methode permettant de capter les evenements de type ActionEvent sur la fenetre d'exportation de projet.
	 * @param e evenement d'un objet graphique provenant de la fenetre d'exportation de projet.
	 */
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
