
package vue.editeurs;

import javax.jws.WebParam.Mode;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModeleTablesEditeurs extends AbstractTableModel
{
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	private Object[][]	donnees;
	private String[]	titres;
	
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	public ModeleTablesEditeurs(String[] titresColonnes,Object[][] donneesTableau)
	{		
		this.titres = titresColonnes;
		this.donnees = donneesTableau;
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
	public Object getValueAt(int indiceLigne,int indiceColonne)
	{
		return this.donnees[indiceLigne][indiceColonne];
	}
	
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	
	public void setValueAt(Object value, int indiceLigne,int indiceColonne)
	{
		this.donnees[indiceLigne][indiceColonne] = value;
	}
}
