package sg.ihh.ms.sdms.app.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "sectionIntro", "title", "content", "anchorID", "order", "publishFlag", "createdDt", "modifiedDt"})
public class CentreServiceSubAccordion extends  BaseModel{
    @JsonProperty("sectionIntro")
    private String sectionIntro;
    @JsonProperty("title")
    private String title;
    @JsonProperty("content")
    private String body;
    @JsonProperty("anchorID")
    private String anchorId;

    public CentreServiceSubAccordion() {
    }

    public String getSectionIntro() {
        return sectionIntro;
    }

    public void setSectionIntro(String sectionIntro) {
        this.sectionIntro = sectionIntro;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAnchorId() {
        return anchorId;
    }

    public void setAnchorId(String anchorId) {
        this.anchorId = anchorId;
    }
}
