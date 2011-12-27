package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

import modele.FiltreZIP;
import modele.WorkspaceModele;
import modele.zip.Dezipper;
import vue.FenetreImportationTripletFichier;
import vue.FenetrePrincipale;

public class EcouteurFenetreImportationTripletFichier implements ActionListener {
	/**
	 * <h4>EcouteurFenetreImportationTripletFichier est la classe qui represente l'ecouteur de la classe ImportationTripletFichier</h4>
	 * <p>
	 * Cette classe contient : 
	 * <ul>
	 * <li>une instance de classe de FenetrePrincipale</li>
	 * <li>une instance de classe de ImportationTripletFichier, fenetre d'importation d'un projet.</li>
	 * <li>une instance de classe de JFileChooser, permettant la selection d'une archive/ dossier vers le l'espace de travail (workspace)</li>
	 * </ul>
	 * </p>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * Fenetre principale du programme.
	 * @see FenetrePrincipale
	 */
	private FenetrePrincipale fenetreprincipale;
	/**
	 * Fenetre d'import d'un projet.
	 * @see FenetreImportationTripletFichier
	 */
	private FenetreImportationTripletFichier fenetre = null;
	/**
	 * Fenetre de selection de l'emplacement pour l'export.
	 * @see JFileChooser
	 */
	private JFileChooser jf = null;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe EcouteurFenetreImportationTripletFichier
	 * @param f fenetre d'import d'un projet.
	 */
	public EcouteurFenetreImportationTripletFichier(FenetreImportationTripletFichier f){
		fenetre = f;
		fenetreprincipale = fenetre.getFenetrePrincipale();
		fenetre.getDossierBouton().addActionListener(this);
		fenetre.getArchiveBouton().addActionListener(this);
		fenetre.getImpoterArchive().addActionListener(this);
		fenetre.getImpoterDossier().addActionListener(this);
		init();
	}
	
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	/**
	 * Methode d'initialisation de la fenetre d'import. L'import se fait par archive ou dossier. On privilegie l'archive.
	 */
	private void init() {
		fenetre.getImpoterArchive().setSelected(true);
		fenetre.getImpoterDossier().setSelected(false);
		fenetre.getDossierBouton().setEnabled(false);
	}
	
	/**
	 * Methode d'import d'une archive choisi vers le workspace. Un filtre .zip a ete mis en place.
	 */
	private void importerArchiveWorkspace(){
		jf = new JFileChooser();
		jf.setCurrentDirectory(new File("."));
		jf.addChoosableFileFilter(new FiltreZIP(".zip", "fichier zip"));
		int resultat = jf.showOpenDialog(fenetre);
		if (resultat == JFileChooser.APPROVE_OPTION){
			File fichier;
			fichier = jf.getSelectedFile();
			WorkspaceModele conf = new WorkspaceModele(1);
			conf.lireFichier();
			Dezipper fichierZip = new Dezipper(fichier.getAbsolutePath(),conf.getWorkspacePath());
			System.out.println("succes unzip :"+fichierZip.zipAction());
			fenetreprincipale.getConteneurGlobal().buildNavigateur();
			fenetreprincipale.getConteneurGlobal().intiPositionConteneurGlobal();
			fenetre.repaint();
		}
		fenetre.setVisible(false);
	}
	
	/**
	 * Methode d'import d'un repertoire choisi vers le workspace.
	 */
	private void importerDossierWorkspace(){
		jf = new JFileChooser();
		jf.setCurrentDirectory(new File("."));
		jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int resultat1 = jf.showOpenDialog(fenetre);
		if (resultat1 == JFileChooser.APPROVE_OPTION){
			WorkspaceModele conf = new WorkspaceModele(1);
			conf.lireFichier();
			File fichier;
			fichier = jf.getSelectedFile();
			File f = new File(conf.getWorkspacePath()+File.separator+fichier.getName());
			fichier.renameTo(f);
			fenetreprincipale.getConteneurGlobal().buildNavigateur();
			fenetreprincipale.getConteneurGlobal().intiPositionConteneurGlobal();
			fenetre.repaint();
		}
		fenetre.setVisible(false);
	}
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	@Override
	/**
	 * Methode permettant de capter les evenements de type ActionEvent sur la fenetre d'importation de projet.
	 * @param e evenement d'un objet graphique provenant de la fenetre d'importation de projet.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fenetre.getImpoterArchive()){
			fenetre.getImpoterArchive().setSelected(true);
			fenetre.getImpoterDossier().setSelected(false);
			fenetre.getDossierBouton().setEnabled(false);
			fenetre.getArchiveBouton().setEnabled(true);
		}
		else if (e.getSource() == fenetre.getImpoterDossier()){
			fenetre.getImpoterArchive().setSelected(false);
			fenetre.getImpoterDossier().setSelected(true);
			fenetre.getDossierBouton().setEnabled(true);
			fenetre.getArchiveBouton().setEnabled(false);
		} 
		else if(e.getSource() == fenetre.getDossierBouton()) {
			importerDossierWorkspace();
		}
		else if (e.getSource() == fenetre.getArchiveBouton()){
			importerArchiveWorkspace();
		}
		
	}
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	

	
}
