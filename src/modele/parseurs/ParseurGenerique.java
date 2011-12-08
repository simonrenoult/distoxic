package modele.parseurs;

/**
 * <h4>Parseur générique des fichiers *.bin, *.sdf  et *.gph.</h4>
 *  
 * @author g4llic4
 *
 */

public interface ParseurGenerique
{
	/**
	 * Recupère un fichier et créé une liste contenant chaque ligne du fichier
	 * 
	 * @param filePath : chemin du fichier à lire.
	 */
	void lireFichier(String filePath);
	
	/**
 	 * Créé un tableau d'objets à deux dimensions, copie de la liste de ligne.
 	 * 
	 * @return retourne la conversion de la liste en tableau.
	 */
	Object[][] convertirListeVersTableau2D();
	
	void trierListe();
}
