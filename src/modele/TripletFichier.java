package src.modele;

import java.io.File;
import java.io.IOException;

import src.modele.fichiers.FichierBIN;
import src.modele.fichiers.FichierGPH;
import src.modele.fichiers.FichierSDF;


/**
 * 
 * Cette classe regroupe les 3 types de fichiers sous forme de tableaux d'objet
 * qui permet de remplir le modele des JTable. Cette classe sera aussi utilis�
 * pour l'export et l'import d'archive .zip (contenant les 3 fichiers).
 * 
 * 
 */
public class TripletFichier
{
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private static String	extensionGPH	= ".gph";
	private static String	extensionBIN	= ".bin";
	private static String	extensionSDF	= ".sdf";

	/*
	 * On utilise ces fichiers pour remplir les JTable d'un onglet.
	 */
	private FichierBIN		binFile			= null;
	private FichierGPH		gphFile			= null;
	private FichierSDF		sdfFile			= null;

	private String			BINPath			= null;
	private String			GPHPath			= null;
	private String			SDFPath			= null;

	private String			DirectoryPath	= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur prenant les 3 chemins de fichiers (sdf,bin et gph). On cree
	 * alors a partir de ces 3 chemins, 3 objets associes a l'extension.
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
	 * Constructeur prenant 2 chemins de fichiers parmis les formats sdf,bin et
	 * gph. On cr�� alors � partir de ces 2 chemins, 2 objets associ�s
	 * � l'extension.
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
	 * Constructeur prenant 1 chemin de fichier parmis les formats sdf,bin et
	 * gph. On cr�� alors � partir de ce 1 chemins, l'objet associ� �
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
	 * On instancie un objet BIN, SDF ou GPH selon l'extension du path.
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

	private void BINinit()
	{
		binFile = new FichierBIN(BINPath);
	}

	private void GPHinit()
	{
		gphFile = new FichierGPH(GPHPath);
	}

	private void SDFinit()
	{
		sdfFile = new FichierSDF(SDFPath);
	}

	/**
	 * @return the binFile
	 */
	public FichierBIN getBinFile()
	{
		return binFile;
	}

	/**
	 * On recupere le nom du dossier du projet dans lequel se trouve les 3
	 * fichiers.
	 * 
	 * @param path
	 * @return
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
	
	public void creerNouveauProjetVierge(String directoryName){
		String directoryPath = creerDossierViergeDansWorkspace(directoryName);
		creerFichierGPH(directoryPath+File.separator+directoryName+".gph");
		creerFichierSDF(directoryPath+File.separator+directoryName+".sdf");
		creerFichierBIN(directoryPath+File.separator+directoryName+".bin");
	}
	
	/**
	 * Creation du fichier BIN lié à un répertoire donné dans le workspace
	 * @param directoryName
	 */
	private boolean creerFichierBIN(String path) {
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
	 * Creation du fichier SDF lié à un répertoire donné dans le workspace
	 * @param directoryName
	 */
	private boolean creerFichierSDF(String path) {
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
	 * Creation du fichier GPH lié à un répertoire donné dans le workspace
	 * @param directoryName
	 */
	private boolean creerFichierGPH(String path) {
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
	 * Creation d'un dossier dans le dossier du workspace.
	 * @param DirectoryName
	 * @return
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
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
