package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StructuredCampaignCardItem {

    @JsonProperty("image")
    private String image;
    @JsonProperty("altText")
    private String imageAltText;
    @JsonProperty("title")
    private String title;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("landingUrl")
    private String landingUrl;
    @JsonProperty("order")
    private String displayOrder;

    public StructuredCampaignCardItem() {
        //Empty Constructor
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageAltText() {
        return imageAltText;
    }

    public void setImageAltText(String imageAltText) {
        this.imageAltText = imageAltText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLandingUrl() {
        return landingUrl;
    }

    public void setLandingUrl(String landingUrl) {
        this.landingUrl = landingUrl;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }
}
