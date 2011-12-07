package modele;

import modele.File.BINFile;
import modele.File.GPHFile;
import modele.File.SDFFile;

/**
 * 
 * Cette classe regroupe les 3 types de fichiers sous forme de tableaux d'objet 
 * qui permet de remplir le modele des JTable. Cette classe sera aussi utilisé 
 * pour l'export et l'import d'archive .zip (contenant les 3 fichiers).
 * 
 * 
 */
public class TripletFichier {
// ----------------------------------------- //
// ----------------ATRIBUTS----------------- //
// ----------------------------------------- //
	
	private static String extensionGPH = ".gph";
	private static String extensionBIN = ".bin";
	private static String extensionSDF = ".sdf";
	
	/*
	 * On utilise ces fichiers pour remplir les JTable d'un onglet.
	 */
	private BINFile binFile = null;
	private GPHFile gphFile = null;
	private SDFFile sdfFile = null;
	
	private String BINPath = null;
	private String GPHPath = null;
	private String SDFPath = null;
	
// ----------------------------------------- //
// --------------CONSTRUCTEURS-------------- //
// ----------------------------------------- //
	/**
	 * Constructeur prenant les 3 chemins de fichiers (sdf,bin et gph).
	 * On créé alors à partir de ces 3 chemins, 3 objets associés à l'extension.
	 * @param Path1
	 * @param Path2
	 * @param Path3
	 */
	public TripletFichier(String Path1,String Path2,String Path3){
		initFile(Path1);
		initFile(Path2);
		initFile(Path3);
	}
	
	/**
	 * Constructeur prenant 2 chemins de fichiers parmis les formats sdf,bin et gph.
	 * On créé alors à partir de ces 2 chemins, 2 objets associés à l'extension.
	 * @param Path1
	 * @param Path2
	 */
	public TripletFichier(String Path1,String Path2){
		initFile(Path1);
		initFile(Path2);
	}
	
	/**
 	 *Constructeur prenant 1 chemin de fichier parmis les formats sdf,bin et gph.
	 * On créé alors à partir de ce 1 chemins, l'objet associé à l'extension. 
	 * @param Path1
	 */
	public TripletFichier(String Path1){
		initFile(Path1);
	}


// ----------------------------------------- //
// -------------INITIALISEURS--------------- //
// ----------------------------------------- //
	
	private void initFile(String path) {
		if(path.endsWith(extensionBIN)){
			BINPath = path;
			BINinit();
		}
		else if (path.endsWith(extensionGPH)){
			GPHPath = path;
			GPHinit();
		}
		else if (path.endsWith(extensionSDF)){
			SDFPath = path;
			SDFinit();
		}
		else {System.out.println("Format inconnu");}
		
	}
	
	private void BINinit() {
		binFile = new BINFile(BINPath);
	}
	
	private void GPHinit() {
		gphFile = new GPHFile(GPHPath);
	}
	
	private void SDFinit() {
		sdfFile = new SDFFile(SDFPath);
	}

	/**
	 * @return the binFile
	 */
	public BINFile getBinFile() {
		return binFile;
	}

// ----------------------------------------- //
// -----------------METHODES---------------- //
// ----------------------------------------- //

	
// ----------------------------------------- //
// ---------------ACCESSEURS---------------- //
// ----------------------------------------- //
	/**
	 * @param binFile the binFile to set
	 */
	public void setBinFile(BINFile binFile) {
		this.binFile = binFile;
	}

	/**
	 * @return the gphFile
	 */
	public GPHFile getGphFile() {
		return gphFile;
	}

	/**
	 * @param gphFile the gphFile to set
	 */
	public void setGphFile(GPHFile gphFile) {
		this.gphFile = gphFile;
	}

	/**
	 * @return the sdfFile
	 */
	public SDFFile getSdfFile() {
		return sdfFile;
	}

	/**
	 * @param sdfFile the sdfFile to set
	 */
	public void setSdfFile(SDFFile sdfFile) {
		this.sdfFile = sdfFile;
	}

	/**
	 * @return the bINPath
	 */
	public String getBINPath() {
		return BINPath;
	}

	/**
	 * @param bINPath the bINPath to set
	 */
	public void setBINPath(String bINPath) {
		BINPath = bINPath;
	}

	/**
	 * @return the gPHPath
	 */
	public String getGPHPath() {
		return GPHPath;
	}

	/**
	 * @param gPHPath the gPHPath to set
	 */
	public void setGPHPath(String gPHPath) {
		GPHPath = gPHPath;
	}

	/**
	 * @return the sDFPath
	 */
	public String getSDFPath() {
		return SDFPath;
	}

	/**
	 * @param sDFPath the sDFPath to set
	 */
	public void setSDFPath(String sDFPath) {
		SDFPath = sDFPath;
	}
// ----------------------------------------- //
// ----------------MUTATEURS---------------- //
// ----------------------------------------- //
}
