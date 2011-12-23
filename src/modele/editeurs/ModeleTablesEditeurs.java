package modele.editeurs;

import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class ModeleTablesEditeurs extends AbstractTableModel 
{
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private static String _INITIALISATION_CHAMPS = "";
	private Object[][]	donnees;
	private String[]	titres;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public ModeleTablesEditeurs(LinkedList<String> titresColonnes, Object[][] donneesTableau)
	{
	}

	public ModeleTablesEditeurs(String[] titresColonnes, Object[][] donneesTableau)
	{
		this.titres = titresColonnes;
		this.donnees = donneesTableau;
		
	}

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //
	public void fireTableCellUpdated(int row,int column){
		super.fireTableCellUpdated(row, column);
	}
	
	/**
	 * Methode permettant de retirer une ligne du tableau
	 * 
	 * @param position
	 */
	public void SupprimerLigne(int position)
	{
		int cpt = 0, cpt2 = 0;
		int nbLigne = this.getRowCount() - 1, nbColonne = this.getColumnCount();
		Object tmp[][] = new Object [nbLigne] [nbColonne];
		
		for (Object [] value : this.donnees)
		{
			if (cpt != position){
				tmp[cpt2++] = value;
				
			}
			cpt++;
		}
		this.donnees = tmp;
		this.fireTableDataChanged();
	}
	
	/**
	 * Permet d'ajouter une ligne en debut de tableau
	 * 
	 * @param data
	 */
	public void ajouterLigneDebut(Object [] data)
	{
		int cpt = 0;
		int nbLigne = this.getRowCount(), nbColonne = this.getColumnCount();
		Object tmp[][] = this.donnees;
		this.donnees = new Object [nbLigne + 1] [nbColonne];
		
		if (tmp != null)
		{
			this.donnees[cpt] = data;
			this.donnees[cpt][0] = 0;
			cpt++;
			for (Object [] value : tmp){
				this.donnees[cpt] = value;
				this.donnees[cpt][0] = cpt;
				cpt++;
			}
		}
		this.fireTableDataChanged();
	}
	/**
	 * Permet d'ajouter une ligne en fin de tableau
	 * 
	 * @param data
	 */
	public void ajouterLigneFin(Object [] data)
	{
		int cpt = 0;
		int nbLigne = this.getRowCount(), nbColonne = this.getColumnCount();
		Object tmp[][] = this.donnees;
		this.donnees = new Object [nbLigne + 1] [nbColonne];
		
		if (tmp != null)
		{
			for (Object [] value : tmp){
				this.donnees[cpt] = value;
				this.donnees[cpt][0] = cpt;
				cpt++;
			}
			this.donnees[cpt] = data;
			this.donnees[cpt][0] = cpt; 
		}
		this.fireTableDataChanged();
	}
	
	/**
	 * Peemet d'ajouter une ligne avant la ligne selectionne
	 * @param data
	 * @param position
	 */
	public void ajouterLigneAvant(Object [] data, int position)
	{
		int cpt = 0;
		int nbLigne = this.getRowCount(), nbColonne = this.getColumnCount();
		Object tmp[][] = this.donnees.clone();
		this.donnees = new Object [nbLigne + 1] [nbColonne];
		if (tmp != null)
		{
			for (Object [] value : tmp){
				if(cpt == position){
					this.donnees[cpt] = data;
					this.donnees[cpt][0] = cpt;
					cpt++;
				}
				this.donnees[cpt] = value;
				this.donnees[cpt][0] = cpt;
				cpt++;
			}
			
		}
		this.fireTableDataChanged();
	}
	
	/**
	 * Peemet d'ajouter une ligne apres la ligne selectionne
	 * @param data
	 * @param position
	 */
	public void ajouterLigneApres(Object [] data, int position)
	{
		int cpt = 0;
		int nbLigne = this.getRowCount(), nbColonne = this.getColumnCount();
		Object tmp[][] = this.donnees.clone();
		this.donnees = new Object [nbLigne + 1] [nbColonne];
		
		if (tmp != null)
		{
			for (Object [] value : tmp){
				this.donnees[cpt] = value;
				this.donnees[cpt][0] = cpt;
				if(cpt == position){
					this.donnees[cpt+1] = data;
					this.donnees[cpt+1][0] = cpt+1;
					cpt++;
				}
				cpt++;
			}
			
		}
		this.fireTableDataChanged();
	}
	
	
	/**
	 * Retourne si un champ spécifique est editable.
	 */
	public boolean isCellEditable(int row, int col)
	{
		return true;
	}
	
	public Object [] creerLigneVierge(int columnCount) {
		Object [] data = new Object[columnCount];
		for (int i = 0; i< columnCount; i++){
			data[i] = _INITIALISATION_CHAMPS;
		}
		return data;
	}
	
	public void sort(int colonne){
		System.out.println("tri colonne "+colonne);
	}
	
	
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public String getColumnName(int indiceColonne)
	{
		return this.titres[indiceColonne];
	}

	@Override
	public int getColumnCount()
	{
		return this.titres.length;
	}

	@Override
	public int getRowCount()
	{
		return this.donnees.length;
	}

	@Override
	public Object getValueAt(int indiceLigne, int indiceColonne)
	{
		return this.donnees[indiceLigne][indiceColonne];
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setValueAt(Object value, int indiceLigne, int indiceColonne)
	{
		this.donnees[indiceLigne][indiceColonne] = value;
        fireTableCellUpdated(indiceLigne, indiceColonne);
	}
}
