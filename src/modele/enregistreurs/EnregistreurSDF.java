package src.modele.enregistreurs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import src.modele.composantsChimiques.FragmentMolecule;


public class EnregistreurSDF implements EnregistreurGenerique
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	private final static String				DESCRIPTION	= "  ";

	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	private LinkedList<FragmentMolecule>	listeSDF;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public EnregistreurSDF(LinkedList<FragmentMolecule> l)
	{
		listeSDF = l;
	}

	public EnregistreurSDF(LinkedList<FragmentMolecule> l, String path)
	{
		this(l);
		ecrireFichier(path);
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	@Override
	public boolean ecrireFichier(String path)
	{
		boolean b = true;
		try
		{
			BufferedWriter buff = new BufferedWriter(new FileWriter(path));

			try
			{
				for (int i = 0 ; i < listeSDF.size() ; i++)
				{
					listeSDF.get(i).display();

					ecrireEnteteFragment(buff, i);
					buff.write('\n');
					ecrireResumeFragment(buff, i);
					buff.write('\n');
					ecrireAtomesFragment(buff, i);
					ecrireLiaisonsFragment(buff, i);
					ecrireInfosFragment(buff, i);
					ecrireBalisesFragments(buff, i);
					buff.write("$$$$");
					buff.write('\n');
				}
			}
			finally
			{
				buff.close();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
			b = false;
		}
		return b;
	}

	private void ecrireEnteteFragment(BufferedWriter buff, int i)
	{
		try
		{
			buff.write('\n');
			buff.write(DESCRIPTION + listeSDF.get(i).getDebutDescription().toString());
			buff.write('\n');
		}
		catch (IOException e)
		{
			System.out.println("EnregistreurSDF - Erreur d'entree/sortie");
		}
	}

	private void ecrireResumeFragment(BufferedWriter buff, int i)
	{
		try
		{
			buff.write(" ");

			for (int j = 0 ; j < listeSDF.get(i).getResumeContenu().length - 2 ; j++)
			{
				if (listeSDF.get(i).getResumeContenu()[j].length() == 1)
					buff.write(' ' + listeSDF.get(i).getResumeContenu()[j] + ' ');
				else if (listeSDF.get(i).getResumeContenu()[j].length() == 2)
					buff.write(listeSDF.get(i).getResumeContenu()[j] + ' ');
			}
			buff.write("           " + listeSDF.get(i).getResumeContenu()[6] + ' '
					+ listeSDF.get(i).getResumeContenu()[7]);
		}
		catch (IOException e)
		{
			System.out.println("EnregistreurSDF - Erreur d'entree/sortie");
		}
	}

	private void ecrireAtomesFragment(BufferedWriter buff, int i)
	{
		try
		{
			for (int j = 0 ; j < listeSDF.get(i).getAtomes().size() ; j++)
			{
				for (int k = 0 ; k < listeSDF.get(i).getAtomes().get(j).getInfos().size() ; k++)
				{
					String nb = listeSDF.get(i).getAtomes().get(j).getInfos().get(k).toString();
					if (listeSDF.get(i).getAtomes().get(j).getInfos().get(k) < 0)
					{
						if (nb.length() == 4)
							nb += "000";
						else if (nb.length() == 5)
							nb += "00";
						else if (nb.length() == 6)
							nb += "0";

						buff.write("   " + nb);
					}
					else
					{
						if (nb.length() == 3)
							nb += "000";
						else if (nb.length() == 4)
							nb += "00";
						else if (nb.length() == 5)
							nb += "0";

						buff.write("    " + nb);
					}
				}

				if (listeSDF.get(i).getAtomes().get(j).getNom().length() == 1)
					buff.write(' ' + listeSDF.get(i).getAtomes().get(j).getNom() + ' ');
				else if (listeSDF.get(i).getAtomes().get(j).getNom().length() == 2)
					buff.write(' ' + listeSDF.get(i).getAtomes().get(j).getNom());

				for (int k = 0 ; k < listeSDF.get(i).getAtomes().get(j).getDivers().size() ; k++)
					buff.write("  " + listeSDF.get(i).getAtomes().get(j).getDivers().get(k).toString());

				buff.write('\n');
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void ecrireLiaisonsFragment(BufferedWriter buff, int i)
	{
		try
		{
			for (int j = 0 ; j < listeSDF.get(i).getLiaisons().size() ; j++)
			{
				for (int k = 0 ; k < listeSDF.get(i).getLiaisons().get(j).size() ; k++)
				{
					if (listeSDF.get(i).getLiaisons().get(j).get(k).length() == 1)
						buff.write("  " + listeSDF.get(i).getLiaisons().get(j).get(k));
					else if (listeSDF.get(i).getLiaisons().get(j).get(k).length() == 2)
						buff.write(" " + listeSDF.get(i).getLiaisons().get(j).get(k));
				}

				buff.write('\n');
			}
		}
		catch (IOException e)
		{
			System.out.println("EnregistreurSDF - Erreur d'entree/sortie");
		}
	}

	private void ecrireInfosFragment(BufferedWriter buff, int i)
	{
		try
		{
			Iterator<String> it = listeSDF.get(i).getInfos().keySet().iterator();
			String clef = null;
			LinkedList<String> val = null;

			for (int j = 0 ; j < listeSDF.get(i).getInfos().size() ; j++)
			{
				while (it.hasNext())
				{
					clef = (String) it.next();
					val = (LinkedList<String>) listeSDF.get(i).getInfos().get(clef);

					buff.write((clef.contains("END")) ? "M  " + clef : "M  " + clef + " ");

					for (int k = 0 ; k < val.size() ; k++)
					{
						if (val.get(k).length() == 1)
							buff.write(' ' + val.get(k) + "  ");
						else
							buff.write((k == val.size() - 1) ? val.get(k) : val.get(k) + "  ");
					}

					buff.write('\n');

				}
			}
		}
		catch (IOException e)
		{
			System.out.println("EnregistreurSDF - Erreur d'entree/sortie");
		}
	}

	private void ecrireBalisesFragments(BufferedWriter buff, int i)
	{
		try
		{
			for (int j = 0 ; j < listeSDF.get(i).getBalises().size() ; j++)
			{
				buff.write("> <" + listeSDF.get(i).getBalises().get(j).getIntitule() + '>');
				buff.write('\n');

				if (listeSDF.get(i).getBalises().get(j).getIntitule().contains("HOMO"))
					buff.write("    " + listeSDF.get(i).getBalises().get(j).getValeur());
				else if (listeSDF.get(i).getBalises().get(j).getIntitule().contains("LUMO"))
				{
					if (listeSDF.get(i).getBalises().get(j).getIntitule().contains("-"))
						buff.write("    " + listeSDF.get(i).getBalises().get(j).getValeur());
					else
						buff.write("     " + listeSDF.get(i).getBalises().get(j).getValeur());
				}
				else
					buff.write(listeSDF.get(i).getBalises().get(j).getValeur());

				buff.write('\n');
				buff.write('\n');
			}
		}
		catch (IOException e)
		{
			System.out.println("EnregistreurSDF - Erreur d'entree/sortie");
		}
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
