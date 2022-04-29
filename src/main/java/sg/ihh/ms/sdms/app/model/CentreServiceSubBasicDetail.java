package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "centreServiceMPageTitle", "pageTitle", "itemUrl", "mainImageUrl", "mainImageAltText", "hideHeroImage", "overview", "summary", "socialSummary","metaTitle","metaDescription", "order", "publishFlag", "createdDt", "modifiedDt"})
public class CentreServiceSubBasicDetail extends BaseModel{

    @JsonProperty("centreServiceMPageTitle")
    private String centreServiceMPageTitle;
    @JsonProperty("pageTitle")
    private String subPageName;
    @JsonProperty("itemUrl")
    private String itemUrl;
    @JsonProperty("mainImageUrl")
    private String mainImage;
    @JsonProperty("mainImageAltText")
    private String mainImageAltText;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("socialSummary")
    private String socialSummary;
    @JsonProperty("metaTitle")
    private String metaTitle;
    @JsonProperty("metaDescription")
    private String metaDescription;

    public CentreServiceSubBasicDetail() {
        //Empty Constructor
    }

    public String getCentreServiceMPageTitle() {
        return centreServiceMPageTitle;
    }

    public void setCentreServiceMPageTitle(String centreServiceMPageTitle) {
        this.centreServiceMPageTitle = centreServiceMPageTitle;
    }

    public String getSubPageName() {
        return subPageName;
    }

    public void setSubPageName(String subPageName) {
        this.subPageName = subPageName;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getMainImageAltText() {
        return mainImageAltText;
    }

    public void setMainImageAltText(String mainImageAltText) {
        this.mainImageAltText = mainImageAltText;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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
