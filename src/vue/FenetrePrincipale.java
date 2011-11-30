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
	public static String	TITRE		= "Dis'toxic";

	private MenuTextuel		menu;
	private ConteneurGlobal	conteneurGlobal;
	private BarOutils		barOutils;
	private JPanel			contentPane;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public FenetrePrincipale()
	{
		super();
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (ClassNotFoundException e)
		{

		}
		catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (UnsupportedLookAndFeelException e)
		{
			try
			{
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			}
			catch (ClassNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (InstantiationException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (IllegalAccessException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (UnsupportedLookAndFeelException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		buildMenuTop();
		buildBarOutils();
		buildConteneurGlobal();
		buildContentPane();
		buildContentPane();
		buildFenetre();
		this.pack();
	}

	// ----------------------------------------- //
	// --------------INITIALISEURS-------------- //
	// ----------------------------------------- //

	private void buildContentPane()
	{
		contentPane = new JPanel(new BorderLayout());
		contentPane.add(barOutils, BorderLayout.NORTH);
		contentPane.add(conteneurGlobal, BorderLayout.CENTER);
		this.getContentPane().add(contentPane);
	}

	private void buildBarOutils()
	{
		barOutils = new BarOutils();
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

	private void buildMenuTop()
	{
		menu = new MenuTextuel();
		this.setJMenuBar(menu);
	}

	private void buildConteneurGlobal()
	{
		conteneurGlobal = new ConteneurGlobal();
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