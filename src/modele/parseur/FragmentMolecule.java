package modele.parseur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class FragmentMolecule
{
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	private String								debutDescription;
	private String								resumeContenu;
	private LinkedList<Atome>					atomes;
	private LinkedList<LinkedList<String>>		liaisons;
	private LinkedList<String>					balises;
	private LinkedList<String>					contenuBalises;
	private HashMap<String, LinkedList<String>>	infos;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public FragmentMolecule()
	{
		setAtomes(new LinkedList<Atome>());
		setLiaisons(new LinkedList<LinkedList<String>>());
		setBalises(new LinkedList<String>());
		setContenuBalises(new LinkedList<String>());
		setInfos(new HashMap<String, LinkedList<String>>());
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	public void display()
	{
		try
		{
			System.out.println("Debut du fragment : " + debutDescription);
			System.out.println("Resume du fragment : " + resumeContenu);

			for (int i = 0 ; i < atomes.size() ; i++)
				System.out.println("Atome - " + atomes.get(i));
			for (int i = 0 ; i < liaisons.size() ; i++)
				System.out.println("Liaison - " + liaisons.get(i));
			for (int i = 0 ; i < balises.size() ; i++)
				System.out.println("Balise - " + balises.get(i));
			for (int i = 0 ; i < contenuBalises.size() ; i++)
				System.out.println("Contenu balise - "+contenuBalises.get(i));
			System.out.println("Infos - " +infos.keySet()+infos.values());
		}
		catch (NullPointerException e)
		{

		}
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

	public LinkedList<String> getBalises()
	{
		return balises;
	}

	public LinkedList<String> getContenuBalises()
	{
		return contenuBalises;
	}

	public String getResumeContenu()
	{
		return resumeContenu;
	}

	public HashMap<String, LinkedList<String>> getInfos()
	{
		return infos;
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

	public void setBalises(LinkedList<String> balises)
	{
		this.balises = balises;
	}

	public void setContenuBalises(LinkedList<String> contenuBalises)
	{
		this.contenuBalises = contenuBalises;
	}

	public void setResumeContenu(String resumeContenu)
	{
		this.resumeContenu = resumeContenu;
	}

	public void setInfos(HashMap<String, LinkedList<String>> infos)
	{
		this.infos = infos;
	}

}
