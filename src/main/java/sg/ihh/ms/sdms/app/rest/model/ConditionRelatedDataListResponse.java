package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ConditionRelatedData;


import java.util.List;

@JsonPropertyOrder({"code", "message", "condition"})
public class ConditionRelatedDataListResponse extends BaseResponse{


    @JsonProperty("condition")
    private ConditionRelatedData conditionRelatedData;

    public ConditionRelatedDataListResponse(ConditionRelatedData conditionRelatedData) {
        super(HttpStatus.OK);
        this.conditionRelatedData = conditionRelatedData;
    }

    public ConditionRelatedData getConditionRelatedData() {
        return conditionRelatedData;
    }

    public void setConditionRelatedData(ConditionRelatedData conditionRelatedData) {
        this.conditionRelatedData = conditionRelatedData;
    }
}
