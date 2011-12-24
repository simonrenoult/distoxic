package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import vue.editeurs.ConteneurEditeurs;

public class EcouteurEnteteOnglet implements ActionListener, ChangeListener
{

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	private ConteneurEditeurs	ce;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	
	public EcouteurEnteteOnglet(ConteneurEditeurs ce)
	{
		this.ce = ce;
		ce.addChangeListener(this);
		for (int i = 0 ; i < ce.getEnteteEditeurs().size() ; i++)
		{
			ce.getEnteteEditeurs().get(i).getButton().addActionListener(this);
		}
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	/**
	 * Retourne l'etat actuel des 3 JTable pour savoir si on doit enregistrer
	 * les modifications avant de supprimer l'onglet.
	 * 
	 * @return
	 */
	private boolean isEnregistrable()
	{
		// TODO Determiner l'etat d'enregistrement de chaque Jtable grace à un
		// booleen
		return false;
	}

	public void rafraichir(ConteneurEditeurs ce)
	{

		this.ce = ce;
		for (int i = 0 ; i < ce.getEnteteEditeurs().size() ; i++)
		{
			ce.getEnteteEditeurs().get(i).getButton().addActionListener(this);
		}

	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			int i = 0;
			// FIXME ce.countComponents()-1 -> enlever le -1 genere une
			// exception !
			while (i < ce.countComponents() - 1)
			{
				if ((e.getSource() == ce.getEnteteEditeurs().get(i).getButton()) && (!isEnregistrable()))
				{
					// System.out.println("i :"+i);
					ce.remove(i);
					ce.getEditeurs().remove(i);
					ce.getEnteteEditeurs().remove(i);
					// System.out.println("taille liste : "+ce.countComponents());
				}
				i++;
			}
		}
		catch (Exception eo)
		{
		}

	}

	@Override
	public void stateChanged(ChangeEvent arg0)
	{
		// TODO Auto-generated method stub

	}
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
