package vue.editeurs;

import java.awt.Dimension;
import javax.swing.JSplitPane;

@SuppressWarnings("serial")
public class Editeurs extends JSplitPane
{
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	public final static Integer	TAILLE_X	= ConteneurEditeurs.TAILLE_X;
	public final static Integer	TAILLE_Y	= ConteneurEditeurs.TAILLE_Y;

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //

	private EditeurSDF			edSdf;
	private JSplitPane			edGph_Bin;
	private EditeurBIN			edBin;
	private EditeurGPH			edGph;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //

	public Editeurs()
	{
		this.setSize(TAILLE_X, TAILLE_Y);
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);

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
		edSdf = new EditeurSDF();
	}

	private void buildEditeursGph_Bin()
	{
		edBin = new EditeurBIN();
		edGph = new EditeurGPH();
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
}
