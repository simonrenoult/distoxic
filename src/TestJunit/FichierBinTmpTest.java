package TestJunit;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.*;
import modele.fichiersTmp.FichierBinTmp;

public class FichierBinTmpTest
{

	/**
	 * Classe de tests unitaires de la classe FichierBinTmpTest
	 * 
	 * <p>
	 * Teste les fonctions de base de la classe FichierBinTmpTest :
	 * <ul>
	 * <li>la modification de valeur dans la liste</li>
	 * <li>la suppression de valeurs dans la liste</li>
	 * <li>le tool tip genere a partir de la liste</li>
	 * </ul>
	 * </p>
	 * 
	 * @see FichierBinTmpTest
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private static LinkedList<LinkedList<Integer>>	listeBINTmp	= null;
	private static int taille;

	// ----------------------------------------- //
	// ------------------TESTS------------------ //
	// ----------------------------------------- //
	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@BeforeClass
	public static void initTests() {
		listeBINTmp = new LinkedList<LinkedList<Integer>>();
		taille = 2;
	}

	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@Before 
	public void InitialisationListe() {
		listeBINTmp.removeAll(listeBINTmp);
		LinkedList<Integer> listeTmp= new LinkedList<Integer>();
		int cpt = 0;
		for(int i = 0; i<taille; i++ ){
			listeTmp = new LinkedList<Integer>();
			for(int j = 0; j< taille; j++){
				listeTmp.addLast(cpt);
				cpt++;
			}
			listeBINTmp.addLast(listeTmp);
		}
	}
	
	
	/**
	 * Test unitaire couvrant la methode modifierValeurClasse
	 */
	@Test
	public void testmodifierValeurClasse() {
		FichierBinTmp fichierBinTmp = new FichierBinTmp(listeBINTmp);
		fichierBinTmp.toString();
		fichierBinTmp.modifierValeurClasse(0, 1, 6);
		assertEquals( fichierBinTmp.toString(), "Debut-6-1-2-3-Fin");
	}
	
	/**
	 * Test unitaire couvrant la methode  suppressionLigneLigneFichierBinTmp
	 */
	@Test
	public void testsuppressionLigneLigneFichierBinTmp() {
		FichierBinTmp fichierBinTmp = new FichierBinTmp(listeBINTmp);
		fichierBinTmp.suppressionLigneLigneFichierBinTmp(0);
		assertEquals( fichierBinTmp.toString(), "Debut-2-3-Fin");
	}
	
	/**
	 * Test unitaire couvrant la methode  afficherListeFragmentAssociee (retourne une chaine servant pour un tooltip)
	 */
	@Test
	public void testafficherListeFragmentAssociee() {
		FichierBinTmp fichierBinTmp = new FichierBinTmp(listeBINTmp);
		assertEquals( fichierBinTmp.afficherListeFragmentAssociee(0), "1");
	}
	
}
