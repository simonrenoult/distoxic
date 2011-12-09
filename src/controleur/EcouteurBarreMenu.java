package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import modele.WorkspaceModele;

import vue.FenetreExportationTripletFichier;
import vue.FenetreImportationTripletFichier;
import vue.FenetrePrincipale;
import vue.editeurs.ConteneurEditeurs;
import vue.editeurs.EnteteOnglet;
import vue.menus.BarreMenu;
import vue.menus.MenuFichier;

public class EcouteurBarreMenu implements ActionListener,ChangeListener
{
	// ---------------------------------//
	// ------------ATRIBUTS-------------//
	// ---------------------------------//
	private FenetreImportationTripletFichier fenetreImportation ;
	private FenetrePrincipale fenetrePrincipale;
	private MenuFichier mf;
	private BarreMenu			mt;
	
	
	// ---------------------------------//
	// ----------CONSTRUCTEURS----------//
	// ---------------------------------//

	public EcouteurBarreMenu()
	{

	}

	public EcouteurBarreMenu(FenetrePrincipale fenetrePrincipale)
	{
		this.fenetrePrincipale = fenetrePrincipale;
		this.mt = fenetrePrincipale.getMenu();
		mf = (MenuFichier) mt.getMenuFichier();
		mf.getNouveau().addActionListener(this);
		mf.getOuvrir().addActionListener(this);
		mf.getEnregistrer().addActionListener(this);
		mf.getEnregistrerSous().addActionListener(this);
		mf.getImporter().addActionListener(this);
		mf.getExporter().addActionListener(this);
		mf.getQuitter().addActionListener(this);
	}
	
	// ---------------------------------//
	// ----------INITIALISEURS----------//
	// ---------------------------------//
	private void LancerMessageErreur(String message){
		JOptionPane.showMessageDialog(null,message
				, "Erreur",JOptionPane.ERROR_MESSAGE);
	}
	// ---------------------------------//
	// -------------METHODES------------//
	// ---------------------------------//

	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == mf.getNouveau()){
			
		}
		else if (e.getSource() == mf.getOuvrir()){
			
		}
		else if(e.getSource() == mf.getEnregistrer()) {
			
		}
		else if (e.getSource() == mf.getEnregistrerSous()){
			
		}
		else if(e.getSource() == mf.getImporter()) {
			fenetreImportation = new FenetreImportationTripletFichier(fenetrePrincipale);
		}
		else if (e.getSource() == mf.getExporter()){
			
			try{
				String dossier = fenetrePrincipale.getConteneurGlobal().getNavigateur().
						getTree().getSelectionPath().toString();
				//System.out.println("dossier : "+dossier );
				dossier = dossier.substring(3, dossier.length()-1);
				//System.out.println("dossier : "+dossier );
				FenetreExportationTripletFichier f = new FenetreExportationTripletFichier(fenetrePrincipale,dossier);
				
			}
			catch(NullPointerException eo){
				 LancerMessageErreur("Veuillez selectionner un projet avant de l'exporter");
			}
			
		}
		else if (e.getSource() == mf.getQuitter()){
			System.exit(0);
		}
	}

	

	@Override
	public void stateChanged(ChangeEvent e) {
		
		
	}

	// ---------------------------------//
	// -----------ACCESSEURS------------//
	// ---------------------------------//

	// ---------------------------------//
	// ------------MUTATEURS------------//
	// ---------------------------------//

}
