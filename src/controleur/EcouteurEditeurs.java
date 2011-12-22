package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.Border;

import vue.editeurs.Editeurs;

public class EcouteurEditeurs implements MouseListener{
// ----------------------------------------- //
// ----------------ATRIBUTS----------------- //
// ----------------------------------------- //
	private Editeurs ed = null;
	private Border bordureSelection = null;
	private Border bordureVide = null;
// ----------------------------------------- //
// --------------CONSTRUCTEURS-------------- //
// ----------------------------------------- //
	public EcouteurEditeurs(Editeurs ed){
		this.ed = ed;
		bordureSelection = ed.getBordureSelection();
		bordureVide = ed.getBordureVide();
		
		try{
			ed.getEdBin().getTableauBIN().addMouseListener(this);
		}
		catch(Exception e){}
		
		try{
			ed.getEdGph().getTableauGPH().addMouseListener(this);
		}
		catch(Exception e){}
		
		try{
			ed.getEdSdf().getTableauSDF().addMouseListener(this);
		}
		catch(Exception e){}
		
	}
// ----------------------------------------- //
// -------------INITIALISEURS--------------- //
// ----------------------------------------- //
@Override
public void mouseClicked(MouseEvent e) {
	
	
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
	// Si on applique la methode directement perte de l'encadrement.
	if(e.isPopupTrigger()){
		selectionBordure(e);
	}
	else{
		selectionBordure(e);
	}
	
}


// ----------------------------------------- //
// -----------------METHODES---------------- //
// ----------------------------------------- //
/**
 * Redirection de l'évenement en fonction du du fichier destinataire.
 * @param e
 */
	public void selectionBordure(MouseEvent e){
	
		if(e.getSource() == ed.getEdBin().getTableauBIN()){
			selectionTableauBin();
		}
		if(e.getSource() == ed.getEdGph().getTableauGPH()){
			selectionTableauGph();
			
		}
		if(e.getSource() == ed.getEdSdf().getTableauSDF()){
			selectionTableauSdf();
			
		}
	}


	/**
	 * Selection de la bordure et MAJ du cadre graphique pour le BIN.
	 */
	private void selectionTableauBin() {
		ed.getEdBin().setBorder(bordureSelection);
		ed.getEdGph().setBorder(bordureVide);
		ed.getEdSdf().setBorder(bordureVide);
		ed.getEdBin().getBinFile().setFlank(true);
		if (ed.getEdGph().getGphFile() != null){
			ed.getEdGph().getGphFile().setFlank(false);
		}
		if (ed.getEdSdf().getSdfFile() != null){
			ed.getEdSdf().getSdfFile().setFlank(false);
		}
	}
	/**
	 *  Selection de la bordure et MAJ du cadre graphique pour le GPH.
	 */
	private void selectionTableauGph() {
		ed.getEdGph().setBorder(bordureSelection);
		ed.getEdBin().setBorder(bordureVide);
		ed.getEdSdf().setBorder(bordureVide);
		ed.getEdGph().getGphFile().setFlank(true);
		if (ed.getEdBin().getBinFile() != null){
			ed.getEdBin().getBinFile().setFlank(false);
		}
		if (ed.getEdSdf().getSdfFile() != null){
			ed.getEdSdf().getSdfFile().setFlank(false);
			
		}
	}
	/**
	 *  Selection de la bordure et MAJ du cadre graphique pour le SDF.
	 */
	private void selectionTableauSdf() {
		ed.getEdGph().setBorder(bordureVide);
		ed.getEdBin().setBorder(bordureVide);
		ed.getEdSdf().setBorder(bordureSelection);
		ed.getEdSdf().getSdfFile().setFlank(true);
		if (ed.getEdBin().getBinFile() != null){
			ed.getEdBin().getBinFile().setFlank(false);
		}
		if (ed.getEdGph().getGphFile() != null){
			ed.getEdGph().getGphFile().setFlank(false);
		}
		
		
	}
// ----------------------------------------- //
// ---------------ACCESSEURS---------------- //
// ----------------------------------------- //
// ----------------------------------------- //
// ----------------MUTATEURS---------------- //
// ----------------------------------------- //
}
