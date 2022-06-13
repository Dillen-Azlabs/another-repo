package sg.ihh.ms.sdms.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode","sectionIntro","carouselItems", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredCampaignCardCarousel extends BaseModel{

    @JsonProperty("sectionIntro")
    private String sectionIntro;
    @JsonProperty("carouselItems")
    private List<StructuredCampaignCardItem> carouselItems;
    @JsonIgnore
    private int order;

    public StructuredCampaignCardCarousel() {
        // Empty Constructor
    }

    public String getSectionIntro() {
        return sectionIntro;
    }

    public void setSectionIntro(String sectionIntro) {
        this.sectionIntro = sectionIntro;
    }

    public List<StructuredCampaignCardItem> getCarouselItems() {
        return carouselItems;
    }

    public void setCarouselItems(List<StructuredCampaignCardItem> carouselItems) {
        this.carouselItems = carouselItems;
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
