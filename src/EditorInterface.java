/*
Student: Angela Pellillo
Stundent ID: 21499500
Module ID: CP6CS19E
Module Name: Applied Software Engineering */

//Editor interface. Allows for flexibility in case different types of Editor classes need to be implemented (eg. Junior Editor, Senior Editor etc).
public interface EditorInterface {
    void checkAdvert(Advert advert, int advertiserId, Magazine magazine);

    void editAdvertGraphics(Advert advert, AdvertGraphics newGraphics);

    void editAdvertTexts(Advert advert, AdvertText newText);

    void setProcessingCentre(ProcessingCentre processingCentre);

    ProcessingCentre getProcessingCentre();

    void setMagazineIssue(MagazineIssue magazineIssue);

    MagazineIssue getMagazineIssue();

    boolean isValid(Advert advert); //to check if advert is valid before sending it to ProcessingCentre

    void setMagazine(Magazine magazine);
    Magazine getMagazine();

}
