package vue.editeurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.EcouteurJtable;
import modele.editeurs.ModeleTablesEditeurs;
import modele.editeurs.TablesEditeurs;
import modele.fichiers.FichierBIN;

@SuppressWarnings("serial")
public class EditeurBIN extends JPanel
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer		TAILLE_X		= 2 * Editeurs.TAILLE_X / 5;
	public final static Integer		TAILLE_Y		= 3 * Editeurs.TAILLE_Y / 5;

	public final static Color		BG_COLOR		= Color.white;

	private final static String		CONTENU_TITRE	= "Editeur de fichiers *.bin";
	private final static String[]	TITRES_TABLEAU	= { "Id molécule","Classe", "Nombre de fragments" };

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private JLabel					titre;
	private JScrollPane				scroll;

	private JTable					tableauBIN;
	private ModeleTablesEditeurs	modele;
	private FichierBIN				fichierBIN;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

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

	private void initTitre()
	{
		setLayout(new FlowLayout());

		titre = new JLabel(CONTENU_TITRE);
		titre.setName("titre");

		add(titre, BorderLayout.BEFORE_FIRST_LINE);
	}

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

	private void initModeleEtTable()
	{
		try
		{
			modele = new ModeleTablesEditeurs(TITRES_TABLEAU, fichierBIN.getParseurBIN().convertirListeVersTableau2D());
			tableauBIN = new TablesEditeurs(modele);
			tableauBIN.setAutoCreateRowSorter(true);
		}
		catch (NullPointerException e)
		{
			System.out.println("Tentative d'initialisation du modele de parseur BIN avortée.");
		}
	}

	private void initScroll()
	{
		remove(titre);
		setLayout(new BorderLayout());

		scroll = new JScrollPane(tableauBIN);
		scroll.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));

		add(scroll, BorderLayout.CENTER);
	}

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
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

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
