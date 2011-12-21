package vue.editeurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import modele.editeurs.ModeleTablesEditeurs;
import modele.editeurs.TablesEditeurs;
import modele.fichier.FichierBIN;

@SuppressWarnings("serial")
public class EditeurBIN extends JPanel
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer		TAILLE_X		= 2 * Editeurs.TAILLE_X / 5 - 40;
	public final static Integer		TAILLE_Y		= 3 * Editeurs.TAILLE_Y / 5;

	public final static Color		BG_COLOR		= Color.white;

	private final static String		CONTENU_TITRE	= "Editeur de fichiers *.bin";
	private final static String[]	TITRES_TABLEAU	= { "Classe", "Nombre de fragments" };

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private JLabel					titre;
	private JScrollPane				scroll;

	private JTable					tableauBIN;
	private ModeleTablesEditeurs	modele;
	private FichierBIN				binFile;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public EditeurBIN(FichierBIN binFile)
	{
		this.binFile = binFile;
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
		// FlowLayout afin de centrer le titre quand aucune table n'est
		// affichee.
		setLayout(new FlowLayout());

		titre = new JLabel(CONTENU_TITRE);
		titre.setName("titre");

		add(titre, BorderLayout.BEFORE_FIRST_LINE);
	}

	private void initParseur()
	{

		try
		{
			binFile.initParseur();
		}
		catch (Exception e)
		{
		}
	}

	private void initModeleEtTable()
	{
		try
		{
			modele = new ModeleTablesEditeurs(TITRES_TABLEAU, binFile.getParseurBIN().convertirListeVersTableau2D());
			tableauBIN = new TablesEditeurs(modele);
		}
		catch (Exception e)
		{
		}
	}

	private void initScroll()
	{
		remove(titre);
		/*
		 * BordeLayout quand une table est affichee afin de permettre le
		 * centrage de la table lors d'une modification de la taille de la
		 * fenetre
		 */
		setLayout(new BorderLayout());

		scroll = new JScrollPane(tableauBIN);
		scroll.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));

		add(scroll, BorderLayout.CENTER);
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
}
