package modele.parseurs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modele.composantsChimiques.Atome;
import modele.composantsChimiques.FragmentMoleculaire;
import modele.composantsChimiques.Liaison;

/**
 * @author g4llic4
 * 
 */
public class ParseurGPH implements ParseurGenerique
{

	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	/**
	 * Declaration des constantes permettant de parser le fichier. ----DEBUT
	 * FRAGMENT ----- t # 0 & -1 * 10 @ 0.0429 % 3 v 0 206 v 1 7 e 0 1 1
	 * 
	 * ----FIN FRAGMENT -------
	 */

	private final static String				_SEPARATION_CHAMP		= " ";
	private final static String				_VERTEX					= "v";
	private final static String				_EDGE					= "e";
	private final static String				_MARQUEUR_DEBUT			= "t";
	private final static String				_NUMERO_GRAPHE			= "#";
	private final static String				_CLASSE_GRAPHE			= "&";
	private final static String				_FREQUENCE_GRAPHE		= "*";
	private final static String				_VALEUR_TOXICITE_GRAPHE	= "@";
	private final static String				_EMERGENCE_GRAPHE		= "%";

	@SuppressWarnings("unused")
	private static String					_SEPARATION_FRAGMENT	= " ";

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //
	
	/**
	 * Indice de l'objet FragmentMoleculaire sur lequel on travail.
	 */
	private static int						indiceFragment			= 0;
	private ArrayList<FragmentMoleculaire>	listeGPH				= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public ParseurGPH(String filePath)
	{
		listeGPH = new ArrayList<FragmentMoleculaire>();
		lireFichier(filePath);
		convertirListeVersTableau2D();
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	
	/**
	 * Permet de lire toutes les lignes d'un fichier donn� pour enextraire les
	 * donnees.
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
			creerFragmentMoleculaireIdentite(tab);
		}
		else if (tab[0].compareTo(_VERTEX) == 0)
		{
			creerFragmentMoleculaireAtome(tab);
		}
		else if (tab[0].compareTo(_EDGE) == 0)
		{
			creerFragmentMoleculaireLiaison(tab);
		}

	}

	/**
	 * Creer un nouvel objet FragmentMoleculaire qui l'initialise et l'ajoute �
	 * la liste d'objet FragmentMoleculaire. On pourra alors ins�rer les donn�es
	 * relatives aux atomes et aux liaisons.
	 * 
	 * @param tab
	 */
	private void creerFragmentMoleculaireIdentite(String[] tab)
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
		listeGPH.add(f);
		indiceFragment = listeGPH.size() - 1;

	}

	/**
	 * On prend la fragment actuel (gr�ce � indiceFragment) et on rempli la
	 * liste d'objet Atome.
	 * 
	 * @param tab
	 */
	private void creerFragmentMoleculaireAtome(String[] tab)
	{
		Atome atome = new Atome(Integer.parseInt(tab[1]), Integer.parseInt(tab[2]));
		listeGPH.get(indiceFragment).getListeAtome().add(atome);
	}

	/**
	 * On prend la fragment actuel (grace a indiceFragment) et on rempli la
	 * liste d'objet Liaison.
	 * 
	 * @param tab
	 */
	private void creerFragmentMoleculaireLiaison(String[] tab)
	{
		Liaison liaison = new Liaison(Integer.parseInt(tab[1]), Integer.parseInt(tab[2]), Integer.parseInt(tab[3]));
		listeGPH.get(indiceFragment).getListeLiaison().add(liaison);
	}

	/**
	 * Permet de convertir la liste de Fragment en un tableau 2D exploitable par
	 * la JTable.
	 * 
	 * @return
	 */
	@Override
	public Object[][] convertirListeVersTableau2D()
	{
		Object[][] tableauGPH = new Object[listeGPH.size()][6];

		for (int i = 0 ; i < tableauGPH.length ; i++)
		{
			tableauGPH[i][0] = listeGPH.get(i).getListeAtome().size();
			tableauGPH[i][1] = listeGPH.get(i).getListeLiaison().size();
			tableauGPH[i][2] = listeGPH.get(i).getNumero();
			tableauGPH[i][3] = listeGPH.get(i).getFrequence();
			tableauGPH[i][4] = listeGPH.get(i).getToxicite();
			tableauGPH[i][5] = listeGPH.get(i).getEmergence();
		}

		return tableauGPH;
	}

	/**
	 * Permet d'afficher le tableau 2D � partir de la liste
	 */
	public void afficherTableau()
	{
		for (FragmentMoleculaire fragment : listeGPH)
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

	@Override
	public void trierListe()
	{

	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
