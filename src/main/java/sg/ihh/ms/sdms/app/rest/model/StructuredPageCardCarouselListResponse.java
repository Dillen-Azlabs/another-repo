package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageCardCarousel;
import sg.ihh.ms.sdms.app.model.StructuredPageTab;

import java.util.List;

@JsonPropertyOrder({"code", "message", "cardCarousel"})
public class StructuredPageCardCarouselListResponse extends BaseResponse{

    @JsonProperty("cardCarousel")
    private StructuredPageCardCarousel structuredPageCardCarousel;

    public StructuredPageCardCarouselListResponse(StructuredPageCardCarousel structuredPageCardCarousel) {
        super(HttpStatus.OK);
        this.structuredPageCardCarousel = structuredPageCardCarousel;
    }

    public StructuredPageCardCarousel getStructuredPageCardCarousel() {
        return structuredPageCardCarousel;
    }

    public void setStructuredPageCardCarousel(StructuredPageCardCarousel structuredPageCardCarousel) {
        this.structuredPageCardCarousel = structuredPageCardCarousel;
    }
}
