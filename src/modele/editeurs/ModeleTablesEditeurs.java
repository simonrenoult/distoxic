package modele.editeurs;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModeleTablesEditeurs extends AbstractTableModel
{
	/**
	 * <h4>ModeleTablesEditeurs est la classe qui represente le modele des tableaux graphiques (JTable).</h4>
	 *  
	 * @see BarreOutils
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * Constante de classe.
	 */
	private static String	_INITIALISATION_CHAMPS	= "";
	/**
	 * Tableau contenant les donnees de la Jtable
	 */
	private Object[][]		donnees;
	/**
	 * Tableau contenant les noms de colonnes de la Jtable.
	 */
	private String[]		titres;

	
	/**
	 * Comme les 3 jtables différente se serve du même modèle, les cellules non
	 * editables ne sont pas les même. 0 pour GPH, 1 pour SDF. Toutes les
	 * colonnes du Bin ne sont pas ediatbles.
	 */
	private int				indexJTable;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	
	/**
	 * Constructeur principal de la classe ModeleTablesEditeurs
	 * @param titresColonnes le Tableau de noms de colonnes
	 * @param donneesTableau le tableau de donnees
	 * @param indexJtable l'index qualifiant la Jtable.
	 */
	public ModeleTablesEditeurs(String[] titresColonnes, Object[][] donneesTableau, int indexJtable)
	{
		this.titres = titresColonnes;
		this.donnees = donneesTableau;
		this.indexJTable = indexJtable;
	}

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //

	/**
	 * Methode de MAJ d'une cellule.
	 * @param row indice de la ligne selectionnee
	 * @param column indice de la colonne selectionnee
	 */
	public void fireTableCellUpdated(int row, int column)
	{
		super.fireTableCellUpdated(row, column);
	}

	/**
	 * Methode permettant de retirer une ligne du tableau
	 * 
	 * @param position indice de la ligne selectionnee
	 */
	public void SupprimerLigne(int position)
	{
		int cpt = 0, cpt2 = 0;
		int nbLigne = this.getRowCount() - 1, nbColonne = this.getColumnCount();
		Object tmp[][] = new Object[nbLigne][nbColonne];

		for (Object[] value : this.donnees)
		{
			if (cpt != position)
			{
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
	 * @param data les donnees de la ligne representative
	 */
	public void ajouterLigneDebut(Object[] data)
	{
		int cpt = 0;
		int nbLigne = this.getRowCount(), nbColonne = this.getColumnCount();
		Object tmp[][] = this.donnees;
		this.donnees = new Object[nbLigne + 1][nbColonne];

		if (tmp != null)
		{
			this.donnees[cpt] = data;
			this.donnees[cpt][0] = 0;
			cpt++;
			for (Object[] value : tmp)
			{
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
	 * @param data les donnees de la ligne representative
	 */
	public void ajouterLigneFin(Object[] data)
	{
		int cpt = 0;
		int nbLigne = this.getRowCount(), nbColonne = this.getColumnCount();
		Object tmp[][] = this.donnees;
		this.donnees = new Object[nbLigne + 1][nbColonne];

		if (tmp != null)
		{
			for (Object[] value : tmp)
			{
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
	 * Peemet d'ajouter une ligne avant la ligne selectionnee
	 * 
	 * @param data les donnees de la ligne representative
	 * @param position indice de la ligne selectionnee
	 */
	public void ajouterLigneAvant(Object[] data, int position)
	{
		int cpt = 0;
		int nbLigne = this.getRowCount(), nbColonne = this.getColumnCount();
		Object tmp[][] = this.donnees.clone();
		this.donnees = new Object[nbLigne + 1][nbColonne];
		if (tmp != null)
		{
			for (Object[] value : tmp)
			{
				if (cpt == position)
				{
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
	 * Peemet d'ajouter une ligne apres la ligne selectionnee
	 * 
	 * @param data les donnees de la ligne representative
	 * @param position indice de la ligne selectionnee
	 */
	public void ajouterLigneApres(Object[] data, int position)
	{
		int cpt = 0;
		int nbLigne = this.getRowCount(), nbColonne = this.getColumnCount();
		Object tmp[][] = this.donnees.clone();
		this.donnees = new Object[nbLigne + 1][nbColonne];

		if (tmp != null)
		{
			for (Object[] value : tmp)
			{
				this.donnees[cpt] = value;
				this.donnees[cpt][0] = cpt;
				if (cpt == position)
				{
					this.donnees[cpt + 1] = data;
					this.donnees[cpt + 1][0] = cpt + 1;
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

		if (indexJTable == 0 && (col >= 3))
		{
			return true;
		}
		if (indexJTable == 1 && (col >= 3))
		{
			return true;
		}
		return false;
	}

	/**
	 * Methode de creation d'une ligne vierge selon un nombre de colonne connu?
	 * @param columnCount le nombre de colonne.
	 * @return le tableau de donnees
	 */
	public Object[] creerLigneVierge(int columnCount)
	{
		Object[] data = new Object[columnCount];
		for (int i = 0 ; i < columnCount ; i++)
		{
			data[i] = _INITIALISATION_CHAMPS;
		}
		return data;
	}

	/**
	 * Methode de tri d'une colonne
	 * @param colonne le numero de la colonne
	 */
	public void sort(int colonne)
	{
		System.out.println("tri colonne " + colonne);
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	/*
	 * @SuppressWarnings({ "unchecked", "rawtypes" }) public Class
	 * getColumnClass(int columnIndex){ return Integer.class; }
	 */
	/**
	 * Methode retournant le nom de la colonne
	 * @param l'indice de la colonne
	 * @return le libelle de la colonne
	 */
	public String getColumnName(int indiceColonne)
	{
		return this.titres[indiceColonne];
	}

	@Override
	/**
	 * Methode comptant le nombre de colonnes
	 * @return le nombre de colonnes
	 */
	public int getColumnCount()
	{
		return this.titres.length;
	}

	@Override
	/**
	 * Methode comptant le nombre de lignes
	 * @return le nombre de lignes
	 */
	public int getRowCount()
	{
		return this.donnees.length;
	}

	@Override
	/**
	 * Methode renvoyant le contenu de la cellule.
	 * @param indiceLigne indice de la ligne
	 * @param indiceColonne indice de la colonne
	 * @return le contenu de la cellule
	 */
	public Object getValueAt(int indiceLigne, int indiceColonne)
	{
		return this.donnees[indiceLigne][indiceColonne];
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	/**
	 * Methode modifaint le contenu de la cellule.
	 * @param indiceLigne indice de la ligne
	 * @param indiceColonne indice de la colonne
	 */
	public void setValueAt(Object value, int indiceLigne, int indiceColonne)
	{
		this.donnees[indiceLigne][indiceColonne] = value;
		fireTableCellUpdated(indiceLigne, indiceColonne);
	}
}
