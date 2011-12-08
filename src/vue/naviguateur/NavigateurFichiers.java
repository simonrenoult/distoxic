
package vue.naviguateur;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

import vue.ConteneurGlobal;

import controleur.EcouteurNavigateur;

import modele.FileInformation;
import modele.WorkspaceModele;

@SuppressWarnings("serial")
public class NavigateurFichiers extends JPanel
{
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	public static Integer			TAILLE_X	= 200;
	public static Integer			TAILLE_Y	= ConteneurGlobal.TAILLE_Y;
	private static Color			COLOR_BG	= Color.GREEN;
	
	private DefaultMutableTreeNode	racine = new DefaultMutableTreeNode("");
	private JTree tree = null;
	private EcouteurNavigateur ecouteur= null;
	
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	public NavigateurFichiers(){
		super();
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		buildTree();
		
	}
	
	
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	
	private void buildTree(){
		
		WorkspaceModele modele = new WorkspaceModele();
		modele.workspaceExistant();
		String workspacePath = modele.getWorkspacePath();
		//String workspacePath = System.getProperty("user.dir");
		//workspacePath = workspacePath+"\\workspace";
		File workspace = new File(workspacePath);
		buildJtreeComponentList(workspace,racine);
		tree = new JTree(racine);
		
		//Une selection à la fois.
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		//Customizer la JTree
		tree.setRootVisible(true);
		tree.setShowsRootHandles(true);
		tree.putClientProperty("JTree.lineStyle", "Angled");
		
		ImageIcon leafIcon = new ImageIcon("src/images/icones/chart_stock.png");
		if (leafIcon != null) {
		    DefaultTreeCellRenderer renderer =  new DefaultTreeCellRenderer();
		    renderer.setLeafIcon(leafIcon);
		    tree.setCellRenderer(renderer);
		    tree.repaint();
		}
		
		
		//Ecoute du JTree
		ecouteur = new EcouteurNavigateur(tree);
		
		JScrollPane treeView = new JScrollPane(tree);
		treeView.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.add(treeView);
	}

	private void buildJtreeComponentList(File file,DefaultMutableTreeNode node){
		if(file.isDirectory()){
			File[] contenu = file.listFiles();
			if(contenu != null){
				for(int i = 0; i<contenu.length; i++){
					if(contenu[i].isDirectory()){
						FileInformation f = new FileInformation("directory",contenu[i].getAbsolutePath() , contenu[i].getName());
						DefaultMutableTreeNode directoryNode = new DefaultMutableTreeNode(f);
						node.add(directoryNode);
						buildJtreeComponentList(contenu[i],directoryNode);
					}
					else{
						buildJtreeComponentList(contenu[i],node);
					}
				}
			}
		}
		else{
			FileInformation f = new FileInformation("file",file.getAbsolutePath() , file.getName());
			DefaultMutableTreeNode fileNode = new DefaultMutableTreeNode(f);
			node.add(fileNode);
		}
	
	}

	
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	
}
