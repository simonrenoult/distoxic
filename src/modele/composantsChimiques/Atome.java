package src.modele.composantsChimiques;

import java.util.LinkedList;

public class Atome
{
	/**
	 * <h4>Atome est la classe d'aide a la creation d'objet de type FragmentMolecule</h4>
	 * 
	 * <p>
	 * Remarque : La classe Atome decrit un atome chimique.
	 * </p>
	 * 
	 * @see FragmentMolecule
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	/**
	 * Un atome est decrit par un nom.
	 */
	private String				nom;
	/**
	 * Un atome est indexe dans un fichier
	 */
	private Integer				indice;
	/**
	 * Un atome est decrit par un numero atomique.
	 */
	private Integer				numeroAtomique;
	/**
	 * Un atome est decrit par un indice 
	 */
	private LinkedList<Float>	infos;
	private LinkedList<Integer>	divers;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	/**
	 * 
	 */
	public Atome()
	{
		setInfos(new LinkedList<Float>());
		setDivers(new LinkedList<Integer>());
	}
	
	/**
	 * Cette classe est utile pour l'exploitation de donn�es. Elle d�pend de la
	 * classe FragmentMoleculaire.
	 * 
	 * @param ind
	 * @param z
	 */
	public Atome(int ind, int z)
	{
		this();
		
		this.indice = ind;
		this.numeroAtomique = z;
	}

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //

	public String toString()
	{
		return nom + " : " + infos + " " + divers;
	}

	public void afficher()
	{
		System.out.println("Atome - " + nom);

		System.out.println("Infos : ");
		for (int i = 0 ; i < infos.size() ; i++)
			System.out.print(infos.get(i) + "  ");

		System.out.println();

		System.out.println("Divers : ");
		for (int i = 0 ; i < divers.size() ; i++)
			System.out.print(divers.get(i) + "  ");
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public String getNom()
	{
		return nom;
	}

	/**
	 * @return the indice
	 */
	public int getIndice()
	{
		return indice;
	}

	/**
	 * @return the numeroAtomique
	 */
	public int getNumeroAtomique()
	{
		return numeroAtomique;
	}
	
	public LinkedList<Float> getInfos()
	{
		return infos;
	}

	public LinkedList<Integer> getDivers()
	{
		return divers;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public void setInfos(LinkedList<Float> infos)
	{
		this.infos = infos;
	}

	public void setDivers(LinkedList<Integer> divers)
	{
		this.divers = divers;
	}

	/**
	 * @param indice
	 *            the indice to set
	 */
	public void setIndice(int indice)
	{
		this.indice = indice;
	}

	/**
	 * @param numeroAtomique
	 *            the numeroAtomique to set
	 */
	public void setNumeroAtomique(int numeroAtomique)
	{
		this.numeroAtomique = numeroAtomique;
	}
}
