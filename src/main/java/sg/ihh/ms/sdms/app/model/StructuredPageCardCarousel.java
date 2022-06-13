package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode","sectionIntro","carouselItems", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPageCardCarousel extends BaseModel {

    @JsonProperty("sectionIntro")
    private String sectionIntro;
    @JsonProperty("carouselItems")
    private List<StructuredPageCardCarouselItem> carouselItems;

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
