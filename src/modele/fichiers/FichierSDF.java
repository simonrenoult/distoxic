package modele.fichiers;

import modele.enregistreurs.EnregistreurSDF;
import modele.fichiersTmp.FichierSdfTmp;
import modele.parseurs.ParseurSDF;

public class FichierSDF implements InitFichier
{

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	/*
	 * REMETTRE TOUTES LES CONSTANTES DU PARSEUR DANS CETTE CLASSE. ELLES
	 * SERVIRONT A L'ENREGISTREMENT.
	 */
	private ParseurSDF		parseurSDF		= null;
	private EnregistreurSDF	enregistreurSDF	= null;
	private FichierSdfTmp fichierSdfTmp = null;
	private String			filePath		= null;
	private boolean			isChanged		= false;
	private boolean			isFlank			= false;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public FichierSDF(String path)
	{
		this.filePath = path;
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	@Override
	public void initParseur()
	{
		parseurSDF = new ParseurSDF(filePath);
		fichierSdfTmp = new FichierSdfTmp(parseurSDF.getFragmentsMolecules());
	}

	@Override
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
