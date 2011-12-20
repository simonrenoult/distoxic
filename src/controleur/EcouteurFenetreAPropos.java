package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.FenetreAPropos;
import vue.FenetrePrincipale;

public class EcouteurFenetreAPropos implements ActionListener
{

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private FenetrePrincipale	fenetrePrincipale;
	private FenetreAPropos		fenetreAPropos;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	public EcouteurFenetreAPropos(FenetrePrincipale fp, FenetreAPropos fap)
	{
		fenetreAPropos = fap;
		fenetrePrincipale = fp;
		
		fenetreAPropos.getFermer().addActionListener(this);
	}
	
	// ----------------------------------------- //
	// ---------------- LISTENERS -------------- //
	// ----------------------------------------- //

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == fenetreAPropos.getFermer())
		{
			fenetreAPropos.dispose();
			fenetrePrincipale.setEnabled(true);
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
