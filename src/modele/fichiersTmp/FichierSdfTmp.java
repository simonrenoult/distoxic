package modele.fichiersTmp;

import java.io.File;
import java.util.LinkedList;

import modele.composantsChimiques.Balise;
import modele.composantsChimiques.FragmentMolecule;


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
	
	public String creerCheminNouveauFichier(String path){
		File fichierReference = new File(path);
		String nomFichier = fichierReference.getName();
		System.out.println(nomFichier);
		String tabNomFichier[] = nomFichier.split(".sdf");
		
		File dossier = fichierReference.getParentFile();
		String listeDossier[] = dossier.list();
		int cpt = 0;
		for (int i = 0; i< listeDossier.length; i++){
			if (listeDossier[i].endsWith("sdf")){
				cpt++;
			}
		}
		
		
		nomFichier = tabNomFichier[0]+"_("+cpt+")"+".sdf";
		
		return dossier.getPath()+File.separator+nomFichier;
	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// -------------- MUTATEURS --------------- //
	// ----------------------------------------- //
	/**
	 * @return the fragmentsMolecules
	 */
	public LinkedList<FragmentMolecule> getListeSDF() {
		return listeSDF;
	}

	/**
	 * @param fragmentsMolecules the fragmentsMolecules to set
	 */
	public void setListeSDF(
			LinkedList<FragmentMolecule> listeSDF) {
		this.listeSDF = listeSDF;
	}

}
