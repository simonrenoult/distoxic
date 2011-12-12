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
import modele.editeurs.ModeleTablesEditeurs;
import modele.file.SDFFile;
import modele.parseurs.ParseurSDF;

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
	private static String[]			TITRES_TABLEAU	= {};

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private JLabel					titre;
	private JScrollPane				scroll;

	private JTable					tableauSDF;
	private ModeleTablesEditeurs	modele;

	private SDFFile					sdfFile;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public EditeurSDF(SDFFile sdfFile)
	{
		this.sdfFile = sdfFile;
		setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		setBackground(BG_COLOR);

		initTitre();

		initParseur();
		initModeleEtTable();
		initScroll();
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
			sdfFile.initParseur();
		}
		catch (Exception e)
		{
		}
	}

	private void initModeleEtTable()
	{
		TITRES_TABLEAU = recupererTitresTableau(this.sdfFile.getParseurSDF());

		modele = new ModeleTablesEditeurs(TITRES_TABLEAU, sdfFile.getParseurSDF().convertirListeVersTableau2D());
		tableauSDF = new JTable(modele);
	}

	private void initScroll()
	{
		remove(titre);
		setLayout(new BorderLayout());

		scroll = new JScrollPane(tableauSDF);
		scroll.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		add(scroll, BorderLayout.CENTER);
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
}
