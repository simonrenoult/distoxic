package vue.editeurs;

import java.awt.Dimension;
import javax.swing.JSplitPane;

import modele.TripletFichier;

@SuppressWarnings("serial")
public class Editeurs extends JSplitPane
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer	TAILLE_X	= ConteneurEditeurs.TAILLE_X;
	public final static Integer	TAILLE_Y	= ConteneurEditeurs.TAILLE_Y - 75;

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private EditeurSDF			edSdf;
	private JSplitPane			edGph_Bin;
	private EditeurBIN			edBin;
	private EditeurGPH			edGph;

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

		this.setTopComponent(edSdf);
		this.setBottomComponent(edGph_Bin);
		this.setDividerLocation(EditeurSDF.TAILLE_Y);
	}

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	private void buildEditeurSdf()
	{
		edSdf = new EditeurSDF(tripletFichier.getSdfFile());
	}

	private void buildEditeursGph_Bin()
	{
		edBin = new EditeurBIN(tripletFichier.getBinFile());
		edGph = new EditeurGPH(tripletFichier.getGphFile());
		edGph_Bin = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, edGph, edBin);
		edGph_Bin.setDividerLocation(EditeurGPH.TAILLE_X);
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
}
