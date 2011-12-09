package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
	private ConteneurEditeurs	ce;
	
	
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

	public EcouteurBarreMenu(ConteneurEditeurs ce)
	{
		this.ce = ce;
		ce.addChangeListener(this);
		for(int i = 0; i< ce.getEnteteEditeurs().size(); i++){
			ce.getEnteteEditeurs().get(i).getButton().addActionListener(this);
		}
		
	}
	
	// ---------------------------------//
	// ----------INITIALISEURS----------//
	// ---------------------------------//
	/**
	 * Retourne l'etat actuel des 3 JTable pour savoir si on doit enregistrer les modifications avant de supprimer l'onglet.
	 * @return
	 */
	private boolean isEnregistrable() {
		//TODO  Determiner l'etat d'enregistrement de chaque Jtable  grace à un booleen
		return false;
	}
	// ---------------------------------//
	// -------------METHODES------------//
	// ---------------------------------//

	public void raffraichir(ConteneurEditeurs ce){
		
		this.ce =ce;
		for(int i = 0; i< ce.getEnteteEditeurs().size(); i++){
			ce.getEnteteEditeurs().get(i).getButton().addActionListener(this);
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try{
			int i = 0;
			//FIXME ce.countComponents()-1 -> enlever le -1 genere une exception !
			while(i < ce.countComponents()-1){
				if((e.getSource() == ce.getEnteteEditeurs().get(i).getButton())&&
							(!isEnregistrable())){
						System.out.println("i :"+i);
						ce.remove(i);
						ce.getEditeurs().remove(i);
						ce.getEnteteEditeurs().remove(i);
						System.out.println("taille liste : "+ce.countComponents());
				}
				i++;
			}
		}
		catch(Exception eo ){}
		
		
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
