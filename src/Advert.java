/*
Student: Angela Pellillo
Stundent ID: 21499500
Module ID: CP6CS19E
Module Name: Applied Software Engineering */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Advert implements AdvertInterface {
    private int advertId;
    private LocalDate date;
    private int editorId = 0;
    private ProcessingCentre proCenter;
    private int advertiserId;
    private int issueNumber = 0;
    private Editor editor;
    private boolean isValid = false;

    // Composition: Lists for texts and graphics
    private List<AdvertText> texts;
    private List<AdvertGraphics> graphics;

    // Constructor
    public Advert(int advertId, LocalDate date, int advertiserId) {
        this.advertId = advertId;
        this.date = date;
        this.advertiserId = advertiserId;

        // Initialize lists
        this.texts = new ArrayList<>();
        this.graphics = new ArrayList<>();
    }

    // Add a text element
    @Override
    public void addText(AdvertText text) {
        this.texts.add(text);
    }

    // Add a graphic element
    @Override
    public void addGraphic(AdvertGraphics graphic) {
        this.graphics.add(graphic);
    }

    // Retrieve all text elements
    @Override
    public List<AdvertText> getTexts() {
        return texts;
    }

    // Retrieve all graphic elements
    @Override
    public List<AdvertGraphics> getGraphics() {
        return graphics;
    }

    // Set the list of graphics
    @Override
    public void setGraphics(List<AdvertGraphics> graphics) {
        this.graphics = graphics;
    }

    // Set the list of texts
    @Override
    public void setTexts(List<AdvertText> texts) {
        this.texts = texts;
    }

    // Retrieve the advert ID
    @Override
    public int getId() {
        return advertId;
    }

    // Display advert information
    public void displayAdvertInfo() {
        System.out.println("Advert Details:");
        System.out.println("Advert ID: " + advertId);
        System.out.println("Issue Number: " + (issueNumber == 0 ? "Not Assigned" : issueNumber));
        System.out.println("Editor ID: " + (editorId == 0 ? "Not Assigned" : editorId));
        System.out
                .println("Processing Centre ID: " + (proCenter == null ? "Not Assigned" : proCenter.getProCentreId()));
        System.out.println("Advertiser ID: " + advertiserId);
        System.out.println("Advert Date: " + date);

        System.out.println("\nTexts:");
        for (AdvertText text : texts) {
            System.out.println("- " + text.getText());
        }

        System.out.println("\nGraphics:");
        for (AdvertGraphics graphic : graphics) {
            System.out.println("- Graphic ID: " + graphic.getId());
        }
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public void getGraphicsId() {
        for (AdvertGraphics graphic : graphics) {
            System.out.println("Graphic ID: " + graphic.getId() + ", Image: " + graphic.getGraphics());
        }
    }

    @Override
    public void getTextsId() {
        for (AdvertText text : texts) {
            System.out.println("Graphic ID: " + text.getId() + ", Image: " + text.getText());
        }

    }

    // Check if advert is complete (required before sending to ProcessingCentre)
    public boolean isComplete() {
        return editorId != 0 && proCenter != null && issueNumber != 0 && !texts.isEmpty() && !graphics.isEmpty()
                && isValid;
    }

    @Override
    public void setId(int newId) {
        this.advertId = newId;
    }

    @Override
    public void setProcessingCentre(ProcessingCentre newProCentre) {
        // Ensuring only one processing centre is assigned to the advert
        if (this.proCenter != null) {
            System.out.println("Error. Processing Centre already assigned to this advert.");
            return;
        }
        this.proCenter = newProCentre;
    }

    @Override
    public ProcessingCentre getProcessingCentre() {
        return proCenter;
    }

    @Override
    public void setEditorId(int newEditorId) {
        this.editorId = newEditorId;
    }

    @Override
    public int getEditorId() {
        return editorId;
    }

    @Override
    public void setIssueNumber(int newIssueNumber) {
        this.issueNumber = newIssueNumber;
    }

    @Override
    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public void setAdvetiserId(int newAdvertiserId) {
        this.advertiserId = newAdvertiserId;
    }

    @Override
    public int getAdvertiserId() {
        return advertiserId;
    }

    @Override
    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    @Override
    public Editor getEditor() {
        return editor;
    }

    // To set and retrieve if advert is been validated by Editor
    @Override
    public void setIsValid(boolean validity) {
        this.isValid = validity;
    }

    @Override
    public boolean getValidity() {
        return isValid;
    }
}
