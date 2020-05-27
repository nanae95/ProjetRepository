package OpenData;

import java.util.ArrayList;

public class ListeDoc extends ArrayList<Document> {

	
	/* La fonction ajouter prend en argument un Document renvoie booleen.
	 * Elle ajoute un element a la liste de document courante et renvoie
	 * true si tout s'est bien passe et false si non.
	 */
	public boolean ajouter(Document doc) {
		if(contient(doc)) { //verifie si le document ne fait pas deja partie de la liste
			return false;
		}
		else {
			add(doc);
			return true;
		}
	}
	
	public ArrayList<Document> extractSerie(String nomSerie) {
		ArrayList<Document> liste = new ArrayList<Document>();
		for(Document doc : this) {
			if(doc.getTitreSerie() == nomSerie) {
				liste.add(doc);
			}
		}
		return liste;
	}
	
	/* La fonction contient prend en argument un Document et retourne un booleen.
	 * Si le Document passe en argument est contenu dans la liste, alors "contient"
	 * renvoie true, sinon elle renvoie false.
	 */
	public boolean contient(Document doc) {
		for(Document elem : this) {
			if(elem instanceof Livre) {
				if(((Livre) doc).getIsbn() == ((Livre)elem).getIsbn()) return true;
			}
			if(doc.getEan()==elem.getEan()) return true;
		}
		return false;
	}
	/* La fonction consulter ne prend rien en argument et ne renvoie rien.
	 * Elle affiche la liste des documents de la liste.
	 */
	public void consulter() {
		StringBuilder res = new StringBuilder("Liste des documents : \n\n");
		res.append("N° notice;	ISBN;	EAN;	Titre;\n");
		for(Document doc : this) {
			res.append(doc.toString() + "\n");
		}
		System.out.println(res);
	}
	
	public void consulterS(String nomSerie) {
		StringBuilder res = new StringBuilder("Liste des documents de la série " + nomSerie + " : \n");
		res.append("N° notice;	ISBN;	EAN;	Titre;\n");
		for(Document doc : this) {
			if(doc.getTitreSerie() == nomSerie) {
				res.append(doc.toString() + "\n");
			}
		}
		System.out.println(res);
	}
}
