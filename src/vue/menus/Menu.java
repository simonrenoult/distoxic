package src.vue.menus;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class Menu extends JMenu
{
	// ----------------------------------------- //
	// -------------- INFORMATIONS ------------- //
	// ----------------------------------------- //
	
	/**
	 * Classe mere de la barre de menu.
	 * Permet d'acceder aux methodes de construction generique d'un item du menu.
	 * 
	 * @author g4llic4
	 * 
	 */
	
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //
	private static String		_ICON_PATH	= "/images/icones/";
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	/**
	 * Permet de construire le JMenuItem passe en parametre.
	 * @param item : JMenuItem a construire.
	 * @param titre : titre a affecte au JMenuItem passe en parametre.
	 * @return : le JMenuItem ainsi cree.
	 */
	public JMenuItem buildMenuItem(JMenuItem item, String titre, String iconPath)
	{
		item = new JMenuItem(titre);
		item.setIcon(new ImageIcon(getClass().getResource(_ICON_PATH+iconPath)));
		item.setName(titre);
		
		return item;
	}

	/**
	 * Permet de construire le JMenuItem passe en parametre.
	 * @param item : JMenuItem a construire.
	 * @param titre : titre a affecte au JMenuItem passe en parametre.
	 * @param ks : affecte un raccourci clavier au JMenuItem passe en parametre.
	 * @return : le JMenuItem ainsi cree.
	 */
	public JMenuItem buildMenuItem(JMenuItem item, String titre, KeyStroke ks,String iconPath)
	{
		item = buildMenuItem(item, titre, iconPath);
		item.setAccelerator(ks);
		
		return item;
	}	
}
