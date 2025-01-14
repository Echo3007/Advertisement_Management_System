/*
Student: Angela Pellillo
Stundent ID: 21499500
Module ID: CP6CS19E
Module Name: Applied Software Engineering */

public class Advertiser extends User {

    private Editor editor;
    private String contact;
    private Magazine magazine;

    public Advertiser(int id, String name, String surname, String contact) {
        super(id, name, surname);
        this.contact = contact;
    }

    // Getter for editor
    public Editor getEditor() {
        return editor;
    }

    // Setter for editor
    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public void setContact(String newContact) {
        this.contact = newContact;
    }

    public String getContact() {
        return contact;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    @Override
    public void sendAdvert(Advert advert) {
        if (editor == null) {
            System.out.println("No editor assigned! Cannot send the advert.");
        } else {
            System.out.println(
                    "Sending advert to Editor.\nAdvertiser Name: " + getName() + " " + getSurname()
                            + "\nAdvert ID: " + advert.getId());
            editor.checkAdvert(advert, getId(), magazine);
        }
    }

}
