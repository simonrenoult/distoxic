package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controleur.EcouteurFenetreExportationTripletFichier;

@SuppressWarnings("serial")
public class FenetreExportationTripletFichier extends JFrame
{

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	public static Integer		TAILLE_X					= 500;
	public static Integer		TAILLE_Y					= 250;
	public static String		TITRE						= "Export project";

	private FenetrePrincipale	fenetrePrincipale;

	private JPanel				containerPrincipal			= new JPanel();
	private JPanel				containerInformation		= new JPanel();
	private JPanel				containerSelectionArchive	= new JPanel();
	private JLabel				iconeInformation			= new JLabel(new ImageIcon(getClass().getResource(
																	"/images/icones/folder_explore.png")));
	private JLabel				message						= new JLabel(
																	"Sélectionnez un répertoire dans lequel exporter le projet Dis'Toxic.");
	private JRadioButton		exporterArchive				= new JRadioButton("Exporter vers une archive .zip.");
	private JRadioButton		exporterDossier				= new JRadioButton("Exporter vers un repertoire    ");
	private ButtonGroup			groupeBouton				= new ButtonGroup();
	private JButton				archiveBouton				= new JButton("Enregistrer");
	private JButton				dossierBouton				= new JButton("Enregistrer");

	private String				projectName;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	public FenetreExportationTripletFichier(FenetrePrincipale fenetrePrincipale, String projectPath)
	{
		this.fenetrePrincipale = fenetrePrincipale;
		this.projectName = projectPath;
		init();

		this.setTitle(TITRE);
		this.setSize(new Dimension(TAILLE_X, TAILLE_Y));
		// this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	public void init()
	{
		buildContainerInformation();
		buildContainerSelectionArchive();
		buildContainerPrincipal();
		initEcouteur();
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	@SuppressWarnings("unused")
	private void initEcouteur()
	{
		EcouteurFenetreExportationTripletFichier e = new EcouteurFenetreExportationTripletFichier(this);
	}

	private void buildContainerInformation()
	{
		containerInformation.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y / 4));
		containerInformation.add(iconeInformation);
		containerInformation.add(message);
		containerInformation.setBackground(new Color(220, 228, 254));
	}

	private void buildContainerSelectionArchive()
	{
		groupeBouton.add(archiveBouton);
		groupeBouton.add(dossierBouton);

		JPanel archive = new JPanel();
		archive.add(exporterArchive);
		archive.add(archiveBouton);
		// archive.setBackground(Color.blue);

		JPanel dossier = new JPanel();
		dossier.add(exporterDossier);
		dossier.add(dossierBouton);
		// dossier.setBackground(Color.red);

		containerSelectionArchive.setPreferredSize(new Dimension(TAILLE_X, (TAILLE_Y / 3) * 2));
		containerSelectionArchive.add(archive, BorderLayout.NORTH);
		containerSelectionArchive.add(dossier, BorderLayout.SOUTH);

	}

	private void buildContainerPrincipal()
	{
		containerPrincipal.add(containerInformation);
		containerPrincipal.add(containerSelectionArchive);
		this.setContentPane(containerPrincipal);

	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
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
	 * @return the containerSelectionArchive
	 */
	public JPanel getContainerSelectionArchive()
	{
		return containerSelectionArchive;
	}

	/**
	 * @param containerSelectionArchive
	 *            the containerSelectionArchive to set
	 */
	public void setContainerSelectionArchive(JPanel containerSelectionArchive)
	{
		this.containerSelectionArchive = containerSelectionArchive;
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
	 * @return the message
	 */
	public JLabel getMessage()
	{
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(JLabel message)
	{
		this.message = message;
	}

	/**
	 * @return the impoterArchive
	 */
	public JRadioButton getExporterArchive()
	{
		return exporterArchive;
	}

	/**
	 * @param impoterArchive
	 *            the impoterArchive to set
	 */
	public void setExporterrchive(JRadioButton exporterArchive)
	{
		this.exporterArchive = exporterArchive;
	}

	/**
	 * @return the impoterDossier
	 */
	public JRadioButton getExporterDossier()
	{
		return exporterDossier;
	}

	/**
	 * @param impoterDossier
	 *            the impoterDossier to set
	 */
	public void setExporterDossier(JRadioButton exporterDossier)
	{
		this.exporterDossier = exporterDossier;
	}

	/**
	 * @return the groupeBouton
	 */
	public ButtonGroup getGroupeBouton()
	{
		return groupeBouton;
	}

	/**
	 * @param groupeBouton
	 *            the groupeBouton to set
	 */
	public void setGroupeBouton(ButtonGroup groupeBouton)
	{
		this.groupeBouton = groupeBouton;
	}

	/**
	 * @return the archiveBouton
	 */
	public JButton getArchiveBouton()
	{
		return archiveBouton;
	}

	/**
	 * @param archiveBouton
	 *            the archiveBouton to set
	 */
	public void setArchiveBouton(JButton archiveBouton)
	{
		this.archiveBouton = archiveBouton;
	}

	/**
	 * @return the dossierBouton
	 */
	public JButton getDossierBouton()
	{
		return dossierBouton;
	}

	/**
	 * @param dossierBouton
	 *            the dossierBouton to set
	 */
	public void setDossierBouton(JButton dossierBouton)
	{
		this.dossierBouton = dossierBouton;
	}

	/**
	 * @return the fenetrePrincipale
	 */
	public FenetrePrincipale getFenetrePrincipale()
	{
		return fenetrePrincipale;
	}

	/**
	 * @param fenetrePrincipale
	 *            the fenetrePrincipale to set
	 */
	public void setFenetrePrincipale(FenetrePrincipale fenetrePrincipale)
	{
		this.fenetrePrincipale = fenetrePrincipale;
	}

	/**
	 * @return the projectPath
	 */
	public String getProjectName()
	{
		return projectName;
	}

	/**
	 * @param projectPath
	 *            the projectPath to set
	 */
	public void setProjectName(String projectPath)
	{
		this.projectName = projectPath;
	}

	/**
	 * @param exporterArchive
	 *            the exporterArchive to set
	 */
	public void setExporterArchive(JRadioButton exporterArchive)
	{
		this.exporterArchive = exporterArchive;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
