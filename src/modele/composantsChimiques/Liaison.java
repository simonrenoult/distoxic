package modele.composantsChimiques;

public class Liaison
{

	/**
	 * <h4>Liaison est la classe d'aide a la creation d'objet de type FragmentMolecule</h4>
	 * 
	 * <p>
	 * Remarque : La classe Liaison decrit une liaison chimique entre deux atomes
	 * </p>
	 * 
	 * @see FragmentMolecule
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * Premier atome lie
	 */
	private int	indiceAtomeRelie1;
	/**
	 * Second atome lie
	 */
	private int	indiceAtomeRelie2;
	/**
	 * Nombre de liaison entre les deux atomes.
	 */
	private int	nombreLiaison;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	/**
	 * Constructeur principal de la classe Liaison
	 * 
	 * @param a indice du premier atome
	 * @param b indice du second atome
	 * @param nb nombre de liaison.
	 */
	public Liaison(int a, int b, int nb)
	{
		this.indiceAtomeRelie1 = a;
		this.indiceAtomeRelie2 = b;
		this.nombreLiaison = nb;
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
	 * @return the atomeRelie1
	 */
	public int getAtomeRelie1()
	{
		return indiceAtomeRelie1;
	}

	/**
	 * @param atomeRelie1
	 *            the atomeRelie1 to set
	 */
	public void setAtomeRelie1(int atomeRelie1)
	{
		this.indiceAtomeRelie1 = atomeRelie1;
	}

	/**
	 * @return the atomeRelie2
	 */
	public int getAtomeRelie2()
	{
		return indiceAtomeRelie2;
	}

	/**
	 * @param atomeRelie2
	 *            the atomeRelie2 to set
	 */
	public void setAtomeRelie2(int atomeRelie2)
	{
		this.indiceAtomeRelie2 = atomeRelie2;
	}

	/**
	 * @return the nombreLiaison
	 */
	public int getNombreLiaison()
	{
		return nombreLiaison;
	}

	/**
	 * @param nombreLiaison
	 *            the nombreLiaison to set
	 */
	public void setNombreLiaison(int nombreLiaison)
	{
		this.nombreLiaison = nombreLiaison;
	}
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
