package OpenData;

import java.util.ArrayList;

public class Biblioth�que {
	private String nom;
	private ArrayList <Utilisateur> listeInscrits;	//liste des inscrits de la biblioth�que
	private ListeDoc listeDocs;						//liste des documents de la biblioth�que
	
	public Biblioth�que() {
		nom = "";
		ArrayList <Utilisateur> listeInscrits = new ArrayList<Utilisateur>();
		ArrayList <Document> listeDoc = new ArrayList<Document>();
	}
	
	public Biblioth�que(String nom, ArrayList <Utilisateur> listeInscrits, ListeDoc listeDocs) {
		this.nom = nom;
		this.listeInscrits = listeInscrits;
		this.listeDocs =listeDocs;
		
	}
	
	//permet d'inscrire un utilisateur dans la biblioth�que
	public void Inscrire(Utilisateur inscrit) {
		listeInscrits.add(inscrit);				
	
	}
	
	public void echange(Biblioth�que b2, Document d1, Document d2) {
		this.Biblioth�que.
	}
	
	
}


