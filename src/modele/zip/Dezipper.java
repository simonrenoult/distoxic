package modele.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Dezipper
{
	/**
	 * <h4>Dezipper est la classe permettant la decompression d'une archive.zip</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE & Simon RENOULT
	 */
	// ----------------------------------------- //
	// --------------- CONSTANTES -------------- //
	// ----------------------------------------- //

	/**
	 * Taille generique du tampon en lecture et ecriture
	 */
	@SuppressWarnings("unused")
	private final static int	BUFFER	= 2048;

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * archive zip
	 */
	private File				zipfile	= null;
	/**
	 * Dossier de destination
	 */
	private File				dest	= null;

	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	/**
	 * Constructeur principal de la classe Dezipper
	 * @param zipfile le chemin de l'archive .zip
	 * @param dest le chemin de destination
	 */
	public Dezipper(String zipfile, String dest)
	{
		this.zipfile = new File(zipfile);
		this.dest = new File(dest);

	}

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	/**
	 * Methode permettant de dezipper l'archive vers le repsertoire de destination.
	 * @return
	 */
	public boolean zipAction()
	{
		try
		{
			ZipInputStream zin = new ZipInputStream(new FileInputStream(zipfile));
			ZipEntry ze;
			while ((ze = zin.getNextEntry()) != null)
			{
				if (ze.isDirectory())
				{
					File dir = new File(dest.getAbsolutePath() + File.separatorChar + ze.getName());
					if (!dir.exists())
						dir.mkdir();
				}
				else
				{
					File f = new File(dest.getAbsolutePath() + File.separator + ze.getName());
					if (!f.getParentFile().exists())
						f.getParentFile().mkdirs();
					FileOutputStream out = new FileOutputStream(dest.getAbsolutePath() + File.separator + ze.getName());
					byte[] buff = new byte[1024];
					int read;
					while ((read = zin.read(buff)) > -1)
						out.write(buff, 0, read);
					out.flush();
					out.close();
				}
			}
			zin.closeEntry();
			zin.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}
