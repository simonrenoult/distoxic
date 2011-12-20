package modele;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WorkspaceModele {

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private static String _FICHIER_CONFIGURATION = "config.txt";
	private static String _SEPARATEUR = "<workspace>";
	private static String _NOMREPERTOIRE_TRAVAIL = "DisToxicProjects";
	
	private String workspacePath = null;
	private String workspacePathDesire =null;
	private File workspaceFile = null;
	
	private int index ;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	public WorkspaceModele(int index){
		this.index = index;
		//l'index est un marqueur utilise par la methode traitementLigne
		//pour savoir si c'est qu'une simple lecture ou que l'on veuille
		//la création d'un dossier.
	}
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
		
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	
	/**
	 * Lecture du fichier conf.txt pour determiner si le workspace doit être créé.
	 * @return un boolean de confirmation 
	 */
	public boolean lireFichier() {
		boolean b = true;
		try {
			BufferedReader buff = new BufferedReader(new FileReader(_FICHIER_CONFIGURATION));
			try {
				String line;
				while ((line = buff.readLine()) != null) {
					b = traitementLigne(line);
				}
			} finally {
				buff.close();
			}
		} catch (IOException ioe) {
			System.err.println("Erreur --" + ioe.toString());
			b = false;
		}
		return b;
	}
	
	/**
	 * On regarde si le chemin du workspace du fichier existe reelement dans le systeme. 
	 * @param line
	 * @return si le chemin du workspace existe.
	 */
	private boolean traitementLigne(String line) {
		String [] tab = line.split(_SEPARATEUR);
		workspacePath = tab[0];
		workspacePath = workspacePath+File.separator+_NOMREPERTOIRE_TRAVAIL;
		workspaceFile = new File(workspacePath);
		if(!(workspaceFile.exists() && workspaceFile.isDirectory()) && (index == 0)){
			//System.out.println("le workspace n'existe pas à l'emplacement inscrit dans le fichier.");
			//System.out.println("fichier : "+workspacePath);
			return false;
		}
		return true;
	}
	
	/**
	 * Methode appelle dans le main pour savoir si chemin du workspace est utilisable sur l'ordinateur.
	 * @return booleen de verification. si false, on lance la fenetreChoixWorkspace pour definir le workspace.
	 */
	public boolean workspaceExistant(){
		return lireFichier();
	}
	
	/**
	 * Methode creant le dossier recensant tous les projets qu'on va y déposer après. la JTree se creera a partir de ce dossier.
	 * @param path
	 * @return un booleen de verification sur la creation du repertoire.
	 */
	public boolean makeWorkspace(String path){
		workspaceFile = new File(path+File.separator+_NOMREPERTOIRE_TRAVAIL);
		workspacePathDesire = workspaceFile.getAbsolutePath();
		RedefinirConfigurationFichier(path);
		return workspaceFile.mkdir();
	}
	
	/**
	 * Reecriture sur fichier conf.txt du nouveau chemin du workspace defini.
	 * @param path
	 * @return
	 */
	private boolean RedefinirConfigurationFichier(String path){
		String chaine = path+_SEPARATEUR;
		//System.out.println("Definition du workspace : "+chaine);
		try {
				BufferedWriter buff = new BufferedWriter(new FileWriter(_FICHIER_CONFIGURATION));
				buff.write(chaine);
				buff.close();
				
			} catch (IOException e) {
				//e.printStackTrace();
				//System.out.println("Echec de l'Ecriture sur fichier.");
				return false;
			}
		//System.out.println("Ecriture sur fichier terminé avec succès");
			return true;
			
		
		
	}

	
		
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @return the workspacePath
	 */
	public String getWorkspacePath() {
		return workspacePath;
	}

	/**
	 * @param workspacePath the workspacePath to set
	 */
	public void setWorkspacePath(String workspacePath) {
		this.workspacePath = workspacePath;
	}

	/**
	 * @return the workspacePathDesire
	 */
	public String getWorkspacePathDesire() {
		return workspacePathDesire;
	}

	/**
	 * @param workspacePathDesire the workspacePathDesire to set
	 */
	public void setWorkspacePathDesire(String workspacePathDesire) {
		this.workspacePathDesire = workspacePathDesire;
	}

	/**
	 * @return the workspaceFile
	 */
	public File getWorkspaceFile() {
		return workspaceFile;
	}

	/**
	 * @param workspaceFile the workspaceFile to set
	 */
	public void setWorkspaceFile(File workspaceFile) {
		this.workspaceFile = workspaceFile;
	}
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
