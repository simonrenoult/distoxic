package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import vue.ConteneurGlobal;
import modele.FileInformation;
import modele.TripletFichier;

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
	private void traitementClicFichier(){
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		
		if (node == null) return;
		Object nodeInfo = node.getUserObject();
		if (node.isLeaf()) {
			CharSequence projectName ;
			boolean nouveauPanneau = true;
			FileInformation information = (FileInformation)nodeInfo;
			
			for(int i = 0; i<cGlobal.getEditeur().getEditeurs().size(); i++ ){
				//System.out.println(cGlobal.getEditeur().getEditeurs().get(i).getTripletFichier().getDirectoryPath());
				projectName  = new String(cGlobal.getEditeur().getEditeurs().get(i).getTripletFichier().getDirectoryPath());
				if(information.getFilePath().contains(projectName)){
					if(jtableFichierVide(information.getFilePath(),cGlobal.getEditeur().getEditeurs().get(i).getTripletFichier())){
						System.out.println("on implement directement le fichier dans la Jtable");
						TripletFichier t = new TripletFichier(information.getFilePath());
						cGlobal.getEditeur().modifierEditeur(t, i);
					}
					else{
						System.out.println("demande d'enregisterment");
						TripletFichier t = new TripletFichier(information.getFilePath());
						cGlobal.getEditeur().modifierEditeur(t, i);
					}
					nouveauPanneau = false;
				}
				
				
			}
			
			if (nouveauPanneau){
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
	
	/**
	 * On Regarde si le fichier selectionne par l'utilisateur n'est pas déjà ouvert ceux sur quoi il faudra regarder son etat d'enregistrement.
	 * @param filePath
	 * @param tripletFichier
	 * @return
	 */
	private boolean jtableFichierVide(String filePath, TripletFichier tripletFichier) {
		
		if(filePath.endsWith("gph") && (tripletFichier.getGphFile() == null)){
				return true;
		}
		else if (filePath.endsWith("sdf") && (tripletFichier.getSdfFile() == null)){
			return true;
		}
		else if (filePath.endsWith("bin")  && (tripletFichier.getBinFile() == null)){
			return true;
		}
		return false;
	}
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
			traitementClicFichier();
		}
		
	}

// ----------------------------------------- //
// ---------------ACCESSEURS---------------- //
// ----------------------------------------- //

// ----------------------------------------- //
// ----------------MUTATEURS---------------- //
// ----------------------------------------- //
}
