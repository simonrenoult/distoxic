package vue.editeurs;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EditeurSDF extends JPanel
{
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	public static Integer	TAILLE_X		= Editeurs.TAILLE_X;
	public static Integer	TAILLE_Y		= 2 * Editeurs.TAILLE_Y / 5;

	private JLabel			titre;
	private String			contenuTitre	= "Editeur de fichiers *.sdf";

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public EditeurSDF()
	{
		setSize(TAILLE_X, TAILLE_Y);
		setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		setBackground(Color.WHITE);

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
