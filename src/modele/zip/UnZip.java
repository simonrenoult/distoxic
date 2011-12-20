package modele.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * Taille g�n�rique du tampon en lecture et �criture
	 */
	static final int BUFFER = 2048;
	private File zipfile = null;
	private File dest = null;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	public UnZip(String zipfile, String dest){
		this.zipfile = new File(zipfile);
		this.dest = new File(dest);
		
	}
	
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	public boolean zipAction(){
	try {
		ZipInputStream zin = new ZipInputStream(new FileInputStream(zipfile));
		ZipEntry ze;
		while ((ze = zin.getNextEntry()) != null) {
			if (ze.isDirectory()) {
				File dir = new File(dest.getAbsolutePath() + File.separatorChar
						+ ze.getName());
				if (!dir.exists())
					dir.mkdir();
			} else {
				File f = new File(dest.getAbsolutePath() + File.separator
						+ ze.getName());
				if (!f.getParentFile().exists())
					f.getParentFile().mkdirs();
				FileOutputStream out = new FileOutputStream(dest
						.getAbsolutePath()
						+ File.separator + ze.getName());
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
	catch (Exception e) {
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
