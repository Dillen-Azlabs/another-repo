package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "imageUrl", "heading", "subHeading", "description", "button1Label", "button1Url", "button1inNewTab", "button2Label", "button2Url","button2inNewTab", "order", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPageCtaSection extends BaseModel{

    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("heading")
    private String heading;
    @JsonProperty("subHeading")
    private String subHeading;
    @JsonProperty("description")
    private String description;
    @JsonProperty("button1Label")
    private String button1Label;
    @JsonProperty("button1Url")
    private String button1Url;
    @JsonProperty("button1inNewTab")
    private boolean button1inNewTab;
    @JsonProperty("button2Label")
    private String button2Label;
    @JsonProperty("button2Url")
    private String button2Url;
    @JsonProperty("button2inNewTab")
    private boolean button2inNewTab;



    public StructuredPageCtaSection() {
        //Empty Constructor
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getButton1Label() {
        return button1Label;
    }

    public void setButton1Label(String button1Label) {
        this.button1Label = button1Label;
    }

    public String getButton1Url() {
        return button1Url;
    }

    public void setButton1Url(String button1Url) {
        this.button1Url = button1Url;
    }

    public boolean isButton1inNewTab() {
        return button1inNewTab;
    }

    public void setButton1inNewTab(boolean button1inNewTab) {
        this.button1inNewTab = button1inNewTab;
    }

    public String getButton2Label() {
        return button2Label;
    }

    public void setButton2Label(String button2Label) {
        this.button2Label = button2Label;
    }

    public String getButton2Url() {
        return button2Url;
    }

    public void setButton2Url(String button2Url) {
        this.button2Url = button2Url;
    }

    public boolean isButton2inNewTab() {
        return button2inNewTab;
    }

    public void setButton2inNewTab(boolean button2inNewTab) {
        this.button2inNewTab = button2inNewTab;
    }
}
