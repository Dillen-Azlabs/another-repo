
package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "displayName", "itemUrl", "salutation", "mcrNumber", "isMedicalReviewer", "profileImageUrl", "profileImageAltText", "designation", "specialty", "languageSpoken", "gender", "insurancePanel", "videoUrl", "quote", "qnaUrl", "qnaLinkText", "hasMediaCoverage", "shortBio", "socialSummary", "metaTitle", "metaDescription", "order", "publishFlag", "createdDt", "modifiedDt"})
public class MedicalProfessionalDetail extends BaseModel {

    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("itemUrl")
    private String itemUrl;
    @JsonProperty("salutation")
    private String salutation;
    @JsonProperty("mcrNumber")
    private String mcrNumber;
    @JsonProperty("isMedicalReviewer")
    private boolean isMedicalReviewer;
    @JsonProperty("profileImageUrl")
    private String profileImageUrl;
    @JsonProperty("profileImageAltText")
    private String profileImageAltText;
    @JsonProperty("designation")
    private String designation;
    @JsonProperty("specialty")
    private String specialty;
    @JsonProperty("languageSpoken")
    private List<String> languageSpoken;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("insurancePanel")
    private List<String> insurancePanel;
    @JsonProperty("videoUrl")
    private String videoUrl;
    @JsonProperty("quote")
    private String quote;
    @JsonProperty("qnaUrl")
    private String qnaUrl;
    @JsonProperty("qnaLinkText")
    private String qnaLinkText;
    @JsonProperty("hasMediaCoverage")
    private boolean hasMediaCoverage;
    @JsonProperty("shortBio")
    private String shortBio;
    @JsonProperty("socialSummary")
    private String socialSummary;
    @JsonProperty("metaTitle")
    private String metaTitle;
    @JsonProperty("metaDescription")
    private String metaDescription;


    public MedicalProfessionalDetail() {
        // Empty Constructor
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getMcrNumber() {
        return mcrNumber;
    }

    public void setMcrNumber(String mcrNumber) {
        this.mcrNumber = mcrNumber;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public boolean getIsMedicalReviewer() {
        return isMedicalReviewer;
    }

    public void setIsMedicalReviewer(boolean isMedicalReviewer) {
        this.isMedicalReviewer = isMedicalReviewer;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<String> getLanguageSpoken() {
        return languageSpoken;
    }

    public void setLanguageSpoken(List<String> languageSpoken) {
        this.languageSpoken = languageSpoken;
    }

    public List<String> getInsurancePanel() {
        return insurancePanel;
    }

    public void setInsurancePanel(List<String> insurancePanel) {
        this.insurancePanel = insurancePanel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getQnaUrl() {
        return qnaUrl;
    }

    public void setQnaUrl(String qnaUrl) {
        this.qnaUrl = qnaUrl;
    }

    public String getQnaLinkText() {
        return qnaLinkText;
    }

    public void setQnaLinkText(String qnaLinkText) {
        this.qnaLinkText = qnaLinkText;
    }

    public boolean isHasMediaCoverage() {
        return hasMediaCoverage;
    }

    @ColumnName("media_coverage")
    public void setHasMediaCoverage(boolean hasMediaCoverage) {
        this.hasMediaCoverage = hasMediaCoverage;
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    public String getSocialSummary() {
        return socialSummary;
    }

    public void setSocialSummary(String socialSummary) {
        this.socialSummary = socialSummary;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }
}
