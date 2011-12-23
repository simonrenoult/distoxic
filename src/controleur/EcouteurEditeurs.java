package controleur;

import java.awt.Event;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;

import modele.editeurs.ModeleTablesEditeurs;

import vue.MenuContextuel;
import vue.editeurs.Editeurs;

public class EcouteurEditeurs implements MouseListener, ActionListener{
// ----------------------------------------- //
// ----------------ATRIBUTS----------------- //
// ----------------------------------------- //
	private MenuContextuel menuContextuel = null;
	private Editeurs ed = null;
	private JTable JtableBin = null;
	private JTable JtableGph = null;
	private JTable JtableSdf = null;
	private Border bordureSelection = null;
	private Border bordureVide = null;
// ----------------------------------------- //
// --------------CONSTRUCTEURS-------------- //
// ----------------------------------------- //
	public EcouteurEditeurs(Editeurs ed){
		this.ed = ed;
		bordureSelection = ed.getBordureSelection();
		bordureVide = ed.getBordureVide();
		initMenuContextuel(0);
		
		try{
			ed.getEdBin().getTableauBIN().addMouseListener(this);
			this.JtableBin = ed.getEdBin().getTableauBIN();
			this.JtableBin.addMouseListener(this);
			
		}
		catch(Exception e){}
		
		try{
			ed.getEdGph().getTableauGPH().addMouseListener(this);
			this.JtableGph = ed.getEdGph().getTableauGPH();
			this.JtableGph.addMouseListener(this);
		}
		catch(Exception e){}
		
		try{
			ed.getEdSdf().getTableauSDF().addMouseListener(this);
			this.JtableSdf = ed.getEdSdf().getTableauSDF();
			this.JtableSdf.addMouseListener(this);
		}
		catch(Exception e){}
		
	}

	
// ----------------------------------------- //
// --------------INITIALISEURS-------------- //
// ----------------------------------------- //
	private void initMenuContextuel(int index){
		menuContextuel = new MenuContextuel(index);
		menuContextuel.getAjouterDebutTableau().addActionListener(this);
		menuContextuel.getAjouterAvantLigneSelection().addActionListener(this);
		menuContextuel.getAjouterApresLigneSelection().addActionListener(this);
		menuContextuel.getAjouterFinTableau().addActionListener(this);
		menuContextuel.getSupprimer().addActionListener(this);
	}

// ----------------------------------------- //
// -----------------METHODES---------------- //
// ----------------------------------------- //

//--------- Selection de la bordure ---------//

/**
 * Redirection de l'évenement en fonction du du fichier destinataire.
 * @param e
 */
	public void selectionBordure(MouseEvent e){
	
		if(e.getSource() == ed.getEdBin().getTableauBIN()){
			selectionTableauBin();
		}
		if(e.getSource() == ed.getEdGph().getTableauGPH()){
			selectionTableauGph();
			
		}
		if(e.getSource() == ed.getEdSdf().getTableauSDF()){
			selectionTableauSdf();
			
		}
	}
	/**
	 * Selection de la bordure et MAJ du cadre graphique pour le BIN.
	 */
	private void selectionTableauBin() {
		ed.getEdBin().setBorder(bordureSelection);
		ed.getEdGph().setBorder(bordureVide);
		ed.getEdSdf().setBorder(bordureVide);
		ed.getEdBin().getBinFile().setFlank(true);
		if (ed.getEdGph().getGphFile() != null){
			ed.getEdGph().getGphFile().setFlank(false);
		}
		if (ed.getEdSdf().getSdfFile() != null){
			ed.getEdSdf().getSdfFile().setFlank(false);
		}
	}
	/**
	 *  Selection de la bordure et MAJ du cadre graphique pour le GPH.
	 */
	private void selectionTableauGph() {
		ed.getEdGph().setBorder(bordureSelection);
		ed.getEdBin().setBorder(bordureVide);
		ed.getEdSdf().setBorder(bordureVide);
		ed.getEdGph().getGphFile().setFlank(true);
		if (ed.getEdBin().getBinFile() != null){
			ed.getEdBin().getBinFile().setFlank(false);
		}
		if (ed.getEdSdf().getSdfFile() != null){
			ed.getEdSdf().getSdfFile().setFlank(false);
			
		}
	}
	/**
	 *  Selection de la bordure et MAJ du cadre graphique pour le SDF.
	 */
	private void selectionTableauSdf() {
		ed.getEdGph().setBorder(bordureVide);
		ed.getEdBin().setBorder(bordureVide);
		ed.getEdSdf().setBorder(bordureSelection);
		ed.getEdSdf().getSdfFile().setFlank(true);
		if (ed.getEdBin().getBinFile() != null){
			ed.getEdBin().getBinFile().setFlank(false);
		}
		if (ed.getEdGph().getGphFile() != null){
			ed.getEdGph().getGphFile().setFlank(false);
		}
		
		
	}
	
//--------- Suppression de lignes  ---------//
	/**
	 * Suppression de la ligne choisi sur les tableaux SDF et BIN.
	 */
	private void suppressionSdfBin() {
		int positionLigne = JtableSdf.getSelectedRow();
		if(JtableBin != null){
			((ModeleTablesEditeurs)ed.getEdBin().getTableauBIN().getModel()).SupprimerLigne(positionLigne);
			((ModeleTablesEditeurs)ed.getEdSdf().getTableauSDF().getModel()).SupprimerLigne(positionLigne);
		}
		else{
			lancerMessageErreur("Impossibilité de suppression : tableau BIN absent.");
		}
		
	}
	/**
	 * Suppression de la ligne choisi sur le tableau GPH.
	 */
	private void suppessionGPH() {
		int positionLigne = JtableGph.getSelectedRow();
		((ModeleTablesEditeurs)ed.getEdGph().getTableauGPH().getModel()).SupprimerLigne(positionLigne);
		
	}
	/**
	 * Suppression de la ligne choisi sur les tableaux BIN et SDF.
	 */
	private void suppressionBinSdf() {
		int positionLigne = JtableBin.getSelectedRow();
		if(ed.getEdSdf().getTableauSDF() != null){
			((ModeleTablesEditeurs)ed.getEdBin().getTableauBIN().getModel()).SupprimerLigne(positionLigne);
			((ModeleTablesEditeurs)ed.getEdSdf().getTableauSDF().getModel()).SupprimerLigne(positionLigne);
		}
		else{
			lancerMessageErreur("Impossibilité de suppression : tableau SDF absent.");
		}
		
	}
	/**
	 * Redirection des suppression suite au clic sur un des 3 tableaux.
	 */
	private void suppressionLigne() {
		if(ed.getEdBin().getBinFile() != null && ed.getEdBin().getBinFile().isFlank()){
			suppressionBinSdf();
		}
		else if (ed.getEdGph().getGphFile() != null && ed.getEdGph().getGphFile().isFlank()){
			suppessionGPH();
		}
		else if (ed.getEdSdf().getSdfFile() != null && ed.getEdSdf().getSdfFile().isFlank()){
			suppressionSdfBin();
		}
	}	
	/**
	 * Boite de dialogue renvoyant un erreur personalisee
	 * @param message
	 */
	private void lancerMessageErreur(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}
	
//--------- Ajout ligne debut tableau-----//
	
	/**
	 * Ajout d'une ligne en début de tableau SDF et BIN
	 */
	private void ajouterLigneDebutTableauSdfBin() {
		if(JtableBin != null){
			((ModeleTablesEditeurs)JtableBin.getModel()).
				ajouterLigneDebut(((ModeleTablesEditeurs)JtableBin.getModel()).
					creerLigneVierge(JtableBin.getColumnCount()));
			
			((ModeleTablesEditeurs)JtableSdf.getModel()).
			ajouterLigneDebut(((ModeleTablesEditeurs)JtableSdf.getModel()).
				creerLigneVierge(JtableSdf.getColumnCount()));
		}
		else{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}
	}

	/**
	 * Ajout d'une ligne en début de tableau GPH
	 */
	private void ajouterLigneDebutTableauGph() {
		((ModeleTablesEditeurs)JtableGph.getModel()).
		ajouterLigneDebut(((ModeleTablesEditeurs)JtableGph.getModel()).
			creerLigneVierge(JtableGph.getColumnCount()));
	}

	/**
	 * Ajout d'une ligne en début de fichier BIN et SDF
	 */
	private void ajouterLigneDebutTableauBinSdf() {
		if(JtableSdf != null){
			((ModeleTablesEditeurs)JtableBin.getModel()).
				ajouterLigneDebut(((ModeleTablesEditeurs)JtableBin.getModel()).
					creerLigneVierge(JtableBin.getColumnCount()));
			
			((ModeleTablesEditeurs)JtableSdf.getModel()).
			ajouterLigneDebut(((ModeleTablesEditeurs)JtableSdf.getModel()).
				creerLigneVierge(JtableSdf.getColumnCount()));
		}
		else{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}
		
	}
	/**
	 * Methode de redirection sur l'ajout de ligne en début de fichier./
	 */
	private void ajouterLigneDebutTableau() {
		if(ed.getEdBin().getBinFile() != null && ed.getEdBin().getBinFile().isFlank()){
			ajouterLigneDebutTableauBinSdf();
		}
		else if (ed.getEdGph().getGphFile() != null && ed.getEdGph().getGphFile().isFlank()){
			ajouterLigneDebutTableauGph();
		}
		else if (ed.getEdSdf().getSdfFile() != null && ed.getEdSdf().getSdfFile().isFlank()){
			ajouterLigneDebutTableauSdfBin();
		}
		
	}
	
	//--------- Ajout ligne fin tableau---------//

	/**
	 * Methode de redirection pour ajouter un ligne en fin de tableau
	 */
	private void ajouterLigneFinTableau() {
		if(ed.getEdBin().getBinFile() != null && ed.getEdBin().getBinFile().isFlank()){
			ajouterLigneFinTableauBinSdf();
		}
		else if (ed.getEdGph().getGphFile() != null && ed.getEdGph().getGphFile().isFlank()){
			ajouterLigneFinTableauGph();
		}
		else if (ed.getEdSdf().getSdfFile() != null && ed.getEdSdf().getSdfFile().isFlank()){
			ajouterLigneFinTableauSdfBin();
		}
	}
	/**
	 * AJout d'une ligne en fin de tableaux SDF et BIN
	 */
	private void ajouterLigneFinTableauSdfBin() {
		if(JtableBin != null){
			((ModeleTablesEditeurs)JtableBin.getModel()).
				ajouterLigneFin(((ModeleTablesEditeurs)JtableBin.getModel()).
					creerLigneVierge(JtableBin.getColumnCount()));
			
			((ModeleTablesEditeurs)JtableSdf.getModel()).
			ajouterLigneFin(((ModeleTablesEditeurs)JtableSdf.getModel()).
				creerLigneVierge(JtableSdf.getColumnCount()));
		}
		else{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}
		
	}
	/**
	 * Ajout d'une ligne en fin de tableau GPH
	 */
	private void ajouterLigneFinTableauGph() {
		((ModeleTablesEditeurs)JtableGph.getModel()).
		ajouterLigneFin(((ModeleTablesEditeurs)JtableGph.getModel()).
			creerLigneVierge(JtableGph.getColumnCount()));
		
	}
	/**
	 * AJout d'une ligne en fin de tableaux BIN et SDF
	 */
	private void ajouterLigneFinTableauBinSdf() {
		if(JtableSdf != null){
			((ModeleTablesEditeurs)JtableBin.getModel()).
			ajouterLigneFin(((ModeleTablesEditeurs)JtableBin.getModel()).
					creerLigneVierge(JtableBin.getColumnCount()));
			
			((ModeleTablesEditeurs)JtableSdf.getModel()).
			ajouterLigneFin(((ModeleTablesEditeurs)JtableSdf.getModel()).
				creerLigneVierge(JtableSdf.getColumnCount()));
		}
		else{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}
		
	}
	
	//--------- Ajout ligne avant tableau---------//
	
	 /**
	 * Methode de redirection vers l'ajout d'une ligne avant celle choisi par l'utilisateur
	 */
	private void ajouterLigneAvantTableau() {
		if(ed.getEdBin().getBinFile() != null && ed.getEdBin().getBinFile().isFlank()){
			ajouterLigneAvantTableauBinSdf();
		}
		else if (ed.getEdGph().getGphFile() != null && ed.getEdGph().getGphFile().isFlank()){
			ajouterLigneAvantTableauGph();
		}
		else if (ed.getEdSdf().getSdfFile() != null && ed.getEdSdf().getSdfFile().isFlank()){
			ajouterLigneAvantTableauSdfBin();
		}
		
	}

	/**
	 * Ajout d'une ligne avant la ligne choisi par l'utilisateur dans les tableaux SDF et BIN
	 */
	private void ajouterLigneAvantTableauSdfBin() {
		if(JtableBin != null){
			int positionLigne = JtableSdf.getSelectedRow();
			((ModeleTablesEditeurs)JtableBin.getModel()).
				ajouterLigneAvant(((ModeleTablesEditeurs)JtableBin.getModel()).
					creerLigneVierge(JtableBin.getColumnCount()), positionLigne);
			
			((ModeleTablesEditeurs)JtableSdf.getModel()).
			ajouterLigneAvant(((ModeleTablesEditeurs)JtableSdf.getModel()).
				creerLigneVierge(JtableSdf.getColumnCount()),positionLigne);
		}
		else{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}
		
	}
	/**
	 * Ajout d'une ligne avant la ligne choisi par l'utilisateur dans le tableaux GPH
	 */
	private void ajouterLigneAvantTableauGph() {
		int positionLigne = JtableGph.getSelectedRow();
		((ModeleTablesEditeurs)JtableGph.getModel()).
		ajouterLigneAvant(((ModeleTablesEditeurs)JtableGph.getModel()).
			creerLigneVierge(JtableGph.getColumnCount()),positionLigne);
		
	}

	/**
	 * Ajout d'une ligne avant la ligne choisi par l'utilisateur dans les tableaux BIN et SDF
	 */
	private void ajouterLigneAvantTableauBinSdf() {
		if(JtableSdf != null){
			int positionLigne = JtableBin.getSelectedRow();
			((ModeleTablesEditeurs)JtableBin.getModel()).
			ajouterLigneAvant(((ModeleTablesEditeurs)JtableBin.getModel()).
					creerLigneVierge(JtableBin.getColumnCount()), positionLigne);
			
			((ModeleTablesEditeurs)JtableSdf.getModel()).
			ajouterLigneAvant(((ModeleTablesEditeurs)JtableSdf.getModel()).
				creerLigneVierge(JtableSdf.getColumnCount()), positionLigne);
		}
		else{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}
		
	}
	
	//--------- Ajout ligne apres tableau---------//
	
	/**
	 * /**
	 * Methode de redirection vers l'ajout d'une ligne apres celle choisi par l'utilisateur
	 */
	 
	private void ajouterLigneApresTableau() {
		if(ed.getEdBin().getBinFile() != null && ed.getEdBin().getBinFile().isFlank()){
			ajouterLigneApresTableauBinSdf();
		}
		else if (ed.getEdGph().getGphFile() != null && ed.getEdGph().getGphFile().isFlank()){
			ajouterLigneApresTableauGph();
		}
		else if (ed.getEdSdf().getSdfFile() != null && ed.getEdSdf().getSdfFile().isFlank()){
			ajouterLigneApresTableauSdfBin();
		}
		
	}

	/**
	 * Ajout d'une ligne apres la ligne choisi par l'utilisateur dans les tableaux SDF et BIN
	 */
	private void ajouterLigneApresTableauSdfBin() {
		if(JtableBin != null){
			int positionLigne = JtableSdf.getSelectedRow();
			((ModeleTablesEditeurs)JtableBin.getModel()).
				ajouterLigneApres(((ModeleTablesEditeurs)JtableBin.getModel()).
					creerLigneVierge(JtableBin.getColumnCount()), positionLigne);
			
			((ModeleTablesEditeurs)JtableSdf.getModel()).
			ajouterLigneApres(((ModeleTablesEditeurs)JtableSdf.getModel()).
				creerLigneVierge(JtableSdf.getColumnCount()),positionLigne);
		}
		else{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}
		
	}

	/**
	 * Ajout d'une ligne apres la ligne choisi par l'utilisateur dans le tableau GPH
	 */
	private void ajouterLigneApresTableauGph() {
		int positionLigne = JtableGph.getSelectedRow();
		((ModeleTablesEditeurs)JtableGph.getModel()).
		ajouterLigneApres(((ModeleTablesEditeurs)JtableGph.getModel()).
			creerLigneVierge(JtableGph.getColumnCount()),positionLigne);
		
		
	}

	/**
	 * Ajout d'une ligne apres la ligne choisi par l'utilisateur dans les tableaux BIN et SDF
	 */
	private void ajouterLigneApresTableauBinSdf() {
		if(JtableSdf != null){
			int positionLigne = JtableBin.getSelectedRow();
			((ModeleTablesEditeurs)JtableBin.getModel()).
			ajouterLigneApres(((ModeleTablesEditeurs)JtableBin.getModel()).
					creerLigneVierge(JtableBin.getColumnCount()), positionLigne);
			
			((ModeleTablesEditeurs)JtableSdf.getModel()).
			ajouterLigneApres(((ModeleTablesEditeurs)JtableSdf.getModel()).
				creerLigneVierge(JtableSdf.getColumnCount()), positionLigne);
		}
		else{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}
		
	}

	// ----------------------------------------- //
	// ---------------LISTENER------------------ //
	// ----------------------------------------- //
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuContextuel.getAjouterDebutTableau()){
			ajouterLigneDebutTableau();
		}
		else if(e.getSource() == menuContextuel.getAjouterFinTableau()){
			ajouterLigneFinTableau();
		}
		else if(e.getSource() == menuContextuel.getAjouterAvantLigneSelection()){
			ajouterLigneAvantTableau();
		}
		else if(e.getSource() == menuContextuel.getAjouterApresLigneSelection()){
			ajouterLigneApresTableau();
		}
		else if (e.getSource() == menuContextuel.getSupprimer()){
			suppressionLigne();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// Si on applique la methode directement perte de l'encadrement.
		if(e.getModifiers()== Event.META_MASK){
			selectionBordure(e);
			if(ed.getEdGph().getGphFile() != null && ed.getEdGph().getGphFile().isFlank()){
				initMenuContextuel(1);
				menuContextuel.show(e.getComponent(), e.getX(), e.getY());
			}
			else{
				initMenuContextuel(0);
				menuContextuel.show(e.getComponent(), e.getX(), e.getY());
			}
			
		}
		else{
			selectionBordure(e);
			if(ed.getEdBin().getBinFile() != null){
				Point p = e.getPoint(); 
		        int colonne = JtableBin.columnAtPoint(p);
		        if(colonne == 2){
		        	System.out.println("lancer fenetre");
		        }
			}
		}
		
	}
	

}
