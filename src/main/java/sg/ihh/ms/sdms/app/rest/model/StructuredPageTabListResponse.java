package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageTab;

@JsonPropertyOrder({"code", "message", "tab"})
public class StructuredPageTabListResponse extends BaseResponse{

    @JsonProperty("tab")
    private StructuredPageTab structuredPageTab;

    public StructuredPageTabListResponse(StructuredPageTab structuredPageTab) {
        super(HttpStatus.OK);
        this.structuredPageTab = structuredPageTab;
    }

    public StructuredPageTab getStructuredPageTab() {
        return structuredPageTab;
    }

    public void setStructuredPageTab(StructuredPageTab structuredPageTab) {
        this.structuredPageTab = structuredPageTab;
    }
}
