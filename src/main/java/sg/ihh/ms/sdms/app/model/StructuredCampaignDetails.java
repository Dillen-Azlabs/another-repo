package sg.ihh.ms.sdms.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "titleH1Display", "itemUrl","mainImageUrl","mainImageAltText", "overview", "benefitsList","summary", "socialSummary","metaTitle","metaDescription", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredCampaignDetails extends  BaseModel{
    @JsonProperty("titleH1Display")
    private String campaignTitle;
    @JsonProperty("itemUrl")
    private String itemUrl;
    @JsonProperty("mainImageUrl")
    private String mainImage;
    @JsonProperty("mainImageAltText")
    private String mainImageAltText;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("benefitsList")
    private String benefitsList;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("socialSummary")
    private String socialSummary;
    @JsonProperty("metaTitle")
    private String metaTitle;
    @JsonProperty("metaDescription")
    private String metaDescription;
    @JsonIgnore
    private int order;

    public StructuredCampaignDetails() {
        // EMPTY Constructor
    }

    public String getCampaignTitle() {
        return campaignTitle;
    }

    public void setCampaignTitle(String campaignTitle) {
        this.campaignTitle = campaignTitle;
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

    public String getBenefitsList() {
        return benefitsList;
    }

    public void setBenefitsList(String benefitsList) {
        this.benefitsList = benefitsList;
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

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public void setOrder(int order) {
        this.order = order;
    }
}
