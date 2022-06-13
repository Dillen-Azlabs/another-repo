package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "displayApptCta", "displayFindMPCta", "addCTALabel", "addCTAUrl", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ContentHubSubCta extends BaseModel{

    @JsonProperty("displayApptCta")
    private boolean displayApptCta;
    @JsonProperty("displayFindMPCta")
    private boolean displayFindMPCta;
    @JsonProperty("addCTALabel")
    private String addCtaLabel;
    @JsonProperty("addCTAUrl")
    private String addCtaUrl;

    public ContentHubSubCta() {
        //Empty Constructor
    }

    public boolean isDisplayApptCta() {
        return displayApptCta;
    }

    public void setDisplayApptCta(boolean displayApptCta) {
        this.displayApptCta = displayApptCta;
    }

    public boolean isDisplayFindMPCta() {
        return displayFindMPCta;
    }

    public void setDisplayFindMPCta(boolean displayFindMPCta) {
        this.displayFindMPCta = displayFindMPCta;
    }

    public String getAddCtaLabel() {
        return addCtaLabel;
    }

    public void setAddCtaLabel(String addCtaLabel) {
        this.addCtaLabel = addCtaLabel;
    }

    public String getAddCtaUrl() {
        return addCtaUrl;
    }

    public void setAddCtaUrl(String addCtaUrl) {
        this.addCtaUrl = addCtaUrl;
    }

}
