package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import vue.ConteneurGlobal;

import modele.FileInformation;
import modele.TripletFichier;
import modele.parseurs.ParseurBIN;
import modele.parseurs.ParseurGPH;

public class EcouteurNavigateur implements TreeSelectionListener, MouseListener{
// ----------------------------------------- //
// ----------------ATRIBUTS----------------- //
// ----------------------------------------- //
	private JTree tree = null;
	private ConteneurGlobal cGlobal = null;
// ----------------------------------------- //
// --------------CONSTRUCTEURS-------------- //
// ----------------------------------------- //
	public EcouteurNavigateur(ConteneurGlobal global) {
		this.cGlobal = global;
		this.tree = global.getNavigateur().getTree();
		
		tree.addTreeSelectionListener(this);
		tree.addMouseListener(this);
	}
// ----------------------------------------- //
// -------------INITIALISEURS--------------- //
// ----------------------------------------- //

// ----------------------------------------- //
// -----------------METHODES---------------- //
// ----------------------------------------- //
//-------TreeSelectionListener
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		/*DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                tree.getLastSelectedPathComponent();
		
		if (node == null) return;
		 
        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
            FileInformation information = (FileInformation)nodeInfo;
            System.out.println(information.toString());
        }*/
       
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if((e.getClickCount() == 2)){
			
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)
	                tree.getLastSelectedPathComponent();
			
			if (node == null) return;
			Object nodeInfo = node.getUserObject();
	        if (node.isLeaf()) {
	            FileInformation information = (FileInformation)nodeInfo;
	            System.out.println(information.getFilePath());
	            
	            
	            if(information.toString().endsWith(".gph")){
	            	cGlobal.getEditeur().addEditeur(new TripletFichier(information.getFilePath()));
	            }
	            else if(information.toString().endsWith(".sdf")){
	            	cGlobal.getEditeur().addEditeur(new TripletFichier(information.getFilePath()));
	            }
	            else if(information.toString().endsWith(".bin")){
	            	cGlobal.getEditeur().addEditeur(new TripletFichier(information.getFilePath()));
	            }
	        }
		}
		
	}

// ----------------------------------------- //
// ---------------ACCESSEURS---------------- //
// ----------------------------------------- //

// ----------------------------------------- //
// ----------------MUTATEURS---------------- //
// ----------------------------------------- //
}
