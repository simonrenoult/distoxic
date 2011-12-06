package modele;

import java.util.ArrayList;

public class FragmentMoleculaire
{
	/**
	 * @author alexis
	 */
	
	
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private int					numero;
	private int					classe;
	private int					frequence;
	private float				toxicite;
	private float				emergence;

	private ArrayList<Atome>	listeAtome		= new ArrayList<Atome>();
	private ArrayList<Liaison>	listeLiaison	= new ArrayList<Liaison>();

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public FragmentMoleculaire()
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
	/**
	 * @return the numero
	 */
	public int getNumero()
	{
		return numero;
	}

	/**
	 * @return the nombreAtomes
	 */
	public int getClasse()
	{
		return classe;
	}

	/**
	 * @return the frequence
	 */
	public int getFrequence()
	{
		return frequence;
	}

	/**
	 * @return the toxicit�
	 */
	public float getToxicite()
	{
		return toxicite;
	}

	/**
	 * @return the emergence
	 */
	public float getEmergence()
	{
		return emergence;
	}
	
	/**
	 * @return the listeAtome
	 */
	public ArrayList<Atome> getListeAtome()
	{
		return listeAtome;
	}

	/**
	 * @return the listeLiaison
	 */
	public ArrayList<Liaison> getListeLiaison()
	{
		return listeLiaison;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero)
	{
		this.numero = numero;
	}

	/**
	 * @param nombreAtomes
	 *            the nombreAtomes to set
	 */
	public void setClasse(int classe)
	{
		this.classe = classe;
	}

	/**
	 * @param frequence
	 *            the frequence to set
	 */
	public void setFrequence(int frequence)
	{
		this.frequence = frequence;
	}
	
	/**
	 * @param toxicit
	 *            � the toxicit� to set
	 */
	public void setToxicite(float toxicite)
	{
		this.toxicite = toxicite;
	}

	/**
	 * @param emergence
	 *            the emergence to set
	 */
	public void setEmergence(float emergence)
	{
		this.emergence = emergence;
	}


	/**
	 * @param listeAtome
	 *            the listeAtome to set
	 */
	public void setListeAtome(ArrayList<Atome> listeAtome)
	{
		this.listeAtome = listeAtome;
	}

	/**
	 * @param listeLiaison
	 *            the listeLiaison to set
	 */
	public void setListeLiaison(ArrayList<Liaison> listeLiaison)
	{
		this.listeLiaison = listeLiaison;
	}
}
