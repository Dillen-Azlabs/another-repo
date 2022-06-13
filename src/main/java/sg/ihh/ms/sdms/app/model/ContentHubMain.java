package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "pageTitleH1Display", "itemUrl", "mainImageUrl", "mainImageAltText", "summary", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ContentHubMain extends BaseModel{

    @JsonProperty("pageTitleH1Display")
    private String pageTitle;
    @JsonProperty("itemUrl")
    private String itemUrl;
    @JsonProperty("mainImageUrl")
    private String mainImage;
    @JsonProperty("mainImageAltText")
    private String mainImageAltText;
    @JsonProperty("summary")
    private String summary;

    public ContentHubMain() {
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
