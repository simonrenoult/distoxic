package modele.composantsChimiques;

public class Balise
{	
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	private String intitule;
	private String valeur;
	
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public Balise()
	{
		this("","");
	}
	
	public Balise(String titre)
	{
		setIntitule(titre);
		setValeur("");
	}
	
	public Balise(String titre, String val)
	{
		setIntitule(titre);
		setValeur(val);
	}
	
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

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
