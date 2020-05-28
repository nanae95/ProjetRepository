package OpenData;

import java.util.ArrayList;

public class Biblioth�que {
	private String nom;
	private ArrayList <Utilisateur> listeInscrits;	
	private ArrayList <Document> listeDocs;
	//dans une biblioth�que besoin d'une liste de documents ?
	
	public Biblioth�que() {
		nom = "";
		ArrayList <Utilisateur> listeInscrits = new ArrayList<Utilisateur>();
		ArrayList <Document> listeDoc = new ArrayList<Document>();
	}
	
	public Biblioth�que(String nom, ArrayList <Utilisateur> listeInscrits, ArrayList <Document> listeDocs) {
		this.nom = nom;
		this.listeInscrits = listeInscrits;
		this.listeDocs =listeDocs;
		
	}
	
	public void Inscrire(Utilisateur inscrit) {
		listeInscrits.add(inscrit);
	
	}
	
}


