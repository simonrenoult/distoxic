package modele;

import java.io.File;
import java.io.IOException;

import modele.fichiers.FichierBIN;
import modele.fichiers.FichierGPH;
import modele.fichiers.FichierSDF;


public class TripletFichier
{
	/**
	 * <h4>TripletFichier est la classe (modele) ou sont associes les trois type de fichiers : SDF, BIN et GPH.</h4>
	 * 
	 * <p>
	 * Remarque : Chaque fichier appartient au même projet, cette classe sert de modele quant à la création d'onglet.<br>
	 * De plus, Chaque modele de Jtable fera reference aux donnees comprises dans chaque fichier : 
	 * <ul>
	 * <li>FichierBIN</li>
	 * <li>FichierGPH</li>
	 * <li>FichierSDF</li>
	 * </ul>
	 * </p>
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * Contantes regoupant les extensions acceptees par cette classe.
	 */
	private static String	extensionGPH	= ".gph";
	private static String	extensionBIN	= ".bin";
	private static String	extensionSDF	= ".sdf";

	/**
	 * Chaque type de Fichier$$$ sera la source pour parser, enregistrer, recuperer/editer des donnes concerant les tableaux graphiques.
	 * @see FichierBIN
	 * @see FichierGPH
	 * @see FichierSDF
	 */
	private FichierBIN		binFile			= null;
	private FichierGPH		gphFile			= null;
	private FichierSDF		sdfFile			= null;

	/**
	 * Chemin absolu des trois fichiers BIN, GPH et SDF.
	 */
	private String			BINPath			= null;
	private String			GPHPath			= null;
	private String			SDFPath			= null;

	/**
	 * Chemin absolu du repertoire dans lequel sont stockes les trois fichiers BIN, GPH et SDF.
	 */
	private String			DirectoryPath	= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur prenant les trois chemins de fichiers (sdf,bin et gph). On cree
	 * alors a partir de ces trois chemins, trois objets associes a l'extension.
	 * 
	 * @param Path1
	 * @param Path2
	 * @param Path3
	 */
	public TripletFichier(String Path1, String Path2, String Path3)
	{
		initFile(Path1);
		initFile(Path2);
		initFile(Path3);
	}

	/**
	 * Constructeur prenant deux chemins de fichiers parmis les formats sdf,bin et
	 * gph. On cree alors a partir de ces deux chemins, deux objets associes
	 * a l'extension.
	 * 
	 * @param Path1
	 * @param Path2
	 */
	public TripletFichier(String Path1, String Path2)
	{
		initFile(Path1);
		initFile(Path2);
	}

	/**
	 * Constructeur prenant un chemin de fichier parmis les formats sdf,bin et
	 * gph. On cree alors a partir de ce chemin, l'objet associe a
	 * l'extension.
	 * 
	 * @param Path1
	 */
	public TripletFichier(String Path1)
	{
		initFile(Path1);
	}
	
	public TripletFichier()
	{
		
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	/**
	 * Methode d'instance d'un objet BIN, SDF ou GPH selon l'extension du path.
	 * 
	 * @param path
	 */
	private void initFile(String path)
	{
		if (path.endsWith(extensionBIN))
		{
			BINPath = path;
			DirectoryPath = mkDirectoryPath(path);
			BINinit();
		}
		else if (path.endsWith(extensionGPH))
		{
			GPHPath = path;
			DirectoryPath = mkDirectoryPath(path);
			GPHinit();
		}
		else if (path.endsWith(extensionSDF))
		{
			SDFPath = path;
			DirectoryPath = mkDirectoryPath(path);
			SDFinit();
		}
		else
		{
			System.out.println("Format inconnu");
		}

	}
	/**
	 * Methode d'instance d'un objet BIN.
	 */
	private void BINinit()
	{
		binFile = new FichierBIN(BINPath);
	}
	/**
	 * Methode d'instance d'un objet GPH.
	 */
	private void GPHinit()
	{
		gphFile = new FichierGPH(GPHPath);
	}
	/**
	 * Methode d'instance d'un objet SDF.
	 */
	private void SDFinit()
	{
		sdfFile = new FichierSDF(SDFPath);
	}

	

	/**
	 * Methode recuperant le nom du dossier du projet dans lequel se trouve les 3
	 * fichiers.
	 * 
	 * @param path le chemin absolu d'un des fichiers
	 * @return le chemin absolu du dossier du projet.
	 */
	public String mkDirectoryPath(String path)
	{

		if (System.getProperty("os.name").toLowerCase().contains("linux")
				|| (System.getProperty("os.name").toLowerCase().contains("mac")))
		{
			String tab[] = path.split(File.separator);
			String projetcsName = tab[tab.length - 2];
			return projetcsName;
		}
		else if (System.getProperty("os.name").toLowerCase().contains("windows"))
		{
			// Il faut echeper le caractere \ !
			String tab[] = path.split(File.separator + File.separator);
			String projetcsName = tab[tab.length - 2];
			return projetcsName;
		}

		return "";

	}
	
	/**
	 * Methode permattant de creer un nouveau projet vierge
	 * @param directoryName le nom du dossier du projet.
	 */
	public void creerNouveauProjetVierge(String directoryName){
		String directoryPath = creerDossierViergeDansWorkspace(directoryName);
		creerFichierGPH(directoryPath+File.separator+directoryName+".gph");
		creerFichierSDF(directoryPath+File.separator+directoryName+".sdf");
		creerFichierBIN(directoryPath+File.separator+directoryName+".bin");
	}
	
	/**
	 * Methode de creation du fichier BIN lié à un répertoire donné dans le workspace
	 * @param directoryName le nom du doosier du projet
	 */
	public boolean creerFichierBIN(String path) {
		File binFile = new File(path);
		try {
			binFile.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		return true;
		
	}

	/**
	 * Methode de creation du fichier SDF lié à un répertoire donné dans le workspace
	 * @param directoryName le nom du doosier du projet
	 */
	public boolean creerFichierSDF(String path) {
		File sdfFile = new File(path);
		try {
			sdfFile.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * Methode de creation du fichier GPH lié à un répertoire donné dans le workspace
	 * @param directoryName le nom du doosier du projet
	 */
	public boolean creerFichierGPH(String path) {
		File gphFile = new File(path);
		try {
			gphFile.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Methode de creation d'un dossier dans le dossier du workspace.
	 * @param DirectoryName le nom du dossier
	 * @return le chemin absolu du dossier du projet.
	 */
	public String creerDossierViergeDansWorkspace(String DirectoryName){
		WorkspaceModele modele = new WorkspaceModele(1);
		modele.lireFichier();
		String DirectoryPath = modele.getWorkspacePath()+File.separator+DirectoryName;
		File newDossier = new File(DirectoryPath);
		newDossier.mkdir();
		return DirectoryPath;
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @param binFile
	 *            the binFile to set
	 */
	public void setBinFile(FichierBIN binFile)
	{
		this.binFile = binFile;
	}

	/**
	 * @return the gphFile
	 */
	public FichierGPH getGphFile()
	{
		return gphFile;
	}

	/**
	 * @param gphFile
	 *            the gphFile to set
	 */
	public void setGphFile(FichierGPH gphFile)
	{
		this.gphFile = gphFile;
	}

	/**
	 * @return the sdfFile
	 */
	public FichierSDF getSdfFile()
	{
		return sdfFile;
	}

	/**
	 * @param sdfFile
	 *            the sdfFile to set
	 */
	public void setSdfFile(FichierSDF sdfFile)
	{
		this.sdfFile = sdfFile;
	}

	/**
	 * @return the bINPath
	 */
	public String getBINPath()
	{
		return BINPath;
	}

	/**
	 * @param bINPath
	 *            the bINPath to set
	 */
	public void setBINPath(String bINPath)
	{
		BINPath = bINPath;
	}

	/**
	 * @return the gPHPath
	 */
	public String getGPHPath()
	{
		return GPHPath;
	}

	/**
	 * @param gPHPath
	 *            the gPHPath to set
	 */
	public void setGPHPath(String gPHPath)
	{
		GPHPath = gPHPath;
	}

	/**
	 * @return the sDFPath
	 */
	public String getSDFPath()
	{
		return SDFPath;
	}

	/**
	 * @param sDFPath
	 *            the sDFPath to set
	 */
	public void setSDFPath(String sDFPath)
	{
		SDFPath = sDFPath;
	}

	/**
	 * @return the directoryPath
	 */
	public String getDirectoryPath()
	{
		return DirectoryPath;
	}

	/**
	 * @param directoryPath
	 *            the directoryPath to set
	 */
	public void setDirectoryPath(String directoryPath)
	{
		DirectoryPath = directoryPath;
	}
	
	/**
	 * @return the binFile
	 */
	public FichierBIN getBinFile()
	{
		return binFile;
	}
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
