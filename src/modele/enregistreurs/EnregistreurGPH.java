package src.modele.enregistreurs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import src.modele.composantsChimiques.FragmentMolecule;


public class EnregistreurGPH implements EnregistreurGenerique
{
	/**
	 * <h4>EnregistreurGPH est la classe permettant l'enregistrement sur fichier du tableau graphique GPH</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //
	
	/**
	 * Declaration des constantes permettant de parser le fichier.
	 * t # 0 & -1 * 10 @ 0.0429 % 3 v 0 206 v 1 7 e 0 1 1
	 * 
	 */

	private final static String			_SEPARATION_CHAMP		= " ";
	private final static String			_VERTEX					= "v";
	private final static String			_EDGE					= "e";
	private final static String			_MARQUEUR_DEBUT			= "t";
	private final static String			_NUMERO_GRAPHE			= "#";
	private final static String			_CLASSE_GRAPHE			= "&";
	private final static String			_FREQUENCE_GRAPHE		= "*";
	private final static String			_VALEUR_TOXICITE_GRAPHE	= "@";
	private final static String			_EMERGENCE_GRAPHE		= "%";

	@SuppressWarnings("unused")
	private static String				_SEPARATION_FRAGMENT	= " ";

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	/**
	 * Liste sur lequel vont etre recuperees les donnees afin de les ecrire sur fichier.
	 */
	private LinkedList<FragmentMolecule>	listeGPH				= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur par defaut de la classe EnregistreurGPH
	 */
	public EnregistreurGPH()
	{

	}

	/**
	 * Constructeur de la classe EnregistreurGPH
	 * @param liste la liste de donnees
	 * @param path le chemin du fichier dans lequel on va ecrire.
	 */
	public EnregistreurGPH(LinkedList<FragmentMolecule> liste, String path)
	{
		listeGPH = liste;
		ecrireFichier(path);
	}

	/**
	 * Constructeur de la classe EnregistreurGPH
	 * @param liste la liste de donnees
	 */
	public EnregistreurGPH(LinkedList<FragmentMolecule> liste)
	{
		listeGPH = liste;
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	/**
	 * Methode principale d'ecriture sur fichier GPH. Chaque fragment est
	 * decomposable en partie : l'entete, la description des atomes et la
	 * description des liaisons.
	 * 
	 * @param path le chemin du fichier
	 * @return booleen d'ecriture sur fichier.
	 */
	@Override
	public boolean ecrireFichier(String path)
	{
		boolean b = true;
		try
		{
			BufferedWriter buff = new BufferedWriter(new FileWriter(path));
			try
			{
				for (int i = 0 ; i < listeGPH.size() ; i++)
				{
					ecrireEnteteFragment(buff, i);
					ecrireSommetFragment(buff, i);
					ecrireAreteFragment(buff, i);
					buff.write("\n");
				}
			}
			catch (Exception e)
			{
				// e.printStackTrace();
				b = false;
			}
			finally
			{
				buff.close();
			}
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			b = false;
		}
		return b;
	}

	/**
	 * Methode ecrivant sur le fichier l'entete du fragment de numero index.
	 * 
	 * @param buff le buffer
	 * @param index l'indice de la ligne
	 * @return booleen d'ecriture
	 */
	private boolean ecrireEnteteFragment(BufferedWriter buff, int index)
	{

		float emergenceFloat = Float.valueOf(listeGPH.get(index).getBalise("Emergence").getValeur());
		int emergenceInt = Float.valueOf(listeGPH.get(index).getBalise("Emergence").getValeur()).intValue();
		String emergence;
		if (emergenceFloat - emergenceInt == 0)
		{
			emergence = String.valueOf(emergenceInt);
		}
		else
		{
			emergence = String.valueOf(emergenceFloat);
		}

		String line;
		line = _MARQUEUR_DEBUT + _SEPARATION_CHAMP + _NUMERO_GRAPHE + _SEPARATION_CHAMP
				+ listeGPH.get(index).getBalise("Numero").getValeur() + _SEPARATION_CHAMP + _CLASSE_GRAPHE
				+ _SEPARATION_CHAMP + listeGPH.get(index).getBalise("Classe").getValeur() + _SEPARATION_CHAMP
				+ _FREQUENCE_GRAPHE + _SEPARATION_CHAMP + listeGPH.get(index).getBalise("Frequence").getValeur()
				+ _SEPARATION_CHAMP + _VALEUR_TOXICITE_GRAPHE + _SEPARATION_CHAMP
				+ listeGPH.get(index).getBalise("Toxicite").getValeur() + _SEPARATION_CHAMP + _EMERGENCE_GRAPHE
				+ _SEPARATION_CHAMP + emergence + "\n";
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

	/**
	 * Methode ecrivant l'ensemble des sommets (atomes) pour le fragment de numero index.
	 * 
	 * @param buff le buffer
	 * @param index l'indice de la ligne
	 * @return booleen d'ecriture
	 */
	private boolean ecrireSommetFragment(BufferedWriter buff, int index)
	{
		String line;
		for (int i = 0 ; i < listeGPH.get(index).getAtomes().size() ; i++)
		{
			line = _VERTEX + _SEPARATION_CHAMP;
			line = line + listeGPH.get(index).getAtomes().get(i).getIndice() + _SEPARATION_CHAMP
					+ listeGPH.get(index).getAtomes().get(i).getNumeroAtomique();
			line = line + "\n";
			try
			{
				buff.write(line);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		return true;
	}

	/**
	 *  Methode ecrivant sur le fichier l'ensemble des aretes (liaisons atomiques) pour le fragme,t de numero index.
	 * 
	 * @param buff le buffer
	 * @param index l'indice de la ligne
	 * @return booleen d'ecriture
	 */
	private boolean ecrireAreteFragment(BufferedWriter buff, int index)
	{
		String line;
		for (int i = 0 ; i < listeGPH.get(index).getListeLiaison().size() ; i++)
		{
			line = _EDGE + _SEPARATION_CHAMP;
			line = line + listeGPH.get(index).getListeLiaison().get(i).getAtomeRelie1() + _SEPARATION_CHAMP
					+ listeGPH.get(index).getListeLiaison().get(i).getAtomeRelie2() + _SEPARATION_CHAMP
					+ listeGPH.get(index).getListeLiaison().get(i).getNombreLiaison();
			line = line + "\n";
			try
			{
				buff.write(line);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
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