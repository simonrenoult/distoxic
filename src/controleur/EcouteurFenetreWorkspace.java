package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import vue.FenetreChoixWorkspace;

public class EcouteurFenetreWorkspace implements ActionListener {

	
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private FenetreChoixWorkspace fenetre;
	private File fichier = new File("");
	private JFileChooser jf = null;
	private boolean LancerFenetrePrincipale = false;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	public EcouteurFenetreWorkspace(FenetreChoixWorkspace f) {
		this.fenetre = f;
		f.getSelection().addActionListener(this);
		f.getValider().addActionListener(this);
		f.getAnnuler().addActionListener(this);
	}
	
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	
	
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fenetre.getSelection()){
			jf = new JFileChooser();
			jf.setCurrentDirectory(new File("."));
			jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int resultat1 = jf.showOpenDialog(fenetre);
			if (resultat1 == JFileChooser.APPROVE_OPTION){
				fichier = jf.getSelectedFile();
				fenetre.getPathWorkspaceTextField().setText(fichier.getAbsolutePath());
			}
		}
		else if (e.getSource() == fenetre.getValider()){
			LancerFenetrePrincipale = true;
			fenetre.setVisible(false);
		}
		else if (e.getSource() == fenetre.getAnnuler()){
			System.exit(0);
		}
		
		
	} 
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //



	/**
	 * @return the lancerFenetrePrincipale
	 */
	public boolean isLancerFenetrePrincipale() {
		return LancerFenetrePrincipale;
	}



	/**
	 * @param lancerFenetrePrincipale the lancerFenetrePrincipale to set
	 */
	public void setLancerFenetrePrincipale(boolean lancerFenetrePrincipale) {
		LancerFenetrePrincipale = lancerFenetrePrincipale;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
