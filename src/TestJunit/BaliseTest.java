package TestJunit;

import static org.junit.Assert.*;
import org.junit.*;
import modele.composantsChimiques.Balise;

public class BaliseTest
{

	/**
	 * Classe de tests unitaires de la classe Balise
	 * 
	 * <p>
	 * Teste les fonctions de base de la classe Balise :
	 * <ul>
	 * <li>La conformite de l'affichage console (et des getter/setter)</li>
	 * </ul>
	 * </p>
	 * 
	 * @see Balise
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private static Balise baliseA;
	private static Balise baliseB;
	private static Balise baliseC;

	// ----------------------------------------- //
	// ------------------TESTS------------------ //
	// ----------------------------------------- //
	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@BeforeClass
	public static void initTests() {
		baliseA = new Balise();
		baliseB = new Balise("testB");
		baliseC = new Balise("testC", "valeurC");
	}

	/**
	 * Test unitaire couvrant la methode  toString () avec initialisation sans parmetres
	 */
	@Test
	public void testToStringSansInitialisation() {
		assertEquals(baliseA.toString(), "Titre : , Valeur : ");
	}
	
	/**
	 * Test unitaire couvrant la methode  toString () avec initialisation d'un parmetre
	 */
	@Test
	public void testToStringAvecInitialisation() {
		assertEquals(baliseB.toString() , "Titre : testB, Valeur : ");
	}
	
	/**
	 * Test unitaire couvrant la methode  toString () avec initialisation des deux parmetres
	 */
	@Test
	public void testToStringAvecInitialisationComplete() {
		assertEquals(baliseC.toString(), "Titre : testC, Valeur : valeurC");
	}
}
