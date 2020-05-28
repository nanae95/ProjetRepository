package OpenData;

public class Utilisateur {
	private int quotaDoc; //quota de documents imposé à l'utilisateur
	private int nbDoc; //nombre de document emprunté par l'utilisateur
	private String nom;
	private String prenom;
	private int IdUtilisateur;
	
	public Utilisateur() {
		nom = "";
		prenom = "";
		IdUtilisateur = 0;
		quotaDoc = 0;
		nbDoc = 0;
	}
	
	public Utilisateur(int quotaDoc, int nbDoc, String nom, String prenom, int IdUtilisateur)
	{
		this.quotaDoc = quotaDoc;
		this.nbDoc = nbDoc;
		this.nom = nom;
		this.prenom = prenom;
		this.IdUtilisateur = IdUtilisateur;	
	}
	
	public void SetquotaDoc(int quotaDoc) {
		this.quotaDoc= quotaDoc;	
	}
	
	public void emprunt(Document Doc) {
		if(nbDoc++ <= quotaDoc) && (Doc.getDispo()== true) {
			nbDoc ++;
			Doc.setDispo();
		}
		//dans l'autre cas besoin message erreur
		// besoin de la bibliothèque ?
	}
	
	public void remise(Document Doc) {
		nbDoc --;
		Doc.setDispo();
	}
	
}
