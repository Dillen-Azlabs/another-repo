package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "careAreaOverview", "specialistsHeading", "specialistsCount", "specialistsLabel", "specialistsDescription", "specialistsButtonLabel", "specialistsButtonUrl", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ContentHubMainCareAreaSpecialist extends BaseModel{

    @JsonProperty("careAreaOverview")
    private String careAreaOverview;
    @JsonProperty("specialistsHeading")
    private String specialistsHeading;
    @JsonProperty("specialistsCount")
    private String specialistsCount;
    @JsonProperty("specialistsLabel")
    private String specialistsLabel;
    @JsonProperty("specialistsDescription")
    private String specialistsDescription;
    @JsonProperty("specialistsButtonLabel")
    private String specialistsButtonLabel;
    @JsonProperty("specialistsButtonUrl")
    private String specialistsButtonUrl;

    public ContentHubMainCareAreaSpecialist() {
        //Empty Constructor
    }

    public String getCareAreaOverview() {
        return careAreaOverview;
    }

    public void setCareAreaOverview(String careAreaOverview) {
        this.careAreaOverview = careAreaOverview;
    }

    public String getSpecialistsHeading() {
        return specialistsHeading;
    }

    public void setSpecialistsHeading(String specialistsHeading) {
        this.specialistsHeading = specialistsHeading;
    }

    public String getSpecialistsCount() {
        return specialistsCount;
    }

    public void setSpecialistsCount(String specialistsCount) {
        this.specialistsCount = specialistsCount;
    }

    public String getSpecialistsLabel() {
        return specialistsLabel;
    }

    public void setSpecialistsLabel(String specialistsLabel) {
        this.specialistsLabel = specialistsLabel;
    }

    public String getSpecialistsDescription() {
        return specialistsDescription;
    }

    public void setSpecialistsDescription(String specialistsDescription) {
        this.specialistsDescription = specialistsDescription;
    }

    public String getSpecialistsButtonLabel() {
        return specialistsButtonLabel;
    }

    public void setSpecialistsButtonLabel(String specialistsButtonLabel) {
        this.specialistsButtonLabel = specialistsButtonLabel;
    }

    public String getSpecialistsButtonUrl() {
        return specialistsButtonUrl;
    }

    public void setSpecialistsButtonUrl(String specialistsButtonUrl) {
        this.specialistsButtonUrl = specialistsButtonUrl;
    }
}
