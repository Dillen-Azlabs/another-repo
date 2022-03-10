package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "relatedMPageDisplay", "pageTitleH1Display", "itemUrl", "mainImageUrl", "mainImageAltText", "hideHeroImage", "overview", "summary", "socialSummary","metaTitle","metaDescription", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ContentHubSubBasicDetail extends BaseModel{

    @JsonProperty("relatedMPageDisplay")
    private String relatedMPageDisplay;
    @JsonProperty("pageTitleH1Display")
    private String pageTitle;
    @JsonProperty("itemUrl")
    private String itemUrl;
    @JsonProperty("mainImageUrl")
    private String mainImage;
    @JsonProperty("mainImageAltText")
    private String mainImageAltText;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("socialSummary")
    private String socialSummary;
    @JsonProperty("metaTitle")
    private String metaTitle;
    @JsonProperty("metaDescription")
    private String metaDescription;

    public ContentHubSubBasicDetail() {
        //Empty Constructor
    }

    public String getRelatedMPageDisplay() {
        return relatedMPageDisplay;
    }

    public void setRelatedMPageDisplay(String relatedMPageDisplay) {
        this.relatedMPageDisplay = relatedMPageDisplay;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
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
