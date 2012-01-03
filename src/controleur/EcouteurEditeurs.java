package controleur;

import java.awt.Event;
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

public class EcouteurEditeurs implements MouseListener, ActionListener
{
	/**
	 * <h4>EcouteurEditeurs est la classe qui represente l'ecouteur des classes EditeursSDF, EditeursGPH, EditeurBIN</h4>
	 * <p>
	 * Cette classe contient : 
	 * <ul>
	 * <li>Une instance de classe MenuContextuel, representant la vue lie au clic droit.</li>
	 * <li>Une instance de classe de Editeurs, afin d'avoir acces à l'ensemble des editeurs DSF, BIN, et GPH.</li>
	 * <li>Trois instance de classe de Jtable, referant les Jtables associe aux editeurs.</li>
	 * <li>Deux instance de classe de Border, Permettant de connaître la Jtable selectionne par l'utilisateur..</li>
	 * </ul>
	 * </p>
	 * 
	 * <p>
	 * Remarque : Les 3 Jtables ne sont pas instanciees au même moment, l'editeur peut donc comporter des Jtables null.
	 * </p>
	 * @see EditeurSDF
	 * @see EditeurSGPH
	 * @see EditeurBIN
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	/**
	 * Le popup menu lie au clic droit, utile pour l'ajout de ligne dans les tableaux.
	 * @see  MenuContextuel
	 */
	private MenuContextuel	menuContextuel		= null;
	/**
	 * Un editeur regroupe jusqu'a 3 editeursSDF, BIN et GPH. Il represente un onglet graphique.
	 * @see Editeurs
	 */
	private Editeurs		editeur				= null;
	/**
	 * Un editeur peut contenir au minimum 1 Jtable et au maximum 3 Jtables. On a donc 3jtables provenant d'editeurs different.
	 * @ see TablesEditeurs
	 */
	private JTable			JtableBin			= null;
	private JTable			JtableGph			= null;
	private JTable			JtableSdf			= null;
	
	/**
	 * Chaque tableau (Jtable) est encadre lors de la prise de focus. Cela renseigne pour l'enregistrement, quel tableau est selectionne
	 */
	private Border			bordureSelection	= null;
	private Border			bordureVide			= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	/**
	 * Constructeur principal de la classe.
	 * @param ed l'editeur (l'onglet graphique) a ecouter.
	 */
	public EcouteurEditeurs(Editeurs ed)
	{
		this.editeur = ed;
		bordureSelection = ed.getBordureSelection();
		bordureVide = ed.getBordureVide();

		
		if (ed.getEdBin().getBinFile() != null)
		{
			ed.getEdBin().getTableauBIN().addMouseListener(this);
			this.JtableBin = ed.getEdBin().getTableauBIN();
			this.JtableBin.addMouseListener(this);
		}
		if (ed.getEdGph().getGphFile() != null){
			ed.getEdGph().getTableauGPH().addMouseListener(this);
			this.JtableGph = ed.getEdGph().getTableauGPH();
			this.JtableGph.addMouseListener(this);
		}
		if (ed.getEdSdf().getSdfFile() != null){
			ed.getEdSdf().getTableauSDF().addMouseListener(this);
			this.JtableSdf = ed.getEdSdf().getTableauSDF();
			this.JtableSdf.addMouseListener(this);
		}
	}

	// ----------------------------------------- //
	// --------------INITIALISEURS-------------- //
	// ----------------------------------------- //

	/**
	 * Methode d'instanciation de l'objet menuContextuel.
	 * @param index permet de connaitre quel type menu popup il faut charger en fonction des Jtables.
	 */
	private void initMenuContextuel(int index)
	{
		menuContextuel = new MenuContextuel(index);
		/*menuContextuel.getAjouterDebutTableau().addActionListener(this);
		menuContextuel.getAjouterAvantLigneSelection().addActionListener(this);
		menuContextuel.getAjouterApresLigneSelection().addActionListener(this);
		menuContextuel.getAjouterFinTableau().addActionListener(this);*/
		menuContextuel.getSupprimer().addActionListener(this);
		if (index == 1)
		{
			menuContextuel.getAjouterFragmentBin().addActionListener(this);
		}
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	// --------- Selection de la bordure ---------//

	/**
	 * Redirection de l'évenement en fonction du du fichier destinataire.
	 * 
	 * @param e evenement liee a la souris
	 */
	public void selectionBordure(MouseEvent e)
	{

		if (e.getSource() == editeur.getEdBin().getTableauBIN())
		{
			selectionTableauBin();
		}
		if (e.getSource() == editeur.getEdGph().getTableauGPH())
		{
			selectionTableauGph();

		}
		if (e.getSource() == editeur.getEdSdf().getTableauSDF())
		{
			selectionTableauSdf();
		}
	}

	/**
	 * Methode de selection de la bordure et MAJ du cadre graphique pour le BIN.
	 */
	private void selectionTableauBin()
	{
		editeur.getEdBin().setBorder(bordureSelection);
		editeur.getEdGph().setBorder(bordureVide);
		editeur.getEdSdf().setBorder(bordureVide);
		editeur.getEdBin().getBinFile().setFlank(true);
		
		if (editeur.getEdGph().getGphFile() != null)
		{
			editeur.getEdGph().getGphFile().setFlank(false);
		}
		if (editeur.getEdSdf().getSdfFile() != null)
		{
			editeur.getEdSdf().getSdfFile().setFlank(false);
		}
	}

	/**
	 * Methode de selection de la bordure et MAJ du cadre graphique pour le GPH.
	 */
	private void selectionTableauGph()
	{
		editeur.getEdGph().setBorder(bordureSelection);
		editeur.getEdBin().setBorder(bordureVide);
		editeur.getEdSdf().setBorder(bordureVide);
		editeur.getEdGph().getGphFile().setFlank(true);
		
		if (editeur.getEdBin().getBinFile() != null)
		{
			editeur.getEdBin().getBinFile().setFlank(false);
		}
		if (editeur.getEdSdf().getSdfFile() != null)
		{
			editeur.getEdSdf().getSdfFile().setFlank(false);

		}
	}

	/**
	 * Methode de selection de la bordure et MAJ du cadre graphique pour le SDF.
	 */
	private void selectionTableauSdf()
	{
		editeur.getEdGph().setBorder(bordureVide);
		editeur.getEdBin().setBorder(bordureVide);
		editeur.getEdSdf().setBorder(bordureSelection);
		editeur.getEdSdf().getSdfFile().setFlank(true);
		if (editeur.getEdBin().getBinFile() != null)
		{
			editeur.getEdBin().getBinFile().setFlank(false);
		}
		if (editeur.getEdGph().getGphFile() != null)
		{
			editeur.getEdGph().getGphFile().setFlank(false);
		}

	}

	// --------- Suppression de lignes ---------//
	/**
	 * Methode de suppression de la ligne choisi sur les tableaux SDF et BIN.
	 */
	private void suppressionSdfBin()
	{
		int positionLigne = JtableSdf.getSelectedRow();
		if (JtableBin != null)
		{
			((ModeleTablesEditeurs) editeur.getEdBin().getTableauBIN().getModel()).SupprimerLigne(positionLigne);
			((ModeleTablesEditeurs) editeur.getEdSdf().getTableauSDF().getModel()).SupprimerLigne(positionLigne);
			editeur.getEdBin().getBinFile().getFichierBinTmp().suppressionLigneLigneFichierBinTmp(positionLigne);
			editeur.getEdSdf().getSdfFile().getFichierSdfTmp().suppressionLigneLigneFichierBinTmp(positionLigne);
		}
		else
		{
			lancerMessageErreur("Impossibilité de suppression : tableau BIN absent.");
		}

	}

	/**
	 * Methode de suppression de la ligne choisi sur le tableau GPH.
	 */
	private void suppessionGPH()
	{
		int positionLigne = JtableGph.getSelectedRow();
		((ModeleTablesEditeurs) editeur.getEdGph().getTableauGPH().getModel()).SupprimerLigne(positionLigne);
		editeur.getEdGph().getGphFile().getFichierGphTmp().suppressionLigneLigneFichierBinTmp(positionLigne);
		
	}

	/**
	 * Methode de suppression de la ligne choisi sur les tableaux BIN et SDF.
	 */
	private void suppressionBinSdf()
	{
		int positionLigne = JtableBin.getSelectedRow();
		if (editeur.getEdSdf().getTableauSDF() != null)
		{
			((ModeleTablesEditeurs) editeur.getEdBin().getTableauBIN().getModel()).SupprimerLigne(positionLigne);
			((ModeleTablesEditeurs) editeur.getEdSdf().getTableauSDF().getModel()).SupprimerLigne(positionLigne);
			editeur.getEdBin().getBinFile().getFichierBinTmp().suppressionLigneLigneFichierBinTmp(positionLigne);
			editeur.getEdSdf().getSdfFile().getFichierSdfTmp().suppressionLigneLigneFichierBinTmp(positionLigne);
		}
		else
		{
			lancerMessageErreur("Impossibilité de suppression : tableau SDF absent.");
		}

	}

	/**
	 * Methode de redirection des suppression suite au clic sur un des 3 tableaux.
	 */
	private void suppressionLigne()
	{
		if (editeur.getEdBin().getBinFile() != null && editeur.getEdBin().getBinFile().isFlank())
		{
			suppressionBinSdf();
		}
		else if (editeur.getEdGph().getGphFile() != null && editeur.getEdGph().getGphFile().isFlank())
		{
			suppessionGPH();
		}
		else if (editeur.getEdSdf().getSdfFile() != null && editeur.getEdSdf().getSdfFile().isFlank())
		{
			suppressionSdfBin();
		}
	}

	/**
	 * Boite de dialogue renvoyant un erreur personalisee
	 * 
	 * @param message le message d'erreur a faire communiquer.
	 */
	private void lancerMessageErreur(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	// --------- Ajout ligne debut tableau-----//

	/**
	 * Methode d'ajout d'une ligne en début de tableau SDF et BIN
	 */
	private void ajouterLigneDebutTableauSdfBin()
	{
		if (JtableBin != null)
		{
			((ModeleTablesEditeurs) JtableBin.getModel()).ajouterLigneDebut(((ModeleTablesEditeurs) JtableBin
					.getModel()).creerLigneVierge(JtableBin.getColumnCount()));

			((ModeleTablesEditeurs) JtableSdf.getModel()).ajouterLigneDebut(((ModeleTablesEditeurs) JtableSdf
					.getModel()).creerLigneVierge(JtableSdf.getColumnCount()));
		}
		else
		{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}
	}

	/**
	 *  Methode d'ajout d'une ligne en début de tableau GPH
	 */
	private void ajouterLigneDebutTableauGph()
	{
		((ModeleTablesEditeurs) JtableGph.getModel()).ajouterLigneDebut(((ModeleTablesEditeurs) JtableGph.getModel())
				.creerLigneVierge(JtableGph.getColumnCount()));
	}

	/**
	 *  Methode d'ajout d'une ligne en début de fichier BIN et SDF
	 */
	private void ajouterLigneDebutTableauBinSdf()
	{
		if (JtableSdf != null)
		{
			((ModeleTablesEditeurs) JtableBin.getModel()).ajouterLigneDebut(((ModeleTablesEditeurs) JtableBin
					.getModel()).creerLigneVierge(JtableBin.getColumnCount()));

			((ModeleTablesEditeurs) JtableSdf.getModel()).ajouterLigneDebut(((ModeleTablesEditeurs) JtableSdf
					.getModel()).creerLigneVierge(JtableSdf.getColumnCount()));
		}
		else
		{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}

	}

	/**
	 *  Methode de redirection sur l'ajout de ligne en début de fichier./
	 */
	private void ajouterLigneDebutTableau()
	{
		if (editeur.getEdBin().getBinFile() != null && editeur.getEdBin().getBinFile().isFlank())
		{
			ajouterLigneDebutTableauBinSdf();
		}
		else if (editeur.getEdGph().getGphFile() != null && editeur.getEdGph().getGphFile().isFlank())
		{
			ajouterLigneDebutTableauGph();
		}
		else if (editeur.getEdSdf().getSdfFile() != null && editeur.getEdSdf().getSdfFile().isFlank())
		{
			ajouterLigneDebutTableauSdfBin();
		}

	}

	// --------- Ajout ligne fin tableau---------//

	/**
	 * Methode de redirection pour ajouter un ligne en fin de tableau
	 */
	private void ajouterLigneFinTableau()
	{
		if (editeur.getEdBin().getBinFile() != null && editeur.getEdBin().getBinFile().isFlank())
		{
			ajouterLigneFinTableauBinSdf();
		}
		else if (editeur.getEdGph().getGphFile() != null && editeur.getEdGph().getGphFile().isFlank())
		{
			ajouterLigneFinTableauGph();
		}
		else if (editeur.getEdSdf().getSdfFile() != null && editeur.getEdSdf().getSdfFile().isFlank())
		{
			ajouterLigneFinTableauSdfBin();
		}
	}

	/**
	 * AJout d'une ligne en fin de tableaux SDF et BIN
	 */
	private void ajouterLigneFinTableauSdfBin()
	{
		if (JtableBin != null)
		{
			((ModeleTablesEditeurs) JtableBin.getModel()).ajouterLigneFin(((ModeleTablesEditeurs) JtableBin.getModel())
					.creerLigneVierge(JtableBin.getColumnCount()));

			((ModeleTablesEditeurs) JtableSdf.getModel()).ajouterLigneFin(((ModeleTablesEditeurs) JtableSdf.getModel())
					.creerLigneVierge(JtableSdf.getColumnCount()));
		}
		else
		{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}

	}

	/**
	 * Methode d'ajout d'une ligne en fin de tableau GPH
	 */
	private void ajouterLigneFinTableauGph()
	{
		((ModeleTablesEditeurs) JtableGph.getModel()).ajouterLigneFin(((ModeleTablesEditeurs) JtableGph.getModel())
				.creerLigneVierge(JtableGph.getColumnCount()));

	}

	/**
	 *  Methode d'ajout d'une ligne en fin de tableaux BIN et SDF
	 */
	private void ajouterLigneFinTableauBinSdf()
	{
		if (JtableSdf != null)
		{
			((ModeleTablesEditeurs) JtableBin.getModel()).ajouterLigneFin(((ModeleTablesEditeurs) JtableBin.getModel())
					.creerLigneVierge(JtableBin.getColumnCount()));

			((ModeleTablesEditeurs) JtableSdf.getModel()).ajouterLigneFin(((ModeleTablesEditeurs) JtableSdf.getModel())
					.creerLigneVierge(JtableSdf.getColumnCount()));
		}
		else
		{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}

	}

	// --------- Ajout ligne avant tableau---------//

	/**
	 * Methode de redirection vers l'ajout d'une ligne avant celle choisi par
	 * l'utilisateur
	 */
	private void ajouterLigneAvantTableau()
	{
		if (editeur.getEdBin().getBinFile() != null && editeur.getEdBin().getBinFile().isFlank())
		{
			ajouterLigneAvantTableauBinSdf();
		}
		else if (editeur.getEdGph().getGphFile() != null && editeur.getEdGph().getGphFile().isFlank())
		{
			ajouterLigneAvantTableauGph();
		}
		else if (editeur.getEdSdf().getSdfFile() != null && editeur.getEdSdf().getSdfFile().isFlank())
		{
			ajouterLigneAvantTableauSdfBin();
		}

	}

	/**
	 * Methode d'ajout d'une ligne avant la ligne choisi par l'utilisateur dans les
	 * tableaux SDF et BIN
	 */
	private void ajouterLigneAvantTableauSdfBin()
	{
		if (JtableBin != null)
		{
			int positionLigne = JtableSdf.getSelectedRow();
			((ModeleTablesEditeurs) JtableBin.getModel()).ajouterLigneAvant(
					((ModeleTablesEditeurs) JtableBin.getModel()).creerLigneVierge(JtableBin.getColumnCount()),
					positionLigne);

			((ModeleTablesEditeurs) JtableSdf.getModel()).ajouterLigneAvant(
					((ModeleTablesEditeurs) JtableSdf.getModel()).creerLigneVierge(JtableSdf.getColumnCount()),
					positionLigne);
		}
		else
		{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}

	}

	/**
	 * Methode d'ajout d'une ligne avant la ligne choisi par l'utilisateur dans le
	 * tableaux GPH
	 */
	private void ajouterLigneAvantTableauGph()
	{
		int positionLigne = JtableGph.getSelectedRow();
		((ModeleTablesEditeurs) JtableGph.getModel()).ajouterLigneAvant(
				((ModeleTablesEditeurs) JtableGph.getModel()).creerLigneVierge(JtableGph.getColumnCount()),
				positionLigne);

	}

	/**
	 * Methode d'ajout d'une ligne avant la ligne choisi par l'utilisateur dans les
	 * tableaux BIN et SDF
	 */
	private void ajouterLigneAvantTableauBinSdf()
	{
		if (JtableSdf != null)
		{
			int positionLigne = JtableBin.getSelectedRow();
			((ModeleTablesEditeurs) JtableBin.getModel()).ajouterLigneAvant(
					((ModeleTablesEditeurs) JtableBin.getModel()).creerLigneVierge(JtableBin.getColumnCount()),
					positionLigne);

			((ModeleTablesEditeurs) JtableSdf.getModel()).ajouterLigneAvant(
					((ModeleTablesEditeurs) JtableSdf.getModel()).creerLigneVierge(JtableSdf.getColumnCount()),
					positionLigne);
		}
		else
		{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}

	}

	// --------- Ajout ligne apres tableau---------//

	/**
	 * Methode de redirection vers l'ajout d'une ligne apres celle choisi
	 * par l'utilisateur
	 */

	private void ajouterLigneApresTableau()
	{
		if (editeur.getEdBin().getBinFile() != null && editeur.getEdBin().getBinFile().isFlank())
		{

		}
		else if (editeur.getEdSdf().getSdfFile() != null && editeur.getEdSdf().getSdfFile().isFlank())
		{

		}
		else
		{
			lancerMessageErreur("Aucune molecule n'a ete selectionne pour l'ajout du fragment.");
		}

	}

	/**
	 * Methode d'ajout d'une ligne apres la ligne choisi par l'utilisateur dans les
	 * tableaux SDF et BIN
	 */
	@SuppressWarnings("unused")
	private void ajouterLigneApresTableauSdfBin()
	{
		if (JtableBin != null)
		{
			int positionLigne = JtableSdf.getSelectedRow();
			((ModeleTablesEditeurs) JtableBin.getModel()).ajouterLigneApres(
					((ModeleTablesEditeurs) JtableBin.getModel()).creerLigneVierge(JtableBin.getColumnCount()),
					positionLigne);

			((ModeleTablesEditeurs) JtableSdf.getModel()).ajouterLigneApres(
					((ModeleTablesEditeurs) JtableSdf.getModel()).creerLigneVierge(JtableSdf.getColumnCount()),
					positionLigne);
		}
		else
		{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}

	}

	/**
	 * Methode d'ajout d'une ligne apres la ligne choisi par l'utilisateur dans le tableau GPH
	 */
	@SuppressWarnings("unused")
	private void ajouterLigneApresTableauGph()
	{
		int positionLigne = JtableGph.getSelectedRow();
		((ModeleTablesEditeurs) JtableGph.getModel()).ajouterLigneApres(
				((ModeleTablesEditeurs) JtableGph.getModel()).creerLigneVierge(JtableGph.getColumnCount()),
				positionLigne);

	}

	/**
	 * Methode d'ajout d'une ligne apres la ligne choisi par l'utilisateur dans les
	 * tableaux BIN et SDF
	 */
	@SuppressWarnings("unused")
	private void ajouterLigneApresTableauBinSdf()
	{
		if (JtableSdf != null)
		{
			int positionLigne = JtableBin.getSelectedRow();
			((ModeleTablesEditeurs) JtableBin.getModel()).ajouterLigneApres(
					((ModeleTablesEditeurs) JtableBin.getModel()).creerLigneVierge(JtableBin.getColumnCount()),
					positionLigne);

			((ModeleTablesEditeurs) JtableSdf.getModel()).ajouterLigneApres(
					((ModeleTablesEditeurs) JtableSdf.getModel()).creerLigneVierge(JtableSdf.getColumnCount()),
					positionLigne);
		}
		else
		{
			lancerMessageErreur("Impossibilité d'ajout de ligne : tableau BIN absent.");
		}

	}
	
	/**
	 * Methode d'ajout d'une ligne proveant de JtableGph vers JtableBin. Il ajoute a une molecule selectionne dans JtableSDF, l'indice du fragment dans la JtableBin.
	 */
	private void ajoutFragmentMolecule()
	{
		if (editeur.getEdSdf().getSdfFile() != null && JtableSdf.getSelectedRow() != -1)
		{
			if (editeur.getEdBin().getBinFile() != null)
			{
				int positionLigne = JtableSdf.getSelectedRow();
				int numeroFragment = JtableGph.getSelectedRow();
				editeur.getEdBin().getBinFile().getFichierBinTmp().ajoutFragment(positionLigne, numeroFragment);
				int nbFragment = (Integer) (JtableBin.getValueAt(positionLigne, 2));
				JtableBin.setValueAt(nbFragment + 1, positionLigne, 2);
			}
			else
			{
				lancerMessageErreur("Ajout impossible : aucun tableau BIN n'est present.");
			}
		}
		else
		{
			lancerMessageErreur("Vous n'avez pas selectionne de molecule (tableau SDF) pour l'ajout du fragment");
		}

	}

	// ----------------------------------------- //
	// ---------------LISTENER------------------ //
	// ----------------------------------------- //

	@Override
	/**
	 * Methode permettant de capter les evenements de type ActionEvent sur le popup menu.
	 * @param e evenement d'un objet graphique provenant de la selection d'un item sur le popup menu du programme.
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == menuContextuel.getAjouterDebutTableau())
		{
			ajouterLigneDebutTableau();
		}
		else if (e.getSource() == menuContextuel.getAjouterFinTableau())
		{
			ajouterLigneFinTableau();
		}
		else if (e.getSource() == menuContextuel.getAjouterAvantLigneSelection())
		{
			ajouterLigneAvantTableau();
		}
		else if (e.getSource() == menuContextuel.getAjouterApresLigneSelection())
		{
			ajouterLigneApresTableau();
		}
		else if (e.getSource() == menuContextuel.getSupprimer())
		{
			suppressionLigne();
		}
		else if (e.getSource() == menuContextuel.getAjouterFragmentBin())
		{
			ajoutFragmentMolecule();
		}
	}

	
	/**
	 * Methode permettant de capter les evenements de type MouseEvent sur le popup menu.
	 * @param e evenement lie au clic de la souris.
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// Si on applique la methode directement perte de l'encadrement.
		if (e.getModifiers() == Event.META_MASK)
		{
			selectionBordure(e);
			if (editeur.getEdGph().getGphFile() != null && editeur.getEdGph().getGphFile().isFlank())
			{
				initMenuContextuel(1);
			}
			else
			{
				initMenuContextuel(0);
			}
			menuContextuel.show(e.getComponent(), e.getX(), e.getY());
		}
		else
		{
			selectionBordure(e);
		}

	}

}
