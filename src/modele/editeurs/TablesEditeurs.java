package modele.editeurs;

import javax.swing.JTable;

@SuppressWarnings("serial")
public class TablesEditeurs extends JTable
{
	/**
	 * <h4>TablesEditeurs est la classe qui represente le tableau graphique de type JTable</h4>

	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe TablesEditeurs
	 * @param modele un modele de type AbstractTableModel
	 */
	public TablesEditeurs(ModeleTablesEditeurs modele)
	{
		super(modele);
		setDefaultRenderer(Object.class, new TablesEditeursCellRenderer());
	}
	
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
