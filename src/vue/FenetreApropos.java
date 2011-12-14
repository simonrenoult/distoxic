package vue;

import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JWindow;

@SuppressWarnings("serial")
public class FenetreApropos extends JWindow {


	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //
	
	
	
	private Dimension	dimension	= new Dimension(600, 300);
	private JButton quitter = new JButton("Quitter");
	@SuppressWarnings("unused")
	private JLabel information = new JLabel("Dis'Toxic");

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //
	
	/**
	 * Constructeur principal de la classe Splasher
	 * 
	 */
	public FenetreApropos()
	{
		initComponenent();
		
		this.setSize(dimension);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setAlwaysOnTop(true);

	}

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //
	private void initComponenent(){
		
		this.add(new JLabel(createImageIcon("/images/aspirine.png", "")));
		this.add(quitter);
		
	}
	


	private ImageIcon createImageIcon(String path, String description)
	{
		URL imgURL = getClass().getResource(path);
		if (imgURL != null)
		{
			return new ImageIcon(imgURL, description);
		}
		else
		{
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	
}
