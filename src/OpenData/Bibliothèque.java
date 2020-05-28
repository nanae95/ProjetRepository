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
	
	//la fonction echanger permet � 2 biblioth�ques de s'�changer 2 documents
	public void echanger(Biblioth�que b2, Document d1, Document d2) {
		listeDocs.supprimer(d1);
		listeDocs.ajouter(d2);
		b2.listeDocs.supprimer(d2);
		b2.listeDocs.ajouter(d1);
	}
	
	
}


