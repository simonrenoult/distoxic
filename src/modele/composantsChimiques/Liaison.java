package modele.composantsChimiques;

public class Liaison
{

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private int	indiceAtomeRelie1;
	private int	indiceAtomeRelie2;
	private int	nombreLiaison;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	/**
	 * Cette classe est utile pour l'exploitation de donn�es. Elle d�pend de la
	 * classe FragmentMoleculaire.
	 * 
	 * @param a
	 * @param b
	 * @param nb
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
