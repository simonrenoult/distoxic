package modele.parseur;

import java.util.LinkedList;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class FragmentMoleculeSDF
{
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //


	private String				numDebutDescription;
	private LinkedList<Float>	listeAtomes;
	private LinkedList<Integer>	listeLiaisons;
	private Hashtable			balises;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public FragmentMoleculeSDF()
	{

	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public String getNumDebutDescription()
	{
		return numDebutDescription;
	}

	public LinkedList<Float> getListeAtomes()
	{
		return listeAtomes;
	}

	public LinkedList<Integer> getLitseLiaisons()
	{
		return listeLiaisons;
	}

	public Hashtable getBalises()
	{
		return balises;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setNumDebutDescription(String numDebutDescription)
	{
		this.numDebutDescription = numDebutDescription;
	}

	public void setListeAtomes(LinkedList<Float> listeAtomes)
	{
		this.listeAtomes = listeAtomes;
	}

	public void setLitseLiaisons(LinkedList<Integer> listeLiaisons)
	{
		this.listeLiaisons = listeLiaisons;
	}

	public void setBalises(Hashtable balises)
	{
		this.balises = balises;
	}


}
