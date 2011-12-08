package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import vue.editeurs.ConteneurEditeurs;
import vue.menus.BarreMenu;

public class EcouteurBarreMenu implements ActionListener,ChangeListener
{
	// ---------------------------------//
	// ------------ATRIBUTS-------------//
	// ---------------------------------//

	private BarreMenu			mt;
	private ConteneurEditeurs	ce;
	
	// ---------------------------------//
	// ----------CONSTRUCTEURS----------//
	// ---------------------------------//

	public EcouteurBarreMenu()
	{

	}

	public EcouteurBarreMenu(BarreMenu mt)
	{
		this.mt = mt;
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
