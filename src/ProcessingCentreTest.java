import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import java.time.LocalDate;
import java.util.ArrayList;

public class ProcessingCentreTest {
    private ProcessingCentre processingCentre;
    private ArrayList<Advert> adverts; 
    private Advert advert;

    @Before
    public void setUp(){
        processingCentre = new ProcessingCentre(8);
        adverts = new ArrayList<>();
        advert = new Advert(77, LocalDate.now(), 99);
    }

    //Testing setters and getters for Processing Centre id
    @Test
    public void testSetAndGetProCentreID(){
        assertEquals(8, processingCentre.getProCentreId());
        processingCentre.setProCentreId(10);
        assertEquals(10, processingCentre.getProCentreId());
    }

    //Testing Add and Get adverts list
    @Test
    public void testAddAndGetAdvert(){
        assertEquals(0, adverts.size()); //no advert has been added yet
        advert.setProcessingCentre(processingCentre);
        processingCentre.addAdvert(advert);
        assertEquals(1, processingCentre.getAdverts().size());
        assertEquals(advert, processingCentre.getAdverts().get(0));

        //New advert and different processing centre is created. It can be seen that it will not be added,as processing centre is different
        Advert diffAdver = new Advert(88, null, 8);
        ProcessingCentre newProcessingCentre = new ProcessingCentre(9);
        diffAdver.setProcessingCentre(newProcessingCentre);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        processingCentre.addAdvert(diffAdver);
        String output = outputStream.toString().trim();

        assertTrue("Expected error message when trying to add advert with different processing centre", output
                .contains("Error. Processing Centre already assigned."));
        assertEquals(1, processingCentre.getAdverts().size());
    }


    //Testing storeAdvert function
    @Test
    public void testStoreAdvert(){
        advert.setEditorId(88);
        advert.setIssueNumber(99);
        AdvertGraphics graphic = new AdvertGraphics(2, 2, null); //set to null to easily test
        AdvertText text = new AdvertText(4, 4, "hhihihihiih");
        advert.addGraphic(graphic);
        advert.addText(text);
        advert.setIsValid(true);
        advert.setProcessingCentre(processingCentre);
        assertEquals(true, advert.isComplete()); //to check that advert is complete before testing store function

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        processingCentre.storeAdvertContent(advert);

        String output = outputStream.toString().trim();

        assertTrue("Expected message that advert was stored correctly", output
                .contains("Advert stored successfully in Processing Centre ID: " + processingCentre.getProCentreId()));
        assertEquals(1, processingCentre.getAdverts().size());

        //trying to store incomplete advert
        Advert incompleteAdvert = new Advert(0, null, 0);

        processingCentre.storeAdvertContent(incompleteAdvert);

        String output2 = outputStream.toString().trim();

        assertTrue("Expected error message when trying to store incomplete advert", output2
                .contains("Cannot store incomplete advert."));
        assertEquals(1, processingCentre.getAdverts().size());


    }

}
