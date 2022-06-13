package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageCardCarousel;
import sg.ihh.ms.sdms.app.model.StructuredPageMediaSection;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "mediaSection"})
public class StructuredPageMediaSectionListResponse extends BaseResponse {

    @JsonProperty("mediaSection")
    private StructuredPageMediaSection structuredPageMediaSection;

    public StructuredPageMediaSectionListResponse(StructuredPageMediaSection structuredPageMediaSection) {
        super(HttpStatus.OK);
        this.structuredPageMediaSection = structuredPageMediaSection;
    }

    public StructuredPageMediaSection getStructuredPageMediaSection() {
        return structuredPageMediaSection;
    }

    public void setStructuredPageMediaSection(StructuredPageMediaSection structuredPageMediaSection) {
        this.structuredPageMediaSection = structuredPageMediaSection;
    }
}
