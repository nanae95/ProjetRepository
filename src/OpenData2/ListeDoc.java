package OpenData2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ListeDoc extends HashMap<String,Document> {
	
	/* La fonction ajouter prend en argument un Document renvoie booleen.
	 * Elle ajoute un element a la liste de document courante et renvoie
	 * true si tout s'est bien passe et false si non.
	 */
	public boolean ajouter(Document doc) {
		if(containsKey(doc.getEan())) { //verifie si le document ne fait pas deja partie de la liste
			return false;
		}
		else {
			put(doc.getEan(), doc);			
			return true;
		}
	}
	
	/* La fonction supprimer prend en argument un Document renvoie booleen.
	 * Elle supprime un element a la liste de document courante et renvoie
	 * true si le document à supprimer était bien dans la liste des documents et false si non.
	 */
	
	public boolean supprimer(Document doc) {
		if(containsKey(doc.getEan())) { 
			remove(doc.getEan());
			return true;
		}
		else {	
			return false;
		}
	}
	
	/* La fonction consulter ne prend rien en argument et ne renvoie rien.
	 * Elle affiche la liste des documents de la liste.
	 */
	public void consulter() {
		System.out.println("Liste des documents : \n\n");
		System.out.println("N° notice;	ISBN;	EAN;	Titre;	Date de Publication;\n");
		for(Document doc : this.values()) {
			System.out.println(doc.toString() + "\n");
		}
	}
	
	/* La fonction "rechercheEan" renvoie le document associe au numero EAN donne.
	 * Elle prend en argument un entier correspondant au numero EAN et renvoie le
	 * document associe s'il existe
	 */
	public Document recherche(int ean) {
		return get(ean);
	}
	
	public void consulterNom(String nom) {
		System.out.println("Liste des documents : \n\n");
		System.out.println("N° notice;	ISBN;	EAN;	Titre;	Date de Publication;\n");
		for(Document doc : this.values()) {
			if(doc.getNomAuteur().equals(nom)) {
				System.out.println(doc.toString() + "\n");
			}
		}
	}
	
	public void consulterPrenom(String prenom) {
		System.out.println("Liste des documents : \n\n");
		System.out.println("N° notice;	ISBN;	EAN;	Titre;	Date de Publication;\n");
		for(Document doc : this.values()){
			if(doc.getPrenomAuteur().equals(prenom)) {
				System.out.println(doc.toString() + "\n");
			}
		}
	}
	
	public void consulterNomPrenom(String nom, String prenom) {
		StringBuilder res = new StringBuilder("Liste des documents : \n\n");
		res.append("N° notice;	ISBN;	EAN;	Titre;	Date de Publication;\n");
		for(Document doc : this.values()) {
			if(doc.getNomAuteur().equals(nom)) {
				if(doc.getPrenomAuteur().equals(prenom)) {
					res.append(doc.toString() + "\n");					
				}
			}
		}
		System.out.println(res);
	}
	
	public void consulterType(int dateMin, int dateMax) {
		//(0)autre, (1)bd, (2)carte, (3)cd, (4)jds, (5)jv, (6)partition, (7)revue, (8)vinyle
		int nbTypes[] = {0,0,0,0,0,0,0,0,0};
		String types[] = {Autre.class.getName(), BD.class.getName(), Carte.class.getName(), JeuDeSociete.class.getName(), JeuxVideo.class.getName(), Partition.class.getName(), Revue.class.getName(), Vinyle.class.getName()};
		System.out.println("Liste des documents : \n\n");
		System.out.println("N° notice;	ISBN;	EAN;	Titre;	Date de Publication;\n");
		for(Document doc : this.values()) {
			if(doc.getDatePubli() >= dateMin && doc.getDatePubli() <= dateMax) {
				for(int i = 0; i<9 ; i++) {
					if(doc.getClass().getName().equals(types[0])) nbTypes[0] ++;					
				}
			}
		}
		System.out.println( types[1] + " BD, " + types[2] + " cartes, " + types[3] + " CD, " + 
							types[4] + " jeux de societe, " +  types[5] + " jeux video, " + types[6] +
							" partitions, " +  types[7] + " revue ets " + types[8] + 
							" vinyles ont été publiés entre " + dateMin + " et " + dateMax + " ");
	}
}
