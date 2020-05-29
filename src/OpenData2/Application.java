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
		System.out.println("Entrez le nom de la nouvelle biblioth�que :");
		String nomBiblio = sc2.nextLine();
		listeBibli.add(new Bibliotheque(nomBiblio));
		System.out.println("Biblioth�que cr��e!\n Que voulez vous faire ensuite ?\n");
	}
	
	public void creerDoc() {
		//verifier ean isbn et ajouter liste doc
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Entrez l'EAN :");
		String ean = sc3.nextLine();
		System.out.println("Entrez le titre du document :");
		String titre = sc3.nextLine();
		System.out.println("Entrez le nom de l'�diteur :");
		String editeur = sc3.nextLine();
		System.out.println("Entrez sa date de publication :");
		int datePub = sc3.nextInt();
		listeDoc = new Document(numNotice ,ean ,titre ,datePub );
		if(type.contains("Livre")) {
			app.getLesLivres().ajouter(new Livre(ean, isbn, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			app.getLesSeriesLivres().ajouter(new Livre(ean, isbn, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			//AJOUT AUX BIBLIOTHEQUES
			if(numberCopyAimeCesaire > 0) app.getListeBibli().get(0).ajouter(isbn);
	   		if(numberCopyEdmondRostand > 0) app.getListeBibli().get(1).ajouter(isbn);
	   		if(numberCopyJeanPierreMelville > 0)  app.getListeBibli().get(2).ajouter(isbn);
	   		if(numberCopyOscarWilde > 0) app.getListeBibli().get(3).ajouter(isbn);
	   		if(numberCopySaintSimon > 0) app.getListeBibli().get(4).ajouter(isbn);
		}
		else {
			if(type.contains("Bande")) {
				app.getLesDocs().ajouter(new BD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
				app.getLesSeries().ajouter(new BD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			}
			else if(type.contains("Carte")) {
				app.getLesDocs().ajouter(new Carte(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
				app.getLesSeries().ajouter(new Carte(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			}
			else if(type.contains("Disque")) {
				app.getLesDocs().ajouter(new CD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
				app.getLesSeries().ajouter(new CD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
			}
				else if(type.contains("societe")) {
					app.getLesDocs().ajouter(new JeuDeSociete(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
					app.getLesSeries().ajouter(new JeuDeSociete(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
				}
				else if(type.contains("Jeux")) {
					app.getLesDocs().ajouter(new JeuxVideo(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
					app.getLesSeries().ajouter(new JeuxVideo(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
				}
				else if(type.contains("Partition")) {
					app.getLesDocs().ajouter(new Partition(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
					app.getLesSeries().ajouter(new Partition(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
				}
				else if(type.contains("Revue")) {
					app.getLesDocs().ajouter(new Revue(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
					app.getLesSeries().ajouter(new Revue(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
				}
				else if(type.contains("Vinyle")) {
					app.getLesDocs().ajouter(new Vinyle(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
					app.getLesSeries().ajouter(new Vinyle(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
				}
				else {
					app.getLesDocs().ajouter(new Autre(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
					app.getLesSeries().ajouter(new Autre(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
				}
		new Document(ean ,titre ,editeur , datePub, );
		System.out.println("Document cr��! \n Que voulez vous faire ensuite ?\n");
		
	}
	
	public void creerUtil() {
		Scanner sc4 = new Scanner(System.in);
		System.out.println("Entrez le pr�nom de l'utilisateur :");
		String prenom = sc4.nextLine();
		System.out.println("Entrez le nom de l'utilisateur :");
		String nom = sc4.nextLine();
		System.out.println("Entrez son quota de documents :");
		int quotaDoc = sc4.nextInt();
		new Utilisateur(quotaDoc, 0, nom, prenom);
		System.out.println("Utilisateur cr��! \n Que voulez vous faire ensuite ?\n");
	}
	
	//la fonction echanger permet � 2 biblioth�ques de s'�changer 2 documents
		public void echanger(Bibliotheque b2, Document d1, Document d2) {
			/*.getListeDocs().supprimer(d1);
			listeDocs.ajouter(d2.getEan());
			b2.listeDocs.supprimer(d2);
			b2.listeDocs.ajouter(d1);*/
		}
	
	public void consulterSerie() {
		Scanner sc5 = new Scanner(System.in);
		System.out.println("Entrez le nom de la s�rie :");
		String serie = sc5.nextLine();
	}
	
	public void consulterDocAuteur() {
		Scanner sc6 = new Scanner(System.in);
		System.out.println("Entrez votre choix : \n 1-Recherche par pr�nom et nom de l'auteur \n 2-Recherche par pr�nom de l'auteur \n 3-Recherche par nom de l'auteur"  );
		int i  = sc6.nextInt();
		if (i==1) {
			System.out.println("Entrez le nom :");
			String nom = sc6.nextLine();
			System.out.println("Entrez le pr�nom :");
			String prenom = sc6.nextLine();
			lesDocs.consulterNomPrenom(nom,prenom);
		}
		if(i==2) {
			System.out.println("Entrez le pr�nom :");
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
	
	public void rechercheDocType() {
		Scanner sc7 = new Scanner(System.in);
		System.out.println("Date de publication minimale des documents recherch�s :");
		int dateMin = sc7.nextInt();
		System.out.println("Date de publication maximale des documents recherch�s :");
		int dateMax = sc7.nextInt();
		lesDocs.consulterType( dateMin, dateMax);
		System.out.println("Date de publication maximale des documents recherch�s :");
	}
	
	public int afficherMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ###### \n #MENU# \n ###### \n 1-Ajouter une nouvelle biblioth�que \n 2-Ajouter un nouveau document \n 3-Ajouter un nouvel utilisateur \n 4-Consulter l'ensemble des document \n 5-Consulter une s�rie \n 6-Consulter les documents d'un auteur \n 7-Rechercher un livre par son IBN \n 8-Rechercher un document par son EAN \n 9-Consulter le nombre de document d'un type publi� dans un intervalle de temps");
		System.out.println("Entrez le num�ro correspondant � votre choix");
		int res = sc.nextInt();
		return res;
	}
	
	public boolean menu(int res) {
		switch(res) {
		case 1: creerBiblio();return false;
		case 2: creerDoc();return false;
		case 3: creerUtil();return false;
		//case 4: consulterTousDoc();return false;
		case 5: consulterSerie();return false;
		case 6: consulterDocAuteur();return false;
		//case 7: rechercheISBN();return false;
		//case 8: rechercheEAN();return false;
		case 9: rechercheDocType();return false;
		case 10: return exit();
		default:{System.out.println("votre choix n'est pas valide"); return true;}
		}	
	}
	
	public boolean exit() {
		return true;
	}

}
