package vue.editeurs;

import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
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
	/**
	 * @return the label
	 */
	public JLabel getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(JLabel label) {
		this.label = label;
	}
	/**
	 * @return the button
	 */
	public JButton getButton() {
		return button;
	}
	/**
	 * @param button the button to set
	 */
	public void setButton(JButton button) {
		this.button = button;
	}
	/**
	 * @return the icon
	 */
	public ImageIcon getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //




}
