import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

public class AdvertiserTest {
    private Advert advert;
    private Editor editor;
    private Advertiser advertiser;
    private ProcessingCentre processingCentre;
    private Magazine magazine;

    @Before
    public void setUp() {
        advertiser = new Advertiser(1, "Han", "Solo", "hansolo@gmail.com");
        editor = new Editor(2, "An", "Pi");
        advert = new Advert(3, LocalDate.now(), 7);
        processingCentre = new ProcessingCentre(88);
        magazine = new Magazine("jjjj", 4);


    }

    @Test
    public void testSetAndGetEditor() {
        advertiser.setEditor(editor);
        assertEquals(editor, advertiser.getEditor());

    }

    @Test
    public void testSetAndGetContact() {
        advertiser.setContact("NewContact@gmail.com");
        assertEquals("NewContact@gmail.com", advertiser.getContact());
    }

    @Test
    public void testSetAndGetMagazine(){
        assertEquals(null, advertiser.getMagazine());

        advertiser.setMagazine(magazine);
        assertEquals(magazine, advertiser.getMagazine());

    }


    @Test
    public void testSendAdvert() {
        assertEquals(null, advertiser.getEditor());

        advertiser.setEditor(editor);
        editor.setProcessingCentre(processingCentre);
        advertiser.setMagazine(magazine);

        // Capture the output to verify what was printed
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        advertiser.sendAdvert(advert);

        String output = outputStream.toString().trim();

        // Assert the expected output contains the correct message
        assertTrue(output.contains(
                "Sending advert to Editor.\nAdvertiser Name: " + advertiser.getName() + " " + advertiser.getSurname()
                        + "\nAdvert ID: " + advert.getId()));
    }
}
