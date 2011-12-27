package modele.composantsChimiques;

public class Balise
{	
	/**
	 * <h4>Balise est la classe d'aide a la creation d'objet de type FragmentMolecule</h4>
	 * 
	 * <p>
	 * Remarque : A chaque balise correspond une valeur.
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
	 * Libelle de la balise.
	 */
	private String intitule;
	/**
	 * Valeur de la balise liee a la varaible intitule
	 */
	private String valeur;
	
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	/**
	 * Constructeur par defaut de la classe Balise
	 */
	public Balise()
	{
		this("","");
	}
	
	/**
	 * Constructeur de la classe Balise. Creation d'une balise sans valeur
	 * @param titre
	 */
	public Balise(String titre)
	{
		setIntitule(titre);
		setValeur("");
	}
	
	/**
	 * Constructeur de la classe Balise. Creation d'une balise avec valeur
	 * @param titre le libelle de la balise
	 * @param val la valeur associee a la blaise
	 */
	public Balise(String titre, String val)
	{
		setIntitule(titre);
		setValeur(val);
	}
	
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	/**
	 * Redefinition de la methode toString.
	 */
	public String toString ()
	{
		return "Titre : "+intitule+'\n'
				+"Valeur : "+valeur;
	}
	
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public String getIntitule()
	{
		return intitule;
	}

	public String getValeur()
	{
		return valeur;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	
	public void setIntitule(String intitule)
	{
		this.intitule = intitule;
	}
	public void setValeur(String valeur)
	{
		this.valeur = valeur;
	}
	
}
