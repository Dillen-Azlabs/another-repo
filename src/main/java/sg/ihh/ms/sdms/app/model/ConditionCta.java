package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "displayApptCta", "displayFindCta", "addCtaLabel", "addCtaUrl", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ConditionCta extends BaseModel{


    @JsonProperty("displayApptCta")
    private boolean displayApptCta;
    @JsonProperty("displayFindCta")
    private boolean displayFindCta;
    @JsonProperty("addCtaLabel")
    private String addCtaLabel;
    @JsonProperty("addCtaUrl")
    private String addCtaUrl;

    public ConditionCta() {
        // empty constructor
    }

    public boolean isDisplayApptCta() {
        return displayApptCta;
    }

    public void setDisplayApptCta(boolean displayApptCta) {
        this.displayApptCta = displayApptCta;
    }

    public boolean isDisplayFindCta() {
        return displayFindCta;
    }

    public void setDisplayFindCta(boolean displayFindCta) {
        this.displayFindCta = displayFindCta;
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
