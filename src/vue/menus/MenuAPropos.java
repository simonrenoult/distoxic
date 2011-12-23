package vue.menus;

import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class MenuAPropos extends Menu
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	private final static String		TITRE_MENU		= "A Propos";

	private final static String		TITRE_AIDE		= "Aide";
	private final static String		TITRE_APROPOS	= "A propos de...";

	private final static Integer	F1_KEY			= 112;

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private JMenuItem				aide;
	private JMenuItem				aPropos;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	public MenuAPropos()
	{
		this.setText(TITRE_MENU);
		this.setMnemonic(KeyEvent.VK_A);

		buildItems();
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	private void buildItems()
	{
		aide = buildMenuItem(aide, TITRE_AIDE, KeyStroke.getKeyStroke(F1_KEY, 0), "help.png");
		this.add(aide);

		this.addSeparator();

		aPropos = buildMenuItem(aPropos, TITRE_APROPOS, "information.png");
		this.add(aPropos);
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public JMenuItem getAide()
	{
		return aide;
	}

	public JMenuItem getAPropos()
	{
		return aPropos;
	}
	
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setAide(JMenuItem aide)
	{
		this.aide = aide;
	}

	public void setAPropos(JMenuItem aPropos)
	{
		this.aPropos = aPropos;
	}
}
