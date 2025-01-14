/*
Student: Angela Pellillo
Stundent ID: 21499500
Module ID: CP6CS19E
Module Name: Applied Software Engineering */

import org.junit.*;

import static org.junit.Assert.assertEquals;
import java.awt.Image; //Importing Image class from Java library

public class AdvertGraphicsTest {
    private AdvertGraphics graphic;
    private Image image;

    @Before
    public void setUp() {
        graphic = new AdvertGraphics(101, 1234, null);
        image = null;

    }

    @Test
    public void testGetId() {

        assertEquals(graphic.getId(), 101);
    }

    @Test
    public void testSetId() {
        graphic.setId(202);
        assertEquals("202", graphic.getId(), 202);
    }

    @Test
    public void testGetAdvertId() {
        assertEquals("1234", graphic.getAdvertId(), 1234);
    }

    @Test
    public void testSetAdvertId() {
        graphic.setAdvertId(5678);
        assertEquals("5678", graphic.getAdvertId(), 5678);
    }

    @Test
    public void testSetAndGetGraphics() {
        graphic.setGraphics(image);
        assertEquals(image, graphic.getGraphics());
    }
}
