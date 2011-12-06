package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import vue.menus.MenuTextuel;

@SuppressWarnings("serial")
public class FenetrePrincipale extends JFrame
{
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	public static Integer	TAILLE_X	= 800;
	public static Integer	TAILLE_Y	= 600;
	public static String	TITRE		= "Dis'Toxic";

	private MenuTextuel		menu;
	private ConteneurGlobal	conteneurGlobal;
	private BarreOutils		barreOutils;
	private JPanel			contentPane;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public FenetrePrincipale()
	{
		super();
		try
		{
			if(System.getProperty("os.name").toLowerCase().contains("linux"))
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			else if(System.getProperty("os.name").toLowerCase().contains("windows"))
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

		buildMenuTop();
		buildBarOutils();
		buildConteneurGlobal();
		buildContentPane();
		buildFenetre();
	}

	// ----------------------------------------- //
	// --------------INITIALISEURS-------------- //
	// ----------------------------------------- //
	
	private void buildMenuTop()
	{
		menu = new MenuTextuel();
		this.setJMenuBar(menu);
	}
	
	private void buildBarOutils()
	{
		barreOutils = new BarreOutils();
	}
	
	private void buildConteneurGlobal()
	{
		conteneurGlobal = new ConteneurGlobal();
	}

	private void buildFenetre()
	{
		this.setTitle(TITRE);
		this.setSize(TAILLE_X, TAILLE_Y);
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void buildContentPane()
	{
		contentPane = new JPanel(new BorderLayout());
		contentPane.add(barreOutils, BorderLayout.NORTH);
		contentPane.add(conteneurGlobal, BorderLayout.CENTER);
		this.getContentPane().add(contentPane);
	}
	
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	public void displayLF()
	{
		UIManager.LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();

		for (int i = 0; i < info.length; i++)
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

	public MenuTextuel getMenu()
	{
		return menu;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setLookAndFeel(String LF)
	{
		try
		{
			UIManager.setLookAndFeel(LF);
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

	public void setMenu(MenuTextuel menu)
	{
		this.menu = menu;
	}
}