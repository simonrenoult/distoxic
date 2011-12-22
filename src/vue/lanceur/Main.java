package vue.lanceur;

import vue.FenetreChoixWorkspace;
import vue.FenetrePrincipale;
import controleur.EcouteurFenetreWorkspace;
import modele.WorkspaceModele;

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
