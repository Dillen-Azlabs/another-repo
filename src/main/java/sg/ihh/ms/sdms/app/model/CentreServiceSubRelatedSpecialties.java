package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "h1Display", "itemUrl","summary", "order", "publishFlag", "createdDt", "modifiedDt"})
public class CentreServiceSubRelatedSpecialties extends BaseModel{

    @JsonProperty("h1Display")
    private String specialtyH1Display;
    @JsonProperty("itemUrl")
    private String itemUrl;
    @JsonProperty("summary")
    private String summary;

    public CentreServiceSubRelatedSpecialties() {
        //Empty Constructor
    }

    public String getSpecialtyH1Display() {
        return specialtyH1Display;
    }

    public void setSpecialtyH1Display(String specialtyH1Display) {
        this.specialtyH1Display = specialtyH1Display;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
