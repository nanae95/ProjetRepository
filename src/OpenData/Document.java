package OpenData;

public abstract class Document {
	boolean dispo; //disponibilité du document
	int numNotice; //numéro de notice
	int ean; //numéro ean
	boolean serie; //fait partie d'une série
	String titre_serie; //si serie = 1, titre_serie = titre de la série auquel il appartient
	
}
