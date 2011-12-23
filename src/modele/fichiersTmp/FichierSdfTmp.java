package modele.fichiersTmp;

import java.util.LinkedList;

import modele.composantsChimiques.FragmentMolecule;
import modele.editeurs.TablesEditeurs;

public class FichierSdfTmp
{
	/**
	 * Classe possèdant un copie de la liste des molécules initialement parsée et se
	 * modifie en fonction des moficiations de l'utilisateur sur la jtable en
	 * vue de l'export ultérieur.
	 * 
	 * @author Simon RENOULT
	 */

	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	private LinkedList<FragmentMolecule>	listeSDF;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public FichierSdfTmp(LinkedList<FragmentMolecule> listeSDF)
	{
		this.listeSDF = listeSDF;
	}

	public FichierSdfTmp()
	{
		this(new LinkedList<FragmentMolecule>());
	}

	public FichierSdfTmp(TablesEditeurs jtable)
	{
		this();
		ecrireModifications(jtable);
	}

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //

	private void ecrireModifications(TablesEditeurs tab)
	{
		
	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// -------------- MUTATEURS --------------- //
	// ----------------------------------------- //

}
