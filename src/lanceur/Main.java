package lanceur;

import controleur.EcouteurFenetreWorkspace;
import modele.WorkspaceModele;
import vue.FenetreChoixWorkspace;
import vue.FenetrePrincipale;

public class Main
{
	/**
	 * <h4>Main est la classe appelle au debut du programme</h4>
	 * 
	 * 
	 * @author Alexis CHRETIENNE
	 * @author Simon RENOULT
	 */

	/**
	 * Methode principale du programme
	 * 
	 * @param args
	 *            tableau de parametre
	 */
	
	public static void main(String[] args)
	{
		System.setProperty("file.encoding", "UTF-8");

		WorkspaceModele modele = new WorkspaceModele(0);
		if (!modele.workspaceExistant())
		{
			FenetreChoixWorkspace fe = new FenetreChoixWorkspace(modele);
			fe.setVisible(true);
			@SuppressWarnings("unused")
			EcouteurFenetreWorkspace e = new EcouteurFenetreWorkspace(fe, modele);
		}
		else
		{
			FenetrePrincipale f = new FenetrePrincipale();
			f.setVisible(true);
			
		}

	}

}
