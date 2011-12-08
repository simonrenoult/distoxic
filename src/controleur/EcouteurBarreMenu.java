package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.editeurs.ConteneurEditeurs;
import vue.menus.BarreMenu;

public class EcouteurBarreMenu implements ActionListener
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
	}

	// ---------------------------------//
	// ----------INITIALISEURS----------//
	// ---------------------------------//

	// ---------------------------------//
	// -------------METHODES------------//
	// ---------------------------------//

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}

	// ---------------------------------//
	// -----------ACCESSEURS------------//
	// ---------------------------------//

	// ---------------------------------//
	// ------------MUTATEURS------------//
	// ---------------------------------//

}
