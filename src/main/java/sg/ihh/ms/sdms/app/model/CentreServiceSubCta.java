package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "heading", "description", "buttonLabel", "buttonUrl", "newTab", "publishFlag", "createdDt", "modifiedDt"})
public class CentreServiceSubCta extends BaseModel{
    @JsonProperty("heading")
    private String ctaSectionHeading;
    @JsonProperty("description")
    private String ctaSectionDescription;
    @JsonProperty("buttonLabel")
    private String ctaSectionButtonLabel;
    @JsonProperty("buttonUrl")
    private String ctaSectionButtonUrl;
    @JsonProperty("newTab")
    private boolean ctaSectionSuttonNewtab;

    public CentreServiceSubCta() {
    }

    public String getCtaSectionHeading() {
        return ctaSectionHeading;
    }

    public void setCtaSectionHeading(String ctaSectionHeading) {
        this.ctaSectionHeading = ctaSectionHeading;
    }

    public String getCtaSectionDescription() {
        return ctaSectionDescription;
    }

    public void setCtaSectionDescription(String ctaSectionDescription) {
        this.ctaSectionDescription = ctaSectionDescription;
    }

    public String getCtaSectionButtonLabel() {
        return ctaSectionButtonLabel;
    }

    public void setCtaSectionButtonLabel(String ctaSectionButtonLabel) {
        this.ctaSectionButtonLabel = ctaSectionButtonLabel;
    }

    public String getCtaSectionButtonUrl() {
        return ctaSectionButtonUrl;
    }

    public void setCtaSectionButtonUrl(String ctaSectionButtonUrl) {
        this.ctaSectionButtonUrl = ctaSectionButtonUrl;
    }

    public boolean isCtaSectionSuttonNewtab() {
        return ctaSectionSuttonNewtab;
    }

    public void setCtaSectionSuttonNewtab(boolean ctaSectionSuttonNewtab) {
        this.ctaSectionSuttonNewtab = ctaSectionSuttonNewtab;
    }
}
