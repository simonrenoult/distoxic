package modele.parseur;

import java.util.LinkedList;

public class FragmentMolecule
{
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //


	private String				debutDescription;
	private String				resumeContenu;
	private LinkedList<Atome>	listeAtomes;
	private LinkedList<String>	listeLiaisons;
	private LinkedList<String>	balises;
	private LinkedList<String>	contenuBalises;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public FragmentMolecule()
	{
		listeAtomes = new LinkedList<Atome>();
		listeLiaisons = new LinkedList<String>();
		balises = new LinkedList<String>();
		contenuBalises = new LinkedList<String>();
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	
	public void display()
	{
		try 
		{
			System.out.println("Debut du fragment : "+debutDescription);
			System.out.println("Resume du fragment : " +resumeContenu);
			
			for (int i = 0 ; i < listeAtomes.size() ; i++)
				System.out.println(listeAtomes.get(i));
			for (int i = 0 ; i < listeLiaisons.size() ; i++)
				System.out.println(listeLiaisons.get(i));
			for (int i = 0 ; i < balises.size() ; i++)
				System.out.println(balises.get(i));
		}
		catch(NullPointerException e)
		{
			
		}
	}
	
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public String getNumDebutDescription()
	{
		return debutDescription;
	}

	public LinkedList<Atome> getListeAtomes()
	{
		return listeAtomes;
	}

	public LinkedList<String> getLitseLiaisons()
	{
		return listeLiaisons;
	}

	public LinkedList<String> getBalises()
	{
		return balises;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setNumDebutDescription(String numDebutDescription)
	{
		this.debutDescription = numDebutDescription;
	}

	public void setListeAtomes(LinkedList<Atome> listeAtomes)
	{
		this.listeAtomes = listeAtomes;
	}

	public void setLitseLiaisons(LinkedList<String> listeLiaisons)
	{
		this.listeLiaisons = listeLiaisons;
	}

	public void setBalises(LinkedList<String> balises)
	{
		this.balises = balises;
	}

	public LinkedList<String> getContenuBalises()
	{
		return contenuBalises;
	}

	public void setContenuBalises(LinkedList<String> contenuBalises)
	{
		this.contenuBalises = contenuBalises;
	}

	public String getResumeContenu()
	{
		return resumeContenu;
	}

	public void setResumeContenu(String resumeContenu)
	{
		this.resumeContenu = resumeContenu;
	}


}
