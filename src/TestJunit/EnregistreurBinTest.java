package TestJunit;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;
import org.junit.*;

import modele.enregistreurs.EnregistreurBIN;

public class EnregistreurBinTest
{

	/**
	 * Classe de tests unitaires de la classe EnregistreurBIN
	 * 
	 * <p>
	 * Teste les fonctions de base de la classe EnregistreurBIN :
	 * <ul>
	 * <li>la sauvegarde sur fichier</li>
	 * </ul>
	 * </p>
	 * 
	 * <p>
	 * Remarque : on ne verifiera pas la validite des donnees qui y sont ecrite. Il suffit de parser ce fichier et d'y effectuer des tests.
	 * @see ParseurBinTest
	 * </p>
	 * 
	 * @see EnregistreurBIN
	 * 
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
		cheminFichierExemple = f.getAbsolutePath()+File.separator+"src"+File.separator+"TestJunit"+
				File.separator+"Fichiers"+File.separator+"exemple_39_45(Enr).bin";
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
	 * Test unitaire couvrant le resultat de l'enregistrement sur fichier BIN a une liste specifique.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testParsingListe() {
		EnregistreurBIN enregistreurBin = new EnregistreurBIN(listeBIN, cheminFichierExemple);
		File fichierBin = new File(cheminFichierExemple);
		assertTrue(fichierBin.isFile());  	
	}
	
	
}
