package vue.naviguateur;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

import modele.InformationFichier;
import modele.WorkspaceModele;
import vue.ConteneurGlobal;


@SuppressWarnings("serial")
public class NavigateurFichiers extends JPanel
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //
	
	private static String			_ICON_PATH	= "/images/icones/";
	public static Integer			TAILLE_X	= 200;
	public static Integer			TAILLE_Y	= ConteneurGlobal.TAILLE_Y;

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	private DefaultMutableTreeNode	racine		= new DefaultMutableTreeNode("");
	private JTree					tree		= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public NavigateurFichiers()
	{
		super();
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		buildTree();
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	public void buildTree()
	{

		WorkspaceModele modele = new WorkspaceModele(0);
		modele.workspaceExistant();
		String workspacePath = modele.getWorkspacePath();

		File workspace = new File(workspacePath);
		buildJtreeComponentList(workspace, racine);
		tree = new JTree(racine);

		// Une selection � la fois.
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		// Customizer la JTree
		tree.setRootVisible(true);
		tree.setShowsRootHandles(true);
		tree.putClientProperty("JTree.lineStyle", "Angled");

		ImageIcon leafIcon = new ImageIcon(getClass().getResource(_ICON_PATH + "chart_stock.png"));
		if (leafIcon != null)
		{
			DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
			renderer.setLeafIcon(leafIcon);
			tree.setCellRenderer(renderer);
			tree.repaint();
		}

		JScrollPane treeView = new JScrollPane(tree);
		treeView.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.add(treeView, BorderLayout.CENTER);
	}

	private void buildJtreeComponentList(File file, DefaultMutableTreeNode node)
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
						InformationFichier f = new InformationFichier("directory", contenu[i].getAbsolutePath(),
								contenu[i].getName());
						DefaultMutableTreeNode directoryNode = new DefaultMutableTreeNode(f);
						node.add(directoryNode);
						buildJtreeComponentList(contenu[i], directoryNode);
					}
					else
					{
						buildJtreeComponentList(contenu[i], node);
					}
				}
			}
		}
		else
		{
			InformationFichier f = new InformationFichier("file", file.getAbsolutePath(), file.getName());
			DefaultMutableTreeNode fileNode = new DefaultMutableTreeNode(f);
			node.add(fileNode);
		}

	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @return the tree
	 */
	public JTree getTree()
	{
		return tree;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	/**
	 * @param tree
	 *            the tree to set
	 */
	public void setTree(JTree tree)
	{
		this.tree = tree;
	}
}
