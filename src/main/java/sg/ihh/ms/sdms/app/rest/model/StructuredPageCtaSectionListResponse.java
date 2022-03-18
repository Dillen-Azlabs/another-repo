package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageCtaSection;

@JsonPropertyOrder({"code", "message", "structuredPages"})
public class StructuredPageCtaSectionListResponse extends BaseResponse{

    @JsonProperty("structuredPages")
    private StructuredPageCtaSection structuredPageCtaSection;

    public StructuredPageCtaSectionListResponse(StructuredPageCtaSection structuredPageCtaSection) {
        super(HttpStatus.OK);
        this.structuredPageCtaSection = structuredPageCtaSection;
    }

    public StructuredPageCtaSection getStructuredPageCtaSection() {
        return structuredPageCtaSection;
    }

    public void setStructuredPageCtaSection(StructuredPageCtaSection structuredPageCtaSection) {
        this.structuredPageCtaSection = structuredPageCtaSection;
    }
}
