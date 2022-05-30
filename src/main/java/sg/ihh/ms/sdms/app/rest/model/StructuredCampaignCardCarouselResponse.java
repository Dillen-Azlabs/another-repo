package sg.ihh.ms.sdms.app.rest.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredCampaignCardCarousel;
import sg.ihh.ms.sdms.app.model.StructuredPageCardCarousel;

@JsonPropertyOrder({"code", "message", "cardCarousel"})
public class StructuredCampaignCardCarouselResponse extends BaseResponse{

    @JsonProperty("cardCarousel")
    private StructuredCampaignCardCarousel structuredCampaignCardCarousel;

    public StructuredCampaignCardCarouselResponse(StructuredCampaignCardCarousel structuredCampaignCardCarousel) {
        super(HttpStatus.OK);
        this.structuredCampaignCardCarousel = structuredCampaignCardCarousel;
    }

    public StructuredCampaignCardCarousel getStructuredCampaignCardCarousel() {
        return structuredCampaignCardCarousel;
    }

    public void setStructuredCampaignCardCarousel(StructuredCampaignCardCarousel structuredCampaignCardCarousel) {
        this.structuredCampaignCardCarousel = structuredCampaignCardCarousel;
    }
}
