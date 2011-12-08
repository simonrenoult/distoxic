package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import vue.barreOutils.BarreOutils;
import vue.menus.BarreMenu;

@SuppressWarnings("serial")
public class FenetrePrincipale extends JFrame
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer	MAX_WIDTH	= 1024;
	public final static Integer	TAILLE_X	= (Toolkit.getDefaultToolkit().getScreenSize().width > MAX_WIDTH) ? MAX_WIDTH
													: 4 * Toolkit.getDefaultToolkit().getScreenSize().width / 5;
	public final static Integer	TAILLE_Y	= 4 * Toolkit.getDefaultToolkit().getScreenSize().height / 5;
	public final static String	TITRE		= "Dis'Toxic";
	
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //
	
	private BarreMenu			menu;
	private ConteneurGlobal		conteneurGlobal;
	private BarreOutils			barreOutils;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

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
		buildBarreOutils();
		buildConteneurGlobal();
		
		setVisible(true);
	}

	// ----------------------------------------- //
	// --------------INITIALISEURS-------------- //
	// ----------------------------------------- //

	private void buildLookAndFeel()
	{
		try
		{
			if (System.getProperty("os.name").toLowerCase().contains("linux"))
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			else if (System.getProperty("os.name").toLowerCase().contains("windows"))
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			else
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
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
	
	private void buildMenuTop()
	{
		menu = new BarreMenu();
		this.setJMenuBar(menu);
	}

	private void buildBarreOutils()
	{
		barreOutils = new BarreOutils();
		this.getContentPane().add(barreOutils, BorderLayout.NORTH);
	}

	private void buildConteneurGlobal()
	{
		conteneurGlobal = new ConteneurGlobal();
		this.getContentPane().add(conteneurGlobal, BorderLayout.CENTER);
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

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

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setMenu(BarreMenu menu)
	{
		this.menu = menu;
	}
}