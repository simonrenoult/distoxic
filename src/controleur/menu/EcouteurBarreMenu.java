package controleur.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import modele.TripletFichier;
import vue.FenetreAPropos;
import vue.FenetreExportationTripletFichier;
import vue.FenetreImportationTripletFichier;
import vue.FenetrePrincipale;
import vue.menus.BarreMenu;
import vue.menus.MenuAPropos;
import vue.menus.MenuFichier;

public class EcouteurBarreMenu implements ActionListener
{
	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //
	
	private FenetrePrincipale	fenetrePrincipale;

	private BarreMenu			bm;
	private MenuFichier			mf;
	private MenuAPropos			ma;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	public EcouteurBarreMenu(FenetrePrincipale fenetrePrincipale)
	{
		this.fenetrePrincipale = fenetrePrincipale;
		this.bm = fenetrePrincipale.getMenu();
		
		initListenersMenuFichier();
		initListenersMenuAPropos();
	}

	// ----------------------------------------- //
	// ------------ INITIALISEURS -------------- //
	// ----------------------------------------- //
	
	private void initListenersMenuFichier()
	{
		mf = (MenuFichier) bm.getMenuFichier();
		mf.getNouveau().addActionListener(this);
		mf.getOuvrir().addActionListener(this);
		mf.getEnregistrer().addActionListener(this);
		mf.getEnregistrerSous().addActionListener(this);
		mf.getImporter().addActionListener(this);
		mf.getExporter().addActionListener(this);
		mf.getQuitter().addActionListener(this);
	}
	
	private void initListenersMenuAPropos()
	{
		ma = (MenuAPropos) bm.getMenuAPropos();
		ma.getAide().addActionListener(this);
		ma.getAPropos().addActionListener(this);
	}
	
	private void lancerMessageErreur(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == mf.getNouveau())
		{
			
		}
		else if (e.getSource() == mf.getOuvrir())
		{

		}
		else if (e.getSource() == mf.getEnregistrer())
		{

		}
		else if (e.getSource() == mf.getEnregistrerSous())
		{

		}
		else if (e.getSource() == mf.getImporter())
		{
			@SuppressWarnings("unused")
			FenetreImportationTripletFichier fenetreImportation = new FenetreImportationTripletFichier(
					fenetrePrincipale);
		}
		else if (e.getSource() == mf.getExporter())
		{

			try
			{
				String dossier = fenetrePrincipale.getConteneurGlobal().getNavigateur().getTree().getSelectionPath()
						.toString();
				dossier = dossier.substring(3, dossier.length() - 1);
				@SuppressWarnings("unused")
				FenetreExportationTripletFichier f = new FenetreExportationTripletFichier(fenetrePrincipale, dossier);
			}
			catch (NullPointerException eo)
			{
				lancerMessageErreur("Veuillez selectionner un projet avant de l'exporter");
			}

		}
		else if (e.getSource() == mf.getQuitter())
		{
			System.exit(0);
		}
		else if(e.getSource() == ma.getAPropos())
		{
			FenetreAPropos f = new FenetreAPropos();
		}
	}

}
