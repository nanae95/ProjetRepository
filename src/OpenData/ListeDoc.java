package OpenData;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ListeDoc extends HashMap<Integer,Document> {

	
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
	
	/* La fonction consulter ne prend rien en argument et ne renvoie rien.
	 * Elle affiche la liste des documents de la liste.
	 */
	public void consulter() {
		Set<Entry<Integer, Document>> setList = this.entrySet();
		Iterator<Entry<Integer, Document>> it = setList.iterator();
		StringBuilder res = new StringBuilder("Liste des documents : \n\n");
		res.append("N° notice;	ISBN;	EAN;	Titre;\n");
		while(it.hasNext()) {
			Entry<Integer, Document> e = it.next();
			res.append(e.getValue().toString() + "\n");
		}
		System.out.println(res);
	}
	
}
