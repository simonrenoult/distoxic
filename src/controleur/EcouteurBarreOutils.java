package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToolBar;

import vue.FenetreImportationTripletFichier;
import vue.FenetrePrincipale;
import vue.barreOutils.BarreOutils;

public class EcouteurBarreOutils implements ActionListener
{
	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private BarreOutils panel;
	private FenetrePrincipale fenetrePrincipale;
	private FenetreImportationTripletFichier fenetreImportation;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //
	public EcouteurBarreOutils(FenetrePrincipale fenetrePrincipale)
	{
		this(fenetrePrincipale.getBarreOutils());
		this.fenetrePrincipale = fenetrePrincipale;
		
	}
	
	public EcouteurBarreOutils(BarreOutils bo)
	{
		panel = bo;
		panel.getNouveau().addActionListener(this);
		panel.getEnregistrer().addActionListener(this);
		panel.getEnregistrerSous().addActionListener(this);
		panel.getImprimer().addActionListener(this);
	}

	// ----------------------------------------- //
	// ---------------- LISTENERS -------------- //
	// ----------------------------------------- //

	// ------- ACTION ------- //

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //

	
	// ----------------------------------------- //
	// --------------- MUTATEURS --------------- //
	// ----------------------------------------- //

}
