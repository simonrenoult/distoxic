package modele.fichier;

import modele.enregistreur.EnregistreurGPH;
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
	private String			filePath;
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

}
