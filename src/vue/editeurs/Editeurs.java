
package vue.editeurs;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JSplitPane;

public class Editeurs extends JSplitPane
{
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	
	public static Integer	TAILLE_X	= ConteneurEditeurs.TAILLE_X;
	public static Integer	TAILLE_Y	= ConteneurEditeurs.TAILLE_Y;
	
	private EditeurSDF		edSdf;
	
	private JSplitPane		edGph_Bin;
	private EditeurBIN		edBin;
	private EditeurGPH		edGph;
	
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
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
	
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
