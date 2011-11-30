
package vue.editeurs;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EditeurGPH extends JPanel
{
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	public static Integer	TAILLE_X	= 3 * Editeurs.TAILLE_X / 5;
	public static Integer	TAILLE_Y	= Editeurs.TAILLE_Y / 2;
	
	private JLabel					titre;
	private String					contenuTitre	= "Editeur de fichiers *.gph";

	
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	public EditeurGPH()
	{
		this.setSize(TAILLE_X, TAILLE_Y);
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.setBackground(Color.WHITE);
		
		initTitre();
	}
	
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	
	private void initTitre()
	{
		titre = new JLabel(contenuTitre);
		titre.setName("titre");
		this.add(titre);
	}
	
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
