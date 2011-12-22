package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import modele.editeurs.ModeleTablesEditeurs;
import modele.fichier.FichierBIN;
import modele.fichier.FichierGPH;
import modele.fichier.FichierSDF;

import vue.MenuContextuel;


public class EcouteurJtable implements TableModelListener, MouseListener, ActionListener {

	
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private MenuContextuel menuContextuel = null;
	private JTable tableau = null;
	private FichierBIN	binFile = null;
	private FichierGPH	gphFile = null;
	private FichierSDF	sdfFile = null;
	

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	public EcouteurJtable(JTable tableau,FichierBIN	binFile,
			FichierGPH	gphFile,FichierSDF	sdfFile ) {
		this.binFile = binFile;
		this.gphFile = gphFile;
		this.sdfFile = sdfFile;
		this.tableau = tableau;
		this.tableau.addMouseListener(this);
		this.tableau.getTableHeader().addMouseListener(this);
		((ModeleTablesEditeurs)(this.tableau.getModel())).addTableModelListener(this);
		initMenuContextuel();
		
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	private void initMenuContextuel(){
		menuContextuel = new MenuContextuel();
		menuContextuel.getAjouterDebutTableau().addActionListener(this);
		menuContextuel.getAjouterAvantLigneSelection().addActionListener(this);
		menuContextuel.getAjouterApresLigneSelection().addActionListener(this);
		menuContextuel.getAjouterFinTableau().addActionListener(this);
		menuContextuel.getSupprimer().addActionListener(this);
	}
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	private void SelectionLigneClicDroit(MouseEvent e){
		tableau.getSelectionModel().addSelectionInterval(tableau.getSelectedRow(),tableau.getSelectedRow());
		tableau.setRowSelectionAllowed(true);
		tableau.setColumnSelectionAllowed(false);
		tableau.changeSelection(e.getY()/tableau.getRowHeight(),0,false, false);
		
	}
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	@Override
	public void tableChanged(TableModelEvent e) {
		
		
		
		if(binFile != null){
			//System.out.println("BIN avant : "+binFile.isChanged());
			binFile.setChanged(true);
			//System.out.println("BIN apres : "+binFile.isChanged());
		}
		else if (gphFile != null){
			//System.out.println("GPH avant : "+gphFile.isChanged());
			gphFile.setChanged(true);
			//System.out.println("GPH apres : "+gphFile.isChanged());
		}
		else if (sdfFile != null){
			//System.out.println("SDF avant : "+sdfFile.isChanged());
			sdfFile.setChanged(true);
			//System.out.println("SDF apres : "+sdfFile.isChanged());
		}
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		/*TableColumnModel colModel = tableau.getColumnModel();
	    int columnModelIndex = colModel.getColumnIndexAtX(e.getX());
	    int modelIndex = colModel.getColumn(columnModelIndex)
	              .getModelIndex();
		System.out.println("numero colonne :"+columnModelIndex);
		System.out.println(modelIndex);
		*/
		 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.isPopupTrigger()){
			SelectionLigneClicDroit(e);
			menuContextuel.show(e.getComponent(), e.getX(), e.getY());
		}
		else{
			//System.out.println("Clic Gauche");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuContextuel.getAjouterDebutTableau()){
			((ModeleTablesEditeurs)tableau.getModel()).ajouterLigneDebut(
					((ModeleTablesEditeurs)tableau.getModel()).creerLigneVierge(
							tableau.getColumnCount()));
		}
		else if(e.getSource() == menuContextuel.getAjouterFinTableau()){
			((ModeleTablesEditeurs)tableau.getModel()).ajouterLigneFin(
					((ModeleTablesEditeurs)tableau.getModel()).creerLigneVierge(
							tableau.getColumnCount()));
		}
		else if(e.getSource() == menuContextuel.getAjouterAvantLigneSelection()){
			((ModeleTablesEditeurs)tableau.getModel()).ajouterLigneAvant(
					((ModeleTablesEditeurs)tableau.getModel()).creerLigneVierge(
							tableau.getColumnCount()), tableau.getSelectedRow());
		}
		else if(e.getSource() == menuContextuel.getAjouterApresLigneSelection()){
			((ModeleTablesEditeurs)tableau.getModel()).ajouterLigneApres(
					((ModeleTablesEditeurs)tableau.getModel()).creerLigneVierge(
							tableau.getColumnCount()), tableau.getSelectedRow());
		}
		else if (e.getSource() == menuContextuel.getSupprimer()){
			((ModeleTablesEditeurs)tableau.getModel()).SupprimerLigne(tableau.getSelectedRow());
		}
		
	}


	

	


	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
