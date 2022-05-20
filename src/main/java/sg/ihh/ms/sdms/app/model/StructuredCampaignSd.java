package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"uid", "languageCode", "pageTitle", "itemUrl", "mainImageUrl","mainImageAltText", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredCampaignSd extends BaseModel{


    @JsonProperty("pageTitle")
    private String campaignTitle;

    @JsonProperty("itemUrl")
    private String itemUrl;

    @JsonProperty("mainImageUrl")
    private String mainImage;

    @JsonProperty("mainImageAltText")
    private String mainImageAltText;

    @JsonIgnore
    private int order;

    public StructuredCampaignSd() {
        //Empty Constructor
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
}
