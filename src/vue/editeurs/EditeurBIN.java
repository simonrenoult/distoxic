package src.vue.editeurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import src.controleur.EcouteurJtable;
import src.modele.editeurs.ModeleTablesEditeurs;
import src.modele.editeurs.TablesEditeurs;
import src.modele.fichiers.FichierBIN;


@SuppressWarnings("serial")
public class EditeurBIN extends JPanel
{
	/**
	 * <h4>EditeurBIN est la classe regroupant l'environement graphique du tableau BIN</h4>
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
	public final static Integer		TAILLE_X		= 2 * Editeurs.TAILLE_X / 5;
	public final static Integer		TAILLE_Y		= 3 * Editeurs.TAILLE_Y / 5;

	public final static Color		BG_COLOR		= Color.white;

	private final static String		CONTENU_TITRE	= "Editeur de fichiers *.bin";
	private final static String[]	TITRES_TABLEAU	= { "Ind molecule ","IndTox ", "Nb fragments" };

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private JLabel					titre;
	private JScrollPane				scroll;
	/**
	 * Tableau graphique
	 */
	private JTable					tableauBIN;
	/**
	 * Modele du tabelau
	 * @see ModeleTablesEditeurs
	 */
	private ModeleTablesEditeurs	modele;
	/**
	 * Classe de reference pour les donnees contenus dans le tableau BIN
	 * @see FichierBIN
	 */
	private FichierBIN				fichierBIN;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe EditeurBIN
	 * @param binFile le modele de fichier BIN
	 */
	public EditeurBIN(FichierBIN binFile)
	{
		this.fichierBIN = binFile;
		setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		setBackground(BG_COLOR);

		initTitre();
		initParseur();
		initModeleEtTable();
		initScroll();
		initEcouteur();
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	/**
	 * Methode d'initialisation du titres.
	 */
	private void initTitre()
	{
		setLayout(new FlowLayout());

		titre = new JLabel(CONTENU_TITRE);

		add(titre, BorderLayout.BEFORE_FIRST_LINE);
	}

	/**
	 * Methode d'initialisation du parseur BIN
	 */
	private void initParseur()
	{
		try
		{
			fichierBIN.initParseur();
		}
		catch (NullPointerException e)
		{
			System.out.println("Tentative d'initialisation du parseur BIN avortée.");
		}
	}

	/**
	 * Methode d'initialisation du tableau graphique BIN
	 */
	private void initModeleEtTable()
	{
		try
		{
			modele = new ModeleTablesEditeurs(TITRES_TABLEAU, fichierBIN.getParseurBIN().convertirListeVersTableau2D(),2);
			tableauBIN = new TablesEditeurs(modele);
			tableauBIN.setAutoCreateRowSorter(true);
			tableauBIN.getTableHeader().setReorderingAllowed(false);
		}
		catch (NullPointerException e)
		{
			System.out.println("Tentative d'initialisation du modele de parseur BIN avortée.");
		}
	}

	/**
	 * Mis en Scroll du tableau graphique
	 */
	private void initScroll()
	{
		remove(titre);
		setLayout(new BorderLayout());

		scroll = new JScrollPane(tableauBIN);
		scroll.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));

		add(scroll, BorderLayout.CENTER);
	}

	/**
	 * Ecoute du tableau graphique
	 */
	private void initEcouteur()
	{
		try
		{
			@SuppressWarnings("unused")
			EcouteurJtable e = new EcouteurJtable(tableauBIN, fichierBIN, null, null);
		}
		catch (NullPointerException e)
		{
		}

	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @return the tableauBIN
	 */
	public JTable getTableauBIN()
	{
		return tableauBIN;
	}

	/**
	 * @return the binFile
	 */
	public FichierBIN getBinFile()
	{
		return fichierBIN;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @param tableauBIN
	 *            the tableauBIN to set
	 */
	public void setTableauBIN(JTable tableauBIN)
	{
		this.tableauBIN = tableauBIN;
	}

	/**
	 * @param binFile
	 *            the binFile to set
	 */
	public void setBinFile(FichierBIN binFile)
	{
		this.fichierBIN = binFile;
	}
}
