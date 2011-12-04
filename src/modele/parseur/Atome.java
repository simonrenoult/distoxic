package modele.parseur;

import java.util.ArrayList;
import java.util.LinkedList;

public class Atome
{
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	private String				nom;
	private LinkedList<Float>	infos;
	private LinkedList<Integer>	divers;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public Atome()
	{
		infos = new LinkedList<Float>();
		divers = new LinkedList<Integer>();
	}

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //
	
	public void afficher()
	{
		System.out.println("Atome - "+nom);
		
		System.out.println("Infos : ");		
		for (int i = 0 ; i < infos.size() ; i++)
			System.out.print(infos.get(i)+"  ");
		
		System.out.println();
		
		System.out.println("Divers : ");
		for (int i = 0 ; i < divers.size() ; i++)
			System.out.print(divers.get(i)+"  ");
	}
	
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public String getNom()
	{
		return nom;
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
}
