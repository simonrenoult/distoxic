
package modele.zip;

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

import modele.WorkspaceModele;

public class Zip {

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
	/**
	 * Taille generique du tampon en lecture et ecriture
	 */
	static final int BUFFER = 2048;
	private String dest = null;
	private String nameFolder = null;
	private String workspace;
	private String nomdossier = null;
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
	public Zip(String nameFolder,String nameZIPFile){
		this.nameFolder = nameFolder;
		this.nomdossier = nameFolder+File.separator;
		this.dest = nameZIPFile;
		WorkspaceModele modele = new WorkspaceModele(1);
		modele.lireFichier();
		this.workspace = modele.getWorkspacePath()+File.separator;
	}
	
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //
	public boolean zipAction(){
		try {
			// creation d'un flux d'ecriture sur fichier
			FileOutputStream dest = new FileOutputStream(this.dest+nameFolder+".zip");
			
			// calcul du checksum : Adler32 (plus rapide) ou CRC32
			CheckedOutputStream checksum = new CheckedOutputStream(dest, new Adler32());
			
			// crï¿½ation d'un buffer d'ecriture
			BufferedOutputStream buff = new BufferedOutputStream(checksum);
			
			// crï¿½ation d'un flux d'ecriture Zip
			ZipOutputStream out = new ZipOutputStream(buff);
			
			// spï¿½cification de la methode de compression
			out.setMethod(ZipOutputStream.DEFLATED);
			
			// spï¿½cifier la qualite de la compression 0..9
			out.setLevel(Deflater.BEST_COMPRESSION);
			 
			// buffer temporaire des donnees a ecriture dans le flux de sortie
			byte data[] = new byte[BUFFER];
			
			// extraction de la liste des fichiers du repertoire courant
			File f = new File(workspace+nameFolder);
			//String files[] = f.list();
			File files[] = f.listFiles();
			
			// pour chacun des fichiers de la liste
			for (int i=0; i<files.length; i++) {
				
				// en afficher le nom
				System.out.println("Adding: "+nomdossier+files[i].getName());
				
				// creation d'un flux de lecture
				FileInputStream fi = new FileInputStream(files[i].getPath());
				
				// creation d'un tampon de lecture sur ce flux
				BufferedInputStream buffi = new BufferedInputStream(fi, BUFFER);
				
				// creation d'en entrïee Zip pour ce fichier
				ZipEntry entry = new ZipEntry(nomdossier+files[i].getName());
				
				// ajout de cette entree dans le flux d'ecriture de l'archive Zip
				out.putNextEntry(entry);
				
				// ecriture du fichier par paquet de BUFFER octets
				// dans le flux d'ecriture
				int count;
				while((count = buffi.read(data, 0, BUFFER)) != -1) {
					out.write(data, 0, count);
				}
				
				// Close the current entry
				out.closeEntry();
				// fermeture du flux de lecture
				buffi.close();
			}
			
			// fermeture du flux d'ecriture
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

