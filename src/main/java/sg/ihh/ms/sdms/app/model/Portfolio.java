
package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "displayName", "associatedTreatments", "achievements", "experiences", "accreditations", "education", "publications", "awards", "order", "publishFlag", "createdDt", "modifiedDt"})
public class Portfolio extends BaseModel {

    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("associatedTreatments")
    private String associatedTreatments;
    @JsonProperty("achievements")
    private String achievements;
    @JsonProperty("experiences")
    private String experiences;
    @JsonProperty("accreditations")
    private boolean accreditations;
    @JsonProperty("education")
    private String education;
    @JsonProperty("publications")
    private String publications;
    @JsonProperty("awards")
    private String awards;


    public Portfolio() {
        // Empty Constructor
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAssociatedTreatments() {
        return associatedTreatments;
    }

    @ColumnName("treatment")
    public void setAssociatedTreatments(String associatedTreatments) {
        this.associatedTreatments = associatedTreatments;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public boolean isAccreditations() {
        return accreditations;
    }

    public void setAccreditations(boolean accreditations) {
        this.accreditations = accreditations;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPublications() {
        return publications;
    }

    @ColumnName("research_and_publications")
    public void setPublications(String publications) {
        this.publications = publications;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }
}
