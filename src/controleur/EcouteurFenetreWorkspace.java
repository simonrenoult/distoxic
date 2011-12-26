package src.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

import src.modele.WorkspaceModele;
import src.vue.FenetreChoixWorkspace;

public class EcouteurFenetreWorkspace implements ActionListener {

	/**
	 * <h4>EcouteurFenetreWorkspace est la classe qui represente l'ecouteur de la classe FenetreWorkspace</h4>
	 * <p>
	 * Cette classe contient : 
	 * <ul>

	 * <li>une instance de classe de FenetreChoixWorkspace</li>
	 * <li>une instance de classe de WorkspaceModele, permattant l'edition de l'emplacement du workspace.</li>
	 * <li>une instance de classe de JFileChooser, permettant la selection du dossier dans lequel vont s'ajouter tous les projets.</li>
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
	 * Fenetre communiquant l'emplacement a choisir pour stocker tous les projets.
	 * @see FenetreChoixWorkspace
	 */
	private FenetreChoixWorkspace fenetre;
	/**
	 * Modele de classe WorkspaceModele. Il permet en autre la consulation et l'edition du fichier de configuration configWorkspace.txt
	 * @see WorkspaceModele
	 */
	private WorkspaceModele modele;
	/**
	 * Dossier de destination pour stocker les projets.
	 * @see File
	 */
	private File fichier = new File("");
	/**
	 * Fenetre de selection de l'emplacement du workspace.
	 * @see JFileChooser
	 */
	private JFileChooser jf = null;
	/**
	 * Si le fichier de configuration n'est pas viable pour l'utilisateur, il faut d'abord configurer le workspace avant de lancer la fenetre principale du programme.
	 */
	private boolean LancerFenetrePrincipale = false;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe EcouteurFenetreWorkspace
	 * @param f la fenetre de selection du workspace
	 * @param modele le modele associe a la selection du workspace
	 */
	public EcouteurFenetreWorkspace(FenetreChoixWorkspace f, WorkspaceModele modele) {
		this.fenetre = f;
		this.modele = modele;
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
	/**
	 * Methode permettant de capter les evenements de type ActionEvent sur la fenetre de choix du workspace.
	 * @param e evenement d'un objet graphique provenant de la fenetre de choix du workspace.
	 */
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
			modele.makeWorkspace(fichier.getAbsolutePath());
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
