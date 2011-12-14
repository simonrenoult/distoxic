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
	selectionBordure(e);
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
	// TODO Auto-generated method stub
	
}


// ----------------------------------------- //
// -----------------METHODES---------------- //
// ----------------------------------------- //
public void selectionBordure(MouseEvent e){

	if(e.getSource() == ed.getEdBin().getTableauBIN()){
		ed.getEdGph().setBorder(bordureVide);
		ed.getEdBin().setBorder(bordureSelection);
		ed.getEdSdf().setBorder(bordureVide);
	}
	if(e.getSource() == ed.getEdGph().getTableauGPH()){
		ed.getEdGph().setBorder(bordureSelection);
		ed.getEdBin().setBorder(bordureVide);
		ed.getEdSdf().setBorder(bordureVide);
	}
	if(e.getSource() == ed.getEdSdf().getTableauSDF()){
		ed.getEdGph().setBorder(bordureVide);
		ed.getEdBin().setBorder(bordureVide);
		ed.getEdSdf().setBorder(bordureSelection);
	}
}
// ----------------------------------------- //
// ---------------ACCESSEURS---------------- //
// ----------------------------------------- //

// ----------------------------------------- //
// ----------------MUTATEURS---------------- //
// ----------------------------------------- //
}
