package vue.menus;

import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import vue.FenetrePrincipale;

@SuppressWarnings("serial")
public class BarreMenu extends JMenuBar
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer	TAILLE_X	= FenetrePrincipale.TAILLE_X;
	public final static Integer	TAILLE_Y	= FenetrePrincipale.TAILLE_Y / 20;

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private MenuFichier			menuFichier;
	private MenuAPropos			menuAPropos;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

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
