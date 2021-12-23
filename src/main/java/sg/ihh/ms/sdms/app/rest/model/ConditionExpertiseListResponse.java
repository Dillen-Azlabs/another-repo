package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ConditionExpertise;

import java.util.List;

@JsonPropertyOrder({"code", "message", "condition"})
public class ConditionExpertiseListResponse extends BaseResponse {
    @JsonProperty("condition")
    private ConditionExpertise conditionExpertise;

    public ConditionExpertiseListResponse(ConditionExpertise conditionExpertise) {
        super(HttpStatus.OK);
        this.conditionExpertise = conditionExpertise;
    }

    public ConditionExpertise getConditionExpertise() {
        return conditionExpertise;
    }

    public void setConditionExpertise(ConditionExpertise conditionExpertise) {
        this.conditionExpertise = conditionExpertise;
    }
}
