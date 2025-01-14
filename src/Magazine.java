/*
Student: Angela Pellillo
Stundent ID: 21499500
Module ID: CP6CS19E
Module Name: Applied Software Engineering */

import java.util.ArrayList;

public class Magazine {
    private String name;
    private int id;
    private ArrayList<MagazineIssue> issues;

    public Magazine (String name, int id){
        this.name = name;
        this.id = id;
        this.issues = new ArrayList<>();
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getName(){
        return name;
    }

    public void setId(int newId){
        this.id = newId;
    }

    public int getId(){
        return id;
    }

    public void addIssue(MagazineIssue magazineIssue){
        issues.add(magazineIssue);
        magazineIssue.setMagazine(this);
    }

    public ArrayList<MagazineIssue> getIssues(){
        return issues;
    }

}
