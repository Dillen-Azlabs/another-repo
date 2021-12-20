package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ConditionCta;

import java.util.List;

@JsonPropertyOrder({"code", "message", "condition"})
public class ConditionCtaListResponse extends BaseResponse{

    @JsonProperty("condition")
    private List<ConditionCta> list;

    public ConditionCtaListResponse(List<ConditionCta> list) {
        super(HttpStatus.OK);
        this.list = list;
    }

    public List<ConditionCta> getList() {
        return list;
    }

    public void setList(List<ConditionCta> list) {
        this.list = list;
    }
}
