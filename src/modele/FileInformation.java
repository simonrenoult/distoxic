package modele;

public class FileInformation {

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	private String fileType = null;
	private String filePath = null;
	private String fileTitle = null;
	
	
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	public FileInformation(String type, String path, String title){
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
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * La construction de la JTree demande une méthode toString qui prendra par défault la méthode toString 
	 * de l'objet appellé.
	 */
	public String toString(){
		return fileTitle;
	}
	
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //


	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}


	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}


	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	/**
	 * @return the fileTitle
	 */
	public String getFileTitle() {
		return fileTitle;
	}


	/**
	 * @param fileTitle the fileTitle to set
	 */
	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}

}
