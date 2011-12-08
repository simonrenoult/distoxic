/*
 * Panneau contenant les onglets.
 * Ces derniers incluent chacun trois �diteurs associ�s � un type de fichier pr�d�fini :
 *				- SDF ;
 *				- GPH ;
 *				- BIN ;
 */
package vue.editeurs;

import java.awt.Dimension;
import javax.swing.JTabbedPane;
import controleur.EcouteurBarreMenu;
import vue.ConteneurGlobal;

@SuppressWarnings("serial")
public class ConteneurEditeurs extends JTabbedPane
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer	TAILLE_X		= 4 * ConteneurGlobal.TAILLE_X / 5;
	public final static Integer	TAILLE_Y		= ConteneurGlobal.TAILLE_Y;

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private Editeurs			editeurs;
	private String				titreEditeurs	= "Triplet";

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public ConteneurEditeurs()
	{
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));

		this.editeurs = new Editeurs();
		this.add(titreEditeurs, editeurs);

		initListeners();
	}

	// ----------------------------------------- //
	// ----------------LISTENERS---------------- //
	// ----------------------------------------- //

	private void initListeners()
	{
		@SuppressWarnings("unused")
		EcouteurBarreMenu emt = new EcouteurBarreMenu(this);
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	public Editeurs getEditeurs()
	{
		return editeurs;
	}

	public String getTitreEditeurs()
	{
		return titreEditeurs;
	}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	public void setEditeurs(Editeurs editeurs)
	{
		this.editeurs = editeurs;
	}

	public void setTitreEditeurs(String titreEditeurs)
	{
		this.titreEditeurs = titreEditeurs;
	}
}