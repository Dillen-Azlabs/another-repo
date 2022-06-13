package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ConditionDiagnosis;

import java.util.List;

@JsonPropertyOrder({"code", "message", "condition"})
public class ConditionDiagnosisListResponse extends BaseResponse{
    @JsonProperty("condition")
    private ConditionDiagnosis conditionDiagnosis;

    public ConditionDiagnosisListResponse(ConditionDiagnosis conditionDiagnosis) {
        super(HttpStatus.OK);
        this.conditionDiagnosis = conditionDiagnosis;
    }

    public ConditionDiagnosis getConditionDiagnosis() {
        return conditionDiagnosis;
    }

    public void setConditionDiagnosis(ConditionDiagnosis conditionDiagnosis) {
        this.conditionDiagnosis = conditionDiagnosis;
    }
}
