package src.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


import src.controleur.EcouteurBarreOutils;
import src.controleur.menu.EcouteurBarreMenu;
import src.vue.barreOutils.BarreOutils;
import src.vue.menus.BarreMenu;

@SuppressWarnings("serial")
public class FenetrePrincipale extends JFrame
{
	/**
	 * <h4>FenetrePrincipale est la classe permettant de decrire la fenetre principale du programme.</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //
	/**
	 * Constantes de classe
	 */
	public final static Integer	MAX_WIDTH	= 1024;
	public final static Integer	TAILLE_X	= (Toolkit.getDefaultToolkit().getScreenSize().width > MAX_WIDTH) ? MAX_WIDTH
													: 4 * Toolkit.getDefaultToolkit().getScreenSize().width / 5;
	public final static Integer	TAILLE_Y	= 4 * Toolkit.getDefaultToolkit().getScreenSize().height / 5;
	public final static String	TITRE		= "Dis'Toxic";
	
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //
	/**
	 * Menu de l'application
	 * @see BarreMenu
	 */
	private BarreMenu			menu;
	/**
	 * Barre d'outil de l'application
	 * @see BarreOutils
	 */
	private BarreOutils			barreOutils;
	/**
	 * Conteneur principal de la fentre
	 * @see ConteneurGlobal
	 */
	private ConteneurGlobal		conteneurGlobal;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la fenetre principal
	 */
	public FenetrePrincipale()
	{
		super();		
		
		buildLookAndFeel();

		setTitle(TITRE);
		setSize(TAILLE_X, TAILLE_Y);
		setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setLayout(new BorderLayout());
		
		buildMenuTop();
		buildConteneurGlobal();
		buildBarreOutils();
		
		
		setVisible(true);
	}

	// ----------------------------------------- //
	// --------------INITIALISEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Utilisation d'un look & feel 
	 */
	private void buildLookAndFeel()
	{
		try
		{
			if (System.getProperty("os.name").toLowerCase().contains("linux"))
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			else if (System.getProperty("os.name").toLowerCase().contains("windows"))
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			else
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	/**
	 * Creation du menu
	 */
	private void buildMenuTop()
	{
		menu = new BarreMenu();
		this.setJMenuBar(menu);
		EcouteurBarreMenu e = new EcouteurBarreMenu(this);
	}
	
	/**
	 * Creation du conteneur principal
	 */
	private void buildConteneurGlobal()
	{
		conteneurGlobal = new ConteneurGlobal();
		this.getContentPane().add(conteneurGlobal, BorderLayout.CENTER);
	}
	
	@SuppressWarnings("unused")
	/**
	 * Creation de la barre d'outil
	 */
	private void buildBarreOutils()
	{
		barreOutils = new BarreOutils();
		EcouteurBarreOutils e = new EcouteurBarreOutils(this);
		this.getContentPane().add(barreOutils, BorderLayout.NORTH);
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	/**
	 * Affichage console du look & feel utilise
	 */
	public void displayLF()
	{
		UIManager.LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();

		for (int i = 0 ; i < info.length ; i++)
		{
			String nomLF = info[i].getName();
			String nomClasse = info[i].getClassName();
			System.out.println("NOM : " + nomLF);
			System.out.println('\t' + "CLASSE : " + nomClasse);
		}
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public BarreMenu getMenu()
	{
		return menu;
	}
	/**
	 * @return the conteneurGlobal
	 */
	public ConteneurGlobal getConteneurGlobal() {
		return conteneurGlobal;
	}
	/**
	 * @return the barreOutils
	 */
	public BarreOutils getBarreOutils() {
		return barreOutils;
	}
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setMenu(BarreMenu menu)
	{
		this.menu = menu;
	}

	/**
	 * @param conteneurGlobal the conteneurGlobal to set
	 */
	public void setConteneurGlobal(ConteneurGlobal conteneurGlobal) {
		this.conteneurGlobal = conteneurGlobal;
	}

	/**
	 * @param barreOutils the barreOutils to set
	 */
	public void setBarreOutils(BarreOutils barreOutils) {
		this.barreOutils = barreOutils;
	}
}