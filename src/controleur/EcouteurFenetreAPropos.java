package src.controleur;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import src.vue.FenetreAPropos;
import src.vue.FenetrePrincipale;

public class EcouteurFenetreAPropos implements ActionListener, HyperlinkListener
{
	/**
	 * <h4>EcouteurFenetreAPropos est la classe qui represente l'ecouteur de la classe FenetreAPropos</h4>
	 * <p>
	 * Cette classe contient : 
	 * <ul>
	 * <li>Une instance de classe FenetrePrincipale, representant la fenetre principal du programme.</li>
	 * <li>Une instance de classe  FenetreAPropos, representant la fenetre d'information utile a l'utilisateur.</li>
	 *</ul>
	 * </p>
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	/**
	 * Objet graphique representant la fenetre principale.
	 * @see FenetrePrincipale
	 */
	private FenetrePrincipale	fenetrePrincipale;
	/**
	 * Objet graphique representant la fenetre d'information du programme.
	 * @see fenetreAPropos
	 */
	private FenetreAPropos		fenetreAPropos;

	/**
	 * Des liens internet ont insere. Changement graphique du type de curseur.
	 */
	private Cursor				main	= new Cursor(Cursor.HAND_CURSOR);
	private Cursor				defaut	= new Cursor(Cursor.DEFAULT_CURSOR);

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe EcouteurFenetreAPropos.
	 * @param fp la fenetre principale
	 * @param fap la fenetre d'information
	 */
	public EcouteurFenetreAPropos(FenetrePrincipale fp, FenetreAPropos fap)
	{
		fenetreAPropos = fap;
		fenetrePrincipale = fp;

		fenetreAPropos.getFermer().addActionListener(this);
		fenetreAPropos.getLienSite().addHyperlinkListener(this);
		fenetreAPropos.getLienSources().addHyperlinkListener(this);
	}

	// ----------------------------------------- //
	// ---------------- LISTENERS -------------- //
	// ----------------------------------------- //

	@Override
	/**
	 * Methode permettant de capter les evenements de type ActionEvent sur la fenetre a propos.
	 * @param e evenement d'un objet graphique provenant de la fenetre a propos.
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == fenetreAPropos.getFermer())
		{
			fenetreAPropos.dispose();
			fenetrePrincipale.setEnabled(true);
		}
	}

	@Override
	/**
	 * Methode permettant de capter les evenements de type HyperlinkEvent sur la fenetre a propos.
	 * @param e evenement d'un lien graphique provenant de la fenetre a propos.
	 */
	public void hyperlinkUpdate(HyperlinkEvent e)
	{
		if (e.getEventType() == HyperlinkEvent.EventType.ENTERED)
		{
			fenetreAPropos.setCursor(main);
		}
		else
		{
			fenetreAPropos.setCursor(defaut);
		}

		if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
		{
			Desktop d = Desktop.getDesktop();
			try
			{
				d.browse(e.getURL().toURI());
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
			catch (URISyntaxException e1)
			{
				e1.printStackTrace();
			}
		}

	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //

	public FenetreAPropos getFenetreAPropos()
	{
		return fenetreAPropos;
	}

	public void setFenetreAPropos(FenetreAPropos fenetreAPropos)
	{
		this.fenetreAPropos = fenetreAPropos;
	}

	// ----------------------------------------- //
	// --------------- MUTATEURS --------------- //
	// ----------------------------------------- //

	public FenetrePrincipale getFenetrePrincipale()
	{
		return fenetrePrincipale;
	}

	public void setFenetrePrincipale(FenetrePrincipale fenetrePrincipale)
	{
		this.fenetrePrincipale = fenetrePrincipale;
	}

}
