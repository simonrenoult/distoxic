package modele.fichiers;

import modele.FichierTmp.FichierGphTmp;
import modele.enregistreurs.EnregistreurGPH;
import modele.parseurs.ParseurGPH;

public class FichierGPH implements InitFichier
{

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	/*
	 * REMETTRE TOUTES LES CONSTANTES DU PARSEUR DANS CETTE CLASSE. ELLES
	 * SERVIRONT A L'ENREGISTREMENT.
	 */

	private ParseurGPH		parseurGPH;
	private EnregistreurGPH	enregistreurGPH;
	private FichierGphTmp fichierGphTmp = null;
	private String			filePath;
	private boolean isChanged = false;
	private boolean isFlank = false;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public FichierGPH(String path)
	{
		this.filePath = path;
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	@Override
	public void initParseur()
	{
		parseurGPH = new ParseurGPH(filePath);
		fichierGphTmp = new FichierGphTmp(parseurGPH.getListeGPH());
	}

	@Override
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
