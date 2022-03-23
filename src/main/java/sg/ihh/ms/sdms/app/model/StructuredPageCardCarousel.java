package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode","sectionIntro","carouselItems", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPageCardCarousel  {

    @JsonProperty("uid")
    private String uid;
    @JsonProperty("languageCode")
    private String languageCode;
    @JsonProperty("sectionIntro")
    private String sectionIntro;
    @JsonProperty("carouselItems")
    private List<StructuredPageCardCarouselItem> carouselItems;
    @JsonProperty("publishFlag")
    private String publishFlag;
    @JsonProperty("createdDt")
    private String createdDt;
    @JsonProperty("modifiedDt")
    private String modifiedDt;

    public StructuredPageCardCarousel() {
        // Empty Constructor
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getSectionIntro() {
        return sectionIntro;
    }

    public void setSectionIntro(String sectionIntro) {
        this.sectionIntro = sectionIntro;
    }

    public List<StructuredPageCardCarouselItem> getCarouselItems() {
        return carouselItems;
    }

    public void setCarouselItems(List<StructuredPageCardCarouselItem> carouselItems) {
        this.carouselItems = carouselItems;
    }

    public String getPublishFlag() {
        return publishFlag;
    }

    public void setPublishFlag(String publishFlag) {
        this.publishFlag = publishFlag;
    }

    public String getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(String createdDt) {
        this.createdDt = createdDt;
    }

    public String getModifiedDt() {
        return modifiedDt;
    }

    public void setModifiedDt(String modifiedDt) {
        this.modifiedDt = modifiedDt;
    }
}
