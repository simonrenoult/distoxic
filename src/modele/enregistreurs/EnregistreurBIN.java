package modele.enregistreurs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class EnregistreurBIN implements EnregistreurGenerique
{
	/**
	 * <h4>EnregistreurBIN est la classe permettant l'enregistrement sur fichier du tableau graphique BIN</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	/**
	 * Constantes de classe.
	 */
	public static int						_CLASSEMAX		= 6;
	public static int						_CLASSEMIN		= 1;
	public static String					_SEPARATEURBIN	= " ";

	/**
	 * Liste representative du fichier BIN qui va etre parcouru pour ecrire les les donnees sur fichier.
	 */
	private LinkedList<LinkedList<Integer>>	listeBIN		= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur par defaut de la classe EnregistreurBIN
	 */
	public EnregistreurBIN()
	{

	}

	/**
	 * Constructeur de la classe EnregistreurBIN
	 * @param liste la liste de donnees
	 * @param path le chemin du fichier dans lequel on va ecrire.
	 */
	public EnregistreurBIN(LinkedList<LinkedList<Integer>> liste, String path)
	{
		System.out.println("enregistrment du fichier BIN");
		listeBIN = liste;
		ecrireFichier(path);

	}

	/**
	 * Constructeur de la classe EnregistreurBIN
	 * @param liste la liste de donnees
	 */
	public EnregistreurBIN(LinkedList<LinkedList<Integer>> liste)
	{
		System.out.println("enregistrment du fichier BIN");
		listeBIN = liste;

	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	/**
	 * Methode principale d'ecriture sur fichier BIN. On ecrit chaque ligne
	 * correspondant à l'ensemble des fragments toxiques appartenant à une
	 * molécule.
	 * 
	 * @param le chemin du fichier dans lequel on va ecrire.
	 * @return booleen d'ecriture sur fichier.
	 */
	@Override
	public boolean ecrireFichier(String path)
	{

		try
		{
			BufferedWriter buff = new BufferedWriter(new FileWriter(path));
			try
			{
				for (int i = 0 ; i < listeBIN.size() ; i++)
				{
					ecrireLigne(buff, i);
				}
			}
			catch (Exception e)
			{
				return false;
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
			return false;
		}
		return true;
	}

	/**
	 * Methode ecrivant sur fichier la ligne correspondant à l'ensemble des fragments
	 * toxiques d'une molécule.
	 * 
	 * @param buff le buffer
	 * @param index le numero de ligne
	 */
	public boolean ecrireLigne(BufferedWriter buff, int index)
	{
		String line = "";
		for (int j = 0 ; j < listeBIN.get(index).size() ; j++)
		{
			line = line + String.valueOf(listeBIN.get(index).get(j)) + _SEPARATEURBIN;
		}
		if (index < listeBIN.size() - 1)
		{
			// On ajoute \n à toute les lignes sauf la derniere.
			line = line + "\n";
		}

		try
		{
			buff.write(line);
		}
		catch (IOException e)
		{
			// e.printStackTrace();
			return false;
		}
		return true;
	}
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}