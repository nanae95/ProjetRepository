package OpenData;

import java.util.Comparator;

public class DocumentComparator implements Comparator<Document> {

	/* La redéfinition de la fonction "compare" compare deux
	 * document en fonction de leur date de publication.
	 * Elle prend en argument deux Document doc1 et doc2
	 * Elle renvoie : 	-1 si doc1 < doc2
	 * 					 0 si doc1 = doc2
	 * 					 1 si doc1 > doc2
	 * 
	 */
	@Override
	public int compare(Document doc1, Document doc2) {
		if(doc1.getDatePubli()<doc2.getDatePubli()) {
			return -1; 
		}
		else {
			if(doc1.getDatePubli()<doc2.getDatePubli()) {
				return -1;
			}
			else return 0;
		}
	}

}
