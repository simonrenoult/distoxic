package vue.barreOutils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import controleur.EcouteurBarreOutils;

import vue.FenetrePrincipale;

@SuppressWarnings("serial")
public class BarreOutils extends JPanel
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //
	
	private static String		_ICON_PATH	= "src" + File.separator + "images" + File.separator + "icones"
													+ File.separator;
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
		setLayout(new BorderLayout());

		initBoutons();
		initBarreMenu();
		initPanel();
		initListener();
	}
	
	// ----------------------------------------- //
	// ----------------METHODES----------------- //
	// ----------------------------------------- //

	private void initBoutons()
	{
		nouveau = creerBouton("folder_add.png", "Nouveau");
		enregistrer = creerBouton("save_as.png", "Enregistrer");
		enregistrerSous = creerBouton("save_as.png", "Enregistrer Tous");
		imprimer = creerBouton("printer.png", "Imprimer");
	}

	private void initBarreMenu()
	{
		barreFichier = new JToolBar();
		
		barreFichier.add(nouveau);
		barreFichier.add(enregistrer);
		barreFichier.add(enregistrerSous);
		barreFichier.add(imprimer);
		
		barreFichier.addSeparator();
		barreFichier.setRollover(true);
	}

	private JButton creerBouton(String path, String toolTip)
	{
		JButton button = new JButton();
		button.setIcon(new ImageIcon(_ICON_PATH + path));
		button.setToolTipText(toolTip);
		button.setPreferredSize(new Dimension(30, 30));
		
		return button;
	}

	private void initListener()
	{
		//@SuppressWarnings("unused")
		//EcouteurBarreOutils e = new EcouteurBarreOutils(this);
	}

	private void initPanel()
	{
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.add(barreFichier, BorderLayout.PAGE_START);
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	/**
	 * @return the toolbar
	 */
	public JToolBar getToolbar()
	{
		return barreFichier;
	}

	/**
	 * @param toolbar
	 *            the toolbar to set
	 */
	public void setToolbar(JToolBar toolbar)
	{
		this.barreFichier = toolbar;
	}

	/**
	 * @return the nouveau
	 */
	public JButton getNouveau()
	{
		return nouveau;
	}

	/**
	 * @param nouveau
	 *            the nouveau to set
	 */
	public void setNouveau(JButton nouveau)
	{
		this.nouveau = nouveau;
	}

	

	/**
	 * @return the enregistrer
	 */
	public JButton getEnregistrer()
	{
		return enregistrer;
	}

	/**
	 * @param enregistrer
	 *            the enregistrer to set
	 */
	public void setEnregistrer(JButton enregistrer)
	{
		this.enregistrer = enregistrer;
	}

	/**
	 * @return the enregistrerSous
	 */
	public JButton getEnregistrerSous()
	{
		return enregistrerSous;
	}

	/**
	 * @param enregistrerSous
	 *            the enregistrerSous to set
	 */
	public void setEnregistrerSous(JButton enregistrerSous)
	{
		this.enregistrerSous = enregistrerSous;
	}

	/**
	 * @return the imprimer
	 */
	public JButton getImprimer()
	{
		return imprimer;
	}

	/**
	 * @param imprimer
	 *            the imprimer to set
	 */
	public void setImprimer(JButton imprimer)
	{
		this.imprimer = imprimer;
	}
}
