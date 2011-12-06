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
import modele.parseurs.ParseurBIN;

@SuppressWarnings("serial")
public class EditeurBIN extends JPanel
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer		TAILLE_X		= 2 * Editeurs.TAILLE_X / 5 - 40;
	public final static Integer		TAILLE_Y		= 3 * Editeurs.TAILLE_Y / 5;

	public final static Color		BG_COLOR		= Color.WHITE;

	private final static String		CONTENU_TITRE	= "Editeur de fichiers *.bin";
	private final static String[]	TITRES_TABLEAU	= { "Numero", "Classe", "Nombre de fragments" };

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private JLabel					titre;
	private JScrollPane				scroll;

	private JTable					tableauBIN;
	private ModeleTablesEditeurs	modele;
	private ParseurBIN				parseur;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public EditeurBIN()
	{
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
		// FIXME chemin à définir.
		parseur = new ParseurBIN("./workspace/exemple_60_56/exemple_60_56.bin");
	}

	private void initModeleEtTable()
	{
		modele = new ModeleTablesEditeurs(TITRES_TABLEAU, parseur.convertirListeVersTableau());
		tableauBIN = new JTable(modele);
	}

	private void initScroll()
	{
		remove(titre);
		// BordeLayout quand une table est affichee afin de permettre le
		// centrage de la table.
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

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
