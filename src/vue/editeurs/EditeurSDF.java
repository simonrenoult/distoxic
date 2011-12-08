package vue.editeurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modele.editeurs.ModeleTablesEditeurs;
import modele.parseurs.ParseurGPH;
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
	private final static String[]	TITRES_TABLEAU	= { "Indice", "Nb Atomes", "Nb Liaisons" };

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private JLabel					titre;
	private JScrollPane				scroll;

	private JTable					tableauSDF;
	private ModeleTablesEditeurs	modele;

	private ParseurSDF				parseur;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public EditeurSDF()
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
		setLayout(new FlowLayout());

		titre = new JLabel(TITRE);
		titre.setName("titre");

		add(titre);
	}

	private void initParseur()
	{
		// FIXME chemin a definir.
		parseur = new ParseurSDF("./workspace/DisToxicProjects/exemple_60_56/exemple_56.sdf");
	}

	private void initModeleEtTable()
	{
		modele = new ModeleTablesEditeurs(recupererTitresTableau(parseur), parseur.convertirListeVersTableau2D());
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
	
	private String[] recupererTitresTableau(ParseurSDF p)
	{
		LinkedList<String> l = p.recupererIntitulesBalises();
		String[] s = new String[TITRES_TABLEAU.length + l.size()];

		for (int i = 0 ; i < TITRES_TABLEAU.length ; i++)
			s[i] = TITRES_TABLEAU[i];

		for (int i = 0 ; i < l.size() ; i++)
			s[TITRES_TABLEAU.length + i] = l.get(i);

		return s;
	}
	
	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //

	public JLabel getTitre()
	{
		return titre;
	}

	// ----------------------------------------- //
	// --------------- MUTATEURS --------------- //
	// ----------------------------------------- //

	public void setTitre(JLabel titre)
	{
		this.titre = titre;
	}
}
