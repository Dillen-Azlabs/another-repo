package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageCta;


@JsonPropertyOrder({"code", "message", "structuredPage"})
public class StructuredPageCtaListResponse extends BaseResponse{

    @JsonProperty("structuredPage")
    private StructuredPageCta structuredPageCta;

    public StructuredPageCtaListResponse(StructuredPageCta structuredPageCta) {
        super(HttpStatus.OK);
        this.structuredPageCta = structuredPageCta;
    }

    public StructuredPageCta getStructuredPageCta() {
        return structuredPageCta;
    }

    public void setStructuredPageCta(StructuredPageCta structuredPageCta) {
        this.structuredPageCta = structuredPageCta;
    }
}
