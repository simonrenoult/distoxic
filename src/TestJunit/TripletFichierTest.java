package TestJunit;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.*;

import modele.TripletFichier;
import modele.WorkspaceModele;

public class TripletFichierTest
{
	/**
	 * Classe de tests unitaires de la classe TripletFichier
	 * 
	 * <p>
	 * Teste les fonctions de base de la classe TripletFichier :
	 * <ul>
	 * <li>Initialisation des bons types de fichiers en focntions des chemins (extensions) donnees.</li>
	 * <li>La creation d'un fichier pour un chemin donnee en parametre</li>
	 * <li>La creation d'un dossier dans le workspace sur un nom donnee en parametre</li>
	 * <li>La creation d'un projet dans le workspace sur un nom de dossier donnee en parametre</li>
	 * </ul>
	 * </p>
	 * 
	 * <p>
	 * Remarque : Ces tests peuvent s'aider de la classe WorkspaceModele.
	 * </p>
	 * @see TripletFichier
	 * @see WorkspaceModele
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private static String pathGenerique ;
	private static String nomDossier ;
	private static String nomFichierBin;
	private static String pathBIN;
	private static String pathGPH;
	private static String pathSDF;
	

	// ----------------------------------------- //
	// ------------------TESTS------------------ //
	// ----------------------------------------- //
	/**
	 * Initialisation des données de test avant l'ensemble des tests
	 */
	@BeforeClass
	public static void initTests() {
		pathGenerique = "C:"+File.separator+"Users"+File.separator+"alex"+File.separator;
		nomDossier = "testUnitaireCreationProjet";
		nomFichierBin = "testBin.bin";
		pathBIN = pathGenerique+"test.bin";
		pathGPH = pathGenerique+"test.gph";
		pathSDF = pathGenerique+"test.sdf";
		
	}

	/**
	 * Test unitaire couvrant la construction d'un objet TripletFichier avec un parametre
	 */
	@Test
	public void testCheminBin() {
		TripletFichier triplet = new TripletFichier(pathBIN);
		assertEquals(triplet.getBinFile().getFilePath(), pathBIN);
	}
	
	
	
	/**
	 * Test unitaire couvrant la construction d'un objet TripletFichier avec deux parametres
	 */
	@Test
	public void testCheminBIN_GPH() {
		TripletFichier triplet = new TripletFichier(pathBIN, pathGPH);
		assertTrue(triplet.getBinFile().getFilePath().equals(pathBIN) && 
			triplet.getGphFile().getFilePath().equals(pathGPH));
	}
	
	/**
	 * Test unitaire couvrant la construction d'un objet TripletFichier avec trois parametres
	 */
	@Test
	public void testCheminBIN_GPH_SDF() {
		TripletFichier triplet = new TripletFichier(pathBIN, pathGPH,pathSDF);
		assertTrue(triplet.getBinFile().getFilePath().equals(pathBIN) && 
			triplet.getGphFile().getFilePath().equals(pathGPH) && 
			triplet.getSdfFile().getFilePath().equals(pathSDF));
	}
	
	/**
	 * Test unitaire couvrant la creation d'un fichier BIN (methode similaire au BIN, GPH et SDF).
	 */
	@Test
	public void testCreationProjet() {
		TripletFichier triplet = new TripletFichier();
		WorkspaceModele modele = new WorkspaceModele(1);
		modele.lireFichier();
		String cheminWorkspace = modele.getWorkspacePath();
		String cheminDossierProjet = cheminWorkspace+File.separator+nomDossier;
		
		triplet.creerNouveauProjetVierge(nomDossier);
		File dossier = new File(cheminDossierProjet);
		File ficherBin = new File(cheminDossierProjet+File.separator+nomDossier+".bin");
		File ficherGph = new File(cheminDossierProjet+File.separator+nomDossier+".gph");
		File ficherSdf = new File(cheminDossierProjet+File.separator+nomDossier+".sdf");
		
		assertTrue(dossier.isDirectory()&& ficherBin.isFile() && ficherGph.isFile() &&
				ficherSdf.isFile());
	}
	
	/**
	 * Test unitaire couvrant la creation d'un projet (nouveau dossier + trois fichiers BIN, GPH et SDF)
	 */
	@Test
	public void testCreationFichier() {
		TripletFichier triplet = new TripletFichier();
		triplet.creerFichierBIN(pathGenerique+nomFichierBin);
		
		File ficherBin = new File(pathGenerique+nomFichierBin);
		assertTrue(ficherBin.isFile() && ficherBin.getName().equals(nomFichierBin));
	}
	
	/**
	 * Test unitaire couvrant la creation d'un projet (nouveau dossier + trois fichiers BIN, GPH et SDF)
	 */
	@Test
	public void testCreationDossier() {
		TripletFichier triplet = new TripletFichier();
		WorkspaceModele modele = new WorkspaceModele(1);
		modele.lireFichier();
		String cheminDossierProjet = modele.getWorkspacePath()+File.separator+nomDossier;
		triplet.creerDossierViergeDansWorkspace(nomDossier);
		
		File dossier = new File(cheminDossierProjet);
		assertTrue(dossier.isDirectory() && dossier.getName().equals(nomDossier));
	}
	
	/**
	 * Les tests ne permettent pas de supprimer les dossiers et fichiers crees.
	 */
	@AfterClass
	public static void initTestsApresTest() {
		
		/*
		 * Suppression des fichiers et dossier sur le test : testCreationProjet() & testCreationDossier()
		 */
		WorkspaceModele modele = new WorkspaceModele(1);
		modele.lireFichier();
		String cheminWorkspace = modele.getWorkspacePath();
		String cheminDossierProjet = cheminWorkspace+File.separator+nomDossier;
		File dossierA = new File(cheminDossierProjet);
		if(dossierA.exists()){
			File[] tabFichier = dossierA.listFiles();
			for(int i = 0; i< tabFichier.length; i++){
				tabFichier[i].delete();
			}
			dossierA.delete();
		}
		
		/**
		 * Suppression du fichier sur le test : testCreationFichier()
		 */
		File fichier = new File(pathGenerique+nomFichierBin);
		if(fichier.exists()){
			fichier.delete();
		}
		
	}
	
	
}
