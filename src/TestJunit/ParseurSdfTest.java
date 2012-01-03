package TestJunit;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import org.junit.*;

import modele.composantsChimiques.Atome;
import modele.composantsChimiques.Balise;
import modele.composantsChimiques.FragmentMolecule;
import modele.parseurs.ParseurSDF;

public class ParseurSdfTest
{

	/**
	 * Classe de tests unitaires de la classe ParseurSdf
	 * 
	 * <p>
	 * Teste les fonctions de base de la classe ParseurSdf :
	 * <ul>
	 * <li>la recuperation des donnees dans une liste</li>
	 * <li>la conversion des donnees en un tableau 2D</li>
	 * </ul>
	 * </p>
	 * 
	 * @see ParseurSdf
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
				File.separator+"Fichiers"+File.separator+"exemple_45(Par).sdf";
	}

	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@Before 
	public void verificationListeApresParsing() {
		FragmentMolecule fg = new FragmentMolecule();
		
		fg.setDebutDescription("SciTegic06091010432D");
		String [] tabResume = {"11","10", "0", "0", "0", "0", "999", "V2000"};
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
	 * Test unitaire couvrant le resultat du parsing sur fichier BIN dans une liste specifique.
	 */
	@Test
	public void testParsingListe() {
		ParseurSDF p = new ParseurSDF(cheminFichierExemple);
		p.getFragmentsMolecules().getFirst().display();
	
		assertTrue(
			p.getFragmentsMolecules().getFirst().getResumeContenu()[0].equals(fragmentsMolecules.getFirst().getResumeContenu()[0]) &&
			p.getFragmentsMolecules().getFirst().getResumeContenu()[1].equals(fragmentsMolecules.getFirst().getResumeContenu()[1]) &&
			p.getFragmentsMolecules().getFirst().getResumeContenu()[2].equals(fragmentsMolecules.getFirst().getResumeContenu()[2]) &&
			p.getFragmentsMolecules().getFirst().getDebutDescription().equals(fragmentsMolecules.getFirst().getDebutDescription()) &&
			p.getFragmentsMolecules().getFirst().getAtomes().getFirst().getNom().equals(fragmentsMolecules.getFirst().getAtomes().getFirst().getNom()) &&
			(String.valueOf(p.getFragmentsMolecules().getFirst().getAtomes().getFirst().getDivers().size())).equals((String.valueOf(fragmentsMolecules.getFirst().getAtomes().getFirst().getDivers().size()))) &&
			(String.valueOf(p.getFragmentsMolecules().getFirst().getAtomes().getFirst().getInfos().size())).equals((String.valueOf(fragmentsMolecules.getFirst().getAtomes().getFirst().getInfos().size()))) &&
			p.getFragmentsMolecules().getFirst().getBalise("HOMO").getValeur().equals(fragmentsMolecules.getFirst().getBalise("HOMO").getValeur()) &&
			p.getFragmentsMolecules().getFirst().getInfos().equals(fragmentsMolecules.getFirst().getInfos())
			);
		
	}
	
	/**
	 * Test unitaire couvrant le resultat de la methode convertirListeVersTableau2D()
	 */
	@Test
	public void testListeToTableau2D() {
		ParseurSDF p = new ParseurSDF(cheminFichierExemple);
		Object[][] tabFichier = p.convertirListeVersTableau2D();
		
		Object[] tabRef = new Object[4];
		tabRef[0] = "0";
		tabRef[1] = "1";
		tabRef[2] = "1";
		tabRef[3] = "-4.844630";
		
		assertTrue(tabFichier[0][0].toString().equals(tabRef[0].toString()) && 
				tabFichier[0][1].toString().equals(tabRef[1].toString()) &&
				tabFichier[0][2].toString().equals(tabRef[2].toString()) &&
				tabFichier[0][3].toString().equals(tabRef[3].toString()));
		
		
	}
	
}
