package vue.barreOutils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import vue.FenetrePrincipale;

@SuppressWarnings("serial")
public class BarreOutils extends JPanel
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer	TAILLE_X	= FenetrePrincipale.TAILLE_X;
	public final static Integer	TAILLE_Y	= FenetrePrincipale.TAILLE_Y / 20;

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private JToolBar			barreFichier;
	private JButton				nouveau;
	private JButton				enregistrer;
	private JButton				enregistrerSous;
	private JButton				imprimer;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	public BarreOutils()
	{
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));

		initBarreFichier();
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	private void initBarreFichier()
	{
		initBoutons();

		barreFichier = new JToolBar();

		barreFichier.add(nouveau);
		barreFichier.add(enregistrer);
		barreFichier.add(enregistrerSous);
		barreFichier.add(imprimer);
		barreFichier.addSeparator();
		barreFichier.setRollover(true);
		
		this.add(barreFichier, BorderLayout.PAGE_START);
	}
	
	private void initBoutons()
	{
		nouveau = creerBouton("src/images/icones/folder_add.png", "Nouveau");
		enregistrer = creerBouton("src/images/icones/save_as.png", "Enregistrer");
		enregistrerSous = creerBouton("src/images/icones/save_as.png", "Enregistrer Tous");
		imprimer = creerBouton("src/images/icones/printer.png", "Imprimer");
	}	

	// ----------------------------------------- //
	// ----------------METHODES----------------- //
	// ----------------------------------------- //
	
	private JButton creerBouton(String path, String toolTip)
	{
		JButton button = new JButton();
		button.setIcon(new ImageIcon(path));
		button.setToolTipText(toolTip);
		button.setPreferredSize(new Dimension(30, 30));
		return button;
	}

	

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	
	public JToolBar getBarreFichier()
	{
		return barreFichier;
	}

	public JButton getNouveau()
	{
		return nouveau;
	}

	public JButton getEnregistrer()
	{
		return enregistrer;
	}

	public JButton getEnregistrerSous()
	{
		return enregistrerSous;
	}

	public JButton getImprimer()
	{
		return imprimer;
	}
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	
	public void setBarreFichier(JToolBar barreFichier)
	{
		this.barreFichier = barreFichier;
	}

	public void setNouveau(JButton nouveau)
	{
		this.nouveau = nouveau;
	}

	public void setEnregistrer(JButton enregistrer)
	{
		this.enregistrer = enregistrer;
	}

	public void setEnregistrerSous(JButton enregistrerSous)
	{
		this.enregistrerSous = enregistrerSous;
	}

	public void setImprimer(JButton imprimer)
	{
		this.imprimer = imprimer;
	}
}
