package src.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

import src.controleur.EcouteurFenetreAPropos;


@SuppressWarnings("serial")
public class FenetreAPropos extends JWindow
{
	/**
	 * <h4>FenetreAPropos est la classe permettant de decrire la fenetre d'information du fichier.</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	/**
	 * Constantes de classe
	 */
	private final static String		_ICON_PATH		= "/images/icones/";

	private final static Color		COULEUR_BORDURE	= Color.BLACK;

	private final static String		VERSION			= "v0.9";
	private final static String		REVISON			= "4b59ee2079";
	private final static Dimension	dimension		= new Dimension(420, 320);

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private FenetrePrincipale		fenetrePrincipale;

	private JButton					fermer;
	private JEditorPane				lienSite;
	private JEditorPane				lienSources;

	private EcouteurFenetreAPropos	ecouteur;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	/**
	 * Constructeur principal de la classe FenetreAPropos
	 * @param fp la fenetre principale du programme.
	 * 
	 */
	public FenetreAPropos(FenetrePrincipale fp)
	{
		setFenetrePrincipale(fp);

		this.setSize(dimension);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		initComponenent();
		ecouteur = new EcouteurFenetreAPropos(fenetrePrincipale, this);
	}

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //
	/**
	 * Methode d'initialisation du conteneur principal a la fenetre A propos
	 */
	private void initComponenent()
	{
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		container.setBorder(BorderFactory.createLineBorder(COULEUR_BORDURE));

		container.add(top(), BorderLayout.CENTER);
		container.add(bottom(), BorderLayout.PAGE_END);

		getContentPane().add(container);
	}

	/**
	 * Methode de creation du panneau d'information du haut
	 * @return le panneau d'information
	 */
	private JPanel top()
	{
		JLabel logo = new JLabel(new ImageIcon(getClass().getResource(_ICON_PATH + "logo_150.png")));
		logo.setVerticalAlignment(JLabel.NORTH);
		logo.setHorizontalAlignment(JLabel.CENTER);
		logo.setBackground(Color.WHITE);

		JEditorPane auteurs = new JEditorPane("text/html", "<html>" + "<h3>" + "Auteurs :" + "</h3>"
				+ " Alexis CHRETIENNE<br />" + " Simon RENOULT" + "</html>");

		lienSite = new JEditorPane("text/html", "<html>" + "<h3>"
				+ "<a href=\"http://distoxic.github.com/distoxic/\">Page Web</a>" + "</h3>" + "</html>");
		lienSite.setEditable(false);

		lienSources = new JEditorPane("text/html", "<html>" + "<h3>"
				+ "<a href=\"https://github.com/distoxic/distoxic\">Sources</a>" + "</h3>" + "</html>");
		lienSources.setEditable(false);

		JPanel top_left = new JPanel();
		top_left.add(logo);
		top_left.setBackground(Color.WHITE);

		JPanel top_right = new JPanel(new BorderLayout());
		top_right.add(auteurs, BorderLayout.PAGE_START);
		top_right.add(lienSite, BorderLayout.CENTER);
		top_right.add(lienSources, BorderLayout.PAGE_END);

		JPanel top_top = new JPanel(new GridLayout(1, 3));

		top_top.add(top_left);
		top_top.add(top_right);
		top_top.setBackground(Color.WHITE);

		JPanel top = new JPanel(new BorderLayout());
		top.setBackground(Color.WHITE);

		JEditorPane infos = new JEditorPane("text/html", "<html>" + "<p style=\"text-align : justify\">"
				+ "Dis'Toxic (Display Toxicities) est un logiciel d'affichage "
				+ "et d'édition de fichiers contenant des fragments "
				+ "moléculaires dont un certain nombre représente " + "des fragments catalyseurs de toxicités."
				+ "</p>" + "</html>"

		);

		top.add(top_top, BorderLayout.NORTH);
		top.add(infos, BorderLayout.CENTER);

		return top;
	}

	/**
	 * Methode de creation du panneau d'information du bas
	 * @return le panneau d'information
	 */
	private JPanel bottom()
	{
		JLabel revision = new JLabel("Revision " + REVISON);
		revision.setForeground(Color.GRAY);
		JLabel version = new JLabel("Dis'Toxic " + VERSION);
		version.setForeground(Color.GRAY);
		fermer = new JButton("Fermer");

		JPanel bottom_left = new JPanel(new FlowLayout());
		bottom_left.setBackground(Color.WHITE);
		bottom_left.add(version);

		JPanel bottom_center = new JPanel();
		bottom_center.setBackground(Color.WHITE);
		bottom_center.add(revision);

		JPanel bottom_right = new JPanel(new FlowLayout());
		bottom_right.setBackground(Color.WHITE);
		bottom_right.add(fermer);

		JPanel bottom = new JPanel(new GridLayout(1, 3));
		bottom.setBackground(Color.WHITE);

		bottom.add(bottom_left);
		bottom.add(bottom_center);
		bottom.add(bottom_right);

		return bottom;
	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //

	public JButton getFermer()
	{
		return fermer;
	}

	public void setFermer(JButton fermer)
	{
		this.fermer = fermer;
	}

	public FenetrePrincipale getFenetrePrincipale()
	{
		return fenetrePrincipale;
	}

	public void setFenetrePrincipale(FenetrePrincipale fenetrePrincipale)
	{
		this.fenetrePrincipale = fenetrePrincipale;
	}

	public EcouteurFenetreAPropos getEcouteur()
	{
		return ecouteur;
	}

	public void setEcouteur(EcouteurFenetreAPropos ecouteur)
	{
		this.ecouteur = ecouteur;
	}

	public JEditorPane getLienSite()
	{
		return lienSite;
	}

	public JEditorPane getLienSources()
	{
		return lienSources;
	}

	public void setLienSite(JEditorPane lienSite)
	{
		this.lienSite = lienSite;
	}

	public void setLienSources(JEditorPane lienSources)
	{
		this.lienSources = lienSources;
	}
}
