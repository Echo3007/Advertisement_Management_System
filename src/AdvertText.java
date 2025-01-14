/*
Student: Angela Pellillo
Stundent ID: 21499500
Module ID: CP6CS19E
Module Name: Applied Software Engineering */

public class AdvertText {
    private int id;
    private int advertId;
    private String advertText;

    public AdvertText(int id, int advertId, String advertText) {
        this.id = id;
        this.advertId = advertId;
        this.advertText = advertText;
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

    public void setText(String newAdvertText) {
        advertText = newAdvertText;
    }

    public String getText() {
        return advertText;
    }

}
