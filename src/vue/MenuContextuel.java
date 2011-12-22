package vue;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

@SuppressWarnings("serial")
public class MenuContextuel extends JPopupMenu {

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private static String		_ICON_PATH	= "/images/icones/";
	private JMenu ajouter ;
	private JMenuItem ajouterDebutTableau;
	private JMenuItem ajouterAvantLigneSelection;
	private JMenuItem ajouterApresLigneSelection;
	private JMenuItem ajouterFinTableau;
	
	private JMenuItem supprimer ;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	 public MenuContextuel(){
		 super();
		 initBoutons();
		 
	 }
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
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
	
	private JMenuItem creerItem(String name, String iconPath)
	{
		
		JMenuItem menuItem = new JMenuItem(name, new ImageIcon(getClass().getResource(_ICON_PATH + iconPath)));
		return menuItem;
	}
	
	private JMenu creerMenu(String name, String iconPath)
	{
		JMenu menu = new JMenu (name);
		menu.setIcon(new ImageIcon(getClass().getResource(_ICON_PATH + iconPath)));
		return menu;
	}
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	/**
	 * @return the ajouter
	 */
	public JMenu getAjouter() {
		return ajouter;
	}

	/**
	 * @param ajouter the ajouter to set
	 */
	public void setAjouter(JMenu ajouter) {
		this.ajouter = ajouter;
	}

	/**
	 * @return the ajouterDebutTableau
	 */
	public JMenuItem getAjouterDebutTableau() {
		return ajouterDebutTableau;
	}

	/**
	 * @param ajouterDebutTableau the ajouterDebutTableau to set
	 */
	public void setAjouterDebutTableau(JMenuItem ajouterDebutTableau) {
		this.ajouterDebutTableau = ajouterDebutTableau;
	}

	/**
	 * @return the ajouterAvantLigneSelection
	 */
	public JMenuItem getAjouterAvantLigneSelection() {
		return ajouterAvantLigneSelection;
	}

	/**
	 * @param ajouterAvantLigneSelection the ajouterAvantLigneSelection to set
	 */
	public void setAjouterAvantLigneSelection(JMenuItem ajouterAvantLigneSelection) {
		this.ajouterAvantLigneSelection = ajouterAvantLigneSelection;
	}

	/**
	 * @return the ajouterApresLigneSelection
	 */
	public JMenuItem getAjouterApresLigneSelection() {
		return ajouterApresLigneSelection;
	}

	/**
	 * @param ajouterApresLigneSelection the ajouterApresLigneSelection to set
	 */
	public void setAjouterApresLigneSelection(JMenuItem ajouterApresLigneSelection) {
		this.ajouterApresLigneSelection = ajouterApresLigneSelection;
	}

	/**
	 * @return the ajouterFinTableau
	 */
	public JMenuItem getAjouterFinTableau() {
		return ajouterFinTableau;
	}

	/**
	 * @param ajouterFinTableau the ajouterFinTableau to set
	 */
	public void setAjouterFinTableau(JMenuItem ajouterFinTableau) {
		this.ajouterFinTableau = ajouterFinTableau;
	}

	/**
	 * @return the supprimer
	 */
	public JMenuItem getSupprimer() {
		return supprimer;
	}

	/**
	 * @param supprimer the supprimer to set
	 */
	public void setSupprimer(JMenuItem supprimer) {
		this.supprimer = supprimer;
	}

	

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	
	
}