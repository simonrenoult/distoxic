package src.modele.composantsChimiques;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class FragmentMolecule
{
	/**
	 * @author g4llic4
	 */

	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	private String										debutDescription;
	private String[]									resumeContenu;

	private LinkedList<Atome>							atomes;
	private LinkedList<LinkedList<String>>				liaisons;
	private LinkedList<Liaison>							listeLiaison;
	private LinkedList<Balise>							balises;
	private LinkedHashMap<String, LinkedList<String>>	infos;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public FragmentMolecule()
	{

		setAtomes(new LinkedList<Atome>());
		setLiaisons(new LinkedList<LinkedList<String>>());
		setListeLiaison(new LinkedList<Liaison>());
		setBalises(new LinkedList<Balise>());
		setInfos(new LinkedHashMap<String, LinkedList<String>>());
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	public void display()
	{
		System.out.println("======================================");
		System.out.println("Debut du fragment : " + debutDescription);
		System.out.println("======================================");
		System.out.println("Resume du fragment : ");
		for (int i = 0 ; i < resumeContenu.length ; i++)
			System.out.print(resumeContenu[i] + ' ');
		System.out.println('\n' + "======================================");

		for (int i = 0, j = 1 ; i < atomes.size() ; i++, j++)
			System.out.println("Atome " + j + " - " + atomes.get(i));

		System.out.println("======================================");

		for (int i = 0, j = 1 ; i < liaisons.size() ; i++, j++)
			System.out.println("Liaison " + j + " - " + liaisons.get(i));

		System.out.println("======================================");

		for (int i = 0 ; i < balises.size() ; i++)
		{
			System.out.println(balises.get(i));
			System.out.println("--------------------------------------");
		}

		System.out.println("======================================");
		System.out.println("Infos - " + infos.toString() + '\n' + "======================================" + '\n');

		System.out.println("###################################");
		System.out.println();
	}

	public String toString()
	{
		return debutDescription + '\n' + resumeContenu;
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public String getDebutDescription()
	{
		return debutDescription;
	}

	public LinkedList<Atome> getAtomes()
	{
		return atomes;
	}

	public LinkedList<LinkedList<String>> getLiaisons()
	{
		return liaisons;
	}

	public LinkedList<Balise> getBalises()
	{
		return balises;
	}

	public String[] getResumeContenu()
	{
		return resumeContenu;
	}

	public LinkedHashMap<String, LinkedList<String>> getInfos()
	{
		return infos;
	}

	public Balise getBalise(String intitule)
	{
		for (Balise b : balises)
			if (b.getIntitule().equals(intitule))
				return b;

		return null;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setDebutDescription(String numDebutDescription)
	{
		this.debutDescription = numDebutDescription;
	}

	public void setAtomes(LinkedList<Atome> listeAtomes)
	{
		this.atomes = listeAtomes;
	}

	public void setLiaisons(LinkedList<LinkedList<String>> listeLiaisons)
	{
		this.liaisons = listeLiaisons;
	}

	public void setBalises(LinkedList<Balise> balises)
	{
		this.balises = balises;
	}

	public void setResumeContenu(String[] resumeContenu)
	{
		this.resumeContenu = resumeContenu;
	}

	public void setInfos(LinkedHashMap<String, LinkedList<String>> infos)
	{
		this.infos = infos;
	}

	public LinkedList<Liaison> getListeLiaison()
	{
		return listeLiaison;
	}

	public void setListeLiaison(LinkedList<Liaison> listeLiaison)
	{
		this.listeLiaison = listeLiaison;
	}

}
