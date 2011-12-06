package vue.editeurs;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EditeurSDF extends JPanel
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public static Integer		TAILLE_X	= Editeurs.TAILLE_X;
	public static Integer		TAILLE_Y	= 2 * Editeurs.TAILLE_Y / 5;

	private final static String	TITRE		= "Editeur de fichiers *.sdf";

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private JLabel				titre;

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
		titre = new JLabel(TITRE);
		titre.setName("titre");
		this.add(titre);
	}
	
	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //

	public JLabel getTitre()
	{
		return titre;
	}

	// ----------------------------------------- //
	// --------------- MUTATEURS --------------- //
	// ----------------------------------------- //
	
	public void setTitre(JLabel titre)
	{
		this.titre = titre;
	}
}
