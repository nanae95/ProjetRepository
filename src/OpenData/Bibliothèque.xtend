package OpenData

import java.util.ArrayList

class Biblioth�que {
	String nom
	ArrayList<Utilisateur> listeInscrits
	ArrayList<Document> listeDocs

	// dans une biblioth�que besoin d'une liste de documents ?
	new() {
		nom = ""
		var ArrayList<Utilisateur> listeInscrits = new ArrayList<Utilisateur>()
		var ArrayList<Document> listeDoc = new ArrayList<Document>()
	}

	new(String nom, ArrayList<Utilisateur> listeInscrits, ArrayList<Document> listeDocs) {
		this.nom = nom
		this.listeInscrits = listeInscrits
		this.listeDocs = listeDocs
	}

	def void Inscrire(Utilisateur inscrit) {
		listeInscrits.add(inscrit)
	}
}
