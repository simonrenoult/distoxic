package vue.editeurs;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

import controleur.EcouteurEditeurs;

import modele.TripletFichier;

@SuppressWarnings("serial")
public class Editeurs extends JSplitPane
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer	TAILLE_X	= ConteneurEditeurs.TAILLE_X;
	public final static Integer	TAILLE_Y	= ConteneurEditeurs.TAILLE_Y - 75;
	public static int largeurBordure = 2;
	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private EditeurSDF			edSdf;
	private JSplitPane			edGph_Bin;
	private EditeurBIN			edBin;
	private EditeurGPH			edGph;

	private Border bordureVide = BorderFactory.createMatteBorder(largeurBordure, largeurBordure,
			largeurBordure, largeurBordure, Color.white);
	private Border bordureSelection = BorderFactory.createMatteBorder(largeurBordure, largeurBordure,
			largeurBordure, largeurBordure, Color.red);
	private TripletFichier tripletFichier;
	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	public Editeurs(TripletFichier tripletFichier)
	{
		this.setSize(TAILLE_X, TAILLE_Y);
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		this.tripletFichier = tripletFichier;
		buildEditeurSdf();
		buildEditeursGph_Bin();
		initPositionEditeurs();
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	private void buildEditeurSdf()
	{
		edSdf = new EditeurSDF(tripletFichier.getSdfFile());
		edSdf.setBorder(bordureVide);
	}

	public void buildEditeursGph_Bin()
	{
		edBin = new EditeurBIN(tripletFichier.getBinFile());
		edBin.setBorder(bordureVide);
		edGph = new EditeurGPH(tripletFichier.getGphFile());
		edGph.setBorder(bordureVide);
		edGph_Bin = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, edGph, edBin);
		edGph_Bin.setDividerLocation(EditeurGPH.TAILLE_X);
	}
	
	private void initPositionEditeurs(){
		this.setTopComponent(edSdf);
		this.setBottomComponent(edGph_Bin);
		this.setDividerLocation(EditeurSDF.TAILLE_Y);
		@SuppressWarnings("unused")
		EcouteurEditeurs e = new EcouteurEditeurs(this);
	}
	
	public void ajouterEditeurBin(TripletFichier tripletFichier, int indexEditeur){
		this.tripletFichier.setBinFile(tripletFichier.getBinFile());
		this.tripletFichier.setBINPath(tripletFichier.getBinFile().getFilePath());
		buildEditeursGph_Bin();
		initPositionEditeurs();
	}
	
	public void ajouterEditeurGph(TripletFichier tripletFichier, int indexEditeur){
		this.tripletFichier.setGphFile(tripletFichier.getGphFile());
		this.tripletFichier.setGPHPath(tripletFichier.getGphFile().getFilePath());
		buildEditeursGph_Bin();
		initPositionEditeurs();
	}
	
	public void ajouterEditeurSdf(TripletFichier tripletFichier, int indexEditeur){
		this.tripletFichier.setSdfFile(tripletFichier.getSdfFile());
		this.tripletFichier.setSDFPath(tripletFichier.getSdfFile().getFilePath());
		buildEditeurSdf();
		initPositionEditeurs();
		
	}

	// ----------------------------------------- //
	// -------------- ACCESSEURS --------------- //
	// ----------------------------------------- //

	public EditeurSDF getEdSdf()
	{
		return edSdf;
	}

	public JSplitPane getEdGph_Bin()
	{
		return edGph_Bin;
	}

	public EditeurBIN getEdBin()
	{
		return edBin;
	}

	public EditeurGPH getEdGph()
	{
		return edGph;
	}
	/**
	 * @return the tripletFichier
	 */
	public TripletFichier getTripletFichier() {
		return tripletFichier;
	}
	/**
	 * @return the bordureVide
	 */
	public Border getBordureVide() {
		return bordureVide;
	}

	/**
	 * @return the bordureSelection
	 */
	public Border getBordureSelection() {
		return bordureSelection;
	}
	// ----------------------------------------- //
	// --------------- MUTATEURS --------------- //
	// ----------------------------------------- //

	public void setEdSdf(EditeurSDF edSdf)
	{
		this.edSdf = edSdf;
	}

	public void setEdGph_Bin(JSplitPane edGph_Bin)
	{
		this.edGph_Bin = edGph_Bin;
	}

	public void setEdBin(EditeurBIN edBin)
	{
		this.edBin = edBin;
	}

	public void setEdGph(EditeurGPH edGph)
	{
		this.edGph = edGph;
	}
	/**
	 * @param tripletFichier the tripletFichier to set
	 */
	public void setTripletFichier(TripletFichier tripletFichier) {
		this.tripletFichier = tripletFichier;
	}

	

	/**
	 * @param bordureVide the bordureVide to set
	 */
	public void setBordureVide(Border bordureVide) {
		this.bordureVide = bordureVide;
	}


	/**
	 * @param bordureSelection the bordureSelection to set
	 */
	public void setBordureSelection(Border bordureSelection) {
		this.bordureSelection = bordureSelection;
	}
}
