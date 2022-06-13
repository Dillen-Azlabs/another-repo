package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "sectionIntro", "tabItems", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPageTab extends BaseModel {

    @JsonProperty("sectionIntro")
    private String sectionIntro;
    @JsonProperty("tabItems")
    private List<StructuredPageTabItem> tabItems;

    public StructuredPageTab() {
        //Empty Constructor
    }

    public String getSectionIntro() {
        return sectionIntro;
    }

    public void setSectionIntro(String sectionIntro) {
        this.sectionIntro = sectionIntro;
    }

    public List<StructuredPageTabItem> getTabItems() {
        return tabItems;
    }

    public void setTabItems(List<StructuredPageTabItem> tabItems) {
        this.tabItems = tabItems;
    }
}
