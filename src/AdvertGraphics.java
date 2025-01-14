/*
Student: Angela Pellillo
Stundent ID: 21499500
Module ID: CP6CS19E
Module Name: Applied Software Engineering */

import java.awt.Image; //Importing Image class from Java library

public class AdvertGraphics {

    private int id;
    private int advertId;
    private Image graphics;

    public AdvertGraphics(int id, int advertId, Image graphics) {
        this.id = id;
        this.advertId = advertId;
        this.graphics = graphics;

    }

    public void setId(int newId) {
        id = newId;
    }

    public int getId() {
        return id;
    }

    public void setAdvertId(int newAdvertId) {
        advertId = newAdvertId;
    }

    public int getAdvertId() {
        return advertId;
    }

    public void setGraphics(Image newGraphics) {
        graphics = newGraphics;
    }

    public Image getGraphics() {
        return graphics;
    }

}
