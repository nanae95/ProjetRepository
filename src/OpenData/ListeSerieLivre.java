package OpenData;

import java.util.ArrayList;

public class ListeSerieLivre extends ListeSerie {

	public boolean ajouter(Document doc) {
		//VERIFIER SI C EST UN LIVRE
		if(containsKey(doc.getTitreSerie())) { //verifie si le document ne fait pas deja partie de la liste
			ArrayList<Integer> newListe = (ArrayList<Integer>)get(doc.getTitreSerie()).clone();
			newListe.add(((Livre) doc).getIsbn());
			put(doc.getTitreSerie(), newListe);
			return true;	
		}
		else {			
			ArrayList<Integer> newListe = new ArrayList<Integer>();
			newListe.add(((Livre) doc).getIsbn());
			put(doc.getTitreSerie(), newListe);
			return true;
		}
	}
}