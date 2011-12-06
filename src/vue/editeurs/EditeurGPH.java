package vue.editeurs;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modele.parseur.ParseurBIN;
import modele.parseur.ParseurGPH;

@SuppressWarnings("serial")
public class EditeurGPH extends JPanel
{
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	public static Integer			TAILLE_X		= 3 * Editeurs.TAILLE_X / 5;
	public static Integer			TAILLE_Y		= Editeurs.TAILLE_Y - EditeurSDF.TAILLE_Y;

	private JLabel					titre;
	private String					contenuTitre	= "Editeur de fichiers *.gph";

	private JScrollPane				scroll;

	private JTable					tableauGPH;
	private final static String[]	TITRES_TABLEAU	= { "Numero", "Nb atomes", "Nb liaisons", "Classe", "Frequece",
			"Toxicite", "Emergence"				};

	private ModeleTablesEditeurs	modele;

	private ParseurGPH				parseur;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public EditeurGPH()
	{
		this.setSize(TAILLE_X, TAILLE_Y);
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.setBackground(Color.WHITE);

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
		titre = new JLabel(contenuTitre);
		titre.setName("titre");
		this.add(titre);
	}

	private void initParseur()
	{
		// FIXME chemin a definir.
		parseur = new ParseurGPH("./workspace/exemple_60_56/exemple_60.gph");
	}

	private void initModeleEtTable()
	{
		modele = new ModeleTablesEditeurs(TITRES_TABLEAU, parseur.convertirListeVersTableau());
		tableauGPH = new JTable(modele);
		tableauGPH.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
	}

	private void initScroll()
	{
		this.remove(titre);
		scroll = new JScrollPane(tableauGPH);
		// FIXME changer par des tailles variables selon les dimensions de la
		// fenetre
		scroll.setPreferredSize(new Dimension(350, 230));
		this.add(scroll);
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
