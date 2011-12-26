package src.modele;

import java.io.File;

public class FiltreZIP extends javax.swing.filechooser.FileFilter
{
	/**
	 * <h4>FiltreZIP est la classe qui aide a la selection de l'import d'un projet sous format .zip</h4>
	 * 
	 * <p>
	 * Remarque : Classe servant a creer un filtre specifique pour les objets de type JFileChooser.
	 * </p>
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * L'extension qui constitue le filtre
	 */
	private String extension;
	/**
	 * La description du filtre.
	 */
	private String description;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe FiltreZIP
	 * @param extension l'extansion a filtrer
	 * @param description la description du filtre
	 */
	public FiltreZIP(String extension, String description)
	{
		this.extension = extension;
		this.description = description;
	}
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	@Override
	/**
	 * Methode appellee pour chaque fichier afin de savoir si ce dernier visible dans les objets de type JFileChooser.
	 * @param le fichier
	 * @return un booleen de visibilite.
	 */
	public boolean accept(File fichier)
	{
		if (fichier.getName().endsWith(extension)){
			return true;
		}
		else if (fichier.isDirectory()){
			return true;
		}
		return false;
	}

	/**
	 * Methode retournant la description du filtre.
	 * @return la description du filtre
	 */
	public String getDescription()
	{
	return this.description + "(*" + extension + ")";
	}
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
	
	
	



	}
