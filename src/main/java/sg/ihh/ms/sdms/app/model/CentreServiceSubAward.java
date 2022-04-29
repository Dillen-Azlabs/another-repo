package sg.ihh.ms.sdms.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "sectionIntro", "awardItems", "order", "publishFlag", "createdDt", "modifiedDt"})
public class CentreServiceSubAward extends BaseModel{

    @JsonProperty("sectionIntro")
    private String sectionIntro;
    @JsonProperty("awardItems")
    private List<CentreServiceSubAwardItem> awardItem;
    @JsonIgnore
    private int order;

    public CentreServiceSubAward() {
    }

    public String getSectionIntro() {
        return sectionIntro;
    }

    public void setSectionIntro(String sectionIntro) {
        this.sectionIntro = sectionIntro;
    }

    public List<CentreServiceSubAwardItem> getAwardItem() {
        return awardItem;
    }

    public void setAwardItem(List<CentreServiceSubAwardItem> awardItem) {
        this.awardItem = awardItem;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public void setOrder(int order) {
        this.order = order;
    }
}
