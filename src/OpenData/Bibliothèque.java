package OpenData;

import java.util.ArrayList;

public class Bibliothèque {
	private String nom;
	private ArrayList <Utilisateur> listeInscrits;	//liste des inscrits de la bibliothèque
	private ListeDoc listeDocs;						//liste des documents de la bibliothèque
	
	public Bibliothèque() {
		nom = "";
		ArrayList <Utilisateur> listeInscrits = new ArrayList<Utilisateur>();
		ArrayList <Document> listeDoc = new ArrayList<Document>();
	}
	
	public Bibliothèque(String nom, ArrayList <Utilisateur> listeInscrits, ListeDoc listeDocs) {
		this.nom = nom;
		this.listeInscrits = listeInscrits;
		this.listeDocs =listeDocs;
		
	}
	
	//permet d'inscrire un utilisateur dans la bibliothèque
	public void Inscrire(Utilisateur inscrit) {
		listeInscrits.add(inscrit);				
	
	}
	
	public void echange(Bibliothèque b2, Document d1, Document d2) {
		this.Bibliothèque.
	}
	
	
}


