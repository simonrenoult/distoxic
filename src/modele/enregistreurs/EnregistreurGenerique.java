package src.modele.enregistreurs;

public interface EnregistreurGenerique {


	/**
	 * Methode principale permettant d'ecrire sur un fichier passe en parametre
	 * @param path
	 * @return booleen desucces de l'ecriture sur fichier.
	 */
	public boolean ecrireFichier(String path);
}
