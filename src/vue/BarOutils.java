package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class BarOutils extends JPanel {

	
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //


	private static final long serialVersionUID = 1L;
	private JToolBar toolbar = new JToolBar();
	private JButton nouveau = new JButton();
	private JButton enregistrer = new JButton();
	private JButton enregistrerSous = new JButton();
	private JButton imprimer = new JButton();
	
	public static Integer			TAILLE_X	= ConteneurGlobal.TAILLE_X;
	public static Integer			TAILLE_Y	= 30;
	
	
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	public BarOutils() {
		
		super(new BorderLayout());
		initialiserBouton();
		initialiserToolBar();
		initialiserPanel();
	}
	
	

	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //
	
	private void initialiserToolBar() {
		toolbar.add(nouveau);
		toolbar.add(enregistrer);
		toolbar.add(enregistrerSous);
		toolbar.add(imprimer);
		toolbar.addSeparator();
		toolbar.setRollover(true);
	}
	
	private void initialiserBouton() {
		nouveau = creerBouton("src/images/icones/folder_add.png","Nouveau");
		enregistrer = creerBouton("src/images/icones/save_as.png", "Enregistrer");
		enregistrerSous = creerBouton("src/images/icones/save_as.png", "Enregistrer Tous");
		imprimer = creerBouton("src/images/icones/printer.png", "Imprimer");
		
	}
	
	private JButton creerBouton(String path,String toolTip){
		
		JButton button = new JButton();
		button.setIcon(new ImageIcon(path));
		button.setToolTipText(toolTip);
		button.setPreferredSize(new Dimension(30, 30));
		return button;
	}
	
	private void initialiserPanel() {
		this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
		this.add(toolbar,BorderLayout.PAGE_START);
		
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
