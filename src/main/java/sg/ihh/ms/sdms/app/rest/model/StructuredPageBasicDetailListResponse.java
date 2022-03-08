package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageBasicDetail;

@JsonPropertyOrder({"code", "message", "structuredPage"})
public class StructuredPageBasicDetailListResponse extends BaseResponse{

    @JsonProperty("structuredPage")
    private StructuredPageBasicDetail structuredPageBasicDetail;

    public StructuredPageBasicDetailListResponse(StructuredPageBasicDetail structuredPageBasicDetail) {
        super(HttpStatus.OK);
        this.structuredPageBasicDetail = structuredPageBasicDetail;
    }

    public StructuredPageBasicDetail getStructuredPageBasicDetail() {
        return structuredPageBasicDetail;
    }

    public void setStructuredPageBasicDetail(StructuredPageBasicDetail structuredPageBasicDetail) {
        this.structuredPageBasicDetail = structuredPageBasicDetail;
    }
}
