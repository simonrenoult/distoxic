package TestJunit;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.*;
import modele.parseurs.ParseurBIN;

public class ParseurBinTest
{

	/**
	 * Classe de tests unitaires de la classe ParseurBin
	 * 
	 * <p>
	 * Teste les fonctions de base de la classe ParseurBin :
	 * <ul>
	 * <li>la recuperation des donnee dans une liste</li>
	 * <li>la conversion des donnee en un tableau 2D</li>
	 * </ul>
	 * </p>
	 * 
	 * @see ParseurBin
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	private static LinkedList<LinkedList<Integer>>	listeBIN;
	private static String cheminFichierExemple;
	// ----------------------------------------- //
	// ------------------TESTS------------------ //
	// ----------------------------------------- //
	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@BeforeClass
	public static void initTests() {
		listeBIN = new LinkedList<LinkedList<Integer>>();
		File f = new File("");
		System.out.println(f.getAbsolutePath());
		cheminFichierExemple = f.getAbsolutePath()+File.separator+"src"+File.separator+"TestJunit"+
				File.separator+"Fichiers"+File.separator+"exemple_39_45(Par).bin";
	}

	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@Before 
	public void verificationListeApresParsing() {
		listeBIN.removeAll(listeBIN);
		
		LinkedList<Integer> listeTmp = new LinkedList<Integer>();
		listeTmp.add(3);
		listeTmp.add(4);
		listeTmp.add(6);
		listeTmp.add(8);
		listeTmp.add(12);
		listeTmp.add(20);
		listeTmp.add(21);
		listeBIN.addLast(listeTmp);
		
		LinkedList<Integer> listeTmpBis = new LinkedList<Integer>();
		listeTmpBis.add(23);
		listeTmpBis.add(24);
		listeTmpBis.add(27);
		listeTmpBis.add(28);
		listeTmpBis.add(31);
		listeTmpBis.add(32);
		listeBIN.addLast(listeTmpBis);

	}
	
	/**
	 * Test unitaire couvrant le resultat du parsing sur fichier BIN dans une liste specifique.
	 */
	@Test
	public void testParsingListe() {
		ParseurBIN p = new ParseurBIN(cheminFichierExemple);
		assertTrue( p.getListeBIN().equals( listeBIN ));  	
	}
	
	/**
	 * Test unitaire couvrant le resultat de la methode convertirListeVersTableau2D()
	 */
	@Test
	public void testListeToTableau2D() {
		ParseurBIN p = new ParseurBIN(cheminFichierExemple);
		Object[][] tab = p.convertirListeVersTableau2D();
		
		Object[] tabResultatLigne0 = {0,listeBIN.get(0).get(0),listeBIN.get(0).size()-1};
		Object[] tabResultatLigne1 = {1,listeBIN.get(1).get(0),listeBIN.get(1).size()-1};
		
		assertTrue(Arrays.equals(tabResultatLigne0,tab[0]) && Arrays.equals(tabResultatLigne1,tab[1]) ); 	
	}
	
}
