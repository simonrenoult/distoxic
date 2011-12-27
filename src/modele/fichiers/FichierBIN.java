package modele.fichiers;

import modele.enregistreurs.EnregistreurBIN;
import modele.fichiersTmp.FichierBinTmp;
import modele.parseurs.ParseurBIN;

public class FichierBIN implements InitFichier
{
	/**
	 * <h4>FichierBIN est la classe principale d'une ressource pour un fichier BIN</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	
	/**
	 * Parseur BIN afin de recuperer les donnees pour les inserer dans le tableau graphique BIN.
	 * @see ParseurBIN
	 */
	private ParseurBIN		parseurBIN		= null;
	/**
	 * Permet l'enregistrement d'une source de donnees BIN (liste provenant de FichierBinTmp)
	 */
	private EnregistreurBIN	enregistreurBIN	= null;
	/**
	 * Des qu'il y a modification dans le tableau graphique BIN, on modifie la source de donnees BIN (liste temporaire)
	 */
	private FichierBinTmp	fichierBinTmp	= null;
	/**
	 * Chemin absolu du fichier BIN
	 */
	private String			filePath		= null;
	
	private boolean			isChanged		= false;
	/**
	 * Booleen indiquant si le tablau BIN est encadre (est selectionne). 
	 */
	private boolean			isFlank			= false;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe FichierBIN
	 * @param path le chemin absolu du fichier.bin
	 */
	public FichierBIN(String path)
	{
		this.filePath = path;
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	@Override
	/**
	 * Methode pour instancier le parseur et le fichier temporaire. cette methode est appellee lors du double clic sur le fichier.bin de l'arbre.
	 */
	public void initParseur()
	{
		parseurBIN = new ParseurBIN(filePath);
		fichierBinTmp = new FichierBinTmp(parseurBIN.getListeBIN());
	}

	@Override
	/**
	 * Methode pour instancier l'enregistreur afin de pouvoir generer le fichier.bin_$ a partir de la liste temporaire contenu dans l'objet fichierBinTmp.
	 */
	public void initEnregistreur()
	{
		enregistreurBIN = new EnregistreurBIN();
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @return the parseurBIN
	 */
	public ParseurBIN getParseurBIN()
	{
		return parseurBIN;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath()
	{
		return filePath;
	}

	/**
	 * @return the enregistreurBIN
	 */
	public EnregistreurBIN getEnregistreurBIN()
	{
		return enregistreurBIN;
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

	/**
	 * @return the fichierBinTmp
	 */
	public FichierBinTmp getFichierBinTmp()
	{
		return fichierBinTmp;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @param parseurBIN
	 *            the parseurBIN to set
	 */
	public void setParseurBIN(ParseurBIN parseurBIN)
	{
		this.parseurBIN = parseurBIN;
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
	 * @param enregistreurBIN
	 *            the enregistreurBIN to set
	 */
	public void setEnregistreurBIN(EnregistreurBIN enregistreurBIN)
	{
		this.enregistreurBIN = enregistreurBIN;
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
	 * @param fichierBinTmp
	 *            the fichierBinTmp to set
	 */
	public void setFichierBinTmp(FichierBinTmp fichierBinTmp)
	{
		this.fichierBinTmp = fichierBinTmp;
	}

}
