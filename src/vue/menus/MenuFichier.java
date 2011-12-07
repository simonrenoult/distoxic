package vue.menus;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class MenuFichier extends Menu
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	private final static String	TITRE_MENU				= "Fichier";

	private final static String	TITRE_NOUVEAU			= "Nouveau";
	private final static String	TITRE_OUVRIR			= "Ouvrir";
	private final static String	TITRE_ENREGISTRER		= "Enregistrer";
	private final static String	TITRE_ENREGISTRER_SOUS	= "Enregistrer Sous";
	private final static String	TITRE_IMPORTER			= "Importer";
	private final static String	TITRE_EXPORTER			= "Exporter";
	private final static String	TITRE_QUITTER			= "Quitter";

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private JMenuItem			nouveau;
	private JMenuItem			ouvrir;
	private JMenuItem			enregistrer;
	private JMenuItem			enregistrerSous;
	private JMenuItem			importer;
	private JMenuItem			exporter;
	private JMenuItem			quitter;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	public MenuFichier()
	{
		this.setText(TITRE_MENU);
		this.setMnemonic(KeyEvent.VK_F);

		buildItems();
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	private void buildItems()
	{
		nouveau = buildMenuItem(nouveau, TITRE_NOUVEAU, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		this.add(nouveau);

		ouvrir = buildMenuItem(ouvrir, TITRE_OUVRIR, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
		this.add(ouvrir);

		this.addSeparator();

		enregistrer = buildMenuItem(enregistrer, TITRE_ENREGISTRER,
				KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		this.add(enregistrer);

		enregistrerSous = buildMenuItem(enregistrerSous, TITRE_ENREGISTRER_SOUS,
				KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		this.add(enregistrerSous);

		this.addSeparator();

		importer = buildMenuItem(importer, TITRE_IMPORTER, KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_MASK));
		this.add(importer);

		exporter = buildMenuItem(exporter, TITRE_EXPORTER, KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
		this.add(exporter);

		this.addSeparator();

		quitter = buildMenuItem(quitter, TITRE_QUITTER, KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		this.add(quitter);
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public JMenuItem getNouveau()
	{
		return nouveau;
	}

	public JMenuItem getOuvrir()
	{
		return ouvrir;
	}

	public JMenuItem getEnregistrer()
	{
		return enregistrer;
	}

	public JMenuItem getEnregistrerSous()
	{
		return enregistrerSous;
	}

	public JMenuItem getImporter()
	{
		return importer;
	}

	public JMenuItem getExporter()
	{
		return exporter;
	}

	public JMenuItem getQuitter()
	{
		return quitter;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setNouveau(JMenuItem nouveau)
	{
		this.nouveau = nouveau;
	}

	public void setOuvrir(JMenuItem ouvrir)
	{
		this.ouvrir = ouvrir;
	}

	public void setEnregistrer(JMenuItem enregistrer)
	{
		this.enregistrer = enregistrer;
	}

	public void setEnregistrerSous(JMenuItem enregistrerSous)
	{
		this.enregistrerSous = enregistrerSous;
	}

	public void setImporter(JMenuItem importer)
	{
		this.importer = importer;
	}

	public void setExporter(JMenuItem exporter)
	{
		this.exporter = exporter;
	}

	public void setQuitter(JMenuItem quitter)
	{
		this.quitter = quitter;
	}

}
