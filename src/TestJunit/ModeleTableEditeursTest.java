package TestJunit;

import static org.junit.Assert.*;
import org.junit.*;

import modele.editeurs.ModeleTablesEditeurs;

public class ModeleTableEditeursTest
{

	/**
	 * Classe de tests unitaires de la classe ModeleTableEditeurs
	 * 
	 * <p>
	 * Teste les fonctions de base de la classe ModeleTableEditeurs :
	 * <ul>
	 * <li>la suppression d'une ligne</li>
	 * <li>le nombre de colonnes dans tableau</li>
	 * <li>le nombre de lignes dans tableau</li>
	 * <li>l'acces a une valeur dans tableau</li>
	 * <li>le changement d'une valeur dans tableau</li>
	 * </ul>
	 * </p>
	 * 
	 * @see ModeleTableEditeurs
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private static Object[][] tableau ;
	private static int taille = 2;

	// ----------------------------------------- //
	// ------------------TESTS------------------ //
	// ----------------------------------------- //
	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@BeforeClass
	public static void initTests() {
		tableau = new Object[taille][taille];
	}

	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@Before 
	public void InitialisationTableau() {
		int cpt = 0;
		for(int i = 0; i< tableau.length; i++){
			for(int j = 0; j<tableau.length; j++){
				tableau[i][j]=cpt;
				cpt++;
			}
		}
	}
	
	/**
	 * Test unitaire couvrant la methode  toString()
	 */
	@Test
	public void testToSuppressionLigne() {
		ModeleTablesEditeurs modele = new ModeleTablesEditeurs(new String[2], tableau, 1);
		modele.toString();
		modele.SupprimerLigne(0);
		assertEquals(modele.toString(),"Debut-2-3-Fin");
	}
	
	/**
	 * Test unitaire couvrant la methode  getColumnCount()
	 */
	@Test
	public void testNombreColonnes() {
		ModeleTablesEditeurs modele = new ModeleTablesEditeurs(new String[2], tableau, 1);
		assertEquals(modele.getColumnCount(),taille);
	}
	
	/**
	 * Test unitaire couvrant la methode  getRowCount()
	 */
	@Test
	public void testNombreLignes() {
		ModeleTablesEditeurs modele = new ModeleTablesEditeurs(new String[2], tableau, 1);
		assertEquals(modele.getRowCount(),taille);
	}
	
	/**
	 * Test unitaire couvrant la methode  ()
	 */
	@Test
	public void testGetValueAt() {
		ModeleTablesEditeurs modele = new ModeleTablesEditeurs(new String[2], tableau, 1);
		assertEquals(modele.getValueAt(0, 0),0);
	}
	
	/**
	 * Test unitaire couvrant la methode  ()
	 */
	@Test
	public void testSetValueAt() {
		ModeleTablesEditeurs modele = new ModeleTablesEditeurs(new String[2], tableau, 1);
		modele.setValueAt("A", 0, 0);
		assertEquals(modele.getValueAt(0, 0),"A");
	}
	
	
}
