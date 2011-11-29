package modele.parseur;

public interface ParseurGenerique
{
	void lireFichier(String filePath);
		
	Object[][] convertirListeVersTableau();
	
	void trierListe();
}
