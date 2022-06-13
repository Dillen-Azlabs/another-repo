package sg.ihh.ms.sdms.app.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "treatmentH1Display", "itemUrl", "mainImageUrl", "mainImageAltText", "hideHeroImage", "summary", "socialSummary", "faqCount","metaTitle","metaDescription", "order", "publishFlag", "createdDt", "modifiedDt"})
public class TreatmentDetail extends BaseModel{

    @JsonProperty("treatmentH1Display")
    private String treatmentH1Display;
    @JsonProperty("itemUrl")
    private String itemUrl;
    @JsonProperty("mainImageUrl")
    private String mainImageUrl;
    @JsonProperty("mainImageAltText")
    private String mainImageAltText;
    @JsonProperty("hideHeroImage")
    private boolean hideHeroImage;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("socialSummary")
    private String socialSummary;
    @JsonProperty("faqCount")
    private int faqCount;
    @JsonProperty("metaTitle")
    private String metaTitle;
    @JsonProperty("metaDescription")
    private String metaDesc;

    public TreatmentDetail() {
        //Empty Constructor
    }

    public String getTreatmentH1Display() {
        return treatmentH1Display;
    }

    public void setTreatmentH1Display(String treatmentH1Display) {
        this.treatmentH1Display = treatmentH1Display;
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

    public int getFaqCount() {
        return faqCount;
    }

    public void setFaqCount(int faqCount) {
        this.faqCount = faqCount;
    }

    public String getMetaTitle() {
        return metaTitle;
    }
    @ColumnName("meta_title")
    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaDesc() {
        return metaDesc;
    }
    @ColumnName("meta_desc")
    public void setMetaDesc(String metaDesc) {
        this.metaDesc = metaDesc;
    }
}
