package TestJunit;
import static org.junit.Assert.*;
import modele.InformationFichier;
import org.junit.*;

public class InformationFichierTest
{

	/**
	 * Classe de tests unitaires de la classe InformationFichier
	 * 
	 * <p>
	 * Teste les fonctions de base de la classe InformationFichier :
	 * <ul>
	 * <li>La conformite de l'affichage console (et des getter/setter)</li>
	 * </ul>
	 * </p>
	 * 
	 * @see InformationFichier
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private static InformationFichier info;

	// ----------------------------------------- //
	// ------------------TESTS------------------ //
	// ----------------------------------------- //
	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@BeforeClass
	public static void initTests() {
		info = new InformationFichier("dossier", "C:/Users/Alex/documents", "LibellePourJtree");
	}

	/**
	 * Test unitaire couvrant la methode  toString () avec initialisation des parametres.
	 */
	@Test
	public void testToStringAvecInitialisation() {
		assertEquals(info.toString(), "LibellePourJtree");
	}
	
	
}
