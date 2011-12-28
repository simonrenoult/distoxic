package TestJunit;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;
import org.junit.*;

import modele.composantsChimiques.Atome;
import modele.composantsChimiques.Balise;
import modele.composantsChimiques.FragmentMolecule;
import modele.composantsChimiques.Liaison;
import modele.enregistreurs.EnregistreurGPH;

public class EnregistreurGphTest
{

	/**
	 * Classe de tests unitaires de la classe EnregistreurGph
	 * 
	 * <p>
	 * Teste les fonctions de base de la classe EnregistreurGph :
	 * <ul>
	 * <li>la sauvegarde sur fichier</li>
	 * </ul>
	 * </p>
	 * 
	 * <p>
	 * Remarque : on ne verifiera pas la validite des donnees qui y sont ecrite. Il suffit de parser ce fichier et d'y effectuer des tests.
	 * @see ParseurGphTest
	 * </p>
	 * 
	 * @see EnregistreurGph
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	private static LinkedList<FragmentMolecule>	listeGPH				= null;
	private static String cheminFichierExemple;
	// ----------------------------------------- //
	// ------------------TESTS------------------ //
	// ----------------------------------------- //
	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@BeforeClass
	public static void initTests() {
		listeGPH = new LinkedList<FragmentMolecule>();
		File f = new File("");
		System.out.println(f.getAbsolutePath());
		cheminFichierExemple = f.getAbsolutePath()+File.separator+"src"+File.separator+"TestJunit"+
				File.separator+"Fichiers"+File.separator+"exemple_39(Enr).gph";
	}

	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@Before 
	public void verificationListeApresParsing() {
FragmentMolecule fg = new FragmentMolecule();
		
		LinkedList<Balise> listeBalise = new LinkedList<Balise>();
		listeBalise.add(new Balise("Numero","0"));
		listeBalise.add(new Balise("Classe","-1"));
		listeBalise.add(new Balise("Frequence","10"));
		listeBalise.add(new Balise("Toxicite","0.0429"));
		listeBalise.add(new Balise("Emergence","3.0"));
		
		LinkedList<Atome> listeAtome = new LinkedList<Atome>();
		listeAtome.add(new Atome(0, 206));
		listeAtome.add(new Atome(1, 7));
		
		LinkedList<Liaison> listeLiaison = new LinkedList<Liaison>();
		listeLiaison.add(new Liaison(0,1,1));
		
		fg.setAtomes(listeAtome);
		fg.setBalises(listeBalise);
		fg.setListeLiaison(listeLiaison);
		
		listeGPH.add(fg);
	}
	
	/**
	 * Test unitaire couvrant le resultat de l'enregistrement sur fichier GPH a une liste specifique.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testParsingListe() {
		EnregistreurGPH enregistreurGph = new EnregistreurGPH(listeGPH, cheminFichierExemple);
		File fichierGph = new File(cheminFichierExemple);
		assertTrue(fichierGph.isFile());  	
	}
	
	
}
