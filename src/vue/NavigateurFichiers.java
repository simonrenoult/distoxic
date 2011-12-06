package vue;

import java.awt.Dimension;
import java.io.File;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import modele.FileInformation;

@SuppressWarnings("serial")
public class NavigateurFichiers extends JPanel
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer		TAILLE_X	= 1 * ConteneurGlobal.TAILLE_X / 5;
	public final static Integer		TAILLE_Y	= ConteneurGlobal.TAILLE_Y;

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private DefaultMutableTreeNode	racine		= new DefaultMutableTreeNode("Workspace");
	// private ArrayList<FileInformation> JtreeComponent = new
	// ArrayList<FileInformation>();
	private JTree					tree		= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public NavigateurFichiers()
	{
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

	private void buildTree()
	{

		String workspacePath = System.getProperty("user.dir");
		workspacePath = workspacePath + "\\workspace";
		// System.out.println("workspace : "+workspacePath);
		File workspace = new File(workspacePath);
		System.out.println("contenu du workspace :");
		// buildJtreeComponentList(workspace);
		buildJtreeComponentList2(workspace, racine);
		tree = new JTree(racine);
		JScrollPane treeView = new JScrollPane(tree);
		treeView.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.add(treeView);
	}

	/*
	 * private void buildJtreeComponentList(File file){ if(file.isDirectory()){
	 * File[] contenu = file.listFiles(); if(contenu != null){ for(int i = 0;
	 * i<contenu.length; i++){ if(contenu[i].isDirectory()){
	 * JtreeComponent.add(new
	 * FileInformation("directory",contenu[i].getAbsolutePath() ,
	 * contenu[i].getName())); //System.err.println("dossier : "+contenu[i]); }
	 * buildJtreeComponentList(contenu[i]); } } } else{ JtreeComponent.add(new
	 * FileInformation("file",file.getAbsolutePath() , file.getName()));
	 * //System.out.println("fichier : "+file.getPath()); }
	 * 
	 * }
	 */

	private void buildJtreeComponentList2(File file, DefaultMutableTreeNode node)
	{
		if (file.isDirectory())
		{
			File[] contenu = file.listFiles();
			if (contenu != null)
			{
				for (int i = 0 ; i < contenu.length ; i++)
				{
					if (contenu[i].isDirectory())
					{
						FileInformation f = new FileInformation("directory", contenu[i].getAbsolutePath(),
								contenu[i].getName());
						DefaultMutableTreeNode directoryNode = new DefaultMutableTreeNode(f);
						node.add(directoryNode);
						buildJtreeComponentList2(contenu[i], directoryNode);
					}
					else
					{
						buildJtreeComponentList2(contenu[i], node);
					}
				}
			}
		}
		else
		{
			FileInformation f = new FileInformation("file", file.getAbsolutePath(), file.getName());
			DefaultMutableTreeNode fileNode = new DefaultMutableTreeNode(f);
			node.add(fileNode);
		}

	}

	/*
	 * public void displayJtreeComponentList(){ for(int i = 0;
	 * i<JtreeComponent.size(); i++){
	 * System.out.println(JtreeComponent.get(i).toString()); } }
	 */

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

}
