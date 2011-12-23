package modele.FichierTmp;

import java.io.File;
import java.util.LinkedList;

import modele.composantsChimiques.FragmentMolecule;

public class FichierSDFTmp {
// ----------------------------------------- //
// ----------------ATRIBUTS----------------- //
// ----------------------------------------- //
	private LinkedList<FragmentMolecule>	fragmentsMolecules;
// ----------------------------------------- //
// --------------CONSTRUCTEURS-------------- //
// ----------------------------------------- //

	
// ----------------------------------------- //
// -------------INITIALISEURS--------------- //
// ----------------------------------------- //

// ----------------------------------------- //
// -----------------METHODES---------------- //
// ----------------------------------------- //
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
// ---------------ACCESSEURS---------------- //
// ----------------------------------------- //
	/**
	 * @return the fragmentsMolecules
	 */
	public LinkedList<FragmentMolecule> getFragmentsMolecules() {
		return fragmentsMolecules;
	}

	/**
	 * @param fragmentsMolecules the fragmentsMolecules to set
	 */
	public void setFragmentsMolecules(
			LinkedList<FragmentMolecule> fragmentsMolecules) {
		this.fragmentsMolecules = fragmentsMolecules;
	}

// ----------------------------------------- //
// ----------------MUTATEURS---------------- //
// ----------------------------------------- //
}
