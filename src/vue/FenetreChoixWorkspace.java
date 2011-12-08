package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import modele.WorkspaceModele;

@SuppressWarnings("serial")
public class FenetreChoixWorkspace extends JFrame
{

	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public static Integer	TAILLE_X					= 600;
	public static Integer	TAILLE_Y					= 200;

	public static String	TITRE						= "Selection du Workspace";

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private WorkspaceModele	modeleWorkspace				= null;

	private JPanel			containerPrincipal			= new JPanel();
	private JPanel			containerInformation		= new JPanel();
	private JPanel			containerSelectionWorkspace	= new JPanel();

	private JLabel			iconeInformation			= new JLabel(new ImageIcon(
																"src/images/icones/folder_explore.png"));
	private JLabel			message1					= new JLabel(
																"Dis'Toxic sauvegarde vos projets dans un dossier nomm� DisToxicProjects.");
	private JLabel			message2					= new JLabel(
																"Choisissez le chemin de destination du dossier pour utiliser ce logiciel.");
	private JLabel			workspaceLabel				= new JLabel("Workspace");

	private JTextField		PathWorkspaceTextField		= new JTextField("");

	private JButton			selection					= new JButton("S�lectionner");
	private JButton			valider						= new JButton("Valider");
	private JButton			annuler						= new JButton("Annuler");

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	public FenetreChoixWorkspace(WorkspaceModele modele)
	{
		this.modeleWorkspace = modele;
		
		init();

		this.setTitle(TITRE);
		this.setSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	public void init()
	{
		buildLookAndFeel();
		buildContainerInformation();
		buildContainerSelectionChemin();
		buildContainerPrincipal();
		// initEcouteur();
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
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
	
	/*
	 * private void initEcouteur() { EcouteurFenetreWorkspace e = new
	 * EcouteurFenetreWorkspace(this);
	 * 
	 * }
	 */

	/**
	 * Creation du panneau d'information de la fenetre.
	 */
	private void buildContainerInformation()
	{
		containerInformation.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y / 3));
		containerInformation.add(iconeInformation);
		containerInformation.add(message1);
		containerInformation.add(message2);
	}

	/**
	 * Creation du panneau de selection du chemin pour le 'workspace' et pour le
	 * bouton valider.
	 */
	private void buildContainerSelectionChemin()
	{
		PathWorkspaceTextField.setPreferredSize(new Dimension(TAILLE_X / 2, 30));
		JPanel selectionWorkspacePath = new JPanel();
		selectionWorkspacePath.setPreferredSize(new Dimension(TAILLE_X,
				(TAILLE_Y - containerInformation.getHeight()) / 4));
		selectionWorkspacePath.add(workspaceLabel);
		selectionWorkspacePath.add(PathWorkspaceTextField);
		selectionWorkspacePath.add(selection);

		containerSelectionWorkspace.setPreferredSize(new Dimension(TAILLE_X, (TAILLE_Y / 3) * 2));
		containerSelectionWorkspace.add(selectionWorkspacePath, BorderLayout.NORTH);
		containerSelectionWorkspace.add(valider, BorderLayout.SOUTH);
		containerSelectionWorkspace.add(annuler, BorderLayout.SOUTH);

	}

	/**
	 * Creation de panneau principal � la fenetre.
	 */
	private void buildContainerPrincipal()
	{
		containerPrincipal.add(containerInformation);
		containerPrincipal.add(containerSelectionWorkspace);
		this.setContentPane(containerPrincipal);

	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	/**
	 * @return the tITRE
	 */
	public static String getTITRE()
	{
		return TITRE;
	}

	/**
	 * @param tITRE
	 *            the tITRE to set
	 */
	public static void setTITRE(String tITRE)
	{
		TITRE = tITRE;
	}

	/**
	 * @return the containerPrincipal
	 */
	public JPanel getContainerPrincipal()
	{
		return containerPrincipal;
	}

	/**
	 * @param containerPrincipal
	 *            the containerPrincipal to set
	 */
	public void setContainerPrincipal(JPanel containerPrincipal)
	{
		this.containerPrincipal = containerPrincipal;
	}

	/**
	 * @return the containerInformation
	 */
	public JPanel getContainerInformation()
	{
		return containerInformation;
	}

	/**
	 * @param containerInformation
	 *            the containerInformation to set
	 */
	public void setContainerInformation(JPanel containerInformation)
	{
		this.containerInformation = containerInformation;
	}

	/**
	 * @return the containerSelectionWorkspace
	 */
	public JPanel getContainerSelectionWorkspace()
	{
		return containerSelectionWorkspace;
	}

	/**
	 * @param containerSelectionWorkspace
	 *            the containerSelectionWorkspace to set
	 */
	public void setContainerSelectionWorkspace(JPanel containerSelectionWorkspace)
	{
		this.containerSelectionWorkspace = containerSelectionWorkspace;
	}

	/**
	 * @return the iconeInformation
	 */
	public JLabel getIconeInformation()
	{
		return iconeInformation;
	}

	/**
	 * @param iconeInformation
	 *            the iconeInformation to set
	 */
	public void setIconeInformation(JLabel iconeInformation)
	{
		this.iconeInformation = iconeInformation;
	}

	/**
	 * @return the message1
	 */
	public JLabel getMessage1()
	{
		return message1;
	}

	/**
	 * @param message1
	 *            the message1 to set
	 */
	public void setMessage1(JLabel message1)
	{
		this.message1 = message1;
	}

	/**
	 * @return the message2
	 */
	public JLabel getMessage2()
	{
		return message2;
	}

	/**
	 * @param message2
	 *            the message2 to set
	 */
	public void setMessage2(JLabel message2)
	{
		this.message2 = message2;
	}

	/**
	 * @return the workspaceLabel
	 */
	public JLabel getWorkspaceLabel()
	{
		return workspaceLabel;
	}

	/**
	 * @param workspaceLabel
	 *            the workspaceLabel to set
	 */
	public void setWorkspaceLabel(JLabel workspaceLabel)
	{
		this.workspaceLabel = workspaceLabel;
	}

	/**
	 * @return the pathWorkspaceTextField
	 */
	public JTextField getPathWorkspaceTextField()
	{
		return PathWorkspaceTextField;
	}

	/**
	 * @param pathWorkspaceTextField
	 *            the pathWorkspaceTextField to set
	 */
	public void setPathWorkspaceTextField(JTextField pathWorkspaceTextField)
	{
		PathWorkspaceTextField = pathWorkspaceTextField;
	}

	/**
	 * @return the selection
	 */
	public JButton getSelection()
	{
		return selection;
	}

	/**
	 * @param selection
	 *            the selection to set
	 */
	public void setSelection(JButton selection)
	{
		this.selection = selection;
	}

	/**
	 * @return the valider
	 */
	public JButton getValider()
	{
		return valider;
	}

	/**
	 * @param valider
	 *            the valider to set
	 */
	public void setValider(JButton valider)
	{
		this.valider = valider;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	/**
	 * @return the modeleWorkspace
	 */
	public WorkspaceModele getModeleWorkspace()
	{
		return modeleWorkspace;
	}

	/**
	 * @param modeleWorkspace
	 *            the modeleWorkspace to set
	 */
	public void setModeleWorkspace(WorkspaceModele modeleWorkspace)
	{
		this.modeleWorkspace = modeleWorkspace;
	}

	/**
	 * @return the annuler
	 */
	public JButton getAnnuler()
	{
		return annuler;
	}

	/**
	 * @param annuler
	 *            the annuler to set
	 */
	public void setAnnuler(JButton annuler)
	{
		this.annuler = annuler;
	}
}
