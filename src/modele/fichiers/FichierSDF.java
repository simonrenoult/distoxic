package modele.fichiers;

import modele.enregistreurs.EnregistreurSDF;
import modele.fichiersTmp.FichierSdfTmp;
import modele.parseurs.ParseurSDF;

public class FichierSDF implements InitFichier
{
	/**
	 * <h4>FichierSDF est la classe principale d'une ressource pour un fichier SDF</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	/**
	 * Parseur SDF afin de recuperer les donnees pour les inserer dans le tableau graphique SDF.
	 * @see ParseurSDF
	 */
	private ParseurSDF		parseurSDF		= null;
	/**
	 * Permet l'enregistrement d'une source de donnees SDF (liste provenant de FichierSdfTmp)
	 */
	private EnregistreurSDF	enregistreurSDF	= null;
	/**
	 * Des qu'il y a modification dans le tableau graphique SDF, on modifie la source de donnees SDF (liste temporaire)
	 */
	private FichierSdfTmp fichierSdfTmp = null;
	/**
	 * Chemin absolu du fichier SDF
	 */
	private String			filePath		= null;
	private boolean			isChanged		= false;
	/**
	 * Booleen indiquant si le tablau SDF est encadre (est selectionne). 
	 */
	private boolean			isFlank			= false;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	/**
	 * Constructeur principal de la classe FichierSDF
	 * @param path le chemin absolu du fichier.sdf
	 */
	public FichierSDF(String path)
	{
		this.filePath = path;
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	@Override
	/**
	 * Methode pour instancier le parseur et le fichier temporaire. cette methode est appellee lors du double clic sur le fichier.sdf de l'arbre.
	 */
	public void initParseur()
	{
		parseurSDF = new ParseurSDF(filePath);
		fichierSdfTmp = new FichierSdfTmp(parseurSDF.getFragmentsMolecules());
	}

	@Override
	/**
	 * Methode pour instancier l'enregistreur afin de pouvoir generer le fichier.sdf_$ a partir de la liste temporaire contenu dans l'objet fichierSdfTmp.
	 */
	public void initEnregistreur()
	{
		enregistreurSDF = new EnregistreurSDF(parseurSDF.getFragmentsMolecules());
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @return the parseurSDF
	 */
	public ParseurSDF getParseurSDF()
	{
		return parseurSDF;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath()
	{
		return filePath;
	}

	/**
	 * @return the enregistreurSDF
	 */
	public EnregistreurSDF getEnregistreurSDF()
	{
		return enregistreurSDF;
	}

	/**
	 * @return the isFlank
	 */
	public boolean isFlank()
	{
		return isFlank;
	}

	/**
	 * @return the isChanged
	 */
	public boolean isChanged()
	{
		return isChanged;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @param parseurSDF
	 *            the parseurSDF to set
	 */
	public void setParseurSDF(ParseurSDF parseurSDF)
	{
		this.parseurSDF = parseurSDF;
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
	 * @param enregistreurSDF
	 *            the enregistreurSDF to set
	 */
	public void setEnregistreurSDF(EnregistreurSDF enregistreurSDF)
	{
		this.enregistreurSDF = enregistreurSDF;
	}

	/**
	 * @param isFlank
	 *            the isFlank to set
	 */
	public void setFlank(boolean isFlank)
	{
		this.isFlank = isFlank;
	}

	/**
	 * @param isChanged
	 *            the isChanged to set
	 */
	public void setChanged(boolean isChanged)
	{
		this.isChanged = isChanged;
	}

	/**
	 * @return the fichierSdfTmp
	 */
	public FichierSdfTmp getFichierSdfTmp() {
		return fichierSdfTmp;
	}

	/**
	 * @param fichierSdfTmp the fichierSdfTmp to set
	 */
	public void setFichierSdfTmp(FichierSdfTmp fichierSdfTmp) {
		this.fichierSdfTmp = fichierSdfTmp;
	}

}
