package vue.editeurs;

import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EnteteOnglet extends JPanel {

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private static String _ICON_PATH = "src"+File.separator+"images"+File.separator+"icones"+File.separator;
	
	private JLabel label;
	private JButton button;
	private ImageIcon icon;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	public EnteteOnglet(String title){
		icon =  new ImageIcon(_ICON_PATH+"cross.png");
		
		label = new JLabel(title);
		this.add(label);
		
		button = new JButton(icon);
		button.setPreferredSize(new Dimension(16,16));
		button.setRolloverEnabled(true);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setToolTipText("Fermer");
		this.add(button);
	}
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

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
