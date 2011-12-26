package src.vue;

import java.awt.Dimension;
import javax.swing.JSplitPane;


import src.controleur.EcouteurNavigateur;
import src.vue.barreOutils.BarreOutils;
import src.vue.editeurs.ConteneurEditeurs;
import src.vue.editeurs.EditeurBIN;
import src.vue.editeurs.EditeurGPH;
import src.vue.editeurs.EditeurSDF;
import src.vue.menus.BarreMenu;
import src.vue.naviguateur.NavigateurFichiers;

@SuppressWarnings("serial")
public class ConteneurGlobal extends JSplitPane
{
	/**
	 * <h4>ConteneurGlobal est la classe regroupant tout le graphique sauf la barre de menu.</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //
	
	/**
	 * Largeur du conteneur
	 */
	public final static Integer	TAILLE_X	= FenetrePrincipale.TAILLE_X;
	/**
	 * Hauteur du conteneur
	 */
	public final static Integer	TAILLE_Y	= FenetrePrincipale.TAILLE_Y - BarreMenu.TAILLE_Y - BarreOutils.TAILLE_Y;

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * Contient les trois editeurs (un pour chaque type de fichier : BIN, GPH et SDF)
	 * @see EditeurBIN
	 * @see EditeurGPH
	 * @see EditeurSDF
	 */
	private ConteneurEditeurs	conteneurEditeurs;
	/**
	 * Panneau graphique ou est contenu l'arbre de selection de fichiers
	 * @see NavigateurFichiers
	 */
	private NavigateurFichiers	navigateur;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	/**
	 * Constructeur principal de la classe ConteneurGlobal
	 */
	public ConteneurGlobal()
	{
		intiPositionConteneurGlobal();
		buildConteneurEditeurs();
		buildNavigateur();
	}

	
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	/**
	 * Methode d'initialisation du composant conteneurEditeurs
	 */
	public void intiPositionConteneurGlobal(){
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		this.setDividerLocation(NavigateurFichiers.TAILLE_X);
	}
	
	/**
	 * Methode d'ajout du composant conteneurEditeurs au conteneur principal
	 */
	private void buildConteneurEditeurs()
	{
		conteneurEditeurs = new ConteneurEditeurs();
		this.setRightComponent(conteneurEditeurs);
	}

	@SuppressWarnings("unused")
	/**
	 * Methode d'ajout du composant navigateur au conteneur principal
	 */
	public void buildNavigateur()
	{
		navigateur = new NavigateurFichiers();
		EcouteurNavigateur e = new EcouteurNavigateur(this);
		this.setLeftComponent(navigateur);
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public ConteneurEditeurs getEditeur()
	{
		return conteneurEditeurs;
	}

	public NavigateurFichiers getNavigateur()
	{
		return navigateur;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setEditeur(ConteneurEditeurs editeur)
	{
		this.conteneurEditeurs = editeur;
	}

	public void setNavigateur(NavigateurFichiers navigateur)
	{
		this.navigateur = navigateur;
	}

}
