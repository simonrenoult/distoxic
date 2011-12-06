package vue;

import java.awt.Dimension;
import javax.swing.JSplitPane;

import vue.barreOutils.BarreOutils;
import vue.editeurs.ConteneurEditeurs;
import vue.menus.BarreMenu;

@SuppressWarnings("serial")
public class ConteneurGlobal extends JSplitPane
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer	TAILLE_X	= FenetrePrincipale.TAILLE_X;
	public final static Integer	TAILLE_Y	= FenetrePrincipale.TAILLE_Y - BarreMenu.TAILLE_Y - BarreOutils.TAILLE_Y;

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private ConteneurEditeurs	conteneurEditeurs;
	private NavigateurFichiers	navigateur;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public ConteneurGlobal()
	{
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		this.setDividerLocation(NavigateurFichiers.TAILLE_X);

		buildConteneurEditeurs();
		buildNavigateur();
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	private void buildConteneurEditeurs()
	{
		conteneurEditeurs = new ConteneurEditeurs();
		this.setRightComponent(conteneurEditeurs);
	}

	private void buildNavigateur()
	{
		setNavigateur(new NavigateurFichiers());
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
