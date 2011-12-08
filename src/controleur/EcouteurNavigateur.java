package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import modele.FileInformation;
import modele.parseurs.ParseurBIN;
import modele.parseurs.ParseurGPH;

public class EcouteurNavigateur implements TreeSelectionListener, MouseListener{
// ----------------------------------------- //
// ----------------ATRIBUTS----------------- //
// ----------------------------------------- //
	private JTree tree = null;
// ----------------------------------------- //
// --------------CONSTRUCTEURS-------------- //
// ----------------------------------------- //
	public EcouteurNavigateur(JTree tree) {
		this.tree = tree;
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
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		
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
	            System.out.println(information.toString());
	            if(information.toString().endsWith(".gph")){
	            	ParseurGPH p = new ParseurGPH(information.getFilePath());
	            	p.afficherTableau();
	            }
	            else if(information.toString().endsWith(".sdf")){
	            	
	            }
	            else if(information.toString().endsWith(".bin")){
	            	ParseurBIN p = new ParseurBIN(information.getFilePath());
	            	p.afficherTableau();
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
