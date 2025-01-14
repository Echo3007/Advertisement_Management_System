import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

public class AdvertTest {
    private Advert advert;
    private AdvertText advertText;
    private AdvertText advertText2;
    private AdvertGraphics advertGraphics;
    private AdvertGraphics advertGraphics2;
    private List<AdvertText> texts;
    private List<AdvertGraphics> graphics;
    Editor editor;
    ProcessingCentre processingCentre;
    MagazineIssue issue;

    @Before
    public void setUp() {
        advert = new Advert(1, LocalDate.now(), 1);
        advertText = new AdvertText(1, 1, "Test Random Text 1");
        advertText2 = new AdvertText(2, 2, "Test Random Text 2");
        advertGraphics = new AdvertGraphics(3, 3, null);
        advertGraphics2 = new AdvertGraphics(4, 4, null);
        texts = advert.getTexts();
        graphics = advert.getGraphics();
        editor = new Editor(1, "A", "P");
        processingCentre = new ProcessingCentre(9);
        issue = new MagazineIssue("Hello", LocalDate.now(), 66);
    }

    //Testing adding and getting texts
    @Test
    public void testAddAndGetText() {
        advert.addText(advertText);
        advert.addText(advertText2);

        assertEquals(2, texts.size());
        assertEquals("Expected: Test Random Text 1", texts.get(0).getText(), "Test Random Text 1");
        assertEquals("Expected: Test Random Text 2", texts.get(1).getText(), "Test Random Text 2");

    }

    //Testing adding and getting graphics
    @Test
    public void testAddAndGetGraphic() {
        advert.addGraphic(advertGraphics);
        advert.addGraphic(advertGraphics2);
        assertEquals(2, graphics.size());
        assertEquals("Expected graphic id should be 3", graphics.get(0).getId(), 3);
        assertEquals("Expected graphic id should be 4", graphics.get(1).getId(), 4);
    }

    @Test
    public void testSetGraphics() {
        advert.addGraphic(advertGraphics);
        advert.addGraphic(advertGraphics2);
        advert.setGraphics(graphics);
        assertEquals("The first graphic should match.", graphics, advert.getGraphics());

    }

    @Test
    public void testSetTexts() {
        advert.addText(advertText);
        advert.addText(advertText2);
        advert.setTexts(texts);
        assertEquals("The first graphic should match.", texts, advert.getTexts());
    }

    @Test
    public void testSetAndGetId() {
        advert.setId(7);
        assertEquals("Expected advert id: ", 7, advert.getId());
    }

    @Test
    public void testDisplayAdvertInfo() {
        // This one is manually verified in the terminal
        advert.displayAdvertInfo();

    }

    @Test
    public void testSetAndGetDate() {
        LocalDate expectedDate = LocalDate.of(2025, 12, 25);
        advert.setDate(expectedDate);
        assertEquals(expectedDate, advert.getDate());
        System.out.println(advert.getDate());
    }

    @Test
    public void testGetGraphicsId() {
        advert.addGraphic(advertGraphics);
        advert.addGraphic(advertGraphics2);
        assertEquals("Expected graphic id should be 3", graphics.get(0).getId(), 3);
        assertEquals("Expected graphic id should be 4", graphics.get(1).getId(), 4);

    }

    @Test
    public void testGetTextsId() {
        advert.addText(advertText);
        advert.addText(advertText2);
        assertEquals("Expected text id should be 1", texts.get(0).getId(), 1);
        assertEquals("Expected text id should be 2", texts.get(1).getId(), 2);

    }

    @Test
    public void testIsComplete() {

        // Checks that the advert is complete, meaning: editorId != 0 && proCenterId !=
        // 0 && issueNumber != 0 && !texts.isEmpty() && !graphics.isEmpty();

        editor.setProcessingCentre(processingCentre);
        advert.setProcessingCentre(processingCentre);
        advert.setIsValid(false);
        advert.setIssueNumber(6);
        advert.setEditorId(editor.getId());
        assertEquals(1, advert.getId());
        assertEquals(LocalDate.now(), advert.getDate());
        assertEquals(1, advert.getAdvertiserId());
        assertEquals(1, advert.getEditorId());
        assertEquals(processingCentre, advert.getProcessingCentre());
        assertEquals(false, advert.getValidity());

    }

    // testing if processing center is assigned correctly to advert and checking
    // that
    // when assigned already, it does not re-assign it.
    @Test
    public void testSetAndGetProcessingCentre() {
        ProcessingCentre processingCentre2 = new ProcessingCentre(5);
        assertEquals(null, advert.getProcessingCentre());

        // Arrange
        advert.setProcessingCentre(processingCentre);

        // Capture console output
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        advert.setProcessingCentre(processingCentre2);

        // Assert
        assertEquals("ProcessingCentre should not be changed when already assigned.", processingCentre,
                advert.getProcessingCentre());
        assertTrue("Error message should be displayed.",
                outContent.toString().contains("Error. Processing Centre already assigned to this advert."));

        // Reset System.out
        System.setOut(originalOut);

    }

    @Test
    public void testSetAndGetEditorId() {
        advert.setEditorId(editor.getId());
        assertEquals(1, advert.getEditorId());
    }

    @Test
    public void testSetAndGetIssueNumber() {
        advert.setIssueNumber(issue.getIssueNumber());
        assertEquals(66, advert.getIssueNumber());

    }

    // Testing setters and getters for AdvertiserID
    @Test
    public void testSetAndGetAdvertiserID() {
        // using the advertiserId set in setUp()
        assertEquals(1, advert.getAdvertiserId());
        Advertiser advertiser = new Advertiser(88, "ashdsh", "zhshsh`", "shshsh");
        advert.setAdvetiserId(advertiser.getId());
        assertEquals(advertiser.getId(), advert.getAdvertiserId());
    }

    // Testing getter and setter for editor
    @Test
    public void testSetAndGetterEditor() {
        assertEquals(null, advert.getEditor());
        advert.setEditor(editor);
        assertEquals(editor, advert.getEditor());
    }

}
