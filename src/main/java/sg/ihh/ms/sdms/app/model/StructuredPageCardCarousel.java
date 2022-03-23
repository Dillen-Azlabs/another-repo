package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode","sectionIntro","carouselItems", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPageCardCarousel extends BaseModel {

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
}
