package modele.Zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * Taille g�n�rique du tampon en lecture et �criture
	 */
	static final int BUFFER = 2048;
	private String zipNameFolder = null;
	private String nameFolder = null;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	public Zip(String nameFolder,String nameZIPFile){
		this.nameFolder = nameFolder;
		this.zipNameFolder = nameZIPFile;
		
	}
	
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	public boolean zipAction(){
		try {
			// cr�ation d'un flux d'�criture sur fichier
			FileOutputStream dest = new FileOutputStream(zipNameFolder);
			
			// calcul du checksum : Adler32 (plus rapide) ou CRC32
			CheckedOutputStream checksum = new CheckedOutputStream(dest, new Adler32());
			
			// cr�ation d'un buffer d'�criture
			BufferedOutputStream buff = new BufferedOutputStream(checksum);
			
			// cr�ation d'un flux d'�criture Zip
			ZipOutputStream out = new ZipOutputStream(buff);
			
			// sp�cification de la m�thode de compression
			out.setMethod(ZipOutputStream.DEFLATED);
			
			// sp�cifier la qualit� de la compression 0..9
			out.setLevel(Deflater.BEST_COMPRESSION);
			 
			// buffer temporaire des donn�es � �criture dans le flux de sortie
			byte data[] = new byte[BUFFER];
			
			// extraction de la liste des fichiers du r�pertoire courant
			File f = new File(nameFolder);
			//String files[] = f.list();
			File files[] = f.listFiles();
			for (int i=0; i<files.length; i++) {
				System.out.println("Adding: "+files[i].getAbsolutePath());
			}
			
			// pour chacun des fichiers de la liste
			for (int i=0; i<files.length; i++) {
				
				// en afficher le nom
				System.out.println("Adding: "+files[i]);
				
				// cr�ation d'un flux de lecture
				FileInputStream fi = new FileInputStream(files[i]);
				
				// cr�ation d'un tampon de lecture sur ce flux
				BufferedInputStream buffi = new BufferedInputStream(fi, BUFFER);
				
				// cr�ation d'en entr�e Zip pour ce fichier
				ZipEntry entry = new ZipEntry(files[i].getPath());
				
				// ajout de cette entr�e dans le flux d'�criture de l'archive Zip
				out.putNextEntry(entry);
				
				// �criture du fichier par paquet de BUFFER octets
				// dans le flux d'�criture
				int count;
				while((count = buffi.read(data, 0, BUFFER)) != -1) {
					out.write(data, 0, count);
				}
				
				// Close the current entry
				out.closeEntry();
				// fermeture du flux de lecture
				buffi.close();
			}
			
			// fermeture du flux d'�criture
			out.close();
			buff.close();
			checksum.close();
			dest.close();
			//System.out.println("checksum: " + checksum.getChecksum().getValue());
			// traitement de toute exception         
		} catch(Exception e) {
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
