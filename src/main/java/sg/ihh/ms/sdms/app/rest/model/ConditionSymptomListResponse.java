package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ConditionSymptom;

import java.util.List;

@JsonPropertyOrder({"code", "message", "condition"})
public class ConditionSymptomListResponse extends BaseResponse{
    @JsonProperty("condition")
    private ConditionSymptom conditionSymptom;

    public ConditionSymptomListResponse(ConditionSymptom conditionSymptom) {
        super(HttpStatus.OK);
        this.conditionSymptom = conditionSymptom;
    }

    public ConditionSymptom getConditionSymptom() {
        return conditionSymptom;
    }

    public void setConditionSymptom(ConditionSymptom conditionSymptom) {
        this.conditionSymptom = conditionSymptom;
    }
}
