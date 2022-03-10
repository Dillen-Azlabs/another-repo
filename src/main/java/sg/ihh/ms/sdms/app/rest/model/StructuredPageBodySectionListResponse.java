package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageBodySection;

import java.util.List;

@JsonPropertyOrder({"code", "message", "bodySection"})
public class StructuredPageBodySectionListResponse extends BaseResponse {

    @JsonProperty("bodySection")
    private List<StructuredPageBodySection> list;

    public StructuredPageBodySectionListResponse(List<StructuredPageBodySection> list) {
        super(HttpStatus.OK);
        this.list = list;
    }

    public List<StructuredPageBodySection> getList() {
        return list;
    }

    public void setList(List<StructuredPageBodySection> list) {
        this.list = list;
    }

}
