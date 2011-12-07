package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToolBar;

import vue.FenetreImportationTripletFichier;
import vue.barreOutils.BarreOutils;

public class EcouteurBarreOutils implements ActionListener
{
	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private BarreOutils panel;
	private FenetreImportationTripletFichier fenetreImportation;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	public EcouteurBarreOutils(BarreOutils f){
		panel = f;
		panel.getNouveau().addActionListener(this);
		panel.getImporter().addActionListener(this);
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
		if(e.getSource() == panel.getImporter()){
			fenetreImportation = new FenetreImportationTripletFichier();
		}
	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //

	
	// ----------------------------------------- //
	// --------------- MUTATEURS --------------- //
	// ----------------------------------------- //

}
