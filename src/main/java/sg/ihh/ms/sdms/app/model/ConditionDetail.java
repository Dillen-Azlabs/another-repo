package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "conditionH1Display","conditionH1Display", "itemUrl", "mainImageUrl", "mainImageAltText", "hideMainImage", "summary", "socialSummary", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ConditionDetail extends BaseModel{

    @JsonProperty("conditionH1Display")
    private String conditionH1Display;
    @JsonProperty("itemUrl")
    private String itemUrl;
    @JsonProperty("mainImageUrl")
    private String mainImageUrl;
    @JsonProperty("mainImageAltText")
    private String mainImageAltText;
    @JsonProperty("hideMainImage")
    private boolean hideHeroImage;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("socialSummary")
    private String socialSummary;

    public ConditionDetail() {
        //Empty Constructor
    }

    public String getConditionH1Display() {
        return conditionH1Display;
    }

    public void setConditionH1Display(String conditionH1Display) {
        this.conditionH1Display = conditionH1Display;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getMainImageUrl() {
        return mainImageUrl;
    }

    @ColumnName("main_image")
    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl;
    }

    public String getMainImageAltText() {
        return mainImageAltText;
    }

    @ColumnName("main_image_text")
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

    public String getSocialSummary() {
        return socialSummary;
    }

    public void setSocialSummary(String socialSummary) {
        this.socialSummary = socialSummary;
    }

}
