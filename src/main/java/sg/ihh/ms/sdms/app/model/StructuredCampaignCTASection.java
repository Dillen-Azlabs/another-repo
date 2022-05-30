package sg.ihh.ms.sdms.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "imageUrl", "title", "description", "button1Label", "button1Url", "button2Label", "button2Url", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredCampaignCTASection extends  BaseModel {

    @JsonProperty("imageUrl")
    private String ctaSectionImage;

    @JsonProperty("title")
    private String ctaSectionTitle;

    @JsonProperty("description")
    private String ctaSectionDescription;

    @JsonProperty("button1Label")
    private String ctaSectionButton1Label;

    @JsonProperty("button1Url")
    private String ctaSectionButton1Url;

    @JsonProperty("button2Label")
    private String ctaSectionButton2Label;

    @JsonProperty("button2Url")
    private String ctaSectionButton2Url;

    @JsonIgnore
    private int order;

    public StructuredCampaignCTASection() {
    }

    public String getCtaSectionImage() {
        return ctaSectionImage;
    }

    public void setCtaSectionImage(String ctaSectionImage) {
        this.ctaSectionImage = ctaSectionImage;
    }

    public String getCtaSectionTitle() {
        return ctaSectionTitle;
    }

    public void setCtaSectionTitle(String ctaSectionTitle) {
        this.ctaSectionTitle = ctaSectionTitle;
    }

    public String getCtaSectionDescription() {
        return ctaSectionDescription;
    }

    public void setCtaSectionDescription(String ctaSectionDescription) {
        this.ctaSectionDescription = ctaSectionDescription;
    }

    public String getCtaSectionButton1Label() {
        return ctaSectionButton1Label;
    }

    public void setCtaSectionButton1Label(String ctaSectionButton1Label) {
        this.ctaSectionButton1Label = ctaSectionButton1Label;
    }

    public String getCtaSectionButton1Url() {
        return ctaSectionButton1Url;
    }

    public void setCtaSectionButton1Url(String ctaSectionButton1Url) {
        this.ctaSectionButton1Url = ctaSectionButton1Url;
    }

    public String getCtaSectionButton2Label() {
        return ctaSectionButton2Label;
    }

    public void setCtaSectionButton2Label(String ctaSectionButton2Label) {
        this.ctaSectionButton2Label = ctaSectionButton2Label;
    }

    public String getCtaSectionButton2Url() {
        return ctaSectionButton2Url;
    }

    public void setCtaSectionButton2Url(String ctaSectionButton2Url) {
        this.ctaSectionButton2Url = ctaSectionButton2Url;
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


