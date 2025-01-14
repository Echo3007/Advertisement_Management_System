import org.junit.*;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

public class AdvertTextTest {

    private Advert advert;
    private Advert advert2;
    private AdvertText advertText;
    private String sampleText2;

    @Before
    public void setUp() {
        advert = new Advert(1, LocalDate.now(), 5);
        advert2 = new Advert(2, LocalDate.now(), 9);
        advertText = new AdvertText(1, advert.getId(), "Sample text");
        sampleText2 = "Ciao ciao ciao";

    }

    @Test
    public void testSetAndGetId() {
        advertText.setId(9);
        assertEquals(9, advertText.getId());
    }

    @Test
    public void testSetAndGetAdvertId() {
        advertText.setAdvertId(advert2.getId());
        assertEquals(advert2.getId(), advertText.getAdvertId());
    }

    @Test
    public void testSetAndGetText() {
        advertText.setText(sampleText2);
        assertEquals(sampleText2, advertText.getText());
    }

}
