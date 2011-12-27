package vue.menus;

import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import vue.FenetrePrincipale;

@SuppressWarnings("serial")
public class BarreMenu extends JMenuBar
{
	/**
	 * <h4>BarreMenu est la classe regroupant tout le menu du programme</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer	TAILLE_X	= FenetrePrincipale.TAILLE_X;
	public final static Integer	TAILLE_Y	= FenetrePrincipale.TAILLE_Y / 20;

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //
	/**
	 * Menu Fichier
	 * @see MenuFichier
	 */
	private MenuFichier			menuFichier;
	/**
	 * Menu A propos
	 * @see MenuAPropos
	 */
	private MenuAPropos			menuAPropos;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe BarreMenu
	 */
	public BarreMenu()
	{
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));

		menuFichier = new MenuFichier();
		this.add(menuFichier);

		menuAPropos = new MenuAPropos();
		this.add(menuAPropos);
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public JMenu getMenuFichier()
	{
		return menuFichier;
	}

	public JMenu getMenuAPropos()
	{
		return menuAPropos;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setMenuFichier(MenuFichier menuFichier)
	{
		this.menuFichier = menuFichier;
	}

	public void setMenuAPropos(MenuAPropos menuAPropos)
	{
		this.menuAPropos = menuAPropos;
	}
}
