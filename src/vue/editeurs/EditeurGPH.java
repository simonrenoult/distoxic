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
import modele.file.GPHFile;
import modele.parseurs.ParseurGPH;

@SuppressWarnings("serial")
public class EditeurGPH extends JPanel
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer		TAILLE_X		= 3 * Editeurs.TAILLE_X / 5;
	public final static Integer		TAILLE_Y		= 3 * Editeurs.TAILLE_Y / 5;

	public final static Color		BG_COLOR		= Color.WHITE;

	private final static String		TITRE			= "Editeur de fichiers *.gph";
	private final static String[]	TITRES_TABLEAU	= { "Numero", "Nb atomes", "Nb liaisons", "Classe", "Frequece",
			"Toxicite", "Emergence"				};

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private JLabel					titre;
	private JScrollPane				scroll;

	private JTable					tableauGPH;
	private ModeleTablesEditeurs	modele;

	private GPHFile				gphFile;;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public EditeurGPH(GPHFile gphFile)
	{
		this.gphFile = gphFile;
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
		try{
			gphFile.initParseur();
		}
		catch(Exception e){}
	}

	private void initModeleEtTable()
	{
		try{
			modele = new ModeleTablesEditeurs(TITRES_TABLEAU, gphFile.getParseurGPH().convertirListeVersTableau2D());
			tableauGPH = new JTable(modele);
		}
		catch (Exception e){}
	}

	private void initScroll()
	{
		remove(titre);
		setLayout(new BorderLayout());

		scroll = new JScrollPane(tableauGPH);
		scroll.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));

		add(scroll, BorderLayout.CENTER);
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public JLabel getTitre()
	{
		return titre;
	}

	public JScrollPane getScroll()
	{
		return scroll;
	}

	public JTable getTableauGPH()
	{
		return tableauGPH;
	}

	public ModeleTablesEditeurs getModele()
	{
		return modele;
	}

	public GPHFile getGphFile()
	{
		return gphFile;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setTitre(JLabel titre)
	{
		this.titre = titre;
	}

	public void setScroll(JScrollPane scroll)
	{
		this.scroll = scroll;
	}

	public void setTableauGPH(JTable tableauGPH)
	{
		this.tableauGPH = tableauGPH;
	}

	public void setModele(ModeleTablesEditeurs modele)
	{
		this.modele = modele;
	}

	public void setGphFile(GPHFile file)
	{
		this.gphFile = file;
	}

}
