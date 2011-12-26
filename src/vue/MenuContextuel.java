package src.vue;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

@SuppressWarnings("serial")
public class MenuContextuel extends JPopupMenu
{
	/**
	 * <h4>MenuContextuel est la classe permettant de decrire le popup menu lie au tableau graphique de type JTable</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
		// --------------- CONSTANTES -------------- //
		// ----------------------------------------- //
	/**
	 * Constantes de classe
	 */
	private static String	_ICON_PATH	= "/images/icones/";
	private static int		_GPH_MENU	= 1;
	
	
	// ----------------------------------------- //
		// ----------------ATRIBUTS----------------- //
		// ----------------------------------------- //
	private JMenu			ajouter;
	private JMenuItem		ajouterDebutTableau;
	private JMenuItem		ajouterAvantLigneSelection;
	private JMenuItem		ajouterApresLigneSelection;
	private JMenuItem		ajouterFinTableau;
	private JMenuItem		ajouterFragmentBin;

	private JMenuItem		supprimer;

	/*
	 * selon la Jtable selectionne, l'affichage sera different. Si c'est la
	 * JtableGPH(index == "gph"), ajout d'un menuItem ajouter le fragment au bin
	 * associe.
	 * 
	 */
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe MenuContextuel
	 * @param index numero indiquant quel menu il faut generer en fonction du tableau graphique
	 */
	public MenuContextuel(int index)
	{
		super();
		initBoutons();
		if (index == _GPH_MENU)
		{
			initBoutonGPH();
		}
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	/**
	 * Creation du menu commun
	 */
	private void initBoutons()
	{
		ajouter = creerMenu("Ajouter une ligne", "add.png");

		ajouterDebutTableau = creerItem("Début de tableau", "application_get.png");
		ajouter.add(ajouterDebutTableau);
		ajouterAvantLigneSelection = creerItem("Avant la ligne sélectionnée", "application_back.png");
		ajouter.add(ajouterAvantLigneSelection);
		ajouterApresLigneSelection = creerItem("Après la ligne sélectionnée", "application_go.png");
		ajouter.add(ajouterApresLigneSelection);
		ajouterFinTableau = creerItem("Fin de tableau", "application_put.png");
		ajouter.add(ajouterFinTableau);

		supprimer = creerItem("Supprimer la ligne", "delete.png");
		this.add(ajouter);
		this.add(supprimer);

	}

	/**
	 * Creation du menu GPH qui vient completer le menu commun.
	 */
	private void initBoutonGPH()
	{
		ajouterFragmentBin = creerItem("Ajouter le fragment à la molecule", "arrow_right.png");
		this.add(ajouterFragmentBin);
	}

	/**
	 * Creation d'un item de menu
	 * @param name le libelle de l'item
	 * @param iconPath l'icone associe
	 * @return un item de type JMenuItem
	 */
	private JMenuItem creerItem(String name, String iconPath)
	{

		JMenuItem menuItem = new JMenuItem(name, new ImageIcon(getClass().getResource(_ICON_PATH + iconPath)));
		return menuItem;
	}

	/**
	 * Creation d'un menu
	 * @param name le libelle du menu
	 * @param iconPath l'icone associe
	 * @return un menu de type JMenu
	 */
	private JMenu creerMenu(String name, String iconPath)
	{
		JMenu menu = new JMenu(name);
		menu.setIcon(new ImageIcon(getClass().getResource(_ICON_PATH + iconPath)));
		return menu;
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	/**
	 * @return the ajouter
	 */
	public JMenu getAjouter()
	{
		return ajouter;
	}

	/**
	 * @param ajouter
	 *            the ajouter to set
	 */
	public void setAjouter(JMenu ajouter)
	{
		this.ajouter = ajouter;
	}

	/**
	 * @return the ajouterDebutTableau
	 */
	public JMenuItem getAjouterDebutTableau()
	{
		return ajouterDebutTableau;
	}

	/**
	 * @param ajouterDebutTableau
	 *            the ajouterDebutTableau to set
	 */
	public void setAjouterDebutTableau(JMenuItem ajouterDebutTableau)
	{
		this.ajouterDebutTableau = ajouterDebutTableau;
	}

	/**
	 * @return the ajouterAvantLigneSelection
	 */
	public JMenuItem getAjouterAvantLigneSelection()
	{
		return ajouterAvantLigneSelection;
	}

	/**
	 * @param ajouterAvantLigneSelection
	 *            the ajouterAvantLigneSelection to set
	 */
	public void setAjouterAvantLigneSelection(JMenuItem ajouterAvantLigneSelection)
	{
		this.ajouterAvantLigneSelection = ajouterAvantLigneSelection;
	}

	/**
	 * @return the ajouterApresLigneSelection
	 */
	public JMenuItem getAjouterApresLigneSelection()
	{
		return ajouterApresLigneSelection;
	}

	/**
	 * @param ajouterApresLigneSelection
	 *            the ajouterApresLigneSelection to set
	 */
	public void setAjouterApresLigneSelection(JMenuItem ajouterApresLigneSelection)
	{
		this.ajouterApresLigneSelection = ajouterApresLigneSelection;
	}

	/**
	 * @return the ajouterFinTableau
	 */
	public JMenuItem getAjouterFinTableau()
	{
		return ajouterFinTableau;
	}

	/**
	 * @param ajouterFinTableau
	 *            the ajouterFinTableau to set
	 */
	public void setAjouterFinTableau(JMenuItem ajouterFinTableau)
	{
		this.ajouterFinTableau = ajouterFinTableau;
	}

	/**
	 * @return the supprimer
	 */
	public JMenuItem getSupprimer()
	{
		return supprimer;
	}

	/**
	 * @param supprimer
	 *            the supprimer to set
	 */
	public void setSupprimer(JMenuItem supprimer)
	{
		this.supprimer = supprimer;
	}

	/**
	 * @return the ajouterFragmentBin
	 */
	public JMenuItem getAjouterFragmentBin()
	{
		return ajouterFragmentBin;
	}

	/**
	 * @param ajouterFragmentBin
	 *            the ajouterFragmentBin to set
	 */
	public void setAjouterFragmentBin(JMenuItem ajouterFragmentBin)
	{
		this.ajouterFragmentBin = ajouterFragmentBin;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

}
