package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageAward;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "awards"})
public class StructuredPageAwardListResponse extends BaseResponse {

    @JsonProperty("award")
    private StructuredPageAward list;

    public StructuredPageAwardListResponse(StructuredPageAward list) {
        super(HttpStatus.OK);
        this.list = list;
    }

    public StructuredPageAward getList() {
        return list;
    }

    public void setList(StructuredPageAward list) {
        this.list = list;
    }

}
