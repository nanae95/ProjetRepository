package OpenData2;

public class Utilisateur {
	private int quotaDoc; //quota de documents imposé à l'utilisateur
	private int nbDoc; //nombre de document emprunté par l'utilisateur
	private String nom;
	private String prenom;

	public Utilisateur() {
		nom = "";
		prenom = "";
		quotaDoc = 0;
		nbDoc = 0;
	}
	
	public Utilisateur(int quotaDoc, int nbDoc, String nom, String prenom)
	{
		this.quotaDoc = quotaDoc;
		this.nbDoc = nbDoc;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public void SetquotaDoc(int quotaDoc) {
		this.quotaDoc= quotaDoc;	
	}
	
	
	public void emprunt(Document Doc) {
		if((nbDoc++ <= quotaDoc) && ( Doc.getDispo()== true)) {
			nbDoc ++;
			Doc.setDispo();
			
			
		}
	}
	
	public void remise(Document Doc) {
		nbDoc --;
		Doc.setDispo();
	}
	
}
