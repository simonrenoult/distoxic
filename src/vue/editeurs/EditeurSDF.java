package vue.editeurs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

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

	public final static Color	BG_COLOR	= Color.WHITE;

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
		setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		setBackground(BG_COLOR);

		initTitre();
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	private void initTitre()
	{
		setLayout(new FlowLayout());
		
		titre = new JLabel(TITRE);
		titre.setName("titre");
		
		add(titre);
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
