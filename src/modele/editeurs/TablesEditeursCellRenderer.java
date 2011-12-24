package modele.editeurs;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class TablesEditeursCellRenderer extends DefaultTableCellRenderer
{
	/** Creates a new instance of UserListCellRenderer */
	public TablesEditeursCellRenderer()
	{
		super();
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column)
	{
		Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if (table.getSelectedRow() == row)
		{
			component.setBackground(Color.GREEN);
			component.setForeground(Color.BLACK);
		}
		else if ((row & 1) == 0)
		{
			component.setBackground(Color.WHITE);
			component.setForeground(Color.BLACK);
		}
		else
		{
			component.setBackground(Color.LIGHT_GRAY);
			component.setForeground(Color.BLACK);
		}

		return component;
	}
}
