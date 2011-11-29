package modele.parseur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class ParseurSDF implements ParseurGenerique
{
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	private LinkedList<FragmentMoleculeSDF>	listeMolecules;
	private Object[][]						tableauMolecules;

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
					if(!ligneActuelle.isEmpty())
					{	
						
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

	private FragmentMoleculeSDF creationListe(String line)
	{

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
