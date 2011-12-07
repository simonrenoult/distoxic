package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import modele.FiltreZIP;
import vue.FenetreImportationTripletFichier;

public class EcouteurFenetreImportationTripletFichier implements ActionListener {
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private FenetreImportationTripletFichier fenetre = null;
	private JFileChooser jf = null;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	public EcouteurFenetreImportationTripletFichier(FenetreImportationTripletFichier f){
		fenetre = f;
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
			//TODO : IMPORTER DOSSIER DEPUIS LE SYSTEME VERS LE WORKSPACE.
			System.out.println("OK DOSSIER");
			jf = new JFileChooser();
			jf.setCurrentDirectory(new File("."));
			jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int resultat1 = jf.showOpenDialog(fenetre);
			if (resultat1 == JFileChooser.APPROVE_OPTION)
			{
				File fichier;
				fichier = jf.getSelectedFile();
				System.out.println(fichier.getAbsolutePath());
			}
			fenetre.setVisible(false);
		}	
		else if (e.getSource() == fenetre.getArchiveBouton()){
			//TODO : IMPORTER ZIP DEPUIS LE SYSTEME VERS LE WORKSPACE.
			System.out.println("OK IMPORT ZIP");
			jf = new JFileChooser();
			jf.setCurrentDirectory(new File("."));
			jf.addChoosableFileFilter(new FiltreZIP(".zip", "fichier zip"));
			int resultat = jf.showOpenDialog(fenetre);
			if (resultat == JFileChooser.APPROVE_OPTION)
			{
				File fichier;
				fichier = jf.getSelectedFile();
				System.out.println(fichier.getAbsolutePath());
			}
			fenetre.setVisible(false);
		}
		
	}
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	

	
}
