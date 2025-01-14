/*
Student: Angela Pellillo
Stundent ID: 21499500
Module ID: CP6CS19E
Module Name: Applied Software Engineering */

import java.util.ArrayList;

public class ProcessingCentre {
    private int proCenterId;
    private ArrayList<Advert> adverts; // list of adverts that are assigned to this processing centre

    public ProcessingCentre(int proCenterId) {
        this.proCenterId = proCenterId;
        this.adverts = new ArrayList<>();
    }

    public void setProCentreId(int newProCentreId) {
        this.proCenterId = newProCentreId;
    }

    public int getProCentreId() {
        return proCenterId;
    }

    public void addAdvert(Advert advert) {
        if (advert.getProcessingCentre() != null && advert.getProcessingCentre() != this) {
            System.out.println("Error. Processing Centre already assigned.");
            return;
        }
        adverts.add(advert);
    }

    public ArrayList<Advert> getAdverts() {
        return adverts;
    }

    // In a real world scenario, here there would probably be a database connection
    // to store the advert's content
    // As per OCL
    public void storeAdvertContent(Advert advert) {
        if (advert.isComplete() && advert.getValidity() == true) {
            System.out.println("Advert stored successfully in Processing Centre ID: " + proCenterId);
            addAdvert(advert);
        } else {
            System.out.println("Cannot store incomplete advert.");
        }
    }

}
