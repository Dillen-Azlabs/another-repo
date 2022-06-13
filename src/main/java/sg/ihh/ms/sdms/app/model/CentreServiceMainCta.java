package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "displayEnquiryCta", "displayFindMpCta", "addCtaLabel", "addCtaUrl", "order", "publishFlag", "createdDt", "modifiedDt"})
public class CentreServiceMainCta extends BaseModel{

    @JsonProperty("displayEnquiryCta")
    private boolean displayEnquiryCta;
    @JsonProperty("displayFindMpCta")
    private boolean displayFindMpCta;
    @JsonProperty("addCtaLabel")
    private String addCtaLabel;
    @JsonProperty("addCtaUrl")
    private String addCtaUrl;
    @JsonIgnore
    protected int order;

    public CentreServiceMainCta() {
        // empty constructor
    }

    public boolean isDisplayEnquiryCta() {
        return displayEnquiryCta;
    }

    public void setDisplayEnquiryCta(boolean displayEnquiryCta) {
        this.displayEnquiryCta = displayEnquiryCta;
    }

    public boolean isDisplayFindMpCta() {
        return displayFindMpCta;
    }

    public void setDisplayFindMpCta(boolean displayFindMpCta) {
        this.displayFindMpCta = displayFindMpCta;
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
