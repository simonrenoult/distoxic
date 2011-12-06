package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;

public class EcouteurBarreOutils implements ActionListener
{
	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private JToolBar	toolbar;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	public EcouteurBarreOutils(JToolBar t)
	{
		setToolbar(t);
	}

	// ----------------------------------------- //
	// ---------------- LISTENERS -------------- //
	// ----------------------------------------- //

	// ------- ACTION ------- //

	@Override
	public void actionPerformed(ActionEvent arg0)
	{

	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //

	public JToolBar getToolbar()
	{
		return toolbar;
	}

	// ----------------------------------------- //
	// --------------- MUTATEURS --------------- //
	// ----------------------------------------- //

	public void setToolbar(JToolBar toolbar)
	{
		this.toolbar = toolbar;
	}

}
