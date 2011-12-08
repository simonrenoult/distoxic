/*
 * Panneau contenant les onglets.
 * Ces derniers incluent chacun trois ï¿½diteurs associï¿½s ï¿½ un type de fichier prï¿½dï¿½fini :
 *				- SDF ;
 *				- GPH ;
 *				- BIN ;
 */
package vue.editeurs;

import java.awt.Dimension;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JTabbedPane;

import modele.TripletFichier;
import controleur.EcouteurBarreMenu;
import vue.ConteneurGlobal;

@SuppressWarnings("serial")
public class ConteneurEditeurs extends JTabbedPane
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer	TAILLE_X		= 4 * ConteneurGlobal.TAILLE_X / 5;
	public final static Integer	TAILLE_Y		= ConteneurGlobal.TAILLE_Y;

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private LinkedList<Editeurs>			editeurs;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public ConteneurEditeurs()
	{
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));

				
		/*editeurs = new  LinkedList<Editeurs>();
		String BINPath = "C:\\Users\\alex\\Documents\\DisToxicProjects\\exemple_39_45\\exemple_39_45.bin";
		String GPHPath = "C:\\Users\\alex\\Documents\\DisToxicProjects\\exemple_39_45\\exemple_39.gph";
		TripletFichier t = new TripletFichier(BINPath,GPHPath);
		addEditeur(t);
		*/
		
		/*BINPath = "C:\\Users\\alex\\Documents\\DisToxicProjects\\exemple_70_34\\exemple_70_34.bin";
		//GPHPath = "C:\\Users\\alex\\Documents\\DisToxicProjects\\exemple_39_45\\exemple_39.gph";
		TripletFichier t1 = new TripletFichier(BINPath);
		addEditeur(t1);
			*/	
		initListeners();
	}

	// ----------------------------------------- //
	// ----------------LISTENERS---------------- //
	// ----------------------------------------- //

	private void initListeners()
	{
		@SuppressWarnings("unused")
		EcouteurBarreMenu emt = new EcouteurBarreMenu(this);
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	/**
	 * On créé un nouvel onglet.
	 * On envoi un triplet un objet de tripletFichier afin que chaque JPANEL descendant constuise sa JTable.
	 * On ajoute l'onglet créé aux tableaux d'onglet et on ajoute ce dernier onglet au graphique.
	 * @param tripletFichier
	 */
		public void addEditeur(TripletFichier tripletFichier){
			Editeurs editeur = new Editeurs(tripletFichier);
			editeurs.add(editeur);
			this.add(editeurs.getLast());
			buildPaneHead(tripletFichier,editeurs.size()-1);
			
		}
		
		/**
		 * Permet de creer l'entete de l'onglet. 
		 * @param tripletFichier
		 * @param indiceOnglet
		 */
		private void buildPaneHead(TripletFichier tripletFichier,int indiceOnglet){
			this.setTabComponentAt(indiceOnglet, new EnteteOnglet(nomEditeur(tripletFichier)));
			}
		
		/**
		 * Creation du nom de l'onglet : nom du dossier contenant les fichiers.
		 * @param path
		 * @return
		 */
		public String nomEditeur(TripletFichier tripletFichier){
			
			if (System.getProperty("os.name").toLowerCase().contains("linux") ||
					(System.getProperty("os.name").toLowerCase().contains("mac"))){
				String tab[] = tripletFichier.getDirectoryPath().split(File.separator);
				String projetcsName = tab[tab.length-2];
				return projetcsName;
			}
			else if (System.getProperty("os.name").toLowerCase().contains("windows")){
				// Il faut echeper le caractere \ !
				String tab[] = tripletFichier.getDirectoryPath().split(File.separator+File.separator);
				String projetcsName = tab[tab.length-2];
				return projetcsName;
			}
			
			return "";
		
			
		}
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //


	

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

	

	
}