package modele.parseur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modele.Atome;
import modele.FragmentMoleculaire;
import modele.Liaison;

public class ParseurGPH implements ParseurGenerique
{

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	/**
	 * Declaration des constantes permettant de parser le fichier. ----DEBUT
	 * FRAGMENT ----- t # 0 & -1 * 10 @ 0.0429 % 3 v 0 206 v 1 7 e 0 1 1
	 * 
	 * ----FIN FRAGMENT -------
	 */

	private static String					_SEPARATION_CHAMP		= " ";
	private static String					_VERTEX					= "v";
	private static String					_EDGE					= "e";
	private static String					_MARQUEUR_DEBUT			= "t";
	private static String					_NUMERO_GRAPHE			= "#";
	private static String					_CLASSE_GRAPHE			= "&";
	private static String					_FREQUENCE_GRAPHE		= "*";
	private static String					_VALEUR_TOXICITE_GRAPHE	= "@";
	private static String					_EMERGENCE_GRAPHE		= "%";

	@SuppressWarnings("unused")
	private static String					_SEPARATION_FRAGMENT	= " ";

	/**
	 * Indice de l'objet FragmentMoleculaire sur lequel on travail.
	 */
	private static int						indiceFragment			= 0;
	private ArrayList<FragmentMoleculaire>	ListeGPH				= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	public ParseurGPH(String filePath)
	{
		ListeGPH = new ArrayList<FragmentMoleculaire>();
		lireFichier(filePath);
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	
	/**
	 * Permet de lire toutes les lignes d'un fichier donn� pour enextraire les
	 * donn�es.
	 * 
	 * @param filePath
	 */
	@Override
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
					lireLigne(line);
				}
			}
			finally
			{
				buff.close();
			}
		}
		catch (IOException ioe)
		{
			System.err.println("Erreur --" + ioe.toString());
		}
	}

	/**
	 * Exploitation de la ligne : en fonction des indices (t,v, e ou "" qui sont
	 * des constantes), on redirige la ligne pour extraire les donn�es.
	 * 
	 * @param fileLine
	 */
	public void lireLigne(String fileLine)
	{
		String[] tab = fileLine.split(_SEPARATION_CHAMP);

		if (tab[0].compareTo(_MARQUEUR_DEBUT) == 0)
		{
			CreerFragmentMoleculaireIdentite(tab);
		}
		else if (tab[0].compareTo(_VERTEX) == 0)
		{
			CreerFragmentMoleculaireAtome(tab);
		}
		else if (tab[0].compareTo(_EDGE) == 0)
		{
			CreerFragmentMoleculaireLiaison(tab);
		}

	}

	/**
	 * Creer un nouvel objet FragmentMoleculaire qui l'initialise et l'ajoute �
	 * la liste d'objet FragmentMoleculaire. On pourra alors ins�rer les donn�es
	 * relatives aux atomes et aux liaisons.
	 * 
	 * @param tab
	 */
	private void CreerFragmentMoleculaireIdentite(String[] tab)
	{
		FragmentMoleculaire f = new FragmentMoleculaire();

		for (int i = 1 ; i < tab.length ; i = i + 2)
		{

			if (tab[i].compareTo(_NUMERO_GRAPHE) == 0)
			{
				f.setNumero((Integer.parseInt(tab[i + 1])));
			}
			else if (tab[i].compareTo(_CLASSE_GRAPHE) == 0)
			{
				f.setClasse(Integer.parseInt(tab[i + 1]));
			}
			else if (tab[i].compareTo(_FREQUENCE_GRAPHE) == 0)
			{
				f.setFrequence(Integer.parseInt(tab[i + 1]));
			}
			else if (tab[i].compareTo(_VALEUR_TOXICITE_GRAPHE) == 0)
			{
				f.setToxicite(Float.parseFloat(tab[i + 1]));
			}
			else if (tab[i].compareTo(_EMERGENCE_GRAPHE) == 0)
			{
				f.setEmergence(Float.parseFloat(tab[i + 1]));
			}
		}
		ListeGPH.add(f);
		indiceFragment = ListeGPH.size() - 1;

	}

	/**
	 * On prend la fragment actuel (gr�ce � indiceFragment) et on rempli la
	 * liste d'objet Atome.
	 * 
	 * @param tab
	 */
	private void CreerFragmentMoleculaireAtome(String[] tab)
	{
		Atome atome = new Atome(Integer.parseInt(tab[1]), Integer.parseInt(tab[2]));
		ListeGPH.get(indiceFragment).getListeAtome().add(atome);
	}

	/**
	 * On prend la fragment actuel (gr�ce � indiceFragment) et on rempli la
	 * liste d'objet Liaison.
	 * 
	 * @param tab
	 */
	private void CreerFragmentMoleculaireLiaison(String[] tab)
	{
		Liaison liaison = new Liaison(Integer.parseInt(tab[1]), Integer.parseInt(tab[2]), Integer.parseInt(tab[3]));
		ListeGPH.get(indiceFragment).getListeLiaison().add(liaison);
	}

	/**
	 * Permet de converitr la liste de Fragment en un tableau 2D exploitable par
	 * la JTable.
	 * 
	 * @return
	 */
	@Override
	public Object[][] convertirListeVersTableau()
	{
		Object[][] tableauGPH = new Object[7][ListeGPH.size()];

		for (int i = 0 ; i < tableauGPH.length ; i++)
		{
			for (FragmentMoleculaire fragment : ListeGPH)
			{
				tableauGPH[0][i] = fragment.getNumero();
				tableauGPH[1][i] = fragment.getListeAtome().size();
				tableauGPH[2][i] = fragment.getListeLiaison().size();
				tableauGPH[3][i] = fragment.getNumero();
				tableauGPH[4][i] = fragment.getFrequence();
				tableauGPH[5][i] = fragment.getToxicite();
				tableauGPH[6][i] = fragment.getEmergence();
			}
		}

		return tableauGPH;
	}

	/**
	 * Permet d'afficher le tableau 2D � partir de la liste
	 */
	public void afficherTableau()
	{
		for (FragmentMoleculaire fragment : ListeGPH)
		{
			System.out.println("\n_______________NOUVEAU FRAGMENT______________");
			System.out.print("Numero : " + fragment.getNumero());
			System.out.print(", Nombre atome : " + fragment.getListeAtome().size());
			System.out.print(", Nombre liaison : " + fragment.getListeLiaison().size());
			System.out.print(", Classe : " + fragment.getClasse());
			System.out.print(", Frequence : " + fragment.getFrequence());
			System.out.print(", Toxicite : " + fragment.getToxicite());
			System.out.print(", Emergence : " + fragment.getEmergence());
		}

	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	@Override
	public void trierListe()
	{
		// TODO Auto-generated method stub

	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
