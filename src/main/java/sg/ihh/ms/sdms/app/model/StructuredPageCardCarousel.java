package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode","carouselItems", "order", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPageCardCarousel extends BaseModel {

    @JsonProperty("carouselItems")
    private List<StructuredPageCardCarouselItem> carouselItems;

    public StructuredPageCardCarousel() {
        // Empty Constructor
    }

    public List<StructuredPageCardCarouselItem> getCarouselItems() {
        return carouselItems;
    }

    public void setCarouselItems(List<StructuredPageCardCarouselItem> carouselItems) {
        this.carouselItems = carouselItems;
    }
}
