package TestJunit;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import org.junit.*;

import modele.composantsChimiques.Atome;
import modele.composantsChimiques.Balise;
import modele.composantsChimiques.FragmentMolecule;
import modele.enregistreurs.EnregistreurSDF;

public class EnregistreurSdfTest
{

	/**
	 * Classe de tests unitaires de la classe EnregistreurSdf
	 * 
	 * <p>
	 * Teste les fonctions de base de la classe EnregistreurSdf :
	 * <ul>
	 * <li>la sauvegarde sur fichier</li>
	 * </ul>
	 * </p>
	 * 
	 * <p>
	 * Remarque : on ne verifiera pas la validite des donnees qui y sont ecrite. Il suffit de parser ce fichier et d'y effectuer des tests.
	 * @see ParseurSdfTest
	 * </p>
	 * 
	 * @see EnregistreurSdf
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	private static LinkedList<FragmentMolecule>	fragmentsMolecules = null;
	private static String cheminFichierExemple;
	// ----------------------------------------- //
	// ------------------TESTS------------------ //
	// ----------------------------------------- //
	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@BeforeClass
	public static void initTests() {
		fragmentsMolecules = new LinkedList<FragmentMolecule>();
		File f = new File("");
		System.out.println(f.getAbsolutePath());
		cheminFichierExemple = f.getAbsolutePath()+File.separator+"src"+File.separator+"TestJunit"+
				File.separator+"Fichiers"+File.separator+"exemple_45(Enr).sdf";
	}

	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@Before 
	public void verificationListeApresParsing() {
		
		FragmentMolecule fg = new FragmentMolecule();
		
		fg.setDebutDescription("SciTegic06091010432D");
		String [] tabResume = {"11", "999", "V2000"};
		fg.setResumeContenu(tabResume);
		LinkedList<Atome> listeAtome = new LinkedList<Atome>();
		
		Atome atomeA = new Atome();
		atomeA.setNom("P");
		LinkedList<Float>	infosA = new LinkedList<Float>();
		infosA.add((float) 3.9);
		infosA.add((float) 0.75);
		infosA.add((float) 0.0);
		LinkedList<Integer>	diversA = new LinkedList<Integer>();
		diversA.add(0);
		diversA.add(0);
		atomeA.setDivers(diversA);
		atomeA.setInfos(infosA);
		
		
		listeAtome.add(atomeA);
		
		LinkedList<LinkedList<String>> liaisons = new LinkedList<LinkedList<String>>();
		LinkedList<String> liaisonA = new LinkedList<String>();
		liaisonA.add("1");
		liaisonA.add("2");
		liaisonA.add("1");
		liaisonA.add("0");
		
		liaisons.add(liaisonA);
		
		LinkedList<Balise> listeBalise = new LinkedList<Balise>();
		listeBalise.add(new Balise("HOMO","-4.844630"));
		
		LinkedHashMap<String, LinkedList<String>>	infos = new LinkedHashMap<String, LinkedList<String>>();
		LinkedList<String> content = new LinkedList<String>();
		content.add("1");
		content.add("4");
		content.add("-1");
		infos.put("CHG", content);
		
		fg.setAtomes(listeAtome);
		fg.setLiaisons(liaisons);
		fg.setBalises(listeBalise);
		fg.setInfos(infos);
		
		fragmentsMolecules.add(fg);
	}
	
	/**
	 * Test unitaire couvrant le resultat de l'enregistrement sur fichier SDF a une liste specifique.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testParsingListe() {
		EnregistreurSDF enregistreurGph = new EnregistreurSDF(fragmentsMolecules, cheminFichierExemple);
		File fichierSdf = new File(cheminFichierExemple);
		assertTrue(fichierSdf.isFile());  	
	}
	
	
}
