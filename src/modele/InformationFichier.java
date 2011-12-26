package src.modele;

public class InformationFichier
{
	/**
	 * <h4>InformationFichier est la classe qui aide a la selection d'un fichier dans l'arbre de selection du programme.</h4>
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	/**
	 * Type de fichier : fichier, repertoire, etc.
	 */
	private String	fileType	= null;
	/**
	 * Chemin absolu du fichier
	 */
	private String	filePath	= null;
	/**
	 * Libelle graphique pour ce fichier.
	 */
	private String	fileTitle	= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	/**
	 * Constructeur principal de la classe InformationFichier
	 * @param type type du fichier
	 * @param path le chemin absolu du fichier
	 * @param title le libelle associe au fichier
	 */
	public InformationFichier(String type, String path, String title)
	{
		this.fileType = type;
		this.filePath = path;
		this.fileTitle = title;
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	/**
	 * Methode retournant le libelle lie au fichier. Methode par defaut utilisee par l'objet de type Jtree.
	 * @return le libelle lie au fichier.
	 */
	public String toString()
	{
		return fileTitle;
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	/**
	 * @return the fileType
	 */
	public String getFileType()
	{
		return fileType;
	}

	/**
	 * @param fileType
	 *            the fileType to set
	 */
	public void setFileType(String fileType)
	{
		this.fileType = fileType;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath()
	{
		return filePath;
	}

	/**
	 * @param filePath
	 *            the filePath to set
	 */
	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}

	/**
	 * @return the fileTitle
	 */
	public String getFileTitle()
	{
		return fileTitle;
	}

	/**
	 * @param fileTitle
	 *            the fileTitle to set
	 */
	public void setFileTitle(String fileTitle)
	{
		this.fileTitle = fileTitle;
	}

}
