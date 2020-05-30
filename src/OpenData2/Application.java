package OpenData2;

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
		listeBibli.add(new Bibliotheque(nomBiblio));
		System.out.println("Bibliothèque créée!\n Que voulez vous faire ensuite ?\n");
	}
	
	public boolean creerDoc() {
		
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Entrez l'EAN :");
		String ean = sc3.nextLine();
		System.out.println("Entrez le titre du document :");
		String title = sc3.nextLine();
		System.out.println("Entrez le nom de l'éditeur :");
		String publisher = sc3.nextLine();
		System.out.println("Entrez sa date de publication :");
		int dateBis = sc3.nextInt();
		System.out.println("Entrez le nom de l'auteur :");
		String authorSurname = sc3.nextLine();
		System.out.println("Entrez le prenom de l'auteur :");
		String authorName = sc3.nextLine();
		System.out.println("Fait-il partie d'une serie ? 1 : Oui		2: Non");
		int rep = sc3.nextInt();
		String seriesTitle;
		int seriesNumber;
		if(rep == 1) {
			System.out.println("Quel est le nom de la serie ? ");
			seriesTitle = sc3.nextLine();
			System.out.println("Quel est son numero dans la serie ? ");
			seriesNumber = sc3.nextInt();
		}
		else {
			seriesTitle = "";
			seriesNumber = -1;
		}
		System.out.println("Entrez le type du document :");
		String type = sc3.nextLine();
		if(type.contains("Livre")) { 
			System.out.println("Quel est le numéro ISBN ?");	
			String isbn = sc3.nextLine();
			lesLivres.ajouter(new Livre(ean, isbn, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			lesSeriesLivres.ajouter(new Livre(ean, isbn, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			return false;
		}
		else if(type.contains("Bande")) {
			lesDocs.ajouter(new BD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			lesSeries.ajouter(new BD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
		}
		else if(type.contains("Carte")) {
			lesDocs.ajouter(new Carte(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			lesSeries.ajouter(new Carte(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
		}
		else if(type.contains("Disque")) {
			lesDocs.ajouter(new CD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			lesSeries.ajouter(new CD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
		}
		else if(type.contains("societe")) {
			lesDocs.ajouter(new JeuDeSociete(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			lesSeries.ajouter(new JeuDeSociete(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
		}
		else if(type.contains("Jeux")) {
			lesDocs.ajouter(new JeuxVideo(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			lesSeries.ajouter(new JeuxVideo(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
		}
		else if(type.contains("Partition")) {
			lesDocs.ajouter(new Partition(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			lesSeries.ajouter(new Partition(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
		}
		else if(type.contains("Revue")) {
			lesDocs.ajouter(new Revue(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			lesSeries.ajouter(new Revue(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
		}
		else if(type.contains("Vinyle")) {
			lesDocs.ajouter(new Vinyle(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			lesSeries.ajouter(new Vinyle(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
		}
		else {
			lesDocs.ajouter(new Autre(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			lesSeries.ajouter(new Autre(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
		}
		System.out.println("Document créé! \n Que voulez vous faire ensuite ?\n");
		return false;
		
	}
	
	public void creerUtil() {
		Scanner sc4 = new Scanner(System.in);
		System.out.println("Entrez le prénom de l'utilisateur :");
		String prenom = sc4.nextLine();
		System.out.println("Entrez le nom de l'utilisateur :");
		String nom = sc4.nextLine();
		System.out.println("Entrez son quota maximum de documents empruntés :");
		int quotaDoc = sc4.nextInt();
		System.out.println("Entrez le nom de la bibliotheque ou vous souhaitez l'inscrire :");
		String bibli = sc4.nextLine();
		for(Bibliotheque b : listeBibli) {
			if(b.getNom().equals(bibli)) b.inscrire(new Utilisateur(quotaDoc, 0, nom, prenom));
		}
		System.out.println("Utilisateur crée! \n Que voulez vous faire ensuite ?\n");
	}
	
	//la fonction echanger permet à 2 bibliothèques de s'échanger 2 documents
		public void echanger(Bibliotheque b2, Document d1, Document d2) {
			/*.getListeDocs().supprimer(d1);
			listeDocs.ajouter(d2.getEan());
			b2.listeDocs.supprimer(d2);
			b2.listeDocs.ajouter(d1);*/
		}
	
	public void consulterDocsAuteur() {
		Scanner sc6 = new Scanner(System.in);
		System.out.println("Entrez votre choix : \n 1-Recherche par prénom et nom de l'auteur \n 2-Recherche par prénom de l'auteur \n 3-Recherche par nom de l'auteur"  );
		int i  = sc6.nextInt();
		if (i==1) {
			System.out.println("Entrez le nom :");
			String nom = sc6.nextLine();
			System.out.println("Entrez le prénom :");
			String prenom = sc6.nextLine();
			lesDocs.consulterNomPrenom(nom,prenom);
			lesLivres.consulterNomPrenom(nom, prenom);
		}
		if(i==2) {
			System.out.println("Entrez le prénom :");
			String prenom = sc6.nextLine();
			lesDocs.consulterPrenom(prenom);
		}
		if(i==3) {
			System.out.println("Entrez le nom :");
			String nom = sc6.nextLine();
			lesDocs.consulterNom(nom);
		}
		else {
			//error
			System.out.println("Votre choix n'est pas valable");
		}
	}
	
	public void consulterDocsAuteur(Bibliotheque bi) {
		Scanner sc6 = new Scanner(System.in);
		System.out.println("Entrez votre choix : \n 1-Recherche par prénom et nom de l'auteur \n 2-Recherche par prénom de l'auteur \n 3-Recherche par nom de l'auteur"  );
		int i  = sc6.nextInt();
		if (i==1) {
			System.out.println("Entrez le nom :");
			String nom = sc6.nextLine();
			System.out.println("Entrez le prénom :");
			String prenom = sc6.nextLine();
			bi.getListeDocs().consulterNomPrenom(nom,prenom);
			bi.getListeLivres().consulterNomPrenom(nom, prenom);
		}
		if(i==2) {
			System.out.println("Entrez le prénom :");
			String prenom = sc6.nextLine();
			bi.getListeDocs().consulterPrenom(prenom);
		}
		if(i==3) {
			System.out.println("Entrez le nom :");
			String nom = sc6.nextLine();
			bi.getListeDocs().consulterNom(nom);
		}
		else {
			//error
			System.out.println("Votre choix n'est pas valable");
		}
	}
	
	public void rechercheDocType() {
		Scanner sc7 = new Scanner(System.in);
		System.out.println("Date de publication minimale des documents recherchés :");
		int dateMin = sc7.nextInt();
		System.out.println("Date de publication maximale des documents recherchés :");
		int dateMax = sc7.nextInt();
		lesDocs.consulterType( dateMin, dateMax);
		System.out.println("Date de publication maximale des documents recherchés :");
	}
	
	public int afficherMenu1() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" #############  \n #MENU# \n ########### \n"
				+ "1- FAIRE UN AJOUT \n\n\n"
				+ "2- FAIRE UNE CONSULTATION / RECHERCHE \n\n\n"
				+ "3- EMPRUNTER OU ECHNAGER UN DOCUMENT\n\n\n"
				+ "4- QUITTER\n\n\n");
		System.out.println("Entrez le numéro correspondant à votre choix");
		int res = sc.nextInt();
		return res;
	}
	
	public int afficherMenu2() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" #############  \n #MENU# \n #############  \n"
				+ "1- Ajouter une nouvelle bibliothèque \n\n"
				+ "2- Ajouter un nouveau document \n\n"
				+ "3- Ajouter un nouvel utilisateur \n\n"
				+ "4- Quitter\n\n");
		System.out.println("Entrez le numéro correspondant à votre choix");
		int res = sc.nextInt();
		return res;
	}
	
	public int afficherMenu3() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ###### \n #MENU# \n ###### \n"
				+ "1- DANS UNE BIBLIOTHEQUE PARTICULIERE \n\n\n"
				+ "2- DANS TOUT LE RESEAU\n\n\n"
				+ "3- Quitter\n\n\n");
		System.out.println("Entrez le numéro correspondant à votre choix");
		int res = sc.nextInt();
		return res;
	}
	
	public int afficherMenu4() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ###### \n #MENU# \n ###### \n"
				+ "1- Consulter l'ensemble des document \n\n"
				+ "2- Consulter une série \n\n"
				+ "3- Consulter les documents d'un auteur \n\n"
				+ "4- Rechercher un document \n\n"
				+ "5- Rechercher le nombre de documents publiés dans un intervalle de temps\n\n"
				+ "6- Quitter\n\n");
		System.out.println("Entrez le numéro correspondant à votre choix");
		int res = sc.nextInt();
		return res;
	}
	
	public int afficherMenu5() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ###### \n #MENU# \n ###### \n"
				+ "1- Emprunt d'une bibliotheque dans le reseau \n\n"
				+ "2- Emprunt d'une bibliotheque dans une autre bibliotheque \n\n"
				+ "3- Emprunt d'un utilisateur dans une bibliotheque"
				+ "4- Quitter\n\n");
		System.out.println("Entrez le numéro correspondant à votre choix");
		int res = sc.nextInt();
		return res;
	}
	
	public void consulterSerie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nom de la serie que vous voulez consulter :");
		String serie = sc.nextLine();
		lesSeries.consulter(serie, lesDocs);
	}
	public void consulterSerie(Bibliotheque b) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nom de la serie que vous voulez consulter :");
		String serie = sc.nextLine();
		b.getListeSeries().consulter(serie, lesDocs);
	}
	public void consulterSerieLivres() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nom de la serie que vous voulez consulter :");
		String serie = sc.nextLine();
		lesSeriesLivres.consulter(serie, lesDocs);
	}
	
	public void recherche() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez votre choix : \n 1-Recherche par ISBN \n 2-Recherche par EAN \n" );
		int i  = sc.nextInt();
		System.out.println("Entrez le numero : " );
		String num = sc.nextLine();
		if(i == 1) {
			if(lesDocs.containsKey(num)) System.out.println(lesDocs.get(num));
			else System.out.println("Document introuvable...\n");
		}
	}
	
	public void recherche(Bibliotheque bi) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez votre choix : \n 1-Recherche par ISBN \n 2-Recherche par EAN \n" );
		int i  = sc.nextInt();
		System.out.println("Entrez le numero : " );
		String num = sc.nextLine();
		if(i == 1) {
			if(bi.getListeDocs().containsKey(num)) System.out.println(bi.getListeDocs().get(num));
			else System.out.println("Document introuvable...\n");
		}
	}
	
	public void afficherNbType() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Date minimale de recherche : " );
		int min  = sc.nextInt();
		System.out.println("Date maximale de recherche : " );
		int max  = sc.nextInt();
		lesDocs.consulterType(min, max);
	}
	
	public void afficherNbType(Bibliotheque bi) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Date minimale de recherche : " );
		int min  = sc.nextInt();
		System.out.println("Date maximale de recherche : " );
		int max  = sc.nextInt();
		bi.getListeDocs().consulterType(min, max);
	}
	
	public boolean menu1(int res) {
		switch(res) {
		case 1: return menu2(afficherMenu2());
		case 2: return menu3(afficherMenu3());
		case 3: return menu5(afficherMenu5());
		case 4: return exit();
		default:{System.out.println("votre choix n'est pas valide"); return true;}
		}	
	}
	
	public boolean menu2(int res) {
		switch(res) {
		case 1: creerBiblio(); return false;
		case 2: creerDoc(); return false;
		case 3: creerUtil(); return false;
		case 4: return exit();
		default:{System.out.println("votre choix n'est pas valide"); return true;}
		}	
	}
	
	public boolean menu3(int res) {
		switch(res) {
		case 1: return menu4(afficherMenu4(), getNomBibli());
		case 2: return menu4(afficherMenu4());
		case 3: return exit();
		default:{System.out.println("votre choix n'est pas valide"); return true;}
		}	
	}
	
	public boolean menu4(int res) {
		switch(res) {
		case 1: lesDocs.consulter(); return false;
		case 2: consulterSerie(); return false;
		case 3: consulterDocsAuteur(); return false;
		case 4: recherche(); return false;
		case 5: afficherNbType(); return false;
		case 6: return exit();
		default:{System.out.println("votre choix n'est pas valide"); return true;}
		}	
	}
	
	public boolean menu4(int res, String nom) {
		int i = 0;
		for(Bibliotheque b : listeBibli) {
			while(nom.equals(b.getNom())) {
				i++;
			}
		}
		switch(res) {
		case 1: listeBibli.get(i).getListeDocs().consulter(); return false;
		case 2: consulterSerie(listeBibli.get(i)); return false;
		case 3: consulterDocsAuteur(listeBibli.get(i)); return false;
		case 4: recherche(listeBibli.get(i)); return false;
		case 5: afficherNbType(listeBibli.get(i)); return false;
		case 6: return exit();
		default:{System.out.println("votre choix n'est pas valide"); return true;}
		}	
	}
	
	public boolean menu5(int res) {
		switch(res) {
		case 1: String nom = getNomBibli();
		Scanner sc = new Scanner(System.in);
		System.out.println("Dans quelle bibliotheque voulez vous faire un emprunt \n");
		String nom2 = sc.nextLine();
		System.out.println("Quel est le numéro EAN du document que vous voulez emprunter ? \n");
		String nom3 = sc.nextLine();
		empruntB(nom, nom2, lesDocs.get(nom3));
		case 2: return menu4(afficherMenu4());
		case 3: return exit();
		case 4: return exit();
		default:{System.out.println("votre choix n'est pas valide"); return true;}
		}	
	}
	
	public String getNomBibli() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dans quelle bibliotheque voulez vous faire vos recherches :\n");
		return sc.nextLine();
	}
	
	public void empruntB(String b1, String b2, Document doc) {
		int i =0;
		for(Bibliotheque b : listeBibli) {
			while(b1.equals(b.getNom())) {
				i++;
			}
		}
		int b1Bis = i;
		i= 0;
		for(Bibliotheque b : listeBibli) {
			while(b2.equals(b.getNom())) {
				i++;
			}
		}
		int b2Bis = i;
		listeBibli.get(b1Bis).emprunter(listeBibli.get(b2Bis), doc);
		System.out.println("Emprunt du document \n" + doc + "\nde "+ b1 +" à " + b2);
	}
	
	public boolean exit() {
		return true;
	}

}
