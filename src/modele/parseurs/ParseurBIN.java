package modele.parseurs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ParseurBIN implements ParseurGenerique
{
	/**
	 * <h4>ParseurBIN est la classe servant de parseur pour le fichier.bin afin d'y recuperer l'integrite des donnees.</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //
	/**
	 * Constantes de la classe
	 */
	public static int						_CLASSEMAX	= 6;
	public static int						_CLASSEMIN	= 1;

	/**
	 * Liste ou sont contenus l'ensemble des donnees d'un fichier.bin
	 */
	private LinkedList<LinkedList<Integer>>	listeBIN	= null;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	/**
	 * Constructeur principal de la classe ParseurBIN
	 * Lis le fichier passe en parametre et cree une liste de lignes.
	 * Chaque ligne est une liste des 'mots' qu'elle contient.
	 * 
	 * @param filePath : chemin du fichier à lire.
	 */
	public ParseurBIN(String filePath)
	{
		listeBIN = new LinkedList<LinkedList<Integer>>();
		lireFichier(filePath);
		convertirListeVersTableau2D();
	}

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //
	
	/**
	 * Recupère un fichier et créé une liste contenant chaque ligne du fichier
	 * @param filePath : chemin du fichier à lire.
	 */
	public void lireFichier(String filePath)
	{
		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(filePath));
			try
			{
				String line;
				while ((line = buff.readLine()) != null)
				{
					listeBIN.add(creationListe(line));
				}
			}
			finally
			{
				buff.close();
			}
		}
		catch (IOException ioe)
		{
			// erreur de fermeture des flux
			System.out.println("Erreur --" + ioe.toString());
		}
	}

	/**
	 * Transformation d'une ligne en une liste de 'mots'
	 * 
	 * @param ligne : Ligne du fichier
	 * @return : Liste des mots de Line.
	 */
	private LinkedList<Integer> creationListe(String ligne)
	{
		String[] tab = ligne.split(" ");
		LinkedList<Integer> listeTemp = new LinkedList<Integer>();
		
		for (int i = 0 ; i < tab.length ; i++)
			listeTemp.add(Integer.parseInt(tab[i]));
		
		return listeTemp;
	}

	/**
	 * Trie la liste des lignes du fichier BIN (listeBin).
	 */
	public void trierListe()
	{
		LinkedList<LinkedList<Integer>> ListeTemp = new LinkedList<LinkedList<Integer>>();

		for (int i = 0, cpt = 1 ; i < _CLASSEMAX ; i++, cpt++)
			for (int j = 0 ; j < listeBIN.size() ; j++)
				if (listeBIN.get(j).get(0) == cpt)
					ListeTemp.add(listeBIN.get(j));

		listeBIN = ListeTemp;
	}

	/**
	 * Créé un tableau d'objets à deux dimensions, copie de la liste de ligne.
	 * 
	 * @return : tableau d'objets issu de la liste precedemment generee.
	 */
	public Object[][] convertirListeVersTableau2D()
	{
		Object[][] tmp = new Object[listeBIN.size()][3];
		
		for (int i = 0 ; i < tmp.length ; i++)
		{
			tmp[i][0] = i;
			tmp[i][1] = listeBIN.get(i).get(0);
			tmp[i][2] = listeBIN.get(i).size()-1;
		}
		
		return tmp;
	}

	// ----------------------------------------- //
	// --------------- AFFICHAGES -------------- //
	// ----------------------------------------- //
	
	/**
	 * Affiche le contenu de la liste en console.
	 */
	public void afficherListeBIN()
	{
		for (LinkedList<Integer> liste : listeBIN)
		{
			System.out.println();
			System.out.println("_____________LIGNE BIN___________________");
			for (int i = 0 ; i < liste.size() ; i++)
			{
				System.out.print(liste.get(i).toString() + " ");
			}
		}
	}

	/**
	 * Permet d'afficher le tableau 2D a partir de la liste
	 */
	public void afficherTableau() {
		for(LinkedList<Integer> liste : listeBIN){
			System.out.println();
			System.out.println("\n_______________NOUVELLE LIGNE BIN______________");
			for (int i = 0; i< liste.size(); i++){
				System.out.print(liste.get(i).toString()+" ");
			}
		}
	}
	
	
	
	
	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //
	
	public LinkedList<LinkedList<Integer>> getListeBIN()
	{
		return listeBIN;
	}
	
	// ----------------------------------------- //
	// --------------- MUTATEURS --------------- //
	// ----------------------------------------- //

	public void setListeBIN(LinkedList<LinkedList<Integer>> listeBIN)
	{
		this.listeBIN = listeBIN;
	}

}
