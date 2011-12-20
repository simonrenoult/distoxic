package modele.enregistreur;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import modele.composantsChimiques.FragmentMolecule;

public class EnregistreurGPH implements EnregistreurGenerique
{
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * Declaration des constantes permettant de parser le fichier. ----DEBUT
	 * FRAGMENT ----- t # 0 & -1 * 10 @ 0.0429 % 3 v 0 206 v 1 7 e 0 1 1
	 * 
	 * ----FIN FRAGMENT -------
	 */

	private final static String				_SEPARATION_CHAMP		= " ";
	private final static String				_VERTEX					= "v";
	private final static String				_EDGE					= "e";
	private final static String				_MARQUEUR_DEBUT			= "t";
	private final static String				_NUMERO_GRAPHE			= "#";
	private final static String				_CLASSE_GRAPHE			= "&";
	private final static String				_FREQUENCE_GRAPHE		= "*";
	private final static String				_VALEUR_TOXICITE_GRAPHE	= "@";
	private final static String				_EMERGENCE_GRAPHE		= "%";

	@SuppressWarnings("unused")
	private static String					_SEPARATION_FRAGMENT	= " ";
	
	/**
	 * Indice de l'objet FragmentMoleculaire sur lequel on travail.
	 */
	private ArrayList<FragmentMolecule>	listeGPH				= null;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	public EnregistreurGPH(){
		
	}
	
	public EnregistreurGPH(ArrayList<FragmentMolecule> liste, String path){
		listeGPH = liste;
		ecrireFichier(path);
		
	}
	
	public EnregistreurGPH(ArrayList<FragmentMolecule> liste){
		listeGPH = liste;
		
	}
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

	/**
	 * Methode principale d'ecriture sur fichier GPH. Chaque fragment est decomposable en partie :
	 * l'entete, la description des atomes et la description des liaisons.
	 * @param path
	 * @return
	 */
	@Override
	public boolean ecrireFichier(String path){
		boolean b = true;
		try{
			BufferedWriter buff = new BufferedWriter(new FileWriter(path));
			try{
				for(int i = 0; i<listeGPH.size(); i++){
					ecrireEnteteFragment(buff,i);
					ecrireSommetFragment(buff,i);
					ecrireAreteFragment(buff,i);
					buff.write("\n");
				}
			}
			catch (Exception e) {
				//e.printStackTrace();
				b = false;
			}
			finally{
				buff.close();
			}
		}
		catch (Exception e) {
			//e.printStackTrace();
			b= false;
		}
		return b;
	}
	
	
	/**
	 * On ecrit sur le fichier l'entete du fragment de numero index.
	 * @param buff
	 * @param index
	 * @return
	 */
	private boolean ecrireEnteteFragment(BufferedWriter buff, int index) {
		
		float emergenceFloat = Float.valueOf(listeGPH.get(index).getBalise("Emergence").getValeur());
		int emergenceInt = Float.valueOf(listeGPH.get(index).getBalise("Emergence").getValeur()).intValue();
		String emergence;
		if(emergenceFloat - emergenceInt == 0){
			emergence = String.valueOf(emergenceInt);
		}
		else{
			emergence = String.valueOf(emergenceFloat);
		}
		
		String line;
		line = _MARQUEUR_DEBUT+_SEPARATION_CHAMP+
				_NUMERO_GRAPHE+_SEPARATION_CHAMP+
				listeGPH.get(index).getBalise("Numero").getValeur()+_SEPARATION_CHAMP+
				_CLASSE_GRAPHE+_SEPARATION_CHAMP+
				listeGPH.get(index).getBalise("Classe").getValeur()+_SEPARATION_CHAMP+
				_FREQUENCE_GRAPHE+_SEPARATION_CHAMP+
				listeGPH.get(index).getBalise("Frequence").getValeur()+_SEPARATION_CHAMP+
				_VALEUR_TOXICITE_GRAPHE+_SEPARATION_CHAMP+
				listeGPH.get(index).getBalise("Toxicite").getValeur()+_SEPARATION_CHAMP+
				_EMERGENCE_GRAPHE+_SEPARATION_CHAMP+
				emergence+"\n";
		try {
			buff.write(line);
		} catch (IOException e) {
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * On ecrit l'ensemble des sommets (atomes) pour le fragment de numero index.
	 * @param buff
	 * @param index
	 * @return
	 */
	private boolean ecrireSommetFragment(BufferedWriter buff, int index){
		String line ;
		for(int i = 0; i< listeGPH.get(index).getAtomes().size(); i++){
			line = _VERTEX+_SEPARATION_CHAMP;
			line = line +  listeGPH.get(index).getAtomes().get(i).getIndice()
					+_SEPARATION_CHAMP+ listeGPH.get(index).getAtomes().get(i).getNumeroAtomique();
			line = line + "\n";
			try {
				buff.write(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	/**
	 * On ecrit sur le fichier l'ensemble des aretes (liaisons atomiques) pour le fragme,t de numero index.
	 * @param buff
	 * @param index
	 * @return
	 */
	private boolean ecrireAreteFragment(BufferedWriter buff, int index){
		String line ;
		for(int i = 0; i< listeGPH.get(index).getListeLiaison().size(); i++){
			line = _EDGE+_SEPARATION_CHAMP;
			line = line +  listeGPH.get(index).getListeLiaison().get(i).getAtomeRelie1()
					+_SEPARATION_CHAMP+listeGPH.get(index).getListeLiaison().get(i).getAtomeRelie2()
					+_SEPARATION_CHAMP+listeGPH.get(index).getListeLiaison().get(i).getNombreLiaison();
			line = line + "\n";
			try {
				buff.write(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}

	
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
