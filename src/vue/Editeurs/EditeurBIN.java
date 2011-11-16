
package vue.Editeurs;

<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
=======
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

>>>>>>> 830ee8fbb3182a341dac33c0fdac3606ffadff27
public class EditeurBIN extends JPanel
{
	
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
<<<<<<< HEAD
	
	public static Integer			TAILLE_X		= Editeurs.TAILLE_X / 4;
	public static Integer			TAILLE_Y		= Editeurs.TAILLE_Y / 2;
	
	private JLabel					titre;
	private String					contenuTitre	= "Editeur de fichiers *.bin";
	
	private JScrollPane				scroll;
	private JTable					tableBIN;
	private ModeleTablesEditeurs	modele;
	private String[]				titresTableBIN	= { "Numéro", "Classe", "Nombre de fragments" };
=======

	public static Integer	TAILLE_X	= Editeurs.TAILLE_X / 4;
	public static Integer	TAILLE_Y	= Editeurs.TAILLE_Y / 2;
>>>>>>> 830ee8fbb3182a341dac33c0fdac3606ffadff27
	
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	public EditeurBIN()
	{
<<<<<<< HEAD
		// super();
		super(new FlowLayout());
		
		this.setSize(TAILLE_X, TAILLE_Y);
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		
		initTitre();
		initModeleEtTable();
		initScroll();
=======
		this.setSize(TAILLE_X, TAILLE_Y);
		this.setPreferredSize(new Dimension(TAILLE_X,TAILLE_Y));
>>>>>>> 830ee8fbb3182a341dac33c0fdac3606ffadff27
	}
	
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	
<<<<<<< HEAD
	private void initTitre()
	{
		titre = new JLabel(contenuTitre);
		titre.setName("titre");
		this.add(titre);
	}
	
	private void initModeleEtTable()
	{
		modele = new ModeleTablesEditeurs(titresTableBIN, donneesTableau);
		tableBIN = new JTable(modele);
	}
	
	private void initScroll()
	{
		scroll = new JScrollPane(tableBIN);
		this.add(scroll);
	}
	
=======
>>>>>>> 830ee8fbb3182a341dac33c0fdac3606ffadff27
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
