package TestJunit;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;
import org.junit.*;
import modele.composantsChimiques.Atome;
import modele.composantsChimiques.Balise;
import modele.composantsChimiques.FragmentMolecule;
import modele.composantsChimiques.Liaison;
import modele.parseurs.ParseurGPH;

public class ParseurGphTest
{

	/**
	 * Classe de tests unitaires de la classe ParseurGph
	 * 
	 * <p>
	 * Teste les fonctions de base de la classe ParseurGph :
	 * <ul>
	 * <li>la recuperation des donnee dans une liste</li>
	 * <li>la conversion des donnee en un tableau 2D</li>
	 * </ul>
	 * </p>
	 * 
	 * @see ParseurGph
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
				File.separator+"Fichiers"+File.separator+"exemple_39(Par).gph";
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
	 * Test unitaire couvrant le resultat du parsing sur fichier BIN dans une liste specifique.
	 */
	@Test
	public void testParsingListe() {
		ParseurGPH p = new ParseurGPH(cheminFichierExemple);
		
			assertTrue( p.getListeGPH().getFirst().getBalise("Numero").getValeur().equals( 
				listeGPH.getFirst().getBalise("Numero").getValeur())&& 
				p.getListeGPH().getFirst().getBalise("Classe").getValeur().equals( 
				listeGPH.getFirst().getBalise("Classe").getValeur())&&
				p.getListeGPH().getFirst().getBalise("Frequence").getValeur().equals( 
				listeGPH.getFirst().getBalise("Frequence").getValeur()) &&
				p.getListeGPH().getFirst().getBalise("Toxicite").getValeur().equals( 
				listeGPH.getFirst().getBalise("Toxicite").getValeur()) &&
				String.valueOf(p.getListeGPH().getFirst().getAtomes().size()).equals( 
				String.valueOf(listeGPH.getFirst().getAtomes().size())) &&
				String.valueOf(p.getListeGPH().getFirst().getListeLiaison().size()).equals( 
				String.valueOf(listeGPH.getFirst().getListeLiaison().size()))
				);
	}
	
	/**
	 * Test unitaire couvrant le resultat de la methode convertirListeVersTableau2D()
	 */
	@Test
	public void testListeToTableau2D() {
		ParseurGPH p = new ParseurGPH(cheminFichierExemple);
		Object[][]tabFichier = p.convertirListeVersTableau2D();
		
		Object[]tabRef = new Object[7];
		tabRef[0] = listeGPH.getFirst().getBalise("Numero").getValeur();
		tabRef[1] = listeGPH.getFirst().getAtomes().size();
		tabRef[2] = listeGPH.getFirst().getListeLiaison().size();
		tabRef[3] = listeGPH.getFirst().getBalise("Classe").getValeur();
		tabRef[4] = listeGPH.getFirst().getBalise("Frequence").getValeur();
		tabRef[5] = listeGPH.getFirst().getBalise("Toxicite").getValeur();
		tabRef[6] = listeGPH.getFirst().getBalise("Emergence").getValeur();
		
		assertTrue(tabFichier[0][0].toString().equals(tabRef[0].toString()) && 
				tabFichier[0][1].toString().equals(tabRef[1].toString()) &&
				tabFichier[0][2].toString().equals(tabRef[2].toString()) &&
				tabFichier[0][3].toString().equals(tabRef[3].toString()) &&
				tabFichier[0][4].toString().equals(tabRef[4].toString()) &&
				tabFichier[0][5].toString().equals(tabRef[5].toString()) &&
				tabFichier[0][6].toString().equals(tabRef[6].toString()));
		
	}
	
}
