package TestJunit;

import static org.junit.Assert.*;
import org.junit.*;

import modele.composantsChimiques.Atome;

public class AtomeTest
{

	/**
	 * Classe de tests unitaires de la classe Atome
	 * 
	 * <p>
	 * Teste les fonctions de base de la classe Balise :
	 * <ul>
	 * <li>La conformite de l'affichage console (et des getter/setter)</li>
	 * </ul>
	 * </p>
	 * 
	 * @see Atome
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private static Atome atome;

	// ----------------------------------------- //
	// ------------------TESTS------------------ //
	// ----------------------------------------- //
	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@BeforeClass
	public static void initTests() {
		atome = new Atome();
		atome.setNom("MonAtome");
		atome.getDivers().add(10);
		atome.getDivers().add(12);
		atome.getInfos().add((float) 1.1);
		atome.getInfos().add((float) 2.8765);
	}

	/**
	 * Test unitaire couvrant la methode  toString()
	 */
	@Test
	public void testToString() {
		
		assertEquals(atome.toString(), "MonAtome : [1.1, 2.8765] [10, 12]");
	}
	
	
}
