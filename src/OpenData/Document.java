package OpenData;

public abstract class Document {
	boolean dispo; //disponibilit� du document
	int numNotice; //num�ro de notice
	int ean; //num�ro ean
	boolean serie; //fait partie d'une s�rie
	String titre_serie; //si serie = 1, titre_serie = titre de la s�rie auquel il appartient
	
}
