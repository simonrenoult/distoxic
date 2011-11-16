
package vue.Editeurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import modele.Parseur.ParseurBIN;

@SuppressWarnings("serial")
public class EditeurBIN extends JPanel
{
	
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	public static Integer			TAILLE_X		= Editeurs.TAILLE_X / 4;
	public static Integer			TAILLE_Y		= Editeurs.TAILLE_Y / 2;
	
	private JLabel					titre;
	private String					contenuTitre	= "Editeur de fichiers *.bin";
	
	private JScrollPane				scroll;
	
	private JTable					tableBIN;
	private String[]				titresTableBIN	= { "Numéro", "Classe", "Nombre de fragments" };
	
	private ModeleTablesEditeurs	modele;
	
	private ParseurBIN				parseur;
	
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	public EditeurBIN()
	{
		// super();
		super(new FlowLayout());
		
		this.setSize(TAILLE_X, TAILLE_Y);
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		
		initTitre();
		//initModeleEtTable();
		//initScroll();
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
	
	private void initModeleEtTable()
	{
		modele = new ModeleTablesEditeurs(titresTableBIN, parseur.getDonnees());
		tableBIN = new JTable(modele);
	}
	
	private void initScroll()
	{
		scroll = new JScrollPane(tableBIN);
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
