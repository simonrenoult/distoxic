package vue.barreOutils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import vue.FenetrePrincipale;

@SuppressWarnings("serial")
public class BarreOutils extends JPanel
{

	/**
	 * <h4>BarreOutils est la classe permettant de decrire la barre d'outil
	 * graphique du programme</h4>
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
	private static String		_ICON_PATH			= "/images/icones/";

	public final static Integer	TAILLE_X			= FenetrePrincipale.TAILLE_X;
	public final static Integer	TAILLE_Y			= FenetrePrincipale.TAILLE_Y / 20;

	private final static Color	COULEUR_RECHERCHE	= Color.GRAY;
	public final String			CONTENU_RECHERCHE	= "Rechercher...";

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

	private JToolBar			barreAccessibilite;
	private JTextField			champRecherche;
	
	private JToolBar			barreZoom;
	private JLabel				informationZoom;
	private JSlider				sliderZoom;

	// private JButton augmenterZoom;
	// private JButton diminuerZoom;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	/**
	 * Constructeur principal de la classe BarreOutils
	 */
	public BarreOutils()
	{
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));

		initBarreFichier();
		initBarreRecherche();
		initBarreZoom();

		this.add(barreFichier, BorderLayout.LINE_START);
		this.add(barreAccessibilite);
		this.add(barreZoom, BorderLayout.EAST);
	}

	// ----------------------------------------- //
	// ----------------METHODES----------------- //
	// ----------------------------------------- //

	/**
	 * Ajout des boutons a la barre de Menu.
	 */
	private void initBarreFichier()
	{
		initBoutons();

		barreFichier = new JToolBar();

		barreFichier.add(nouveau);
		barreFichier.add(importer);
		barreFichier.add(exporter);
		barreFichier.add(rafraichir);
		barreFichier.addSeparator();
		barreFichier.add(enregistrerSous);
		barreFichier.add(enregistrerSousTriplet);

		barreFichier.addSeparator();

		barreFichier.setRollover(true);
	}

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
		// imprimer = creerBouton("printer.png", "Imprimer");
	}

	/**
	 * Creation d'un bouton constituant la barre d'outil
	 * 
	 * @param path
	 *            le chemin de l'icone associe
	 * @param toolTip
	 *            le tooltip associe
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

	private void initBarreRecherche()
	{
		barreAccessibilite = new JToolBar();

		champRecherche = new JTextField(CONTENU_RECHERCHE);
		champRecherche.setForeground(COULEUR_RECHERCHE);
		barreAccessibilite.add(champRecherche);
		barreAccessibilite.setRollover(true);
	}
	
	private void initBarreZoom(){

		sliderZoom = new JSlider(8, 20, 11);

		informationZoom = new JLabel(String.valueOf(sliderZoom.getValue()));
		
		barreZoom = new JToolBar();
		barreZoom.add(informationZoom);
		barreZoom.add(sliderZoom);
		
		
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public JLabel getInformationZoom()
	{
		return informationZoom;
	}

	public void setInformationZoom(JLabel informationZoom)
	{
		this.informationZoom = informationZoom;
	}

	public JToolBar getBarreAccessibilite()
	{
		return barreAccessibilite;
	}

	public void setBarreAccessibilite(JToolBar barreAccessibilite)
	{
		this.barreAccessibilite = barreAccessibilite;
	}

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

	public JToolBar getBarreRecherche()
	{
		return barreAccessibilite;
	}

	public void setBarreRecherche(JToolBar barreRecherche)
	{
		this.barreAccessibilite = barreRecherche;
	}

	public JTextField getChampRecherche()
	{
		return champRecherche;
	}

	public void setChampRecherche(JTextField champRecherche)
	{
		this.champRecherche = champRecherche;
	}

	public JSlider getSliderZoom()
	{
		return sliderZoom;
	}

	public void setSliderZoom(JSlider sliderZoom)
	{
		this.sliderZoom = sliderZoom;
	}
}
