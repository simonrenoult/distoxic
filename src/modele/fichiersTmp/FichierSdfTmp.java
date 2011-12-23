package modele.fichiersTmp;

import java.util.LinkedList;

import modele.composantsChimiques.Balise;
import modele.composantsChimiques.FragmentMolecule;
import modele.editeurs.TablesEditeurs;
import modele.parseurs.ParseurSDF;

public class FichierSdfTmp
{
	/**
	 * Classe possèdant un copie de la liste des molécules initialement parsée
	 * et se modifie en fonction des moficiations de l'utilisateur sur la jtable
	 * en vue de l'export ultérieur.
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

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //

	public void modifierValeurClasse(Integer positionLigne, String intituleColonne, String contenuCellule)
	{
		if(listeSDF.get(positionLigne).getBalise(intituleColonne) != null)
			listeSDF.get(positionLigne).getBalise(intituleColonne).setValeur(contenuCellule);
		else
			listeSDF.get(positionLigne).getBalises().add(new Balise(intituleColonne, contenuCellule));
		
	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// -------------- MUTATEURS --------------- //
	// ----------------------------------------- //

}
