package src.vue.editeurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import src.controleur.EcouteurJtable;
import src.modele.editeurs.ModeleTablesEditeurs;
import src.modele.editeurs.TablesEditeurs;
import src.modele.fichiers.FichierSDF;
import src.modele.parseurs.ParseurSDF;


@SuppressWarnings("serial")
public class EditeurSDF extends JPanel
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public static Integer			TAILLE_X		= Editeurs.TAILLE_X;
	public static Integer			TAILLE_Y		= 2 * Editeurs.TAILLE_Y / 5;

	public final static Color		BG_COLOR		= Color.WHITE;

	private final static String		TITRE			= "Editeur de fichiers *.sdf";
	private String[]				TITRES_TABLEAU	= { "Ind molecule","Nb Liaisons", "Nb Atomes" };

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private JLabel					titre;
	private JScrollPane				scroll;

	private JTable					tableauSDF;
	private ModeleTablesEditeurs	modele;

	private FichierSDF				fichierSDF;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

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

	private void initTitre()
	{
		setLayout(new FlowLayout());

		titre = new JLabel(TITRE);
		titre.setName("titre");

		add(titre);
	}

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

	private void initModeleEtTable()
	{
		try
		{
			TITRES_TABLEAU = recupererTitresTableau(fichierSDF.getParseurSDF());

			modele = new ModeleTablesEditeurs(TITRES_TABLEAU, fichierSDF.getParseurSDF().convertirListeVersTableau2D(),1);
			tableauSDF = new TablesEditeurs(modele);
			tableauSDF.setAutoCreateRowSorter(true);
			tableauSDF.getTableHeader().setReorderingAllowed(false);
		}
		catch (NullPointerException e)
		{
			System.out.println("Tentative d'initialisation du modele de arseur SDF avortée.");
		}

	}

	private void initScroll()
	{
		remove(titre);
		setLayout(new BorderLayout());

		scroll = new JScrollPane(tableauSDF);
		scroll.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		add(scroll, BorderLayout.CENTER);
	}

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
