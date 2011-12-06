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
import controleur.EcouteurMenuTextuel;
import vue.ConteneurGlobal;
import vue.NavigateurFichiers;

@SuppressWarnings("serial")
public class ConteneurEditeurs extends JTabbedPane
{
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	public static Integer	TAILLE_X	= ConteneurGlobal.TAILLE_X - NavigateurFichiers.TAILLE_X;
	public static Integer	TAILLE_Y	= ConteneurGlobal.TAILLE_Y;
	
	private Editeurs		editeurs;
	private String			titreEditeurs = "Triplet";
	
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	public ConteneurEditeurs()
	{
		this.setSize(TAILLE_X, TAILLE_Y);
		this.setPreferredSize(new Dimension(TAILLE_X,TAILLE_Y));

		this.editeurs = new Editeurs();
		this.add(titreEditeurs,editeurs);
		
		initListeners();
	}
	
	// ----------------------------------------- //
	// ----------------LISTENERS---------------- //
	// ----------------------------------------- //
	
	private void initListeners()
	{
		@SuppressWarnings("unused")
		EcouteurMenuTextuel emt = new EcouteurMenuTextuel(this);
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