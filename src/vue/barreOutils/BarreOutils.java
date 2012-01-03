package vue.barreOutils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import vue.FenetrePrincipale;

@SuppressWarnings("serial")
public class BarreOutils extends JPanel
{
	/**
	 * <h4>BarreOutils est la classe permettant de decrire la barre d'outil graphique du programme</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //
	/**
	 * Constantes de classe
	 */
	private static String		_ICON_PATH	= "/images/icones/";
	public final static Integer	TAILLE_X	= FenetrePrincipale.TAILLE_X;
	public final static Integer	TAILLE_Y	= FenetrePrincipale.TAILLE_Y / 20;

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private JToolBar			barreFichier;

	private JButton				nouveau;
	private JButton				importer;
	private JButton				exporter;
	private JButton				rafraichir;
	private JButton				enregistrerSousTriplet;
	private JButton				enregistrerSous;
	//private JButton				imprimer;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe BarreOutils
	 */
	public BarreOutils()
	{
		setLayout(new BorderLayout());

		initBoutons();
		initBarreMenu();
		initPanel();
	}

	// ----------------------------------------- //
	// ----------------METHODES----------------- //
	// ----------------------------------------- //
	/**
	 * Creation des boutons constituants la barre d'outil
	 */
	private void initBoutons()
	{
		nouveau = creerBouton("folder_add.png", "Nouveau projet");
		importer = creerBouton("table_import.png", "Importer un projet");
		exporter = creerBouton("table_export.png", "Exporter un projet");
		rafraichir = creerBouton("arrow_refresh.png", "Rafraichir l'espace de travail");
		enregistrerSousTriplet = creerBouton("save_all.png", "Enregistrer le triplet");
		enregistrerSous = creerBouton("save_as.png", "Enregistrer le fichier");
		//imprimer = creerBouton("printer.png", "Imprimer");
	}

	/**
	 * Ajout des boutons a la barre de Menu.
	 */
	private void initBarreMenu()
	{
		barreFichier = new JToolBar();

		barreFichier.add(nouveau);
		barreFichier.add(importer);
		barreFichier.add(exporter);
		barreFichier.add(rafraichir);
		barreFichier.addSeparator();
		barreFichier.add(enregistrerSous);
		barreFichier.add(enregistrerSousTriplet);
		//barreFichier.add(imprimer);
		barreFichier.addSeparator();
		barreFichier.setRollover(true);
	}

	/**
	 * Creation d'un bouton constituant la barre d'outil
	 * @param path le chemin de l'icone associe
	 * @param toolTip le tooltip associe
	 * @return un bouton de type JButton
	 */
	private JButton creerBouton(String path, String toolTip)
	{
		JButton button = new JButton();
		button.setIcon(new ImageIcon(getClass().getResource(_ICON_PATH + path)));
		button.setToolTipText(toolTip);
		button.setPreferredSize(new Dimension(30, 30));

		return button;
	}

	/**
	 * Initailisation du conteneur.
	 */
	private void initPanel()
	{
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.add(barreFichier, BorderLayout.PAGE_START);
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	/**
	 * @return the toolbar
	 */
	public JToolBar getToolbar()
	{
		return barreFichier;
	}

	/**
	 * @param toolbar
	 *            the toolbar to set
	 */
	public void setToolbar(JToolBar toolbar)
	{
		this.barreFichier = toolbar;
	}

	/**
	 * @return the nouveau
	 */
	public JButton getNouveau()
	{
		return nouveau;
	}

	/**
	 * @param nouveau
	 *            the nouveau to set
	 */
	public void setNouveau(JButton nouveau)
	{
		this.nouveau = nouveau;
	}

	/**
	 * @return the enregistrer
	 */
	public JButton getEnregistrerSousTriplet()
	{
		return enregistrerSousTriplet;
	}

	/**
	 * @param enregistrer
	 *            the enregistrer to set
	 */
	public void setEnregistrer(JButton enregistrerSousTriplet)
	{
		this.enregistrerSousTriplet = enregistrerSousTriplet;
	}

	/**
	 * @return the enregistrerSous
	 */
	public JButton getEnregistrerSous()
	{
		return enregistrerSous;
	}

	/**
	 * @param enregistrerSous
	 *            the enregistrerSous to set
	 */
	public void setEnregistrerSous(JButton enregistrerSous)
	{
		this.enregistrerSous = enregistrerSous;
	}

	/**
	 * @return the imprimer
	 */
	/*public JButton getImprimer()
	{
		return imprimer;
	}*/

	/**
	 * @param imprimer
	 *            the imprimer to set
	 */
	/*public void setImprimer(JButton imprimer)
	{
		this.imprimer = imprimer;
	}*/

	/**
	 * @return the importer
	 */
	public JButton getImporter()
	{
		return importer;
	}

	/**
	 * @param importer
	 *            the importer to set
	 */
	public void setImporter(JButton importer)
	{
		this.importer = importer;
	}

	/**
	 * @return the exporter
	 */
	public JButton getExporter()
	{
		return exporter;
	}

	/**
	 * @param exporter
	 *            the exporter to set
	 */
	public void setExporter(JButton exporter)
	{
		this.exporter = exporter;
	}

	/**
	 * @return the rafraichir
	 */
	public JButton getRafraichir()
	{
		return rafraichir;
	}

	/**
	 * @param rafraichir
	 *            the rafraichir to set
	 */
	public void setRafraichir(JButton rafraichir)
	{
		this.rafraichir = rafraichir;
	}
}
