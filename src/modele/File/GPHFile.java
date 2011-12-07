package modele.File;

import modele.Enregistreur.EnregistreurGPH;
import modele.parseurs.ParseurGPH;

public class GPHFile implements FileInit {

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	/*
	 * REMETTRE TOUTES LES CONSTANTES DU PARSEUR DANS CETTE CLASSE.
	 * ELLES SERVIRONT A L'ENREGISTREMENT.
	 */
	
	private ParseurGPH parseurGPH = null;
	private EnregistreurGPH enregistreurGPH = null;
	private String filePath = null;
	
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public GPHFile(String path){
		this.filePath = path;
	}
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	@Override
	public void initParseur(){
		parseurGPH = new ParseurGPH(filePath);
	}
	
	@Override
	public void initEnregistreur(){
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
	public ParseurGPH getParseurGPH() {
		return parseurGPH;
	}
	
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	

	/**
	 * @return the enregistreurGPH
	 */
	public EnregistreurGPH getEnregistreurGPH() {
		return enregistreurGPH;
	}


	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @param parseurGPH the parseurGPH to set
	 */
	public void setParseurGPH(ParseurGPH parseurGPH) {
		this.parseurGPH = parseurGPH;
	}
	
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @param enregistreurGPH the enregistreurGPH to set
	 */
	public void setEnregistreurGPH(EnregistreurGPH enregistreurGPH) {
		this.enregistreurGPH = enregistreurGPH;
	}

	
}
