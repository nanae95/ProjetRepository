package OpenData2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListeSerie extends HashMap<String, ArrayList> {

	/* La fonction ajouter prend en argument un Document renvoie booleen.
	 * Elle ajoute un element a la liste de document courante et renvoie
	 * true si tout s'est bien passe et false si non.
	 */
	public boolean ajouter(Document doc) {
		if(containsKey(doc.getTitreSerie())) { //verifie si le document ne fait pas deja partie de la liste
			ArrayList<String> newListe = (ArrayList<String>)get(doc.getTitreSerie()).clone();
			newListe.add(doc.getEan());
			put(doc.getTitreSerie(), newListe);
			return true;	
		}
		else {			
			ArrayList<String> newListe = new ArrayList<String>();
			newListe.add(doc.getEan());
			put(doc.getTitreSerie(), newListe);
			return true;
		}
	}
	
	/* La fonction "tri" trie les documents du même serie par rapport
	 * a leur date de publication.
	 * Elle prend en argument une ArrayListe de document et renvoie
	 * cette ArrayList trié.
	 */
	public ArrayList<Document> tri(ArrayList<Document> serie) {
		Comparator<Document> docComp = new DocumentComparator();
		Collections.sort(serie, docComp);
		return serie;
	}
	
	/* La fonction consulter ne prend rien en argument et ne renvoie rien.
	 * Elle affiche la liste des documents d'une serie.
	 */
	public void consulter(String serie, ListeDoc liste) {
		ArrayList<Integer> listeEan = (ArrayList<Integer>) tri(get(serie)).clone();
		ArrayList<Document> listeDoc = new ArrayList<Document>();
		for(int i : listeEan) {
			listeDoc.add(liste.get(i));
		}
		tri(listeDoc);
		System.out.println("Liste des documents de la serie " + serie + " : \n\n");
		System.out.println("N° notice;	ISBN;	EAN;	Titre;	Date de Publication;\n");
		for(Document doc : (ArrayList<Document>)get(serie)) {
			System.out.println(doc + "\n");
		}
	}
}
