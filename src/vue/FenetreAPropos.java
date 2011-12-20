package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JWindow;

@SuppressWarnings("serial")
public class FenetreAPropos extends JWindow
{

	// ----------------------------------------- //
	// --------------- ATTRIBUTS --------------- //
	// ----------------------------------------- //
	
	private final static String VERSION = "v0.9";
	private static final String	REVISON	= "4b59ee2079";
	private static String	_ICON_PATH	= "/images/icones/";

	private Dimension		dimension	= new Dimension(450, 380);

	// ----------------------------------------- //
	// ------------- CONSTRUCTEURS ------------- //
	// ----------------------------------------- //

	/**
	 * Constructeur principal de la classe Splasher
	 * 
	 */
	public FenetreAPropos()
	{
		this.setSize(dimension);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		initComponenent();
	}

	// ----------------------------------------- //
	// ---------------- METHODES --------------- //
	// ----------------------------------------- //

	private void initComponenent()
	{
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		container.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		container.add(top(), BorderLayout.CENTER);
		container.add(bottom(), BorderLayout.PAGE_END);
		
		getContentPane().add(container);
	}

	private JPanel top()
	{
		JLabel logo = new JLabel(new ImageIcon(getClass().getResource(_ICON_PATH + "logo_150.png")));
		logo.setVerticalAlignment(JLabel.NORTH);
		logo.setHorizontalAlignment(JLabel.CENTER);
		logo.setBackground(Color.WHITE);
		
		JEditorPane auteurs = new JEditorPane("text/html",
						"<html>" +
							"<h3>"+
								"Auteurs :" +
							"</h3>"+
								" Alexis CHRETIENNE<br />" +
								" Simon RENOULT" +
							"<h3>"+
								"Page Web :" +
							"</h3>"+
								"<a href=\"http://distoxic.github.com/distoxic/\">Dis'Toxic</a>" +
							"<h3>"+
								"Code source :" +
							"</h3>"+
								"<a href=\"https://github.com/distoxic/distoxic\">Sources</a>" +
						"</html>");
		
		JEditorPane infos = new JEditorPane("text/html",
				"<html>" +
						"<p style=\"text-align : justify\">" +
							"Dis'Toxic (Display Toxicities) est un logiciel d'affichage " +
							"et d'édition de fichiers contenant des fragments " +
							"moléculaires dont un certain nombre représente " +
							"des fragments catalyseurs de toxicités." +
						"</p>"+
				"</html>"
						
				);
				
		JPanel top = new JPanel(new BorderLayout());
		top.setBackground(Color.WHITE);
		
		JPanel top_top = new JPanel(new GridLayout(1,3));
		top_top.setBackground(Color.WHITE);
		
		top_top.add(logo);
		top_top.add(auteurs);
		
		top.add(top_top, BorderLayout.NORTH);
		top.add(infos, BorderLayout.CENTER);
		
		return top;
	}
	
	private JPanel bottom()
	{
		JLabel revision = new JLabel("Revision " + REVISON);
		revision.setForeground(Color.GRAY);
		JLabel version = new JLabel("Dis'Toxic " + VERSION);
		version.setForeground(Color.GRAY);
		JButton fermer = new JButton("Fermer");

		JPanel bottom_left = new JPanel(new FlowLayout());
		bottom_left.setBackground(Color.WHITE);
		bottom_left.add(version);
		
		JPanel bottom_center = new JPanel();
		bottom_center.setBackground(Color.WHITE);
		bottom_center.add(revision);

		JPanel bottom_right = new JPanel(new FlowLayout());
		bottom_right.setBackground(Color.WHITE);
		bottom_right.add(fermer);

		JPanel bottom = new JPanel(new GridLayout(1,3));
		bottom.setBackground(Color.WHITE);
		
		bottom.add(bottom_left);
		bottom.add(bottom_center);
		bottom.add(bottom_right);
		
		return bottom;
	}
}
