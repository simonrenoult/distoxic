package vue;

import controleur.EcouteurFenetreWorkspace;
import modele.WorkspaceModele;

public class Main
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		WorkspaceModele modele = new WorkspaceModele(0);
		if(!modele.workspaceExistant()){
			//System.err.println("Le worspace n'a pas �t� trouv�");
			
			FenetreChoixWorkspace fe = new FenetreChoixWorkspace(modele);
			EcouteurFenetreWorkspace e  = new EcouteurFenetreWorkspace(fe);
			while(!e.isLancerFenetrePrincipale()){}
			FenetrePrincipale f = new FenetrePrincipale();
		}
		else{
			//System.out.println("Le worspace a �t� trouv�");
			FenetrePrincipale f = new FenetrePrincipale();
		}
		
	}
		
}
