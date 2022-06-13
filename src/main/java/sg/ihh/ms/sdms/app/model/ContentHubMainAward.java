package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "sectionIntro", "awardItem", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ContentHubMainAward extends BaseModel {

    @JsonProperty("sectionIntro")
    private String sectionIntro;
    @JsonProperty("awardItem")
    private List<ContentHubMainAwardItem> awardItem;

    public ContentHubMainAward() {
        // Empty Constructor
    }

    public String getSectionIntro() {
        return sectionIntro;
    }

    public void setSectionIntro(String sectionIntro) {
        this.sectionIntro = sectionIntro;
    }

    public List<ContentHubMainAwardItem> getAwardItem() {
        return awardItem;
    }

    public void setAwardItem(List<ContentHubMainAwardItem> awardItem) {
        this.awardItem = awardItem;
    }
}
