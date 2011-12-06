package vue.editeurs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modele.parseurs.ParseurBIN;
import modele.parseurs.editeurs.ModeleTablesEditeurs;

@SuppressWarnings("serial")
public class EditeurBIN extends JPanel
{

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	// Taille ideale : 210
	public static Integer			TAILLE_X		= Editeurs.TAILLE_X - EditeurGPH.TAILLE_X;
	// Taille ideale : 230
	public static Integer			TAILLE_Y		= Editeurs.TAILLE_Y - EditeurSDF.TAILLE_Y;

	private JLabel					titre;
	private final static String		CONTENU_TITRE	= "Editeur de fichiers *.bin";

	private JScrollPane				scroll;

	private JTable					tableauBIN;
	private final static String[]	TITRES_TABLEAU	= { "Numero", "Classe", "Nombre de fragments" };

	private ModeleTablesEditeurs	modele;

	private ParseurBIN				parseur;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public EditeurBIN()
	{
		this.setLayout(new FlowLayout());
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
		titre = new JLabel(CONTENU_TITRE);
		titre.setName("titre");
		this.add(titre);
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
		tableauBIN.setPreferredSize(new Dimension(TAILLE_X,TAILLE_Y));
	}

	private void initScroll()
	{
		this.remove(titre);
		scroll = new JScrollPane(tableauBIN);
		//FIXME changer par des tailles variables selon les dimensions de la fenetre
		scroll.setPreferredSize(new Dimension(210,230));
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
