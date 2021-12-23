package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ConditionDetail;

import java.util.List;

@JsonPropertyOrder({"code", "message", "condition"})
public class ConditionDetailListResponse extends BaseResponse{
    @JsonProperty("condition")
    private ConditionDetail conditionDetail;


    public ConditionDetailListResponse(ConditionDetail conditionDetail) {
        super(HttpStatus.OK);
        this.conditionDetail = conditionDetail;
    }

    public ConditionDetail getConditionDetail() {
        return conditionDetail;
    }

    public void setConditionDetail(ConditionDetail conditionDetail) {
        this.conditionDetail = conditionDetail;
    }
}
