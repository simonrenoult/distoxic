package controleur;

import java.awt.Event;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import modele.editeurs.ModeleTablesEditeurs;
import modele.fichiers.FichierBIN;
import modele.fichiers.FichierGPH;
import modele.fichiers.FichierSDF;


public class EcouteurJtable implements TableModelListener, MouseListener, MouseMotionListener
{

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private JTable		tableau	= null;
	private FichierBIN	binFile	= null;
	private FichierGPH	gphFile	= null;
	private FichierSDF	sdfFile	= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public EcouteurJtable(JTable tableau, FichierBIN binFile, FichierGPH gphFile, FichierSDF sdfFile)
	{
		this.binFile = binFile;
		this.gphFile = gphFile;
		this.sdfFile = sdfFile;
		this.tableau = tableau;
		this.tableau.addMouseListener(this);
		this.tableau.getTableHeader().addMouseListener(this);
		((ModeleTablesEditeurs) (this.tableau.getModel())).addTableModelListener(this);

		if (this.binFile != null)
		{
			this.tableau.addMouseMotionListener(this);
		}

	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	private void SelectionLigneClicDroit(MouseEvent e)
	{
		tableau.getSelectionModel().addSelectionInterval(tableau.getSelectedRow(), tableau.getSelectedRow());
		tableau.setRowSelectionAllowed(true);
		tableau.setColumnSelectionAllowed(false);
		tableau.changeSelection(e.getY() / tableau.getRowHeight(), 0, false, false);
	}

	@Override
	public void tableChanged(TableModelEvent e)
	{
		int positionLigne = tableau.getSelectedRow();
		int positionColonne = tableau.getSelectedColumn();
		Object contenuCellule = tableau.getValueAt(positionLigne, positionColonne);

		if (binFile != null)
		{
			binFile.setChanged(true);

			if (positionColonne == 1)
			{
				int valeur = Integer.parseInt(String.valueOf(contenuCellule));
				binFile.getFichierBinTmp().mofifierValeurClasse(positionLigne, positionColonne, valeur);
				binFile.getFichierBinTmp().afficherListeBIN();
			}
		}
		else if (gphFile != null)
		{
			// System.out.println("GPH avant : "+gphFile.isChanged());
			gphFile.setChanged(true);
			// System.out.println("GPH apres : "+gphFile.isChanged());
		}
		else if (sdfFile != null)
		{
			sdfFile.setChanged(true);
			sdfFile.getFichierSdfTmp().modifierValeurClasse(positionLigne, tableau.getColumnName(positionColonne),
					contenuCellule.toString());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (e.getModifiers() == Event.META_MASK)
		{
			SelectionLigneClicDroit(e);
			// menuContextuel.show(e.getComponent(), e.getX(), e.getY());
		}

	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		Point p = e.getPoint();
		int row = tableau.rowAtPoint(p);
		tableau.setToolTipText(binFile.getFichierBinTmp().afficherListeFragmentAssociee(row));
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
