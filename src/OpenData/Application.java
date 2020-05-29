package OpenData;

import java.util.Scanner;

public class Application {
	
	public void creerbiblio() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Entrez le nom de la nouvelle bibliothèque :");
		String nomBiblio = sc2.nextLine();
		new Bibliothèque(nomBiblio);
	}
	
	public void creerDoc() {
		//verifier ean isbn et ajouter liste doc
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Entrez le numéro de notice :");
		int numNotice = sc3.nextInt();
		System.out.println("Entrez l'EAN :");
		int ean = sc3.nextInt();
		System.out.println("Entrez le titre du document :");
		String titre = sc3.nextLine();
		System.out.println("Entrez sa date de publication :");
		int datePub = sc3.nextInt();
		System.out.println("Entrez le type du document :");
		String type = sc3.nextLine();
		new Document(numNotice ,ean ,titre ,datePub, type );
		System.out.println("Document créé");
	}
	
	public void creerUtil() {
		Scanner sc4 = new Scanner(System.in);
		System.out.println("Entrez le prénom de l'utilisateur :");
		String prenom = sc4.nextLine();
		System.out.println("Entrez le nom de l'utilisateur :");
		String nom = sc4.nextLine();
		System.out.println("Entrez son quota de documents :");
		int quotaDoc = sc4.nextInt();
		new Utilisateur(quotaDoc, 0, nom, prenom);
		System.out.println("Utilisateur créé");
	}
	
	public void consulterTousDoc() {

	}
	
	public void consulterSerie() {
		Scanner sc5 = new Scanner(System.in);
		System.out.println("Entrez le nom de la série :");
		String serie = sc5.nextLine();
	}
	
	public void consulterDocAuteur() {
		Scanner sc6 = new Scanner(System.in);
		System.out.println("Entrez votre choix : \n 1-Recherche par prénom et nom de l'auteur \n 2-Recherche par prénom de l'auteur \n 3-Recherche par nom de l'auteur"  );
		int i  = sc6.nextInt();
		if (i=1) {
			System.out.println("Entrez le nom :");
			String nom = sc6.nextLine();
			System.out.println("Entrez le prénom :");
			String prenom = sc6.nextLine();
			ListeDoc.consulterNomPrenom(nom,prenom);
		}
		if(i=2) {
			System.out.println("Entrez le prénom :");
			String prenom = sc6.nextLine();
			ListeDoc.consulterPrenom(prenom);
		}
		if(i=3) {
			System.out.println("Entrez le nom :");
			String nom = sc6.nextLine();
			ListeDoc.consulterNom(nom);
		}
		else {
			//error
			System.out.println("Votre choix n'est pas valable");
		}
	}
	
	public void rechercheISBN() {
		
	}
	
	public void rechercheEAN() {
		
	}
	
	public void rechercheDocType() {
		Scanner sc7 = new Scanner(System.in);
		System.out.println("Entrez le type :");
		String type = sc7.nextLine();
		System.out.println("Date de publication minimale des documents recherchés :");
		int dateMin = sc7.nextInt();
		System.out.println("Date de publication maximale des documents recherchés :");
		int dateMax = sc7.nextInt();
		ListeDoc.consulterType(type, dateMin, dateMax);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ###### \n #MENU# \n ###### \n 1-Ajouter une nouvelle bibliothèque \n 2-Ajouter un nouveau document \n 3-Ajouter un nouvel utilisateur \n 4-Consulter l'ensemble des document \n 5-Consulter une série \n 6-Consulter les documents d'un auteur \n 7-Rechercher un livre par son IBN \n 8-Rechercher un document par son EAN \n 9-Consulter le nombre de document d'un type publié dans un intervalle de temps");
		System.out.println("Entrez le numéro correspondant à votre choix");
		int str = sc.nextInt();
		menu(str);
		
		
		
	}
	
	public void menu(int str) {
		switch(str) {
		case 1: creerbiblio();break;
		case 2: creerDoc();break;
		case 3: creerUtil();break;
		case 4: consulterTousDoc();break;
		case 5: consulterSerie();break;
		case 6: consulterDocAuteur();break;
		case 7: rechercheISBN();break;
		case 8: rechercheEAN();break;
		case 9: rechercheDocType();break;
		default:{System.out.println("votre choix n'est pas valide");
		}
		};	
	}

}
