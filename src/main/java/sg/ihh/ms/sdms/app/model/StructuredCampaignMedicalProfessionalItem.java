package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StructuredCampaignMedicalProfessionalItem {

    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("itemUrl")
    private String itemUrl;
    @JsonProperty("profileImageUrl")
    private String profilePhotoUrl;
    @JsonProperty("profileImageAltText")
    private String profilePhotoAltText;
    @JsonProperty("designation")
    private String designation;

    public StructuredCampaignMedicalProfessionalItem() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public String getProfilePhotoAltText() {
        return profilePhotoAltText;
    }

    public void setProfilePhotoAltText(String profilePhotoAltText) {
        this.profilePhotoAltText = profilePhotoAltText;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
