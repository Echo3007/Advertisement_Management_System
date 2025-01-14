import java.time.LocalDate;
import java.util.List;

public interface AdvertInterface {
    void addText(AdvertText text);

    List<AdvertText> getTexts();

    void addGraphic(AdvertGraphics graphic);

    List<AdvertGraphics> getGraphics();

    void setGraphics(List<AdvertGraphics> graphics);

    void setTexts(List<AdvertText> texts);

    void setId(int newId);

    int getId();

    void setDate(LocalDate date);

    LocalDate getDate();

    void getGraphicsId();

    void getTextsId();

    void setProcessingCentre(ProcessingCentre newProCentre);

    ProcessingCentre getProcessingCentre();

    void setEditorId(int newEditorId);

    int getEditorId();

    void setIssueNumber(int newIssueNumberId);

    int getIssueNumber();

    void setAdvetiserId(int newAdvertiserId);

    int getAdvertiserId();

    boolean isComplete();

    void setEditor(Editor editor);

    Editor getEditor();

    // to check if Advert was validated by Editor
    void setIsValid(boolean validity);

    boolean getValidity();
}
