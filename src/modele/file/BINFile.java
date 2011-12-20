package modele.file;

import modele.enregistreur.EnregistreurBIN;
import modele.parseurs.ParseurBIN;

public class BINFile implements FileInit {

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	/*
	 * REMETTRE TOUTES LES CONSTANTES DU PARSEUR DANS CETTE CLASSE.
	 * ELLES SERVIRONT A L'ENREGISTREMENT.
	 */
	
	private ParseurBIN parseurBIN = null;
	private EnregistreurBIN enregistreurBIN = null;
	private String filePath = null;
	
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public BINFile(String path){
		this.filePath = path;
	}
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	@Override
	public void initParseur(){
		parseurBIN = new ParseurBIN(filePath);
	}
	
	@Override
	public void initEnregistreur(){
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
	public ParseurBIN getParseurBIN() {
		return parseurBIN;
	}
	
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	

	/**
	 * @return the enregistreurBIN
	 */
	public EnregistreurBIN getEnregistreurBIN() {
		return enregistreurBIN;
	}


	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @param parseurBIN the parseurBIN to set
	 */
	public void setParseurBIN(ParseurBIN parseurBIN) {
		this.parseurBIN = parseurBIN;
	}
	
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @param enregistreurBIN the enregistreurBIN to set
	 */
	public void setEnregistreurBIN(EnregistreurBIN enregistreurBIN) {
		this.enregistreurBIN = enregistreurBIN;
	}

	
}
