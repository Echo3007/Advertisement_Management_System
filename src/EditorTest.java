import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EditorTest {

    private Editor editor;
    private Advert advert;
    private ProcessingCentre processingCentre;
    private AdvertGraphics advertGraphics;
    private AdvertText advertText;
    private MagazineIssue issue;
    private Magazine magazine;

    @Before
    public void setUp() {
        editor = new Editor(1, "Angela", "Pellillo");
        advert = new Advert(2, LocalDate.now(), 3);
        processingCentre = new ProcessingCentre(4);
        advertGraphics = new AdvertGraphics(5, advert.getId(), null);
        advertText = new AdvertText(6, advert.getId(), null);
        issue = new MagazineIssue("Ciao", LocalDate.now(), 7);
        magazine = new Magazine("eeee", 8);
    }

    @Test
    public void testSetAndGetProcessingCentre() {
        editor.setProcessingCentre(processingCentre);
        assertEquals(processingCentre, editor.getProcessingCentre());
    }

    @Test
    public void testEditAdvertGraphics() {
        assertTrue(advert.getGraphics().isEmpty());// advert does not contain graphic
        editor.editAdvertGraphics(advert, advertGraphics);

        assertEquals(1, advert.getGraphics().size()); // Size should now be 1

        editor.editAdvertGraphics(advert, new AdvertGraphics(6, 55, null));// calling method again
        assertEquals(1, advert.getGraphics().size()); // Size should still be 1

    }

    @Test
    public void testEditAdvertTexts() {
        assertTrue(advert.getTexts().isEmpty()); // advert does not contain any text at the moment
        editor.editAdvertTexts(advert, advertText);

        assertEquals(1, advert.getTexts().size());// size should be 1 after calling method

        editor.editAdvertTexts(advert, new AdvertText(4, 4, null));
        assertEquals(1, advert.getTexts().size());// size should still be 1 after calling method
    }

    @Test
    public void testSetAndGetMagazineIssue() {
        MagazineIssue magazineIssue2 = new MagazineIssue("Hello", LocalDate.now(), 100);
        editor.setMagazineIssue(magazineIssue2);
        assertEquals(magazineIssue2, editor.getMagazineIssue());
    }

    @Test
    public void testSetAndGetMagazine() {
        assertEquals(null, editor.getMagazine());

        editor.setMagazine(magazine);
        assertEquals(magazine, editor.getMagazine());

    }

    // testing for missing advertiserID
    @Test
    public void testCheckAdvertWithMissingAdvertiserId() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        editor.checkAdvert(advert, 0, magazine);

        String output = outputStream.toString().trim();

        assertTrue("Expected error message when advertiserId is 0.", output
                .contains("Advertiser ID missing. Advert cannot be sent to ProcessingCentre. Contact advertiser."));

    }

    // testing for complete advert
    @Test
    public void testCheckAdvertWithCompleteAdvert() {
        advert.setIssueNumber(1);
        advert.setAdvetiserId(5);
        advert.addGraphic(advertGraphics);
        advert.addText(new AdvertText(3, 3, "Some text"));
        advert.setIsValid(true); // Mark advert as valid
        advert.setEditor(editor);
        advert.setEditorId(editor.getId());
        advert.setProcessingCentre(processingCentre);
        editor.setProcessingCentre(processingCentre);
        assertTrue(advert.isComplete());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        editor.checkAdvert(advert, 5, magazine);
        

        String output = outputStream.toString().trim();

        assertTrue(output.contains("Advert is complete. Ready to send."));
    }

    // Testing for issueNumber 0
    @Test
    public void testCheckAdvertWithMissingDetails() {

        advert.setIssueNumber(0); // Issue number is missing
        advert.addGraphic(advertGraphics);
        advert.addText(advertText);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        editor.setMagazine(magazine);
        editor.setMagazineIssue(issue); // issue number = 7
        magazine.addIssue(issue);

        editor.checkAdvert(advert, advert.getAdvertiserId(), magazine);

        String output = outputStream.toString().trim();

        assertTrue("Expected message when advert is missing details.",
                output.contains("Advert is missing details. Adding missing information..."));

        assertEquals(7, advert.getIssueNumber());
    }

    // Testing with magazine Issue which is not inside Magazine
    @Test
    public void testCheckAdvertWithInvalidMagazineIssue() {
        advert.setIssueNumber(99); // Invalid issue number

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        editor.checkAdvert(advert, advert.getAdvertiserId(), magazine);

        String output = outputStream.toString().trim();

        assertTrue("Expected error message when magazine issue is invalid.",
                output.contains("Error. Magazine Issue sent by Advertiser does not exist in this Magazine."));
    }

    @Test
    public void testCheckAdvertWithMissingGraphicsAndText() {
        // Create an advert with no graphics and no text
        advert.setIssueNumber(0); // Issue number is missing

        // Capture the output to verify what was printed
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act: Call checkAdvert with a valid advertiserId
        editor.checkAdvert(advert, 123, magazine);

        // Assert that missing graphics and text are added
        assertEquals(0, advert.getGraphics().size());
        assertEquals(0, advert.getTexts().size());

        advert.addGraphic(advertGraphics);
        advert.addText(advertText);

        assertEquals(1, advert.getGraphics().size());
        assertEquals(1, advert.getTexts().size());
    }

    // testing if validity is set right
    @Test
    public void testIsValid() {
        advert.setIssueNumber(1);
        advert.setAdvetiserId(5);
        advert.addText(new AdvertText(3, 3, "Some text"));
        advert.setIsValid(true); // Mark advert as valid
        advert.setEditor(editor);
        advert.setEditorId(editor.getId());
        advert.setProcessingCentre(processingCentre);

        assertEquals(false, editor.isValid(advert)); // gives fals cause graphics is missing
        advert.addGraphic(advertGraphics);

        assertEquals(true, editor.isValid(advert));
    }

    // Testing if advert is sent when valid and testing advert is not sent when
    // invalid
    @Test
    public void testSendAdvert() {
        ProcessingCentre processingCentre = new ProcessingCentre(101);

        Editor editor = new Editor(1, "John", "Doe");
        editor.setProcessingCentre(processingCentre);
        Magazine magazine = new Magazine("Hello Computers", 55);
        MagazineIssue magazineIssue = new MagazineIssue("Ciao Ciao", LocalDate.now(),
        66);
        editor.setMagazineIssue(magazineIssue);
        editor.setMagazine(magazine);

        //Magazine Issue is Added to the magazine
        magazine.addIssue(magazineIssue);

        Advertiser advertiser = new Advertiser(1001, "Jane", "Smith",
        "jane.smith@example.com");
        advertiser.setEditor(editor);

        Advert advert = new Advert(2001, LocalDate.now(), advertiser.getId());

        AdvertGraphics graphic = new AdvertGraphics(2, 2, null); //set to null to easily test
        AdvertText text = new AdvertText(4, 4, "hhihihihiih");
        advert.addGraphic(graphic);
        advert.addText(text);
        System.out.println("\n--- Advertiser Sends Advert ---");
        advertiser.setMagazine(magazine);
        editor.checkAdvert(advert, advertiser.getId(), magazine);
        editor.sendAdvert(advert);
        assertEquals(2, processingCentre.getAdverts().size());//expected is 2 because 1 advert is already stored when checkAdvert is called
    }

}
