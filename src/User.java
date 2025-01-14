/*
Student: Angela Pellillo
Stundent ID: 21499500
Module ID: CP6CS19E
Module Name: Applied Software Engineering */


abstract class User {
    protected int id;
    protected String name;
    protected String surname;

    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;

    }

    public void setName(String newName) {
        this.name = newName;

    }

    public String getName() {
        return this.name;
    }

    public void setSurname(String newSurname) {
        this.surname = newSurname;

    }

    public String getSurname() {
        return this.surname;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public abstract void sendAdvert(Advert advert);

}
