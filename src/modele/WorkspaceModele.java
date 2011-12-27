package modele;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WorkspaceModele {

	/**
	 * <h4>WorkspaceModele est la classe permettant de lire/editer le chemin de configuration du workspace.</h4>
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * Constantes de classe.
	 */
	private static String _FICHIER_CONFIGURATION = "configWorkspace.txt";
	private static String _SEPARATEUR = "<workspace>";
	private static String _NOMREPERTOIRE_TRAVAIL = "DisToxicProjects";
	
	/**
	 * le chemin du workspace contenu dans le fichier de configuration configWorkspace.txt
	 */
	private String workspacePath = null;
	/**
	 * le chemin du workspace desire par l'utilisateur
	 */
	private String workspacePathDesire =null;
	/**
	 * le fichier de configuration de chemin workspacePath.
	 */
	private File workspaceFile = null;
	
	/**
	 * Selon la valeur, on lit (1) seulement ou on ecrit (0) en plus dans le fichier de configuration.
	 */
	private int index ;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe WorkspaceModele
	 * @param index l'indice de lecture ou lecture/ecriture sur le fichier de configuration.
	 */
	public WorkspaceModele(int index){
		this.index = index;
	}
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
		
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	
	/**
	 * Methode de lecture du fichier onfigWorkspace.txt pour determiner si le workspace doit etre cree.
	 * @return un boolean de confirmation de lecture du fichier.
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
	 * Methode pour determiner si le chemin du workspace du fichier existe reelement dans le systeme. 
	 * @param line la ligne du fichier (une seule dans configWorkspace.txt).
	 * @return booleen retournant l'existance du chemin dans le SGF.
	 */
	private boolean traitementLigne(String line) {
		String [] tab = line.split(_SEPARATEUR);
		workspacePath = tab[0];
		workspacePath = workspacePath+File.separator+_NOMREPERTOIRE_TRAVAIL;
		workspaceFile = new File(workspacePath);
		if(!(workspaceFile.exists() && workspaceFile.isDirectory()) && (index == 0)){
			//System.out.println("le workspace n'existe pas � l'emplacement inscrit dans le fichier.");
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
	 * Methode creant le dossier recensant tous les projets qu'on va y deposer apres. la JTree se creera a partir de ce dossier.
	 * @param path le chemin absolu du repertoire contenant tous les projets sur le SGF.
	 * @return un booleen de verification sur la creation du repertoire.
	 */
	public boolean makeWorkspace(String path){
		workspaceFile = new File(path+File.separator+_NOMREPERTOIRE_TRAVAIL);
		workspacePathDesire = workspaceFile.getAbsolutePath();
		RedefinirConfigurationFichier(path);
		return workspaceFile.mkdir();
	}
	
	/**
	 * Methode de reecriture sur fichier configWorkspace.txt du nouveau chemin du workspace defini.
	 * @param path le chemin du repertoire.
	 * @return booleen d'ecriture sur fichier. 
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
		//System.out.println("Ecriture sur fichier termin� avec succ�s");
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
