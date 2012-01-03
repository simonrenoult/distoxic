package modele.editeurs;

import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class TablesEditeurs extends JTable
{
	/**
	 * <h4>TablesEditeurs est la classe qui represente le tableau graphique de
	 * type JTable</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATTRIBUTS---------------- //
	// ----------------------------------------- //

	private TableRowSorter<TableModel>	filtre;
	private TablesEditeursCellRenderer	cellRenderer;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe TablesEditeurs
	 * 
	 * @param modele
	 *            un modele de type AbstractTableModel
	 */
	public TablesEditeurs(ModeleTablesEditeurs modele)
	{
		super(modele);
		cellRenderer = new TablesEditeursCellRenderer();
		setDefaultRenderer(Object.class, cellRenderer);

		filtre = new TableRowSorter<TableModel>(modele);

	}

	public TablesEditeursCellRenderer getCellRenderer()
	{
		return cellRenderer;
	}

	public void setCellRenderer(TablesEditeursCellRenderer cellRenderer)
	{
		this.cellRenderer = cellRenderer;
	}

	public TableRowSorter<TableModel> getFiltre()
	{
		return filtre;
	}

	public void setFiltre(TableRowSorter<TableModel> filtre)
	{
		this.filtre = filtre;
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
