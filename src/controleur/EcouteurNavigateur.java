package src.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import src.modele.InformationFichier;
import src.modele.TripletFichier;
import src.vue.ConteneurGlobal;

public class EcouteurNavigateur implements TreeSelectionListener, MouseListener
{
	/**
	 * <h4>EcouteurNavigateur est la classe qui represente l'ecouteur de la classe Navigateur</h4>
	 * <p>
	 * Cette classe contient : 
	 * <ul>
	 * <li>une instance de classe de JTree, arbre rescensant tous les projets contenus dans le workspace.</li>
	 * <li>une instance de classe de ConteneurGlobal, permettant l'acces aux diffentes ressources graphiques dont celui de la classe Navigateur</li>
	 * </ul>
	 * </p>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * arbre rescensant tous les projets contenus dans le workspace.
	 * @see JTree
	 */
	private JTree			tree	= null;
	/**
	 * De type JSplitPane, il permet l'acces aux ressources graphiques dont celles de l'arbre.
	 * @see ConteneurGlobal
	 */
	private ConteneurGlobal	cGlobal	= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	/**
	 * Constructeur principal de la classe EcouteurNavigateur
	 * @param global conteneur principal(JSplitPane) de la fenetre principale.
	 */
	public EcouteurNavigateur(ConteneurGlobal global)
	{
		this.cGlobal = global;
		this.tree = global.getNavigateur().getTree();

		tree.addTreeSelectionListener(this);
		tree.addMouseListener(this);
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	
	/**
	 * Methode permettant l'ajout d'un tableau graphique à un onglet lors du double clic sur un fichier de l'arbre.
	 */
	private void traitementClicFichier()
	{
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

		if (node == null)
			return;
		Object nodeInfo = node.getUserObject();
		if (node.isLeaf())
		{
			CharSequence projectName;
			boolean nouveauPanneau = true;
			InformationFichier information = (InformationFichier) nodeInfo;

			for (int i = 0 ; i < cGlobal.getEditeur().getEditeurs().size() ; i++)
			{
				// System.out.println(cGlobal.getEditeur().getEditeurs().get(i).getTripletFichier().getDirectoryPath());
				projectName = new String(cGlobal.getEditeur().getEditeurs().get(i).getTripletFichier()
						.getDirectoryPath());
				if (information.getFilePath().contains(projectName))
				{
					if (jtableFichierVide(information.getFilePath(), cGlobal.getEditeur().getEditeurs().get(i)
							.getTripletFichier()))
					{
						System.out.println("on implement directement le fichier dans la Jtable");
						TripletFichier t = new TripletFichier(information.getFilePath());
						cGlobal.getEditeur().modifierEditeur(t, i);
					}
					else
					{
						System.out.println("demande d'enregisterment");
						TripletFichier t = new TripletFichier(information.getFilePath());
						cGlobal.getEditeur().modifierEditeur(t, i);
					}
					nouveauPanneau = false;
				}

			}

			if (nouveauPanneau)
			{
				if (information.toString().endsWith(".gph"))
				{
					cGlobal.getEditeur().addEditeur(new TripletFichier(information.getFilePath()));
				}
				else if (information.toString().endsWith(".sdf"))
				{
					cGlobal.getEditeur().addEditeur(new TripletFichier(information.getFilePath()));
				}
				else if (information.toString().endsWith(".bin"))
				{
					cGlobal.getEditeur().addEditeur(new TripletFichier(information.getFilePath()));
				}
			}
		}
	}

	/**
	 * On Regarde si le fichier selectionne par l'utilisateur n'est pas deja
	 * ouvert ceux sur quoi il faudra regarder son etat d'enregistrement.
	 * 
	 * @param filePath
	 * @param tripletFichier
	 * @return
	 */
	private boolean jtableFichierVide(String filePath, TripletFichier tripletFichier)
	{

		if (filePath.endsWith("gph") && (tripletFichier.getGphFile() == null))
		{
			return true;
		}
		else if (filePath.endsWith("sdf") && (tripletFichier.getSdfFile() == null))
		{
			return true;
		}
		else if (filePath.endsWith("bin") && (tripletFichier.getBinFile() == null))
		{
			return true;
		}
		return false;
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	
	// -------TreeSelectionListener
	@Override
	public void valueChanged(TreeSelectionEvent e)
	{
		/*
		 * DefaultMutableTreeNode node = (DefaultMutableTreeNode)
		 * tree.getLastSelectedPathComponent();
		 * 
		 * if (node == null) return;
		 * 
		 * Object nodeInfo = node.getUserObject(); if (node.isLeaf()) {
		 * FileInformation information = (FileInformation)nodeInfo;
		 * System.out.println(information.toString()); }
		 */

	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{

	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{

	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{

	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{

	}

	@Override
	/**
	 * Methode permettant de capter les evenements de type MouseEvent sur un fichier de l'arbre.
	 * @param e evenement (double clic) d'un fichier de l'arbre.
	 */
	public void mouseReleased(MouseEvent e)
	{
		if ((e.getClickCount() == 2))
		{
			traitementClicFichier();
		}

	}
}
