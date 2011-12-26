package src.controleur;

import java.awt.Event;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import src.modele.editeurs.ModeleTablesEditeurs;
import src.modele.fichiers.FichierBIN;
import src.modele.fichiers.FichierGPH;
import src.modele.fichiers.FichierSDF;


public class EcouteurJtable implements TableModelListener, MouseListener, MouseMotionListener
{

	/**
	 * <h4>EcouteurJtable est la classe qui represente l'ecouteur des tableaux graphiques (JTable) dans les classes EditeursSDF, BIN et GPH.</h4>
	 * <p>
	 * Cette classe contient : 
	 * <ul>
	 * <li>une instance de classe de JTable, representant un tableau graphique</li>
	 * <li>une instance de classe de FichierBIN, pour determiner si le tableau instancie provient de la classe EditeurBIN. </li>
	 * <li>une instance de classe de FichierGPH, pour determiner si le tableau instancie provient de la classe EditeurGPH. </li>
	 * <li>une instance de classe de FichierSDF, pour determiner si le tableau instancie provient de la classe EditeurSDF. </li>
	 * </ul>
	 * </p>
	 * 
	 * <p>
	 * Remarque : Cette classe est la même pour les 3 tableaux graphique car elle permet la selection d'une ligne de couleur ainsi que l'edition de ces derniers<br>
	 * Etant donne qu'un editeur declare automatiquement son tableau mais pas son Fichier$$$, on teste la nullite de cette objet pour en connaitre la source du tableau.<br>
	 * Chaque modification de tableau provoque la modification du modele du tableau ainsi que du fichier qui pourra etre enregistre.
	 * </p>
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * Tableau graphique
	 * @see JTable
	 */
	private JTable		tableau	= null;
	/**
	 * Objet de classe FichierBIN,FichierGPH,FichierSDF  regroupant les informations a transmettre au modele du tableau graphique.
	 * @see FichierBIN
	 * @see FichierGPH
	 * @see FichierSDF
	 */
	private FichierBIN	binFile	= null;
	private FichierGPH	gphFile	= null;
	private FichierSDF	sdfFile	= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Construcuteur principal de la classe EcouteurJtable. Le tableau BIN presente un toolTip.
	 * @param tableau le tableau graphique 
	 * @param binFile la source de donnee du tableau graphique BIN
	 * @param gphFile la source de donnee du tableau graphique GPH
	 * @param sdfFile la source de donnee du tableau graphique SDF
	 */
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

	/**
	 * Methode permettant la selection d'une ligne sur un clic droit.
	 * @param e Evenement liee au clic droit
	 */
	private void selectionLigneClicDroit(MouseEvent e)
	{
		tableau.getSelectionModel().addSelectionInterval(tableau.getSelectedRow(), tableau.getSelectedRow());
		tableau.setRowSelectionAllowed(true);
		tableau.setColumnSelectionAllowed(false);
		tableau.changeSelection(e.getY() / tableau.getRowHeight(), 0, false, false);
	}

	@Override
	/**
	 * Methode permettant de capter les evenements de type TableModelEvent sur les tableaux graphiques.
	 * @param e evenement d'une cellule graphique contenue dans les tableaux graphiques.
	 */
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

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}

	@Override
	public void mousePressed(MouseEvent e)
	{

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (e.getModifiers() == Event.META_MASK)
		{
			selectionLigneClicDroit(e);
			// menuContextuel.show(e.getComponent(), e.getX(), e.getY());
		}

	}

	@Override
	public void mouseDragged(MouseEvent e)
	{

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		Point p = e.getPoint();
		int row = tableau.rowAtPoint(p);
		tableau.setToolTipText(binFile.getFichierBinTmp().afficherListeFragmentAssociee(row));
	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// -------------- MUTATEURS  --------------- //
	// ----------------------------------------- //
	
	public JTable getTableau()
	{
		return tableau;
	}

	public FichierBIN getBinFile()
	{
		return binFile;
	}

	public FichierGPH getGphFile()
	{
		return gphFile;
	}

	public FichierSDF getSdfFile()
	{
		return sdfFile;
	}

	public void setTableau(JTable tableau)
	{
		this.tableau = tableau;
	}

	public void setBinFile(FichierBIN binFile)
	{
		this.binFile = binFile;
	}

	public void setGphFile(FichierGPH gphFile)
	{
		this.gphFile = gphFile;
	}

	public void setSdfFile(FichierSDF sdfFile)
	{
		this.sdfFile = sdfFile;
	}
}
