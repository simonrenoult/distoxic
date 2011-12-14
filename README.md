Dis'Toxic
=========

##Qu'est-ce ?


Distoxic se veut être un logiciel d'affichage et d'édition de fichiers issus du GREYC, fichiers contenant des fragments moléculaires dont un certain nombre représente des fragments catalyseurs de toxicités.

Pour plus de détail, constultez le [Sujet](https://github.com/distoxic/distoxic/blob/master/projet.pdf)

##Qui ?

Nous sommes deux étudiants en deuxième année de D.U.T. Informatique :

*  G4llic4 ;
*  Xelais ;

#TODO

*Légende : ( Priorité de niveau 5 ) > ( Priorité de niveau 1 ).*

##Menus :

- **( 2 )** : Menu permettant d'éditer les préférences :
  + Ouverture d'un fichier dans un nouvel onglet ou en écrasant l'onglet courant.
     
##BarreOutils :

- **( 1 )** Diviser le code de chacune des toolbars en autant de classes. 

##Workspace :

- **( 4 )** Rafraichissement automatique du workspace.
- **( 1 )** Menu contextuel sur le clic droit :
	+ Nouveau Workspace, Importer, Exporter, Renommer Fichier/Répertoire.

##Onglets :

- **( 4 )** Onglet offrant la possibilité d'ouvrir un nouvel onglet :
	+ Equivalent Fichier::Nouveau.
		
##Editeurs :

- **( 4 )** Cases des JTables éditables.
- **( 4 )** Ajouter lignes aux JTables.
	+ Générer fichiers en conséquence.
- **( 4 )** Tris JTables. 
- **( 3 )** Réduire une table via les SplitPane.
- **( 3 )** Booléen indiquant si une JTable a été modifiée :
	+ Fenêtre pop-up demandant d'enregistrer ou non les modifications efectuées.
- **( 3 )** Editeur générique duquel hérite les 3 autres éditeurs :
	+ Attributs communs JTable, JTableModel, etc.
- **( 2 )** Ajout d'un JFileChooser dans les panels d'éditeurs vides :
	+ Synchroniser avec le workspace.
	+ Filtre sur fichiers se terminant par .bin :
- **( 2 )** Changer la couleur de la bordure du jpanel focused ;
- **( 2 )** Colorer une ligne sur deux les JTable ;

##Config :
 
- **( 3 )** Envisager la creation de fichiers de configuration des constantes de classes.

##Versions :


##Finalité :

- **( 3 )** Créer un jar exécutable.
