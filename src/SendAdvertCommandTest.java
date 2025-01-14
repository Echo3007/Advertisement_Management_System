import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class SendAdvertCommandTest {
    private ProcessingCentre processingCentre;
    private Advert advert, incompleteAdvert, nullAdvert;
    private SendAdvertCommand sendAdvertCommand;

    @Before
    public void setUp() {
        processingCentre = new ProcessingCentre(8);
        sendAdvertCommand = new SendAdvertCommand(processingCentre, advert);
        processingCentre = new ProcessingCentre(8);
        advert = new Advert(77, LocalDate.now(), 99);
        advert.setEditorId(88);
        advert.setIssueNumber(99);
        AdvertGraphics graphic = new AdvertGraphics(2, 2, null); // set to null to easily test
        AdvertText text = new AdvertText(4, 4, "hhihihihiih");
        advert.addGraphic(graphic);
        advert.addText(text);
        advert.setIsValid(true);
        advert.setProcessingCentre(processingCentre);
        incompleteAdvert = new Advert(5, LocalDate.now(), 7);
    }

    // Testing isValid function to check if advert is not null and is complete
    @Test
    public void testIsValid() {
        assertFalse(sendAdvertCommand.isValid(nullAdvert));// checking that it returns false if advert is null
        assertFalse(sendAdvertCommand.isValid(incompleteAdvert));// checking that it returns false if advert is
                                                                 // incomplete
        assertTrue(sendAdvertCommand.isValid(advert));
    }

    // Testing that command is executed only if advert is valid. Error is thrown
    // otherwise
    @Test
    public void testExecute() {
        // testing for incomplete advert
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        sendAdvertCommand.execute();
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Error.Invalid advert. Command cannot be executed."));

        // Testing for complete advert
        processingCentre = new ProcessingCentre(8);
        sendAdvertCommand = new SendAdvertCommand(processingCentre, advert);
        processingCentre = new ProcessingCentre(8);
        advert = new Advert(77, LocalDate.now(), 99);
        advert.setEditorId(88);
        advert.setIssueNumber(99);
        AdvertGraphics graphic = new AdvertGraphics(2, 2, null);
        AdvertText text = new AdvertText(4, 4, "hhihihihiih");
        advert.addGraphic(graphic);
        advert.addText(text);
        advert.setIsValid(true);
        advert.setProcessingCentre(processingCentre);

        sendAdvertCommand.execute();
        output = outputStream.toString().trim();
        assertTrue(output.contains("Executing command..."));

    }

}
