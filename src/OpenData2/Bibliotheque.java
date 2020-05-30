package OpenData2;

import java.util.ArrayList;

public class Bibliotheque {
	
	private String nom;
	private ArrayList <Utilisateur> listeInscrits;	//liste des inscrits de la bibliothèque
	private ListeDoc listeDocs; //liste des numero EAN et ISBN des documents de la bibliotheque
	private ListeLivre listeLivres;
	private ListeSerie listeSeries;
	
	public Bibliotheque() {
		nom = "";
		listeInscrits = new ArrayList<Utilisateur>();
		listeDocs = new ListeDoc();
		listeLivres = new ListeLivre();
		listeSeries = new ListeSerie();
	}
	
	public Bibliotheque(String nom) {
		this.nom = nom;
		listeInscrits = new ArrayList<Utilisateur>();
		listeDocs = new ListeDoc();
		listeLivres = new ListeLivre();
		listeSeries = new ListeSerie();
	}
	
	public String getNom() {
		return nom;
	}
	
	public ListeDoc getListeDocs() {
		return listeDocs;
	}
	
	public ListeLivre getListeLivres() {
		return listeLivres;
	}
	
	public ListeSerie getListeSeries() {
		return listeSeries;
	}
	
	public ArrayList<Utilisateur> getListeInscrits() {
		return listeInscrits;
	}
	
	//permet d'inscrire un utilisateur dans la bibliothèque
	public void inscrire(Utilisateur inscrit) {
		listeInscrits.add(inscrit);
	}
	
	public void emprunter(Bibliotheque b2, Document d2) {
		listeDocs.ajouter(d2);
		b2.getListeDocs().supprimer(d2);
	}
	
	public void rendre(Bibliotheque b2, Document d2) {
		listeDocs.supprimer(d2);
		b2.getListeDocs().ajouter(d2);
	}
	
	
}


