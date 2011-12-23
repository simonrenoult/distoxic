package modele.FichierTmp;

import java.util.LinkedList;

public class FichierBinTmp {
// ----------------------------------------- //
// ----------------ATRIBUTS----------------- //
// ----------------------------------------- //
	private LinkedList<LinkedList<Integer>>	listeBINTmp	= null;
// ----------------------------------------- //
// --------------CONSTRUCTEURS-------------- //
// ----------------------------------------- //
	public FichierBinTmp(LinkedList<LinkedList<Integer>>	listeBIN) {
		listeBINTmp = listeBIN;
	}
// ----------------------------------------- //
// -------------INITIALISEURS--------------- //
// ----------------------------------------- //
	
	

// ----------------------------------------- //
// -----------------METHODES---------------- //
// ----------------------------------------- //
	
	public void suppressionLigneLigneFichierBinTmp(int position){
		listeBINTmp.remove(position);
	}
	
	public void AjouterLigneLigneFichierBinTmp(int position,int numéro ){
		LinkedList<Integer> element = new LinkedList<Integer>();
		element.add(-1);
		element.add(-2);
		listeBINTmp.add(position, element);
		
	}
	
	public void mofifierValeurClasse( int positionLigne, int positionColonne, int valeur){
		if(positionColonne == 1){
			listeBINTmp.get(positionLigne).set(0, valeur);
		}
		else{
			//traitement sur les fragments incorpore a une molecule.
		}
		
	}
	
	public void ajoutFragment( int positionLigne, int valeurFragment){
		int i = 0; 
		while (i < listeBINTmp.get(positionLigne).size() && 
				listeBINTmp.get(positionLigne).get(i) != valeurFragment){
			i++;
		}
		if(i == listeBINTmp.get(positionLigne).size()){
			listeBINTmp.get(positionLigne).addLast(valeurFragment);
		}
	}
	
	/**
	 * Creation de la chaine a retourner pour le tooltip de chaque ligne du tableau BIN
	 * @param indexMolecule
	 * @return
	 */
	public String afficherListeFragmentAssociee(int indexMolecule){
		String line = "";
		//on echappe 0 car c'est la classe representative de la molecule.
		for (int i = 1; i< listeBINTmp.get(indexMolecule).size(); i++){
			if(i+1 == listeBINTmp.get(indexMolecule).size()){
				line = line + listeBINTmp.get(indexMolecule).get(i).toString();
			}
			else{
				line = line + listeBINTmp.get(indexMolecule).get(i).toString()+",";
			}
		}
		return line;
	}
	
	public void afficherListeBIN()
	{
		for (LinkedList<Integer> liste : listeBINTmp)
		{
			System.out.println();
			System.out.println("________________________________");
			for (int i = 0 ; i < liste.size() ; i++)
			{
				System.out.print(liste.get(i).toString() + " ");
			}
		}
	}
// ----------------------------------------- //
// ---------------ACCESSEURS---------------- //
// ----------------------------------------- //
	/**
	 * @return the listeBINTmp
	 */
	public LinkedList<LinkedList<Integer>> getListeBINTmp() {
		return listeBINTmp;
	}
// ----------------------------------------- //
// ----------------MUTATEURS---------------- //
// ----------------------------------------- //
	/**
	 * @param listeBINTmp the listeBINTmp to set
	 */
	public void setListeBINTmp(LinkedList<LinkedList<Integer>> listeBINTmp) {
		this.listeBINTmp = listeBINTmp;
	}
}
