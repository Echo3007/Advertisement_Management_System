/*
Student: Angela Pellillo
Stundent ID: 21499500
Module ID: CP6CS19E
Module Name: Applied Software Engineering */

public class Editor extends User implements EditorInterface {
    ProcessingCentre processingCentre;
    MagazineIssue magazineIssue;
    AdvertGraphics graphic;
    AdvertText text;
    Magazine magazine;

    public Editor(int id, String name, String surname) {
        super(id, name, surname);
    }

    @Override
    public void editAdvertGraphics(Advert advert, AdvertGraphics newGraphics) {
        if (advert.getGraphics().isEmpty()) {
            System.out.println("Graphics missing. Adding graphic.");
            advert.addGraphic(newGraphics);
        }
    }

    @Override
    public void editAdvertTexts(Advert advert, AdvertText newText) {
        if (advert.getTexts().isEmpty()) {
            System.out.println("Text missing. Adding text to advert.");
            advert.addText(newText);
        }
    }

    @Override
    public void setProcessingCentre(ProcessingCentre processingCentre) {
        this.processingCentre = processingCentre;
    }

    @Override
    public ProcessingCentre getProcessingCentre() {
        return processingCentre;
    }

    @Override
    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    @Override
    public Magazine getMagazine() {
        return magazine;
    }

    @Override
    public void setMagazineIssue(MagazineIssue newMagazineIssue) {
        this.magazineIssue = newMagazineIssue;
    }

    @Override
    public MagazineIssue getMagazineIssue() {
        return magazineIssue;
    }

    /*
     * Implementation of:
     * Rule 1: Editor must validate Advert before invoking the SendAdvertCommand
     * Multiplicity: Many(Advert) to 1(Editor)
     * Precondition: the Advert must be validated
     * 
     * OCL
     * context SendAdvertCommand :: execute()
     * pre: advert.isValidated = true
     */

    @Override
    public void checkAdvert(Advert advert, int advertiserId, Magazine magazine) {
        System.out.println("\n--- Editor Reviews Advert ---");
        advert.setEditor(this); // The Editor assigns themselves as the Advert Editor
        advert.displayAdvertInfo();

        /*
         * Implementation of Rule 3: Each Advert must reference a valid Advertiser
         * OCL
         * 
         * context Advert
         * inv ValidAdvertiser:
         * not self.advertiser.oclIsUndefined()
         */
        if (advert.getAdvertiserId() == 0 || advert.getAdvertiserId() != advertiserId) {
            System.out.println("Advertiser ID missing. Advert cannot be sent to ProcessingCentre. Contact advertiser.");
        
            return;
        } else {
            if (advert.isComplete()) {
                System.out.println("Advert is complete. Ready to send.");
            } else {
                System.out.println("Advert is missing details. Adding missing information...");

                // Assign missing details
                if (advert.getEditorId() == 0) {
                    advert.setEditorId(this.getId());
                }
                if (advert.getProcessingCentre() == null) {
                    advert.setProcessingCentre(processingCentre); // Assign Processing Centre to Advert
                }
                /*
                 * Implementing Rule 5 OCL: Rule 5: The issueNumber in Advert must corresponde
                 * to an existing MagazineIssue
                 * Multiplicity: 1 to 1
                 * OCL
                 * context Advert
                 * inv ValidMagazineIssue:
                 * MagazineIssue.allInstances()->exists(issue | issue.issueNumber =
                 * self.issueNumber)
                 */
                if (advert.getIssueNumber() == 0 && this.magazine == magazine
                        && magazine.getIssues().contains(magazineIssue)) {
                    advert.setIssueNumber(magazineIssue.getIssueNumber());
                } else {
                    System.out.println(
                            "Error. Magazine Issue sent by Advertiser does not exist in this Magazine.\nPlease select valid Magazine Issue of "
                                    + magazine.getName());
                    return;
                }
                /*
                 * Implementing Rule 2: An Advert must contain AdvertText and AdvertGraphics
                 * before it can be sent to the ProcessingCentre.
                 * 
                 * OCL
                 * 
                 * context Advert
                 * inv MustContainTextsAndGraphics:
                 * self.texts->size() > 0 and self.graphics->size() > 0
                 */
                if (advert.getGraphics().size() == 0) {
                    graphic = new AdvertGraphics(10, 15, null);
                    advert.addGraphic(graphic);
                }

                if (advert.getTexts().size() == 0) {
                    text = new AdvertText(3, 3, "SKSJSJDAJ");
                    advert.addText(text);
                }

                advert.setIsValid(true); // after all details have been added, advert is marked as valid by Editor
            }
            // Display updated advert info
            advert.displayAdvertInfo();
            sendAdvert(advert);
        }
    }

    @Override
    public void sendAdvert(Advert advert) {
        if (isValid(advert)) {
            System.out.println("Sending advert to Processing Centre...");
            SendAdvertCommand sendCommand = new SendAdvertCommand(processingCentre, advert);
            Invoker invoker = new Invoker();
            invoker.setCommand(sendCommand);
            invoker.processCommand(sendCommand);
        } else {
            System.out.println("Advert is incomplete. Cannot send to Processing Centre.");
        }
    }

    // check if advert is valid and complete, returns boolean value, will be used
    // for SendAdvertCommand
    @Override
    public boolean isValid(Advert advert) {
        return advert != null && advert.isComplete();
    }

}
