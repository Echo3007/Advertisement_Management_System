/*
Student: Angela Pellillo
Stundent ID: 21499500
Module ID: CP6CS19E
Module Name: Applied Software Engineering */

public class SendAdvertCommand implements CommandInterface {
    private ProcessingCentre processingCentre;
    private Advert advert;

    public SendAdvertCommand(ProcessingCentre processingCentre, Advert advert) {
        this.processingCentre = processingCentre;
        this.advert = advert;
    }

    // check if advert is valid and complete, returns boolean value
    public boolean isValid(Advert advert) {
        return advert != null && advert.isComplete();
    }

    @Override
    public void execute() {
        if (isValid(advert)) {
            System.out.println("Executing command...");
            processingCentre.storeAdvertContent(advert);
        } else {
            System.out.println("Error.Invalid advert. Command cannot be executed.");
        }

    }
}
