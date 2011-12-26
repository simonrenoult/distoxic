package src.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.vue.editeurs.ConteneurEditeurs;

public class EcouteurEnteteOnglet implements ActionListener {

	
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
			ce.getEnteteEditeurs().get(i).getButton().addActionListener(this);
		}
	}
// ----------------------------------------- //
// -------------INITIALISEURS--------------- //
// ----------------------------------------- //
	/**
	 * Methode retournant l'etat actuel des 3 JTable pour savoir si on doit enregistrer les modifications avant de supprimer l'onglet.
	 * @return
	 */
	private boolean isEnregistrable() {
		//TODO  Determiner l'etat d'enregistrement de chaque Jtable  grace à un booleen
		return false;
	}
	
	/**
	 * Methode permattant d'ajouter des onglets a ecouter sans redeclarer un EcouteurEnteteOnglet.
	 * @param ce
	 */
	public void rafraichir(ConteneurEditeurs ce){
		
		this.ce =ce;
		for(int i = 0; i< ce.getEnteteEditeurs().size(); i++){
			ce.getEnteteEditeurs().get(i).getButton().addActionListener(this);
		}
		
	}
// ----------------------------------------- //
// -----------------METHODES---------------- //
// ----------------------------------------- //
	@SuppressWarnings("deprecation")
	@Override
	/**
	 * Methode permettant de capter les evenements de type ActionEvent sur l'entete de chaque onglet.
	 * @param e evenement d'un objet graphique (JButton) provenant d'un onglet graphique.
	 */
	public void actionPerformed(ActionEvent e) {
		try{
			int i = 0;
			//FIXME ce.countComponents()-1 -> enlever le -1 genere une exception !
			while(i < ce.countComponents()-1){
				if((e.getSource() == ce.getEnteteEditeurs().get(i).getButton())&&
							(!isEnregistrable())){
						//System.out.println("i :"+i);
						ce.remove(i);
						ce.getEditeurs().remove(i);
						ce.getEnteteEditeurs().remove(i);
						//System.out.println("taille liste : "+ce.countComponents());
				}
				i++;
			}
		}
		catch(Exception eo ){}
		
	}
	
// ----------------------------------------- //
// ---------------ACCESSEURS---------------- //
// ----------------------------------------- //

	

// ----------------------------------------- //
// ----------------MUTATEURS---------------- //
// ----------------------------------------- //
}
