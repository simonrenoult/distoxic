package src.controleur;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;


import src.modele.editeurs.ModeleTablesEditeurs;
import src.vue.MenuContextuel;
import src.vue.editeurs.Editeurs;

public class EcouteurEditeurs implements MouseListener, ActionListener
{
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private MenuContextuel	menuContextuel		= null;
	private Editeurs		editeur				= null;
	private JTable			JtableBin			= null;
	private JTable			JtableGph			= null;
	private JTable			JtableSdf			= null;
	private Border			bordureSelection	= null;
	private Border			bordureVide			= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public EcouteurEditeurs(Editeurs ed)
	{
		this.editeur = ed;
		bordureSelection = ed.getBordureSelection();
		bordureVide = ed.getBordureVide();

		try
		{
			ed.getEdBin().getTableauBIN().addMouseListener(this);
			this.JtableBin = ed.getEdBin().getTableauBIN();
			this.JtableBin.addMouseListener(this);

		}
		catch (Exception e)
		{
		}

		try
		{
			ed.getEdGph().getTableauGPH().addMouseListener(this);
			this.JtableGph = ed.getEdGph().getTableauGPH();
			this.JtableGph.addMouseListener(this);
		}
		catch (Exception e)
		{
		}

		try
		{
			ed.getEdSdf().getTableauSDF().addMouseListener(this);
			this.JtableSdf = ed.getEdSdf().getTableauSDF();
			this.JtableSdf.addMouseListener(this);
		}
		catch (Exception e)
		{
		}

	}

	// ----------------------------------------- //
	// --------------INITIALISEURS-------------- //
	// ----------------------------------------- //

	@SuppressWarnings("unused")
	private void initMenuContextuel(int index)
	{
		menuContextuel = new MenuContextuel(index);
		menuContextuel.getAjouterDebutTableau().addActionListener(this);
		menuContextuel.getAjouterAvantLigneSelection().addActionListener(this);
		menuContextuel.getAjouterApresLigneSelection().addActionListener(this);
		menuContextuel.getAjouterFinTableau().addActionListener(this);
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
	 * @param e
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
	 * Selection de la bordure et MAJ du cadre graphique pour le BIN.
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
	 * Selection de la bordure et MAJ du cadre graphique pour le GPH.
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
	 * Selection de la bordure et MAJ du cadre graphique pour le SDF.
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
	 * Suppression de la ligne choisi sur les tableaux SDF et BIN.
	 */
	private void suppressionSdfBin()
	{
		int positionLigne = JtableSdf.getSelectedRow();
		if (JtableBin != null)
		{
			((ModeleTablesEditeurs) editeur.getEdBin().getTableauBIN().getModel()).SupprimerLigne(positionLigne);
			((ModeleTablesEditeurs) editeur.getEdSdf().getTableauSDF().getModel()).SupprimerLigne(positionLigne);
		}
		else
		{
			lancerMessageErreur("Impossibilité de suppression : tableau BIN absent.");
		}

	}

	/**
	 * Suppression de la ligne choisi sur le tableau GPH.
	 */
	private void suppessionGPH()
	{
		int positionLigne = JtableGph.getSelectedRow();
		((ModeleTablesEditeurs) editeur.getEdGph().getTableauGPH().getModel()).SupprimerLigne(positionLigne);

	}

	/**
	 * Suppression de la ligne choisi sur les tableaux BIN et SDF.
	 */
	private void suppressionBinSdf()
	{
		int positionLigne = JtableBin.getSelectedRow();
		if (editeur.getEdSdf().getTableauSDF() != null)
		{
			((ModeleTablesEditeurs) editeur.getEdBin().getTableauBIN().getModel()).SupprimerLigne(positionLigne);
			((ModeleTablesEditeurs) editeur.getEdSdf().getTableauSDF().getModel()).SupprimerLigne(positionLigne);
		}
		else
		{
			lancerMessageErreur("Impossibilité de suppression : tableau SDF absent.");
		}

	}

	/**
	 * Redirection des suppression suite au clic sur un des 3 tableaux.
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
	 * @param message
	 */
	private void lancerMessageErreur(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	// --------- Ajout ligne debut tableau-----//

	/**
	 * Ajout d'une ligne en début de tableau SDF et BIN
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
	 * Ajout d'une ligne en début de tableau GPH
	 */
	private void ajouterLigneDebutTableauGph()
	{
		((ModeleTablesEditeurs) JtableGph.getModel()).ajouterLigneDebut(((ModeleTablesEditeurs) JtableGph.getModel())
				.creerLigneVierge(JtableGph.getColumnCount()));
	}

	/**
	 * Ajout d'une ligne en début de fichier BIN et SDF
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
	 * Methode de redirection sur l'ajout de ligne en début de fichier./
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
	 * Ajout d'une ligne en fin de tableau GPH
	 */
	private void ajouterLigneFinTableauGph()
	{
		((ModeleTablesEditeurs) JtableGph.getModel()).ajouterLigneFin(((ModeleTablesEditeurs) JtableGph.getModel())
				.creerLigneVierge(JtableGph.getColumnCount()));

	}

	/**
	 * AJout d'une ligne en fin de tableaux BIN et SDF
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
	 * Ajout d'une ligne avant la ligne choisi par l'utilisateur dans les
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
	 * Ajout d'une ligne avant la ligne choisi par l'utilisateur dans le
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
	 * Ajout d'une ligne avant la ligne choisi par l'utilisateur dans les
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
	 * /** Methode de redirection vers l'ajout d'une ligne apres celle choisi
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
	 * Ajout d'une ligne apres la ligne choisi par l'utilisateur dans les
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
	 * Ajout d'une ligne apres la ligne choisi par l'utilisateur dans le tableau
	 * GPH
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
	 * Ajout d'une ligne apres la ligne choisi par l'utilisateur dans les
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

	// ----------------------------------------- //
	// ---------------LISTENER------------------ //
	// ----------------------------------------- //

	@Override
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
			lancerMessageErreur("Vous n'avez pas selectionne de molecule pour l'ajout du fragment");
		}

	}

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
				// initMenuContextuel(1);
			}
			else
			{
				// initMenuContextuel(0);
			}
			// menuContextuel.show(e.getComponent(), e.getX(), e.getY());
		}
		else
		{
			selectionBordure(e);
		}

	}

}
