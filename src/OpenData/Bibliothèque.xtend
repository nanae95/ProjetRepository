package OpenData;

import OpenData.Document;
import OpenData.Utilisateur;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Bibliothèque {
  private String nom;
  
  private ArrayList<Utilisateur> listeInscrits;
  
  private ArrayList<Document> listeDocs;
  
  public Bibliothèque() {
    this.nom = "";
    ArrayList<Utilisateur> listeInscrits = new ArrayList<Utilisateur>();
    ArrayList<Document> listeDoc = new ArrayList<Document>();
  }
  
  public Bibliothèque(final String nom, final ArrayList<Utilisateur> listeInscrits, final ArrayList<Document> listeDocs) {
    this.nom = nom;
    this.listeInscrits = listeInscrits;
    this.listeDocs = listeDocs;
  }
  
  public void Inscrire(final Utilisateur inscrit) {
    this.listeInscrits.add(inscrit);
  }
}