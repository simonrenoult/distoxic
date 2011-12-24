package src.vue.lanceur;

import src.controleur.EcouteurFenetreWorkspace;
import src.modele.WorkspaceModele;
import src.vue.FenetreChoixWorkspace;
import src.vue.FenetrePrincipale;

public class Main
{
	public static void main(String[] args)
	{
		System.setProperty("file.encoding", "UTF-8");

		WorkspaceModele modele = new WorkspaceModele(0);
		if (!modele.workspaceExistant())
		{
			// System.err.println("Le worspace n'a pas �t� trouv�");
			try
			{
				FenetreChoixWorkspace fe = new FenetreChoixWorkspace(modele);
				EcouteurFenetreWorkspace e = new EcouteurFenetreWorkspace(fe, modele);
				while (!e.isLancerFenetrePrincipale());
				FenetrePrincipale f = new FenetrePrincipale();
				f.setVisible(true);
			}
			catch (Exception e)
			{
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else
		{
			// System.out.println("Le worspace a �t� trouv�");
			try
			{
				FenetrePrincipale f = new FenetrePrincipale();
				f.setVisible(true);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}
