package vue.editeurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.EcouteurJtable;
import modele.editeurs.ModeleTablesEditeurs;
import modele.editeurs.TablesEditeurs;
import modele.fichiers.FichierSDF;
import modele.parseurs.ParseurSDF;

@SuppressWarnings("serial")
public class EditeurSDF extends JPanel
{
	/**
	 * <h4>EditeurSDF est la classe regroupant l'environement graphique du
	 * tableau SDF</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public static Integer			TAILLE_X		= Editeurs.TAILLE_X;
	public static Integer			TAILLE_Y		= 2 * Editeurs.TAILLE_Y / 5;

	public final static Color		BG_COLOR		= Color.WHITE;

	private final static String		TITRE			= "Editeur de fichiers *.sdf";
	private String[]				TITRES_TABLEAU	= { "Ind molecule", "Nb Liaisons", "Nb Atomes" };

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private JLabel					titre;
	private JScrollPane				scroll;
	/**
	 * Tableau graphique
	 */
	private JTable					tableauSDF;
	/**
	 * Modele du tabelau
	 * 
	 * @see ModeleTablesEditeurs
	 */
	private ModeleTablesEditeurs	modele;
	/**
	 * Classe de reference pour les donnees contenus dans le tableau BIN
	 * 
	 * @see FichierBIN
	 */
	private FichierSDF				fichierSDF;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe EditeurSDF
	 * 
	 * @param sdfFile
	 *            le modele de fichier SDF
	 */
	public EditeurSDF(FichierSDF sdfFile)
	{
		this.fichierSDF = sdfFile;
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

		titre = new JLabel(TITRE);
		titre.setName("titre");

		add(titre);
	}

	/**
	 * Methode d'initialisation du parseur SDF
	 */
	private void initParseur()
	{
		try
		{
			fichierSDF.initParseur();
		}
		catch (NullPointerException e)
		{
			System.out.println("Tentative d'initialisation du parseur SDF avortée.");
		}

	}

	/**
	 * Methode d'initialisation du tableau graphique SDF
	 */
	private void initModeleEtTable()
	{
		try
		{
			TITRES_TABLEAU = recupererTitresTableau(fichierSDF.getParseurSDF());

			modele = new ModeleTablesEditeurs(TITRES_TABLEAU, fichierSDF.getParseurSDF().convertirListeVersTableau2D(),
					1);
			tableauSDF = new TablesEditeurs(modele);
			tableauSDF.setAutoCreateRowSorter(true);
			tableauSDF.getTableHeader().setReorderingAllowed(false);
		}
		catch (NullPointerException e)
		{
			System.out.println("Tentative d'initialisation du modele de arseur SDF avortée.");
		}

	}

	/**
	 * Mis en Scroll du tableau graphique
	 */
	private void initScroll()
	{
		remove(titre);
		setLayout(new BorderLayout());

		scroll = new JScrollPane(tableauSDF);
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
			EcouteurJtable e = new EcouteurJtable(tableauSDF, null, null, fichierSDF);
		}
		catch (NullPointerException e)
		{
		}
	}

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //
	/**
	 * Recuperation des titres grace a la liste de balise
	 * 
	 * @param parseur
	 *            le parseur SDF
	 * @return Un tableau de titres
	 */
	private String[] recupererTitresTableau(ParseurSDF parseur)
	{
		LinkedList<String> intitulesBalises = parseur.recupererIntitulesBalises();
		String[] titresTableau = new String[TITRES_TABLEAU.length + intitulesBalises.size()];

		for (int i = 0 ; i < TITRES_TABLEAU.length ; i++)
			titresTableau[i] = TITRES_TABLEAU[i];

		for (int i = 0 ; i < intitulesBalises.size() ; i++)
			titresTableau[TITRES_TABLEAU.length + i] = intitulesBalises.get(i);

		return titresTableau;
	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //

	public JLabel getTitre()
	{
		return titre;
	}

	/**
	 * @return the tableauSDF
	 */
	public JTable getTableauSDF()
	{
		return tableauSDF;
	}

	/**
	 * @return the sdfFile
	 */
	public FichierSDF getSdfFile()
	{
		return fichierSDF;
	}

	// ----------------------------------------- //
	// --------------- MUTATEURS --------------- //
	// ----------------------------------------- //

	public void setTitre(JLabel titre)
	{
		this.titre = titre;
	}

	/**
	 * @param tableauSDF
	 *            the tableauSDF to set
	 */
	public void setTableauSDF(JTable tableauSDF)
	{
		this.tableauSDF = tableauSDF;
	}

	/**
	 * @param sdfFile
	 *            the sdfFile to set
	 */
	public void setSdfFile(FichierSDF sdfFile)
	{
		this.fichierSDF = sdfFile;
	}
}
