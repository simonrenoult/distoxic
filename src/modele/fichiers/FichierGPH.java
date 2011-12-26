package src.modele.fichiers;

import src.modele.enregistreurs.EnregistreurGPH;
import src.modele.fichiersTmp.FichierGphTmp;
import src.modele.parseurs.ParseurGPH;

public class FichierGPH implements InitFichier
{
	/**
	 * <h4>FichierGPH est la classe principale d'une ressource pour un fichier GPH</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	
	/**
	 * Parseur GPH afin de recuperer les donnees pour les inserer dans le tableau graphique GPH.
	 * @see ParseurGPH
	 */
	private ParseurGPH		parseurGPH;
	/**
	 * Permet l'enregistrement d'une source de donnees GPH (liste provenant de FichierGphTmp)
	 */
	private EnregistreurGPH	enregistreurGPH;
	/**
	 * Des qu'il y a modification dans le tableau graphique GPH, on modifie la source de donnees GPH (liste temporaire)
	 */
	private FichierGphTmp fichierGphTmp = null;
	/**
	 * Chemin absolu du fichier GPH
	 */
	private String			filePath;
	private boolean isChanged = false;
	/**
	 * Booleen indiquant si le tablau GPH est encadre (est selectionne).
	 */
	private boolean isFlank = false;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	/**
	 * Constructeur principal de la classe FichierGPH
	 * @param path le chemin absolu du fichier.gph
	 */
	public FichierGPH(String path)
	{
		this.filePath = path;
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	@Override
	/**
	 * Methode pour instancier le parseur et le fichier temporaire. cette methode est appellee lors du double clic sur le fichier.gph de l'arbre.
	 */
	public void initParseur()
	{
		parseurGPH = new ParseurGPH(filePath);
		fichierGphTmp = new FichierGphTmp(parseurGPH.getListeGPH());
	}

	@Override
	/**
	 * Methode pour instancier l'enregistreur afin de pouvoir generer le fichier.gph_$ a partir de la liste temporaire contenu dans l'objet fichierGphTmp.
	 */
	public void initEnregistreur()
	{
		enregistreurGPH = new EnregistreurGPH();
	}
	
	

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @return the parseurGPH
	 */
	public ParseurGPH getParseurGPH()
	{
		return parseurGPH;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath()
	{
		return filePath;
	}

	/**
	 * @return the enregistreurGPH
	 */
	public EnregistreurGPH getEnregistreurGPH()
	{
		return enregistreurGPH;
	}
	
	/**
	 * @return the isFlank
	 */
	public boolean isFlank() {
		return isFlank;
	}
	/**
	 * @return the isChanged
	 */
	public boolean isChanged() {
		return isChanged;
	}
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @param parseurGPH
	 *            the parseurGPH to set
	 */
	public void setParseurGPH(ParseurGPH parseurGPH)
	{
		this.parseurGPH = parseurGPH;
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
	 * @param enregistreurGPH
	 *            the enregistreurGPH to set
	 */
	public void setEnregistreurGPH(EnregistreurGPH enregistreurGPH)
	{
		this.enregistreurGPH = enregistreurGPH;
	}

	

	/**
	 * @param isFlank the isFlank to set
	 */
	public void setFlank(boolean isFlank) {
		this.isFlank = isFlank;
	}

	

	/**
	 * @param isChanged the isChanged to set
	 */
	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}

	/**
	 * @return the fichierGphTmp
	 */
	public FichierGphTmp getFichierGphTmp() {
		return fichierGphTmp;
	}

	/**
	 * @param fichierGphTmp the fichierGphTmp to set
	 */
	public void setFichierGphTmp(FichierGphTmp fichierGphTmp) {
		this.fichierGphTmp = fichierGphTmp;
	}

}
