package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "pageTitleH1Display", "itemUrl", "mainImageUrl", "mainImageAltText", "hideHeroImage", "overview", "summary", "socialSummary","metaTitle","metaDescription", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ContentHubMainBasicDetail extends BaseModel{

    @JsonProperty("pageTitleH1Display")
    private String pageTitle;
    @JsonProperty("itemUrl")
    private String itemUrl;
    @JsonProperty("mainImageUrl")
    private String mainImage;
    @JsonProperty("mainImageAltText")
    private String mainImageAltText;
    @JsonProperty("hideHeroImage")
    private boolean hideHeroImage;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("socialSummary")
    private String socialSummary;
    @JsonProperty("metaTitle")
    private String metaTitle;
    @JsonProperty("metaDescription")
    private String metaDescription;

    public ContentHubMainBasicDetail() {
        //Empty Constructor
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

    public boolean isHideHeroImage() {
        return hideHeroImage;
    }

    public void setHideHeroImage(boolean hideHeroImage) {
        this.hideHeroImage = hideHeroImage;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
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
