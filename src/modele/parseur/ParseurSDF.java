package modele.parseur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ParseurSDF implements ParseurGenerique
{
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	private LinkedList<FragmentMoleculeSDF>	listeMolecules;
	private Object[][]						tableauMolecules;

	private final static String				DEBUT_DESCRIPTION	= "  ";
	private final static String				SEPARATEUR_ATOME	= "    ";
	private final static String				SEPARATEUR_LIAISONS	= "  ";
	private final static String				FIN_DESCRIPTION		= "$$$$";

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public ParseurSDF(String filePath)
	{
		listeMolecules = new LinkedList<FragmentMoleculeSDF>();
		lireFichier(filePath);
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

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

				while ((ligneActuelle = buff.readLine()) != null)
				{
					creationListe(ligneActuelle);
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
	 * b : Extrémité de mot.
	 * t : Tabulation.
	 * n : Le caractère de nouvelle ligne.
	 * f : Espace.
	 * r : Le caractère de retour en début de ligne.
	 */
	private FragmentMoleculeSDF creationListe(String ligne)
	{
		if(ligne.matches("^[ ]{2}[A-Za-z0-9]{1,}"))
			System.out.println(ligne);
				
		return null;
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
		ParseurSDF p = new ParseurSDF("workspace/exemple_60_56/exemple_56.sdf");
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

}
