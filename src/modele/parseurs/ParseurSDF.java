package modele.parseurs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import modele.composantsChimiques.Atome;
import modele.composantsChimiques.Balise;
import modele.composantsChimiques.FragmentMolecule;

public class ParseurSDF implements ParseurGenerique
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Pattern				DEBUT		= Pattern.compile("^[ ]{2}[A-Z][A-Za-z0-9]{1,}+$");
	public final static Pattern				RESUME		= Pattern.compile("[0-9]{3}[ ][A-Z][0-9]{4}$");
	public final static Pattern				ATOMES		= Pattern
																.compile("^([ ]{2,3}( |-)([0-9]+)[.]([0-9]{4})){3}[ ]([A-Za-z]+)(( +)[0-9])+$");
	public final static Pattern				LIAISONS	= Pattern.compile("^([ ]( [0-9]|[0-9]{2})){4}$");
	public final static Pattern				INFO		= Pattern.compile("^M[ ]{2}([A-Z]{3})");
	public final static Pattern				BALISES		= Pattern.compile("<(.+)>");
	public final static Pattern				FIN			= Pattern.compile("^[$]{4}$");

	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	private LinkedList<FragmentMolecule>	fragmentsMolecules;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public ParseurSDF(String filePath)
	{
		fragmentsMolecules = new LinkedList<FragmentMolecule>();
		lireFichier(filePath);
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	// ------- LISTE ------- //

	@Override
	public void lireFichier(String filePath)
	{
		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(filePath));

			try
			{
				String ligneActuelle;
				FragmentMolecule fragmentActuel = null;
				Integer cpt = 0;

				while ((ligneActuelle = buff.readLine()) != null)
				{
					if (!ligneActuelle.isEmpty())
					{
						fragmentActuel = (FragmentMolecule) creationListe(cpt, ligneActuelle, fragmentActuel);

						cpt++;

						if (FIN.matcher(ligneActuelle).find())
							fragmentsMolecules.add(fragmentActuel);
					}
				}
			}
			finally
			{
				buff.close();
			}
		}
		catch (IOException ioe)
		{
			System.out.println("Erreur --" + ioe.toString());
		}
	}

	private Object creationListe(Integer cpt, String ligne, FragmentMolecule fragment)
	{
		Matcher m;

		if (DEBUT.matcher(ligne).find())
		{
			fragment = new FragmentMolecule();
			fragment.setDebutDescription(ligne.trim());
		}
		else if (RESUME.matcher(ligne).find())
		{
			fragment.setResumeContenu(ligne.trim().split("( +)"));
		}
		else if (ATOMES.matcher(ligne).find())
		{
			String[] tmp = ligne.trim().split("( +)");
			Atome atome = new Atome();

			for (int i = 0 ; i < tmp.length ; i++)
			{
				if (i < 3)
					atome.getInfos().add(Float.parseFloat(tmp[i]));
				else if (i == 3)
					atome.setNom(tmp[i]);
				else
					atome.getDivers().add(Integer.parseInt(tmp[i]));
			}

			fragment.getAtomes().add(atome);
		}
		else if (LIAISONS.matcher(ligne).find())
		{
			String[] tmp = ligne.trim().split("( +)");
			LinkedList<String> content = new LinkedList<String>();

			for (int i = 0 ; i < tmp.length ; i++)
				content.add(tmp[i]);

			fragment.getLiaisons().add(content);
		}
		else if (BALISES.matcher(ligne).find())
		{
			m = BALISES.matcher(ligne);

			while (m.find())
				fragment.getBalises().addLast(new Balise(m.group(1)));
		}
		else if (INFO.matcher(ligne).find())
		{
			String[] tmp = ligne.trim().split("( +)");
			LinkedList<String> content = new LinkedList<String>();

			for (int i = 2 ; i < tmp.length ; i++)
				content.add(tmp[i]);

			fragment.getInfos().put(tmp[1], content);
		}
		else if (FIN.matcher(ligne).find())
			;
		else
		{
			fragment.getBalises().getLast().setValeur(ligne.trim());
		}

		return fragment;
	}

	// ------- TABLEAU ------- //

	@Override
	public Object[][] convertirListeVersTableau2D()
	{
		Object[][] tableau = new Object[fragmentsMolecules.size()][calculerLargeurTableau()];

		for (int i = 0 ; i < tableau.length ; i++)
			tableau[i] = convertirMoleculeVersTableau(i, fragmentsMolecules.get(i));

		return tableau;
	}

	private Integer calculerLargeurTableau()
	{
		return 2 + recupererIntitulesBalises().size();
	}

	public LinkedList<String> recupererIntitulesBalises()
	{
		LinkedList<String> l = new LinkedList<String>();

		for (int i = 0 ; i < fragmentsMolecules.size() ; i++)
			for (int j = 0 ; j < fragmentsMolecules.get(i).getBalises().size() ; j++)
				if (!l.contains(fragmentsMolecules.get(i).getBalises().get(j).getIntitule()))
					l.add(fragmentsMolecules.get(i).getBalises().get(j).getIntitule());
		
		return l;
	}

	private Object[] convertirMoleculeVersTableau(Integer indice, FragmentMolecule fragment)
	{
		Object[] tab = new Object[calculerLargeurTableau()];

		tab[0] = fragment.getAtomes().size();
		tab[1] = fragment.getLiaisons().size();

		LinkedList<String> listeBalises = recupererIntitulesBalises();

		for (int i = 0 ; i < listeBalises.size() ; i++)
			for (int j = 0 ; j < fragment.getBalises().size() ; j++)
				if (listeBalises.get(i).equals(fragment.getBalises().get(j).getIntitule()))
					tab[i + 2] = fragment.getBalises().get(j).getValeur();
		
		return tab;
	}

	// ------- TRIS ------- //

	@Override
	public void trierListe()
	{

	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public LinkedList<FragmentMolecule> getFragmentsMolecules()
	{
		return fragmentsMolecules;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setFragmentsMolecules(LinkedList<FragmentMolecule> molecules)
	{
		this.fragmentsMolecules = molecules;
	}

}
