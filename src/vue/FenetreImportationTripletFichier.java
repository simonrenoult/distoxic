package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controleur.EcouteurFenetreImportationTripletFichier;

public class FenetreImportationTripletFichier extends JFrame{

	// ----------------------------------------- //
	// ----------------ATRIBUTS----------------- //
	// ----------------------------------------- //
		public static Integer	TAILLE_X	= 400;
		public static Integer	TAILLE_Y	= 200;
		public static String	TITRE		= "Import project";
	
		private JPanel containerPrincipal = new JPanel();
		private JPanel containerInformation = new JPanel();
		private JPanel containerSelectionArchive = new JPanel();
		private JLabel iconeInformation = new JLabel(new ImageIcon("src/images/icones/folder_explore.png"));
		private JLabel message = new JLabel("Select a directory to search for existing Dis'Toxic projects.");
		private JRadioButton impoterArchive = new JRadioButton("S�lectionner une archive .zip");
		private JRadioButton impoterDossier = new JRadioButton("S�lectionner un dossier         ");
		private ButtonGroup groupeBouton = new ButtonGroup();
		private JButton archiveBouton = new JButton("S�lectionner");
		private JButton dossierBouton = new JButton("S�lectionner"); 
	// ----------------------------------------- //
	// --------------CONSTRUCTEURS-------------- //
	// ----------------------------------------- //
		public FenetreImportationTripletFichier(){
			init();
			
			this.setTitle(TITRE);
			this.setSize(new Dimension(TAILLE_X, TAILLE_Y));
			//this.setPreferredSize(new Dimension(TAILLE_X, TAILLE_Y));
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setVisible(true);
		}
	// ----------------------------------------- //
	// -------------INITIALISEURS--------------- //
	// ----------------------------------------- //

		public void init(){
			buildContainerInformation();
			buildContainerSelectionArchive();
			buildContainerPrincipal();
			initEcouteur();
		}
	// ----------------------------------------- //
	// -----------------METHODES---------------- //
	// ----------------------------------------- //

		private void initEcouteur() {
			EcouteurFenetreImportationTripletFichier e = new EcouteurFenetreImportationTripletFichier(this);
			
		}

		private void buildContainerInformation() {
			containerInformation.setPreferredSize(new Dimension(TAILLE_X,TAILLE_Y/4));
			containerInformation.add(iconeInformation);
			containerInformation.add(message);
			//containerInformation.setBackground(new Color(177, 212, 239));
		}

		private void buildContainerSelectionArchive() {
			groupeBouton.add(archiveBouton);
			groupeBouton.add(dossierBouton);
			
			
			JPanel archive = new JPanel();
			archive.add(impoterArchive);
			archive.add(archiveBouton);
			//archive.setBackground(Color.blue);
			
			JPanel dossier = new JPanel();
			dossier.add(impoterDossier);
			dossier.add(dossierBouton);
			//dossier.setBackground(Color.red);
			
			containerSelectionArchive.setPreferredSize(new Dimension(TAILLE_X, (TAILLE_Y/3)*2));
			containerSelectionArchive.add(archive,BorderLayout.NORTH);
			containerSelectionArchive.add(dossier,BorderLayout.SOUTH);
			
		}

		private void buildContainerPrincipal() {
			containerPrincipal.add(containerInformation);
			containerPrincipal.add(containerSelectionArchive);
			this.setContentPane(containerPrincipal);
			
		}

		
	// ----------------------------------------- //
	// ---------------ACCESSEURS---------------- //
	// ----------------------------------------- //
		/**
		 * @return the containerPrincipal
		 */
		public JPanel getContainerPrincipal() {
			return containerPrincipal;
		}

		/**
		 * @param containerPrincipal the containerPrincipal to set
		 */
		public void setContainerPrincipal(JPanel containerPrincipal) {
			this.containerPrincipal = containerPrincipal;
		}

		/**
		 * @return the containerInformation
		 */
		public JPanel getContainerInformation() {
			return containerInformation;
		}

		/**
		 * @param containerInformation the containerInformation to set
		 */
		public void setContainerInformation(JPanel containerInformation) {
			this.containerInformation = containerInformation;
		}

		/**
		 * @return the containerSelectionArchive
		 */
		public JPanel getContainerSelectionArchive() {
			return containerSelectionArchive;
		}

		/**
		 * @param containerSelectionArchive the containerSelectionArchive to set
		 */
		public void setContainerSelectionArchive(JPanel containerSelectionArchive) {
			this.containerSelectionArchive = containerSelectionArchive;
		}

		/**
		 * @return the iconeInformation
		 */
		public JLabel getIconeInformation() {
			return iconeInformation;
		}

		/**
		 * @param iconeInformation the iconeInformation to set
		 */
		public void setIconeInformation(JLabel iconeInformation) {
			this.iconeInformation = iconeInformation;
		}

		/**
		 * @return the message
		 */
		public JLabel getMessage() {
			return message;
		}

		/**
		 * @param message the message to set
		 */
		public void setMessage(JLabel message) {
			this.message = message;
		}

		/**
		 * @return the impoterArchive
		 */
		public JRadioButton getImpoterArchive() {
			return impoterArchive;
		}

		/**
		 * @param impoterArchive the impoterArchive to set
		 */
		public void setImpoterArchive(JRadioButton impoterArchive) {
			this.impoterArchive = impoterArchive;
		}

		/**
		 * @return the impoterDossier
		 */
		public JRadioButton getImpoterDossier() {
			return impoterDossier;
		}

		/**
		 * @param impoterDossier the impoterDossier to set
		 */
		public void setImpoterDossier(JRadioButton impoterDossier) {
			this.impoterDossier = impoterDossier;
		}

		/**
		 * @return the groupeBouton
		 */
		public ButtonGroup getGroupeBouton() {
			return groupeBouton;
		}

		/**
		 * @param groupeBouton the groupeBouton to set
		 */
		public void setGroupeBouton(ButtonGroup groupeBouton) {
			this.groupeBouton = groupeBouton;
		}

		/**
		 * @return the archiveBouton
		 */
		public JButton getArchiveBouton() {
			return archiveBouton;
		}

		/**
		 * @param archiveBouton the archiveBouton to set
		 */
		public void setArchiveBouton(JButton archiveBouton) {
			this.archiveBouton = archiveBouton;
		}

		/**
		 * @return the dossierBouton
		 */
		public JButton getDossierBouton() {
			return dossierBouton;
		}

		/**
		 * @param dossierBouton the dossierBouton to set
		 */
		public void setDossierBouton(JButton dossierBouton) {
			this.dossierBouton = dossierBouton;
		}

	// ----------------------------------------- //
	// ----------------MUTATEURS---------------- //
	// ----------------------------------------- //
}