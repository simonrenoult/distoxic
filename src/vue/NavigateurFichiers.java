
package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import vue.Editeurs.ConteneurEditeurs;
import vue.Menus.MenuTextuel;

@SuppressWarnings("serial")
public class NavigateurFichiers extends JPanel
{
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	public static Integer			TAILLE_X	= 200;
	public static Integer			TAILLE_Y	= ConteneurGlobal.TAILLE_Y;
	private static Color			COLOR_BG	= Color.GREEN;
	
	private DefaultMutableTreeNode	racine;
	private DefaultTreeModel		modele;
	
	private JTree tree = null;
	
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	public NavigateurFichiers()
	{
		super();
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		//this.setBackground(Color.red);
		buildTree();
        //Create the nodes.
       // DefaultMutableTreeNode top = new DefaultMutableTreeNode("files");
        
 
        //Create a tree that allows one selection at a time.
        //tree = new JTree(top);
		
        
	 
	        
	}
	
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	
	private void buildTree(){
		//Création d'une racine
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode("");
			
		//Nous allons ajouter des branches et des feuilles à notre racine
		for(int i = 1; i < 6; i++){
			DefaultMutableTreeNode rep = new DefaultMutableTreeNode("Noeud N°"+i);
				
			//On rajoute 4 branches
			if(i < 4){	
				DefaultMutableTreeNode rep2 = new DefaultMutableTreeNode("Fichier enfant");
				rep.add(rep2);
			}
			//On ajoute la feuille ou la branche à la racine
			racine.add(rep);
		}
		//On crée, avec notre hiérarchie, un arbre
		tree = new JTree(racine);
		
		//Que nous plaçons sur le ContentPane de notre JFrame à l'aide d'un scroll 
		JScrollPane treeView = new JScrollPane(tree);
		treeView.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.add(treeView);
	}
    
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	
}
