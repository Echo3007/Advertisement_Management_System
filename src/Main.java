import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/*
Student: Angela Pellillo
Stundent ID: 21499500
Module ID: CP6CS19E
Module Name: Applied Software Engineering */

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Step 1: Create ProcessingCentre
        ProcessingCentre processingCentre = new ProcessingCentre(101);

        //Step 2: Create Editor, Magazine and MagazineIssue
        Editor editor = new Editor(1, "John", "Doe");
        editor.setProcessingCentre(processingCentre);
        Magazine magazine = new Magazine("Hello Computers", 55);
        MagazineIssue magazineIssue = new MagazineIssue("Ciao Ciao", LocalDate.now(),
        66);
        editor.setMagazineIssue(magazineIssue);
        editor.setMagazine(magazine);

        //Magazine Issue is Added to the magazine
        magazine.addIssue(magazineIssue);

        // Step 3: Create Advertiser
        Advertiser advertiser = new Advertiser(1001, "Jane", "Smith",
        "jane.smith@example.com");
        advertiser.setEditor(editor);

        // Step 4: Create Advert (no graphics or text yet)
        Advert advert = new Advert(2001, LocalDate.now(), advertiser.getId());

        // Step 5: Advertiser sends Advert to Editor, who will check the Advert and send it to ProcessingCentre
        AdvertGraphics graphic = new AdvertGraphics(2, 2, null); //set to null to easily test
        AdvertText text = new AdvertText(4, 4, "hhihihihiih");
        advert.addGraphic(graphic);
        advert.addText(text);
        System.out.println("\n--- Advertiser Sends Advert ---");
        advertiser.setMagazine(magazine);
        advertiser.sendAdvert(advert);
        System.out.println("Number of Adverts stored: "+processingCentre.getAdverts().size());

       

        /*
         * Testing Rule 4 OCL:
         * "4.An Advert can have only one ProcessingCentre but the ProcessingCentre might store more than one Advert."
         * 
         * context Advert
         * inv OneProcessingCentre:
         * self.processingCentre->size() = 1
         */

        // ProcessingCentre processingCentre1 = new ProcessingCentre(4);
        // ProcessingCentre otherProcessingCentre = new ProcessingCentre(7);
        // Advert advertR = new Advert(4, LocalDate.now(), 8 );

        // processingCentre1.addAdvert(advertR);
        // advertR.setProcessingCentre(processingCentre1);

        // otherProcessingCentre.addAdvert(advertR);//This should display an error, as
        // the advert is already associated to processingCentre1

        /*
         * Testing Rule 5 OCL: The issueNumber in Advert must corresponde to an existing
         * MagazineIssue
         * Multiplicity: 1 to 1
         * OCL
         * context Advert
         * inv ValidMagazineIssue:
         * MagazineIssue.allInstances()->exists(issue | issue.issueNumber =
         * self.issueNumber)
         */

        // Magazine magazine1 = new Magazine("ComputersMagazine", 77);
        // Magazine magazine2 = new Magazine("ComputersMagazine", 87);

        // Editor editor = new Editor(1, "Ang", "Pel");
        // MagazineIssue magazineIssue1 = new MagazineIssue("Issue 1", LocalDate.now(), 1);
        // MagazineIssue magazineIssue2 = new MagazineIssue("Issue NOT in Magazine", LocalDate.now(), 2);
        // Advert advert = new Advert(11, LocalDate.now(), 55);
        // Advertiser advertiser = new Advertiser(1, "He", "Ha", "adshda@gmail.com");
        // magazine1.addIssue(magazineIssue1); // Add the valid issue to the magazine
        // ProcessingCentre processingCentre = new ProcessingCentre(4);

        // editor.setProcessingCentre(processingCentre);
        // editor.setMagazine(magazine1);

        // advertiser.setEditor(editor); // Link the editor to the advertiser

        // // Ensure the editor knows about the magazine

        // // Set the magazine issue for the editor to review
        // editor.setMagazineIssue(magazineIssue1);

        // // Send the advert through the advertiser (which triggers editor's checkAdvert
        // // method)
        // advertiser.setMagazine(magazine1);
        // advertiser.sendAdvert(advert);


        // //Advert Class Creation Example
        // Advert advert = new Advert(0, null, 0);
        // AdvertGraphics graphic = new AdvertGraphics(1, 0, null);
        // AdvertText text = new AdvertText(2, 0, null);
        // advert.setId(7);
        // System.out.println("Advert id:"+ advert.getId());
        // advert.setDate(LocalDate.now());
        // System.out.println("Advert date:"+ advert.getDate());

        // advert.setAdvetiserId(5);
        // System.out.println("Advertiser id:"+ advert.getAdvertiserId());

        // advert.addGraphic(graphic);
        // advert.addText(text);
        // System.out.println("Graphics: "+ advert.getGraphics());
        // System.out.println("Texts: "+ advert.getTexts());
        // advert.displayAdvertInfo();


        // //AdvertGraphics Example
        // AdvertGraphics graphic = new AdvertGraphics(0, 0, null);
        // graphic.setAdvertId(8);
        // graphic.setAdvertId(7);
    

        // File imageFile = new File("C:\\Users\\angel\\Desktop\\A\\4cyLJCik2Z9R7QAoz4exJR.jpg");
        // BufferedImage image = ImageIO.read(imageFile);

        // graphic.setGraphics(image);

        // // Retrieve and display details
        // System.out.println("AdvertGraphics ID: " + graphic.getId());
        // System.out.println("Advert ID: " + graphic.getAdvertId());

        // // Display details about the image
        // BufferedImage loadedImage = (BufferedImage) graphic.getGraphics();
        // System.out.println("Image Width: " + loadedImage.getWidth());
        // System.out.println("Image Height: " + loadedImage.getHeight());

    //    //Advert Text Class Implementation Example
    //    AdvertText advertText = new AdvertText(0, 0, null);
    //    advertText.setAdvertId(7);
    //    advertText.setId(1);
    //    advertText.setText("Heellloooooo");

    //    System.out.println("AdvertText Id: "+advertText.getId());
    //    System.out.println("AdvertText advert ID: "+advertText.getAdvertId());
    //    System.out.println("Text: "+advertText.getText());

        //Advertiser Class Implementation Example
        // 

        // // Display advertiser details
        // System.out.println("Advertiser Details:");
        // System.out.println("Name: " + advertiser.getName() + " " + advertiser.getSurname());
        // System.out.println("Contact: " + advertiser.getContact());

        // // Create a Magazine and associate it with the Advertiser
        // Magazine magazine = new Magazine("Tech Trends", 8);
        // advertiser.setMagazine(magazine);

        // // Create an Editor and associate it with the Advertiser
        // // Editor editor = new Editor(101, "Jane", "Smith");
        // advertiser.setEditor(editor);

        // // Create an Advert
        // Advert advert = new Advert(1001, LocalDate.now(), advertiser.getId());

        // // Send the advert
        // System.out.println("\nSending Advert...");
        // advertiser.sendAdvert(advert);

        // // Editor Implementation Example
        // Editor editor = new Editor(101, "Jane", "Smith");
        // System.out.println("Editor Details:");
        // System.out.println("Name: " + editor.getName() + " " + editor.getSurname());
        // System.out.println("ID: " + editor.getId());

        // // Creating ProcessingCentre
        // ProcessingCentre processingCentre = new ProcessingCentre(201);
        // editor.setProcessingCentre(processingCentre);

        // // Creating Magazine and MagazineIssue
        // Magazine magazine = new Magazine("Computers!", 5);
        // MagazineIssue issue = new MagazineIssue("RAM", LocalDate.now() , 7);
        // magazine.addIssue(issue);
        // editor.setMagazine(magazine);
        // editor.setMagazineIssue(issue);
        // Advertiser advertiser = new Advertiser(1, "John", "Doe", "john.doe@example.com");

        // System.out.println("\nMagazine Details:");
        // System.out.println("Name: " + editor.getMagazine().getName());
        // System.out.println("Issue: " + issue.getName() + " (" + issue.getDateIssued() + ")");

        // // Creating Advert
        // Advert advert = new Advert(1001, LocalDate.now(), advertiser.getId());

        // // Display initial Advert details
        // System.out.println("\nAdvert Details Before Validation:");
        // advert.displayAdvertInfo();

        // // Validate and send the advert to ProcessingCentre
        // System.out.println("\n--- Validating and Sending Advert ---");
        // editor.checkAdvert(advert, 1, magazine);

     
        // //Magazine Class Example
        //  Magazine magazine = new Magazine("Tech Innovations", 101);
        //  System.out.println("Magazine Created:");
        //  System.out.println("Name: " + magazine.getName());
        //  System.out.println("ID: " + magazine.getId());
 
        //  MagazineIssue issue1 = new MagazineIssue("RAM", LocalDate.now(), 2);
        //  MagazineIssue issue2 = new MagazineIssue("CPU", LocalDate.of(2023, 1, 25), 1);
 
        //  // Adding the issues to the Magazine
        //  magazine.addIssue(issue1);
        //  magazine.addIssue(issue2);
 
        //  // Display Magazine details and its issues
        //  System.out.println("\n--- Magazine Details ---");
        //  System.out.println("Name: " + magazine.getName());
        //  System.out.println("ID: " + magazine.getId());
 
        //  System.out.println("\nList of Issues:");
        //  for (MagazineIssue issue : magazine.getIssues()) {
        //      System.out.println("Issue Number: " + issue.getIssueNumber());
        //      System.out.println("Issue Name: " + issue.getName());
        //      System.out.println("Issue Date: " + issue.getDateIssued());
        //      System.out.println("Magazine Name: " + issue.getMagazine().getName());
        //      System.out.println();
        //  }


        // //MagazineIssue Class Example
        //  MagazineIssue januaryIssue = new MagazineIssue("January Edition", LocalDate.of(2025, 1, 1), 101);
        //  MagazineIssue februaryIssue = new MagazineIssue("February Edition", LocalDate.of(2025, 2, 1), 102);
 
        //  // Display details of January Issue
        //  System.out.println("--- Magazine Issue Details ---");
        //  System.out.println("Issue Name: " + januaryIssue.getName());
        //  System.out.println("Date Issued: " + januaryIssue.getDateIssued());
        //  System.out.println("Issue Number: " + januaryIssue.getIssueNumber());
 
        //  // Update details of February Issue
        //  februaryIssue.setName("Special February Edition");
        //  februaryIssue.setDateIssued(LocalDate.of(2025, 2, 14)); // Special Edition
        //  februaryIssue.setIssueNumber(202);
 
        //  // Display updated February Issue details
        //  System.out.println("\n--- Updated February Issue Details ---");
        //  System.out.println("Issue Name: " + februaryIssue.getName());
        //  System.out.println("Date Issued: " + februaryIssue.getDateIssued());
        //  System.out.println("Issue Number: " + februaryIssue.getIssueNumber());




        // //ProcessingCentre Class Implementation Example
        // ProcessingCentre processingCentre = new ProcessingCentre(101);
        // ProcessingCentre processingCentre2  = new ProcessingCentre(777);
        // Editor editor = new Editor(5, "An", "Sol");

        // Advert advert1 = new Advert(1, LocalDate.now(), 5); // ID 1, assigned to ProcessingCentre 101, priority 5
        // advert1.setProcessingCentre(processingCentre);
        // Advert advert2 = new Advert(2, LocalDate.now(), 3);             // Advert 2 has a different processing centre
        // advert2.setProcessingCentre(processingCentre2);
        // Magazine magazine = new Magazine("dd", 4);
        // MagazineIssue issue = new MagazineIssue("EEE", LocalDate.now(), 4);
        // editor.setMagazine(magazine);
        // editor.setMagazineIssue(issue);
        // editor.checkAdvert(advert1, 5, magazine);
        // // Add advert1 to the processing centre
        // System.out.println("--- Adding Advert 1 to Processing Centre ---");
        // processingCentre.addAdvert(advert1);

        // // Display the list of adverts in the processing centre
        // System.out.println("\n--- Adverts in Processing Centre ---");
        // ArrayList<Advert> adverts = processingCentre.getAdverts();
  
        // // Attempt to add advert2 to the processing centre
        // System.out.println("\n--- Attempting to Add Advert 2 (No ProcessingCentre Assigned) ---");
        // processingCentre.addAdvert(advert2);

        // System.out.println("\n--- Final Adverts in Processing Centre ---");
        // System.out.println(adverts);
        // advert1.setEditor(editor);

        // advert1.isComplete();

           // Step 1: Create ProcessingCentre
        ProcessingCentre processingCentre = new ProcessingCentre(101);

        //Step 2: Create Editor, Magazine and MagazineIssue
        Editor editor = new Editor(1, "John", "Doe");
        editor.setProcessingCentre(processingCentre);
        Magazine magazine = new Magazine("Hello Computers", 55);
        MagazineIssue magazineIssue = new MagazineIssue("Ciao Ciao", LocalDate.now(),
        66);
        editor.setMagazineIssue(magazineIssue);
        editor.setMagazine(magazine);

        //Magazine Issue is Added to the magazine
        magazine.addIssue(magazineIssue);

        // Step 3: Create Advertiser
        Advertiser advertiser = new Advertiser(1001, "Jane", "Smith",
        "jane.smith@example.com");
        advertiser.setEditor(editor);

        // Step 4: Create Advert (no graphics or text yet)
        Advert advert = new Advert(2001, LocalDate.now(), advertiser.getId());
        Advert advert2 = new Advert(0, null, 0);
        // // Step 5: Advertiser sends Advert to Editor, who will check the Advert and send it to ProcessingCentre
        // AdvertGraphics graphic = new AdvertGraphics(2, 2, null); //set to null to easily test
        // AdvertText text = new AdvertText(4, 4, null );
        // advert.addGraphic(graphic);
        // advert.addText(text);
        // System.out.println("\n--- Advertiser Sends Advert ---");
        // advertiser.setMagazine(magazine);
        // advertiser.sendAdvert(advert);
        editor.sendAdvert(advert2);
        System.out.println("Number of Adverts stored: "+processingCentre.getAdverts().size());

        // System.out.println("SENDADVERTCOMMAND EXAMPLE");
        // // Create SendAdvertCommand for the advert
        // SendAdvertCommand sendAdvertCommand = new SendAdvertCommand(processingCentre, advert);

        // // Create the Invoker and set the command
        // Invoker invoker = new Invoker();
        // invoker.setCommand(sendAdvertCommand);

        // // Process the command, which will call execute()
        // invoker.processCommand(sendAdvertCommand);
    
    }
}
