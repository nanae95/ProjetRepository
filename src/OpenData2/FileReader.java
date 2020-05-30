package OpenData2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
//import java.util.List;

public class FileReader 
{
	
	public static Application getDataFromCSVFile(String csvFilePath)
	{
		Application app = new Application();
		
        String line = "";
        String[] data = null;
        String separator = ";(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        
        //Document data
        String isbn;
        String ean;
        String title;
        String publisher;
        String date;
        String seriesTitle;
        Integer seriesNumber;
        String authorName;
        String authorSurname;
        String type;
        int totalCopies;
        int numberCopyAimeCesaire;
        int numberCopyEdmondRostand;
        int numberCopyJeanPierreMelville;
        int numberCopyOscarWilde;
        int numberCopySaintSimon;
        
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(csvFilePath), StandardCharsets.ISO_8859_1)) 
        {
        	//Read the first line
        	line = bufferedReader.readLine();
        	
        	//Get data from the line
        	data = line.split(separator, -1);
        	
        	if(data.length != 16)
        	{
        		System.out.println("[FileReader] The file at " + csvFilePath + " does not contain the right number of columns.");
        		return null;
        	}
        	
        	//Read the file line by line
            while ((line = bufferedReader.readLine()) != null)
            {
            	//Get data from the line
            	data = line.split(separator, -1);
            	
            	//Sort data
            		
            		//Get the ISBN number
            		isbn = data[0];
            		
            		//Get the EAN number
            		ean = data[1];
            		
            		//Get the title of the document
            		title = data[2];

            		//Get the name of the publisher
            		publisher = data[3];
            		
            		//Get the publication date
            		try
            		{
            			int dateInt = Integer.parseInt(data[4].replaceAll("[^0-9]", ""));
            			
            			if(dateInt%10000 >= 2021 || dateInt%10000 < 0)
            			{
            				date = "-1";
            			}
            			else if(dateInt/10000 == 0)
            			{
            				date = Integer.toString(dateInt%10000);
            			}
            			else
            			{
            				//date = dateInt%10000 + "-" + dateInt/10000;
            				date = Integer.toString(dateInt/10000);
            			}
            		}
            		catch (Exception exception)
            		{
            			date = "-1";
            		}
            		
            		//Get the title of the series
            		seriesTitle = data[5];
            		
            		//Get the number of this document in the series
            		try
            		{
            			seriesNumber = Integer.parseInt(data[6]);
            		}
            		catch (Exception exception)
            		{
            			seriesNumber = -1;
            		}
            		
            		//Get the name of the author
            		authorSurname = data[7];
            		
            		//Get the surname of the author
            		authorName = data[8];
            		
            		//Get the type of the document
            		type = data[9];
            		
            		//Get the total number of copy in Paris for this document 
            		try
            		{
            			totalCopies = Integer.parseInt(data[10]);
            		}
            		catch (Exception exception)
            		{
            			totalCopies = 0;
            		}
            		
            		//Get the number of copy in the library "Aime Cesaire"
            		try
            		{
            			numberCopyAimeCesaire = Integer.parseInt(data[11]);
            		}
            		catch (Exception exception)
            		{
            			numberCopyAimeCesaire = 0;
            		}
            		
            		//Get the number of copy in the library "Edmond Rostand"
            		try
            		{
            			numberCopyEdmondRostand = Integer.parseInt(data[12]);
            		}
            		catch (Exception exception)
            		{
            			numberCopyEdmondRostand = 0;
            		}
            		
            		//Get the number of copy in the library "Jean-Pierre Melville"
            		try
            		{
            			numberCopyJeanPierreMelville = Integer.parseInt(data[13]);
            		}
            		catch (Exception exception)
            		{
            			numberCopyJeanPierreMelville = 0;
            		}
            		
            		//Get the number of copy in the library "Oscar Wilde"
            		try
            		{
            			numberCopyOscarWilde = Integer.parseInt(data[14]);
            		}
            		catch (Exception exception)
            		{
            			numberCopyOscarWilde = 0;
            		}
            		
            		//Get the number of copy in the library "Saint-Simon"
            		try
            		{
            			numberCopySaintSimon = Integer.parseInt(data[15]);
            		}
            		catch (Exception exception)
            		{
            			numberCopySaintSimon = 0;
            		}
                
                //TODO Do something with data
                    int dateBis = Integer.parseInt(date);
          
            			if(type.contains("Livre")) {
            				app.getLesLivres().ajouter(new Livre(ean, isbn, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            				app.getLesSeriesLivres().ajouter(new Livre(ean, isbn, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            				//AJOUT AUX BIBLIOTHEQUES
            				if(numberCopyAimeCesaire > 0) app.getListeBibli().get(0).getListeLivres().ajouter(new Livre(ean, isbn, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            		   		if(numberCopyEdmondRostand > 0) app.getListeBibli().get(1).getListeLivres().ajouter(new Livre(ean, isbn, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            		   		if(numberCopyJeanPierreMelville > 0)  app.getListeBibli().get(2).getListeLivres().ajouter(new Livre(ean, isbn, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            		   		if(numberCopyOscarWilde > 0) app.getListeBibli().get(3).getListeLivres().ajouter(new Livre(ean, isbn, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            		   		if(numberCopySaintSimon > 0) app.getListeBibli().get(4).getListeLivres().ajouter(new Livre(ean, isbn, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            			}
            			else {
            				if(type.contains("Bande")) {
            					app.getLesDocs().ajouter(new BD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            					app.getLesSeries().ajouter(new BD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            					//AJOUT AUX BIBLIOTHEQUES
               					if(numberCopyAimeCesaire > 0) app.getListeBibli().get(0).getListeLivres().ajouter(new BD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyEdmondRostand > 0) app.getListeBibli().get(1).getListeLivres().ajouter(new BD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyJeanPierreMelville > 0) app.getListeBibli().get(2).getListeLivres().ajouter(new BD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyOscarWilde > 0) app.getListeBibli().get(3).getListeLivres().ajouter(new BD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopySaintSimon > 0) app.getListeBibli().get(4).getListeLivres().ajouter(new BD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            				}
            				else if(type.contains("Carte")) {
            					app.getLesDocs().ajouter(new Carte(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            					app.getLesSeries().ajouter(new Carte(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            					//AJOUT AUX BIBLIOTHEQUES
            					if(numberCopyAimeCesaire > 0) app.getListeBibli().get(0).getListeLivres().ajouter(new Carte(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyEdmondRostand > 0) app.getListeBibli().get(1).getListeLivres().ajouter(new Carte(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyJeanPierreMelville > 0) app.getListeBibli().get(2).getListeLivres().ajouter(new Carte(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyOscarWilde > 0) app.getListeBibli().get(3).getListeLivres().ajouter(new Carte(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopySaintSimon > 0) app.getListeBibli().get(4).getListeLivres().ajouter(new Carte(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            				}
            				else if(type.contains("Disque")) {
            					app.getLesDocs().ajouter(new CD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            					app.getLesSeries().ajouter(new CD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            					//AJOUT AUX BIBLIOTHEQUES
            					if(numberCopyAimeCesaire > 0) app.getListeBibli().get(0).getListeLivres().ajouter(new CD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyEdmondRostand > 0) app.getListeBibli().get(1).getListeLivres().ajouter(new CD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyJeanPierreMelville > 0) app.getListeBibli().get(2).getListeLivres().ajouter(new CD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyOscarWilde > 0) app.getListeBibli().get(3).getListeLivres().ajouter(new CD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopySaintSimon > 0) app.getListeBibli().get(4).getListeLivres().ajouter(new CD(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
            				}
           					else if(type.contains("societe")) {
           						app.getLesDocs().ajouter(new JeuDeSociete(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           						app.getLesSeries().ajouter(new JeuDeSociete(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           						//AJOUT AUX BIBLIOTHEQUES
            					if(numberCopyAimeCesaire > 0) app.getListeBibli().get(0).getListeLivres().ajouter(new JeuDeSociete(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyEdmondRostand > 0) app.getListeBibli().get(1).getListeLivres().ajouter(new JeuDeSociete(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyJeanPierreMelville > 0) app.getListeBibli().get(2).getListeLivres().ajouter(new JeuDeSociete(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyOscarWilde > 0) app.getListeBibli().get(3).getListeLivres().ajouter(new JeuDeSociete(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopySaintSimon > 0) app.getListeBibli().get(4).getListeLivres().ajouter(new JeuDeSociete(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           					}
           					else if(type.contains("Jeux")) {
           						app.getLesDocs().ajouter(new JeuxVideo(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           						app.getLesSeries().ajouter(new JeuxVideo(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           					//AJOUT AUX BIBLIOTHEQUES
            					if(numberCopyAimeCesaire > 0) app.getListeBibli().get(0).getListeLivres().ajouter(new JeuxVideo(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyEdmondRostand > 0) app.getListeBibli().get(1).getListeLivres().ajouter(new JeuxVideo(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyJeanPierreMelville > 0) app.getListeBibli().get(2).getListeLivres().ajouter(new JeuxVideo(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyOscarWilde > 0) app.getListeBibli().get(3).getListeLivres().ajouter(new JeuxVideo(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopySaintSimon > 0) app.getListeBibli().get(4).getListeLivres().ajouter(new JeuxVideo(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           					}
           					else if(type.contains("Partition")) {
           						app.getLesDocs().ajouter(new Partition(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           						app.getLesSeries().ajouter(new Partition(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           					//AJOUT AUX BIBLIOTHEQUES
            					if(numberCopyAimeCesaire > 0) app.getListeBibli().get(0).getListeLivres().ajouter(new Partition(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyEdmondRostand > 0) app.getListeBibli().get(1).getListeLivres().ajouter(new Partition(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyJeanPierreMelville > 0) app.getListeBibli().get(2).getListeLivres().ajouter(new Partition(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyOscarWilde > 0) app.getListeBibli().get(3).getListeLivres().ajouter(new Partition(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopySaintSimon > 0) app.getListeBibli().get(4).getListeLivres().ajouter(new Partition(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           					}
           					else if(type.contains("Revue")) {
           						app.getLesDocs().ajouter(new Revue(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           						app.getLesSeries().ajouter(new Revue(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           					//AJOUT AUX BIBLIOTHEQUES
            					if(numberCopyAimeCesaire > 0) app.getListeBibli().get(0).getListeLivres().ajouter(new Revue(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyEdmondRostand > 0) app.getListeBibli().get(1).getListeLivres().ajouter(new Revue(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyJeanPierreMelville > 0) app.getListeBibli().get(2).getListeLivres().ajouter(new Revue(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyOscarWilde > 0) app.getListeBibli().get(3).getListeLivres().ajouter(new Revue(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopySaintSimon > 0) app.getListeBibli().get(4).getListeLivres().ajouter(new Revue(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           					}
           					else if(type.contains("Vinyle")) {
           						app.getLesDocs().ajouter(new Vinyle(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           						app.getLesSeries().ajouter(new Vinyle(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           					//AJOUT AUX BIBLIOTHEQUES
            					if(numberCopyAimeCesaire > 0) app.getListeBibli().get(0).getListeLivres().ajouter(new Vinyle(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyEdmondRostand > 0) app.getListeBibli().get(1).getListeLivres().ajouter(new Vinyle(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyJeanPierreMelville > 0) app.getListeBibli().get(2).getListeLivres().ajouter(new Vinyle(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyOscarWilde > 0) app.getListeBibli().get(3).getListeLivres().ajouter(new Vinyle(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopySaintSimon > 0) app.getListeBibli().get(4).getListeLivres().ajouter(new Vinyle(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           					}
           					else {
           						app.getLesDocs().ajouter(new Autre(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           						app.getLesSeries().ajouter(new Autre(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           					//AJOUT AUX BIBLIOTHEQUES
            					if(numberCopyAimeCesaire > 0) app.getListeBibli().get(0).getListeLivres().ajouter(new Autre(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyEdmondRostand > 0) app.getListeBibli().get(1).getListeLivres().ajouter(new Autre(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyJeanPierreMelville > 0) app.getListeBibli().get(2).getListeLivres().ajouter(new Autre(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopyOscarWilde > 0) app.getListeBibli().get(3).getListeLivres().ajouter(new Autre(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
               		    		if(numberCopySaintSimon > 0) app.getListeBibli().get(4).getListeLivres().ajouter(new Autre(ean, title, publisher, dateBis, seriesTitle, seriesNumber, authorSurname, authorName));
           					}
           					
           				}
            	
                System.out.println(
                		isbn + ";" +
                		ean + ";" +
                		title + ";" +
                		publisher + ";" +
                		date + ";" +
                		seriesTitle + ";" +
                		seriesNumber + ";" +
                		authorName + ";" +
                		authorSurname + ";" +
                		type + ";" +
                		totalCopies + ";" +
                		numberCopyAimeCesaire + ";" +
                		numberCopyEdmondRostand + ";" +
                		numberCopyJeanPierreMelville + ";" +
                		numberCopyOscarWilde + ";" +
                		numberCopySaintSimon);
            }
        } 
        catch (IOException exception) 
        {
            System.err.println(exception);
        }
    	return app;
	}
}