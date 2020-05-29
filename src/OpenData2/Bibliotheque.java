package OpenData2;

import java.util.ArrayList;

public class Bibliotheque {
	private String nom;
	private ArrayList <Utilisateur> listeInscrits;	//liste des inscrits de la bibliothèque
	private ArrayList<String> listeDocs; //liste des numero EAN et ISBN des documents de la bibliotheque						//liste des documents de la bibliothèque
	
	
	public Bibliotheque() {
		nom = "";
		listeInscrits = new ArrayList<Utilisateur>();
		listeDocs = new ArrayList<String>();
	}
	
	public Bibliotheque(String nom) {
		this.nom = nom;
		listeInscrits = new ArrayList<Utilisateur>();
		listeDocs = new ArrayList<String>();
		
	}
	
	//permet d'inscrire un utilisateur dans la bibliothèque
	public void inscrire(Utilisateur inscrit) {
		listeInscrits.add(inscrit);				
	
	}
	
	//la fonction echanger permet à 2 bibliothèques de s'échanger 2 documents
	/*public void echanger(Bibliotheque b2, Document d1, Document d2) {
		listeDocs.supprimer(d1);
		listeDocs.ajouter(d2.getEan());
		b2.listeDocs.supprimer(d2);
		b2.listeDocs.ajouter(d1);
	} DEPLACER DANS APPLICATION*/
	
	//permet de supprimer un document si il existe dans la liste
	public void supprimer(String doc) {
		if(listeDocs.contains(doc)) listeDocs.remove(doc);
	}
	
	//permet d'ajouter un document si il n'existe pas dans la liste
	public void ajouter(String doc) {
		if(!(listeDocs.contains(doc))) listeDocs.add(doc);
	}
	
}


