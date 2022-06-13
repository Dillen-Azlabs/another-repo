package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"uid", "languageCode", "sectionIntro", "title","anchorId", "content", "order", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredCampaignAccordion extends BaseModel{

    @JsonProperty("sectionIntro")
    private String sectionIntro;
    @JsonProperty("title")
    private String title;
    @JsonProperty("anchorID")
    private String anchorId;
    @JsonProperty("content")
    private String content;

    public StructuredCampaignAccordion() {
        //Empty Constructor
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
