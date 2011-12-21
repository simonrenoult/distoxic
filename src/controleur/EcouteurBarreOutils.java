package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vue.FenetreExportationTripletFichier;
import vue.FenetreImportationTripletFichier;
import vue.FenetrePrincipale;
import vue.barreOutils.BarreOutils;

public class EcouteurBarreOutils implements ActionListener
{
	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private BarreOutils							panel;
	private FenetrePrincipale					fenetrePrincipale;
	@SuppressWarnings("unused")
	private FenetreImportationTripletFichier	fenetreImportation;
	@SuppressWarnings("unused")
	private FenetreExportationTripletFichier	fenetreExportation;

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
		panel.getImporter().addActionListener(this);
		panel.getExporter().addActionListener(this);
		panel.getRafraichir().addActionListener(this);
		panel.getEnregistrerSousTriplet().addActionListener(this);
		panel.getEnregistrerSous().addActionListener(this);
		//panel.getImprimer().addActionListener(this);
	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	private void LancerMessageErreur(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	// ----------------------------------------- //
	// ---------------- LISTENERS -------------- //
	// ----------------------------------------- //

	// ------- ACTION ------- //

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == panel.getNouveau())
		{

		}
		else if (e.getSource() == panel.getImporter())
		{
			fenetreImportation = new FenetreImportationTripletFichier(fenetrePrincipale);
		}
		else if (e.getSource() == panel.getExporter())
		{
			try
			{
				String dossier = fenetrePrincipale.getConteneurGlobal().getNavigateur().getTree().getSelectionPath()
						.toString();
				dossier = dossier.substring(3, dossier.length() - 1);
				fenetreExportation = new FenetreExportationTripletFichier(fenetrePrincipale, dossier);
			}
			catch (NullPointerException eo)
			{
				LancerMessageErreur("Veuillez selectionner un projet avant de l'exporter");
			}
		}
		else if (e.getSource() == panel.getRafraichir())
		{
			this.fenetrePrincipale.getConteneurGlobal().buildNavigateur();
			this.fenetrePrincipale.getConteneurGlobal().intiPositionConteneurGlobal();
		}
		else if (e.getSource() == panel.getEnregistrerSousTriplet())
		{
			int index = fenetrePrincipale.getConteneurGlobal().getEditeur().getSelectedIndex();
			System.out.println("Onglet : "+index);
			System.out.println("Enregistrement de :");
			System.out.println(fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdBin().getBinFile().getFilePath());
			System.out.println(fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdGph().getGphFile().getFilePath());
			System.out.println(fenetrePrincipale.getConteneurGlobal().getEditeur().getEditeurs().get(index).getEdSdf().getSdfFile().getFilePath());
		}
		else if (e.getSource() == panel.getEnregistrerSous())
		{
			int index = fenetrePrincipale.getConteneurGlobal().getEditeur().getSelectedIndex();
			System.out.println("Onglet : "+index);
			System.out.println("panel BIN encadré : "+fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdBin().getBinFile().isFlank());
			System.out.println("panel GPH encadré : "+fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdGph().getGphFile().isFlank());
			System.out.println("panel DSF encadré : "+fenetrePrincipale.getConteneurGlobal().getEditeur().
					getEditeurs().get(index).getEdSdf().getSdfFile().isFlank());
		}
		/*else if (e.getSource() == panel.getImprimer())
		{

		}*/

	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// --------------- MUTATEURS --------------- //
	// ----------------------------------------- //

}
