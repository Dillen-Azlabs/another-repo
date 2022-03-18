package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "imageUrl", "heading", "subHeading", "description", "button1Label", "button1Url", "button1inNewTab", "button2Label", "button2Url","button2inNewTab", "order", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPageCtaSection extends BaseModel{

    @JsonProperty("imageUrl")
    private String ctaSection1Image;
    @JsonProperty("heading")
    private String ctaSection1Heading;
    @JsonProperty("subHeading")
    private String ctaSection1SubHeading;
    @JsonProperty("description")
    private String ctaSection1Description;
    @JsonProperty("button1Label")
    private String ctaSection1Button1Label;
    @JsonProperty("button1Url")
    private String ctaSection1Button1Url;
    @JsonProperty("button1inNewTab")
    private String ctaSection1Button1Newtab;
    @JsonProperty("button2Label")
    private String ctaSection1Button2Label;
    @JsonProperty("button2Url")
    private String ctaSection1Button2Url;
    @JsonProperty("button2inNewTab")
    private String ctaSection1Button2Newtab;



    public StructuredPageCtaSection() {
        //Empty Constructor
    }

    public String getCtaSection1Image() {
        return ctaSection1Image;
    }

    public void setCtaSection1Image(String ctaSection1Image) {
        this.ctaSection1Image = ctaSection1Image;
    }

    public String getCtaSection1Heading() {
        return ctaSection1Heading;
    }

    public void setCtaSection1Heading(String ctaSection1Heading) {
        this.ctaSection1Heading = ctaSection1Heading;
    }

    public String getCtaSection1SubHeading() {
        return ctaSection1SubHeading;
    }

    public void setCtaSection1SubHeading(String ctaSection1SubHeading) {
        this.ctaSection1SubHeading = ctaSection1SubHeading;
    }

    public String getCtaSection1Description() {
        return ctaSection1Description;
    }

    public void setCtaSection1Description(String ctaSection1Description) {
        this.ctaSection1Description = ctaSection1Description;
    }

    public String getCtaSection1Button1Label() {
        return ctaSection1Button1Label;
    }

    public void setCtaSection1Button1Label(String ctaSection1Button1Label) {
        this.ctaSection1Button1Label = ctaSection1Button1Label;
    }

    public String getCtaSection1Button1Url() {
        return ctaSection1Button1Url;
    }

    public void setCtaSection1Button1Url(String ctaSection1Button1Url) {
        this.ctaSection1Button1Url = ctaSection1Button1Url;
    }

    public String getCtaSection1Button1Newtab() {
        return ctaSection1Button1Newtab;
    }

    public void setCtaSection1Button1Newtab(String ctaSection1Button1Newtab) {
        this.ctaSection1Button1Newtab = ctaSection1Button1Newtab;
    }

    public String getCtaSection1Button2Label() {
        return ctaSection1Button2Label;
    }

    public void setCtaSection1Button2Label(String ctaSection1Button2Label) {
        this.ctaSection1Button2Label = ctaSection1Button2Label;
    }

    public String getCtaSection1Button2Url() {
        return ctaSection1Button2Url;
    }

    public void setCtaSection1Button2Url(String ctaSection1Button2Url) {
        this.ctaSection1Button2Url = ctaSection1Button2Url;
    }

    public String getCtaSection1Button2Newtab() {
        return ctaSection1Button2Newtab;
    }

    public void setCtaSection1Button2Newtab(String ctaSection1Button2Newtab) {
        this.ctaSection1Button2Newtab = ctaSection1Button2Newtab;
    }
}
