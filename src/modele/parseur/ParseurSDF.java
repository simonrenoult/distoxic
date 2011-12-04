package modele.parseur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseurSDF implements ParseurGenerique
{
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	private LinkedList<FragmentMolecule>	molecules;
	private Object[][]						tabMolecules;

	public final static Pattern				DEBUT			= Pattern.compile("^[ ]{2}[A-Z][A-Za-z0-9]+");
	public final static Pattern				RESUME_FRAGMENT	= Pattern
																	.compile("^[ ]([0-9]+( +)){6}( +)[0-9]{3}( +)[A-Z][0-9]{3}");
	public final static Pattern				ATOMES			= Pattern
																	.compile("^([ ]{3}( |-)[0-9][.][0-9]{4}){3}[ ][A-Z](( +)[0-9])+");
	public final static Pattern				LIAISONS		= Pattern.compile("^[ ](( |[0-9])[0-9]+[ ]){1}");
	public final static Pattern				INFO			= Pattern.compile("M[ ]{2}([A-Z]{3})");
	public final static Pattern				BALISES			= Pattern.compile("<(.+)>");
	public final static Pattern				BALISES_CONTENT	= Pattern.compile("");
	public final static Pattern				FIN				= Pattern.compile("^[$]{4}");

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public ParseurSDF(String filePath)
	{
		molecules = new LinkedList<FragmentMolecule>();
		lireFichier(filePath);
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

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
						fragmentActuel = (FragmentMolecule) creationListe(ligneActuelle, fragmentActuel, cpt);
						molecules.addLast(fragmentActuel);
						cpt++;
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
			// erreur de fermeture des flux
			System.out.println("Erreur --" + ioe.toString());
		}
	}

	/*
	 * b : Extremite de mot. t : Tabulation. n : Le caractere de nouvelle ligne.
	 * f : Espace. r : Le caractere de retour en debut de ligne.
	 */
	public Object creationListe(String ligne, FragmentMolecule fragment, Integer cpt)
	{
		Matcher m;
		if (DEBUT.matcher(ligne).find())
		{
			fragment = new FragmentMolecule();
			fragment.setNumDebutDescription(ligne.trim());
		}
		else if (RESUME_FRAGMENT.matcher(ligne).find())
			fragment.setResumeContenu(ligne);
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

			fragment.getListeAtomes().add(atome);			
		}
		else if (LIAISONS.matcher(ligne).find())
			fragment.getLitseLiaisons().add(ligne);	
		//FIXME
		else if ((m = BALISES.matcher(ligne)) != null)
			while(m.find())
				fragment.getBalises().add(m.group(1));
		else if (FIN.matcher(ligne).find());
		else if (INFO.matcher(ligne).find())
		{
			
		}
		else
		{
		}
		
		return fragment;

	}

	@Override
	public void trierListe()
	{

	}

	@Override
	public Object[][] convertirListeVersTableau()
	{
		return null;
	}

	public static void main(String[] args)
	{
		ParseurSDF p = new ParseurSDF("workspace/exemple_60_56/test.sdf");
		//ParseurSDF p = new ParseurSDF("workspace/exemple_60_56/exemple_56.sdf");
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

}
