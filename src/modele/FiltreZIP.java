package modele;

import java.io.File;

public class FiltreZIP extends javax.swing.filechooser.FileFilter
{

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	private String extension;
	private String description;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
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
