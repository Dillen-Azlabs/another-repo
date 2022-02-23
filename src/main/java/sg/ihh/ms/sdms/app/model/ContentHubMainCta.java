package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "displayApptCta", "displayFindMPCta", "addCTALabel", "addCTAUrl",  "order",  "overview", "publishFlag", "createdDt", "modifiedDt"})
public class ContentHubMainCta extends BaseModel{

    @JsonProperty("displayApptCta")
    private boolean displayApptCta;
    @JsonProperty("displayFindMPCta")
    private boolean displayFindMpCta;
    @JsonProperty("addCTALabel")
    private String addCtaLabel;
    @JsonProperty("addCTAUrl")
    private String addCtaUrl;
    @JsonProperty("overview")
    private String overview;

    public ContentHubMainCta() {
        //Empty Constructor
    }

    public boolean isDisplayApptCta() {
        return displayApptCta;
    }

    public void setDisplayApptCta(boolean displayApptCta) {
        this.displayApptCta = displayApptCta;
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
