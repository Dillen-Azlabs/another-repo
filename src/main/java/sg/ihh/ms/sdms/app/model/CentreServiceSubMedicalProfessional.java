package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "itemUrl", "displayName", "salutation", "designation", "profileImageUrl", "profileImageAltText", "order", "publishFlag", "createdDt", "modifiedDt"})
public class CentreServiceSubMedicalProfessional extends BaseModel{

    @JsonProperty("itemUrl")
    private String itemUrl;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("salutation")
    private String salutation;
    @JsonProperty("designation")
    private String designation;
    @JsonProperty("profileImageUrl")
    private String profileImageUrl;
    @JsonProperty("profileImageAltText")
    private String profileImageAltText;

    public CentreServiceSubMedicalProfessional() {
        //Empty Constructor
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    @ColumnName("profile_photo_url")
    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileImageAltText() {
        return profileImageAltText;
    }

    @ColumnName("profile_photo_alt_text")
    public void setProfileImageAltText(String profileImageAltText) {
        this.profileImageAltText = profileImageAltText;
    }
}
