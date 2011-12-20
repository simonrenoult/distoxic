package modele.editeurs;

import javax.swing.JTable;

public class TablesEditeurs extends JTable
{
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public TablesEditeurs(ModeleTablesEditeurs modele)
	{
		super(modele);
		TablesEditeursCellRenderer cellRenderer = new TablesEditeursCellRenderer();
		setDefaultRenderer(Object.class, cellRenderer);
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
