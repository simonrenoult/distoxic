package vue;

import java.awt.Dimension;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class Splasher extends Thread{


	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //
	
	private JWindow		window		= new JWindow();
	private Dimension	dimension	= new Dimension(550, 425);
	private static String path = "src"+File.separator+"images"+File.separator;

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //
	
	/**
	 * Constructeur principal de la classe Splasher
	 * 
	 */
	public Splasher()
	{

		window.setSize(dimension);
		window.add(new JLabel(new ImageIcon(path+"splasher.png")));
		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //
	
	@SuppressWarnings("unused")
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

	/**
	 * On lance cette methode et on boucle pendant un temps estime. Le jeu se
	 * charge en parallele.
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void run()
	{
		long time = System.currentTimeMillis();
		while (System.currentTimeMillis() - time < 1000)
		{
		}
		window.setVisible(false);
		this.stop();
	}
}
