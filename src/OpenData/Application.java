package OpenData;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	
	ArrayList<String[]> data;
	ArrayList<Bibliotheque> listeBibli;
	ListeDoc lesDocs;
	ListeLivre lesLivres;
	ListeSerie lesSeries;
	ListeSerieLivre lesSeriesLivres;
	
	public Application() {
		data = new ArrayList<String[]>();
		listeBibli = new ArrayList<Bibliotheque>();
		lesDocs = new ListeDoc();
		lesLivres = new ListeLivre();
		lesSeries = new ListeSerie();
		lesSeriesLivres = new ListeSerieLivre();
        String[] bibliotheques = {"Aime Cesaire", "Edmond Rostand", "Jean Pierre Melville", "Oscar Wilde", "Saint Simon" };
		for(String str : bibliotheques) {
			listeBibli.add(new Bibliotheque(str));
		}
	}
	
	public ArrayList<Bibliotheque> getListeBibli() {
		return listeBibli;
	}	
	
	public ListeDoc getLesDocs() {
		return lesDocs;
	}
	
	public ListeLivre getLesLivres() {
		return lesLivres;
	}
	
	public ListeSerie getLesSeries() {
		return lesSeries;
	}
	
	public ListeSerieLivre getLesSeriesLivres() {
		return lesSeriesLivres;
	}
	
	public void creerBiblio() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Entrez le nom de la nouvelle bibliothèque :");
		String nomBiblio = sc2.nextLine();
		new Bibliotheque(nomBiblio);
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
		//new Document(numNotice ,ean ,titre ,datePub );
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
	
	//la fonction echanger permet à 2 bibliothèques de s'échanger 2 documents
		public void echanger(Bibliotheque b2, Document d1, Document d2) {
			/*.getListeDocs().supprimer(d1);
			listeDocs.ajouter(d2.getEan());
			b2.listeDocs.supprimer(d2);
			b2.listeDocs.ajouter(d1);*/
		}
	
	public void consulterSerie() {
		Scanner sc5 = new Scanner(System.in);
		System.out.println("Entrez le nom de la série :");
		String serie = sc5.nextLine();
	}
	
	public void consulterDocAuteur() {
		
	}
	
	public int afficherMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ###### \n #MENU# \n ###### \n 1-Ajouter une nouvelle bibliothèque \n 2-Ajouter un nouveau document \n 3-Ajouter un nouvel utilisateur \n 4-Consulter l'ensemble des document \n 5-Consulter une série \n 6-Consulter les documents d'un auteur \n 7-Rechercher un livre par son IBN \n 8-Rechercher un document par son EAN \n 9-Consulter le nombre de document d'un type publié dans un intervalle de temps");
		System.out.println("Entrez le numéro correspondant à votre choix");
		int res = sc.nextInt();
		return res;
	}
	
	public boolean menu(int res) {
		switch(res) {
		case 1: creerBiblio();return true;
		case 2: creerDoc();return true;
		case 3: creerUtil();return true;
		//case 4: consulterTousDoc();return true;
		case 5: consulterSerie();return true;
		case 6: consulterDocAuteur();return true;
		//case 7: rechercheISBN();return true;
		//case 8: rechercheEAN();return true;
		//case 9: rechercheDocType();return true;
		case 10: return exit();
		default:{System.out.println("votre choix n'est pas valide"); return true;}
		}	
	}
	
	public boolean exit() {
		return false;
	}

}
