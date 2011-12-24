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

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private FenetrePrincipale	fenetrePrincipale;
	private FenetreAPropos		fenetreAPropos;

	private Cursor				main	= new Cursor(Cursor.HAND_CURSOR);
	private Cursor				defaut	= new Cursor(Cursor.DEFAULT_CURSOR);

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

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
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == fenetreAPropos.getFermer())
		{
			fenetreAPropos.dispose();
			fenetrePrincipale.setEnabled(true);
		}
	}

	@Override
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
