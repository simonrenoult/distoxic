package modele.fichiers;

import modele.enregistreurs.EnregistreurBIN;
import modele.fichiersTmp.FichierBinTmp;
import modele.parseurs.ParseurBIN;

public class FichierBIN implements InitFichier
{

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	/*
	 * REMETTRE TOUTES LES CONSTANTES DU PARSEUR DANS CETTE CLASSE. ELLES
	 * SERVIRONT A L'ENREGISTREMENT.
	 */

	private ParseurBIN		parseurBIN		= null;
	private EnregistreurBIN	enregistreurBIN	= null;
	private FichierBinTmp	fichierBinTmp	= null;
	private String			filePath		= null;
	private boolean			isChanged		= false;
	private boolean			isFlank			= false;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public FichierBIN(String path)
	{
		this.filePath = path;
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	@Override
	public void initParseur()
	{
		parseurBIN = new ParseurBIN(filePath);
		fichierBinTmp = new FichierBinTmp(parseurBIN.getListeBIN());
	}

	@Override
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
