package src.vue.editeurs;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EnteteOnglet extends JPanel
{
	/**
	 * <h4>EnteteOnglet est la classe represenatant l'entete de chaque onglet</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //
	/**
	 * Constante de classe
	 */
	private final static String		_ICON_PATH		= "/images/icones/";
	private final static String		_ICON_NAME		= "cross.png";
	private final static Dimension	BUTTON_SIZE		= new Dimension(16, 16);
	private final static String		BUTTON_TOOLTIP	= "Fermer";

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //

	private JLabel					label;
	private JButton					button;
	private ImageIcon				icon;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe EnteteOnglet
	 * @param title libelle de l'onglet
	 */
	public EnteteOnglet(String title)
	{
		icon = new ImageIcon(getClass().getResource(_ICON_PATH + _ICON_NAME));

		label = new JLabel(title);
		this.add(label);

		button = new JButton(icon);
		button.setPreferredSize(BUTTON_SIZE);
		button.setRolloverEnabled(true);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setToolTipText(BUTTON_TOOLTIP);
		this.add(button);
	}

	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	/**
	 * @return the label
	 */
	public JLabel getLabel()
	{
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(JLabel label)
	{
		this.label = label;
	}

	/**
	 * @return the button
	 */
	public JButton getButton()
	{
		return button;
	}

	/**
	 * @param button
	 *            the button to set
	 */
	public void setButton(JButton button)
	{
		this.button = button;
	}

	/**
	 * @return the icon
	 */
	public ImageIcon getIcon()
	{
		return icon;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon(ImageIcon icon)
	{
		this.icon = icon;
	}
	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //

}
