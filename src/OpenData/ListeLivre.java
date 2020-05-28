package OpenData;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class ListeLivre extends ListeDoc {

	/* La fonction ajouter prend en argument un Document renvoie booleen.
	 * Elle ajoute un element a la liste de document courante et renvoie
	 * true si tout s'est bien passe et false si non.
	 */
	@Override
	public boolean ajouter(Document livre) {
		if(containsKey(((Livre) livre).getIsbn())) { //verifie si le document ne fait pas deja partie de la liste
			return false;
		}
		else {
			put(((Livre) livre).getIsbn(), livre);			
			return true;
		}
	}
}
