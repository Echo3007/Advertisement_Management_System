/*
Student: Angela Pellillo
Stundent ID: 21499500
Module ID: CP6CS19E
Module Name: Applied Software Engineering */

import java.time.LocalDate;

public class MagazineIssue {
    private String name;
    private LocalDate dateIssued;
    private int issueNumber;
    Magazine magazine;

    public MagazineIssue(String name, LocalDate dateIssued, int issueNumber) {
        this.name = name;
        this.dateIssued = dateIssued;
        this.issueNumber = issueNumber;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public void setDateIssued(LocalDate newDateIssued) {
        this.dateIssued = newDateIssued;
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public void setIssueNumber(int newIssueNumber) {
        this.issueNumber = newIssueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setMagazine(Magazine magazine){
        this.magazine = magazine;
    }

    public Magazine getMagazine(){
        return magazine;
    }

}
