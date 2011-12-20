package vue.menus;

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
	public JMenuItem buildMenuItem(JMenuItem item, String titre)
	{
		item = new JMenuItem(titre);
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
	public JMenuItem buildMenuItem(JMenuItem item, String titre, KeyStroke ks)
	{
		item = buildMenuItem(item, titre);
		item.setAccelerator(ks);
		
		return item;
	}	
}
