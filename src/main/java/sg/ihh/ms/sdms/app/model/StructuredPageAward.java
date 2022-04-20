package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;



@JsonPropertyOrder({"uid", "languageCode", "sectionIntro", "awardItems", "order", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPageAward extends BaseModel {

    @JsonProperty("sectionIntro")
    private String awardIntro;
    @JsonIgnore
    protected int order;
    @JsonProperty("awardItems")
    private List<StructuredPageAwardItem> awardItem;

    public StructuredPageAward() {
        // Empty Constructor
    }

    public String getAwardIntro() {
        return awardIntro;
    }

    public void setAwardIntro(String awardIntro) {
        this.awardIntro = awardIntro;
    }

    public List<StructuredPageAwardItem> getAwardItem() {
        return awardItem;
    }

    public void setAwardItem(List<StructuredPageAwardItem> awardItem) {
        this.awardItem = awardItem;
    }
}
