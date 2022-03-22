package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
@JsonPropertyOrder({"uid", "languageCode", "sectionIntro", "title","anchorId","content", "order", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPageAccordion extends BaseModel {

    @JsonProperty("sectionIntro")
    private String sectionIntro;
    @JsonProperty("title")
    private String title;
    @JsonProperty("anchorId")
    private String anchorId;
    @JsonProperty("content")
    private String body;

    public StructuredPageAccordion() {
        // Empty Constructor
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

    public String getAnchorId() {
        return anchorId;
    }

    public void setAnchorId(String anchorId) {
        this.anchorId = anchorId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
