
package vue;

import java.awt.Dimension;
import javax.swing.JSplitPane;
import vue.editeurs.ConteneurEditeurs;
import vue.menus.MenuTextuel;

@SuppressWarnings("serial")
public class ConteneurGlobal extends JSplitPane
{
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	public static Integer		TAILLE_X	= FenetrePrincipale.TAILLE_X;
	public static Integer		TAILLE_Y	= FenetrePrincipale.TAILLE_Y - MenuTextuel.TAILLE_Y;
	
	private ConteneurEditeurs	conteneurEditeurs;
	private NavigateurFichiers	navigateur;
	
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	public ConteneurGlobal()
	{
		this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		this.setSize(TAILLE_X, TAILLE_Y);
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
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
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	
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
