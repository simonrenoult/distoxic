package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import modele.FiltreZIP;
import modele.WorkspaceModele;
import modele.zip.UnZip;
import vue.FenetreImportationTripletFichier;
import vue.FenetrePrincipale;
import vue.naviguateur.NavigateurFichiers;

public class EcouteurFenetreImportationTripletFichier implements ActionListener {
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private FenetrePrincipale fenetreprincipale;
	private FenetreImportationTripletFichier fenetre = null;
	private JFileChooser jf = null;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
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
	private void init() {
		fenetre.getImpoterArchive().setSelected(true);
		fenetre.getImpoterDossier().setSelected(false);
		fenetre.getDossierBouton().setEnabled(false);
		
	}
	
	/**
	 * Methode d'import d'une archive choisi vers le workspace
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
			UnZip fichierZip = new UnZip(fichier.getAbsolutePath(),conf.getWorkspacePath());
			System.out.println("succes unzip :"+fichierZip.zipAction());
			fenetreprincipale.getConteneurGlobal().buildNavigateur();
			fenetre.repaint();
		}
		fenetre.setVisible(false);
	}
	
	/**
	 * Methode d'import d'un repertoire choisi vers le workspace
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
			fenetre.repaint();
		}
		fenetre.setVisible(false);
	}
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	@Override
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
