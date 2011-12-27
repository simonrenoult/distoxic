package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import vue.editeurs.ConteneurEditeurs;

public class EcouteurEnteteOnglet implements ActionListener, ChangeListener
{
=======
import src.vue.editeurs.ConteneurEditeurs;

public class EcouteurEnteteOnglet implements ActionListener {
>>>>>>> dfd55cdf890d2f9d3f0f3afa24db2dc76914d931

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
<<<<<<< HEAD
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
=======
/**
 * <h4>EcouteurEnteteOnglet est la classe qui represente l'ecouteur de la classe EnteteOnglet. Il gere la suppression d'onglet.</h4>
 * <p>
 * Cette classe contient : 
 * <ul>
 * <li>Une instance de classe ConteneurEditeurs, representant l'ensemble des onglets graphiques du programme.</li>
 * </ul>
 * </p>
 * 
 * @see ConteneurEditeurs
 * 
 * @author Alexis CHRETIENNE & Simon RENOULT
 */
// ----------------------------------------- //
// ----------------ATRIBUTS----------------- //
// ----------------------------------------- //
	/**
	 * ConteneurEditeurs represente la stucture accueillant les onglets graphiques. Il contient une liste d'onglet.
	 */
	private ConteneurEditeurs	ce;
// ----------------------------------------- //
// --------------CONSTRUCTEURS-------------- //
// ----------------------------------------- //
	/**
	 * Constructeur prinicpal de la classe EcouteurEnteteOnglet.
	 * @param ce la structure graphique acceuillant l'ensemble des onglets à ecouter.
	 */
	public EcouteurEnteteOnglet(ConteneurEditeurs ce){
		this.ce = ce;
		for(int i = 0; i< ce.getEnteteEditeurs().size(); i++){
>>>>>>> dfd55cdf890d2f9d3f0f3afa24db2dc76914d931
			ce.getEnteteEditeurs().get(i).getButton().addActionListener(this);
		}
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	/**
<<<<<<< HEAD
	 * Retourne l'etat actuel des 3 JTable pour savoir si on doit enregistrer
	 * les modifications avant de supprimer l'onglet.
	 * 
=======
	 * Methode retournant l'etat actuel des 3 JTable pour savoir si on doit enregistrer les modifications avant de supprimer l'onglet.
>>>>>>> dfd55cdf890d2f9d3f0f3afa24db2dc76914d931
	 * @return
	 */
	private boolean isEnregistrable()
	{
		// TODO Determiner l'etat d'enregistrement de chaque Jtable grace à un
		// booleen
		return false;
	}
<<<<<<< HEAD

	public void rafraichir(ConteneurEditeurs ce)
	{

		this.ce = ce;
		for (int i = 0 ; i < ce.getEnteteEditeurs().size() ; i++)
		{
=======
	
	/**
	 * Methode permattant d'ajouter des onglets a ecouter sans redeclarer un EcouteurEnteteOnglet.
	 * @param ce
	 */
	public void rafraichir(ConteneurEditeurs ce){
		
		this.ce =ce;
		for(int i = 0; i< ce.getEnteteEditeurs().size(); i++){
>>>>>>> dfd55cdf890d2f9d3f0f3afa24db2dc76914d931
			ce.getEnteteEditeurs().get(i).getButton().addActionListener(this);
		}

	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	@SuppressWarnings("deprecation")
	@Override
<<<<<<< HEAD
	public void actionPerformed(ActionEvent e)
	{
		try
		{
=======
	/**
	 * Methode permettant de capter les evenements de type ActionEvent sur l'entete de chaque onglet.
	 * @param e evenement d'un objet graphique (JButton) provenant d'un onglet graphique.
	 */
	public void actionPerformed(ActionEvent e) {
		try{
>>>>>>> dfd55cdf890d2f9d3f0f3afa24db2dc76914d931
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
<<<<<<< HEAD

	@Override
	public void stateChanged(ChangeEvent arg0)
	{
		// TODO Auto-generated method stub
=======
	
// ----------------------------------------- //
// ---------------ACCESSEURS---------------- //
// ----------------------------------------- //
>>>>>>> dfd55cdf890d2f9d3f0f3afa24db2dc76914d931

	}
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
