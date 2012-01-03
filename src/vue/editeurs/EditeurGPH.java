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
import modele.fichiers.FichierGPH;

@SuppressWarnings("serial")
public class EditeurGPH extends JPanel
{
	/**
	 * <h4>EditeurGPH est la classe regroupant l'environement graphique du
	 * tableau GPH</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer		TAILLE_X		= 3 * Editeurs.TAILLE_X / 5;
	public final static Integer		TAILLE_Y		= 3 * Editeurs.TAILLE_Y / 5;

	public final static Color		BG_COLOR		= Color.WHITE;

	private final static String		TITRE			= "Editeur de fichiers *.gph";
	private final static String[]	TITRES_TABLEAU	= { "IndFrag", "Nb atomes", "Nb liaisons", "IndTox", "Frequence",
			"Toxicite", "Emergence"				};

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private JLabel					titre;
	private JScrollPane				scroll;
	/**
	 * Tableau graphique
	 */
	private TablesEditeurs			tableauGPH;
	/**
	 * Modele du tabelau
	 * 
	 * @see ModeleTablesEditeurs
	 */
	private ModeleTablesEditeurs	modele;
	/**
	 * Classe de reference pour les donnees contenus dans le tableau BIN
	 * 
	 * @see FichierGPH
	 */
	private FichierGPH				fichierGPH;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe EditeurGPH
	 * 
	 * @param gphFile
	 *            le modele de fichier GPH
	 */
	public EditeurGPH(FichierGPH gphFile)
	{
		this.fichierGPH = gphFile;
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

	/**
	 * Methode d'initialisation du titres.
	 */
	private void initTitre()
	{
		setLayout(new FlowLayout());

		titre = new JLabel(TITRE);

		add(titre);
	}

	/**
	 * Methode d'initialisation du parseur GPH
	 */
	private void initParseur()
	{
		try
		{
			fichierGPH.initParseur();
		}
		catch (NullPointerException e)
		{
			System.out.println("Tentative d'initialisation du parseur GPH avortée.");
		}
	}

	/**
	 * Methode d'initialisation du tableau graphique GPH
	 */
	private void initModeleEtTable()
	{
		try
		{
			modele = new ModeleTablesEditeurs(TITRES_TABLEAU, fichierGPH.getParseurGPH().convertirListeVersTableau2D(),
					0);
			tableauGPH = new TablesEditeurs(modele);
			tableauGPH.setAutoCreateRowSorter(true);
			tableauGPH.getTableHeader().setReorderingAllowed(false);
		}
		catch (NullPointerException e)
		{
			System.out.println("Tentative d'initialisation du modèle de parseur GPH avortée.");
		}
	}

	/**
	 * Mis en Scroll du tableau graphique
	 */
	private void initScroll()
	{
		remove(titre);
		setLayout(new BorderLayout());
		scroll = new JScrollPane(tableauGPH);
		scroll.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));

		add(scroll, BorderLayout.CENTER);
	}

	/**
	 * Ecoute du tableau graphique
	 */
	private void initEcouteur()
	{
		try
		{
			@SuppressWarnings("unused")
			EcouteurJtable e = new EcouteurJtable(tableauGPH, null, fichierGPH, null);
		}
		catch (NullPointerException e)
		{
		}

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

	public TablesEditeurs getTableauGPH()
	{
		return tableauGPH;
	}

	public ModeleTablesEditeurs getModele()
	{
		return modele;
	}

	public FichierGPH getGphFile()
	{
		return fichierGPH;
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

	public void setTableauGPH(TablesEditeurs tableauGPH)
	{
		this.tableauGPH = tableauGPH;
	}

	public void setModele(ModeleTablesEditeurs modele)
	{
		this.modele = modele;
	}

	public void setGphFile(FichierGPH file)
	{
		this.fichierGPH = file;
	}

}
