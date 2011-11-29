package modele.parseur;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParseurBIN implements ParseurGenerique
{
	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	public static int						_CLASSEMAX	= 6;
	public static int						_CLASSEMIN	= 1;

	private ArrayList<ArrayList<Integer>>	listeBIN	= null;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	/**
	 * Lis le fichier passé en paramètre et créé une liste de lignes.
	 * Chaque ligne est une liste des 'mots' qu'elle contient.
	 * 
	 * @param filePath : chemin du fichier à lire.
	 */
	public ParseurBIN(String filePath)
	{
		listeBIN = new ArrayList<ArrayList<Integer>>();
		lireFichier(filePath);
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
	 * @param ligne
	 *            : Ligne du fichier
	 * @return : Liste des mots de Line.
	 */
	private ArrayList<Integer> creationListe(String ligne)
	{
		String[] tab = ligne.split(" ");
		ArrayList<Integer> listeTemp = new ArrayList<Integer>();
		
		for (int i = 0 ; i < tab.length ; i++)
			listeTemp.add(Integer.parseInt(tab[i]));
		
		return listeTemp;
	}

	/**
	 * Trie la liste des lignes du fichier BIN (listeBin).
	 */
	public void trierListe()
	{
		ArrayList<ArrayList<Integer>> ListeTemp = new ArrayList<ArrayList<Integer>>();

		for (int i = 0, cpt = 1 ; i < _CLASSEMAX ; i++, cpt++)
			for (int j = 0 ; j < listeBIN.size() ; j++)
				if (listeBIN.get(j).get(0) == cpt)
					ListeTemp.add(listeBIN.get(j));

		listeBIN = ListeTemp;
	}

	/**
	 * Créé un tableau d'objets à deux dimensions, copie de la liste de ligne.
	 * @return 
	 */
	public Object[][] convertirListeVersTableau()
	{
		Object[][] tmp = new Object[listeBIN.size()][3];
		
		for (int i = 0 ; i < tmp.length ; i++)
		{
			tmp[i][0] = i + 1;
			tmp[i][1] = listeBIN.get(i).get(0);
			tmp[i][2] = listeBIN.get(i).size() - 1;
		}
		
		return tmp;
	}

	// ----------------------------------------- //
	// --------------- AFFICHAGES -------------- //
	// ----------------------------------------- //
	
	public void afficherListeBIN()
	{
		for (ArrayList<Integer> liste : listeBIN)
		{
			System.out.println();
			System.out.println("________________________________");
			for (int i = 0 ; i < liste.size() ; i++)
			{
				System.out.print(liste.get(i).toString() + " ");
			}
		}
	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //
	
	public ArrayList<ArrayList<Integer>> getListeBIN()
	{
		return listeBIN;
	}
	
	// ----------------------------------------- //
	// --------------- MUTATEURS --------------- //
	// ----------------------------------------- //

	public void setListeBIN(ArrayList<ArrayList<Integer>> listeBIN)
	{
		this.listeBIN = listeBIN;
	}

}
