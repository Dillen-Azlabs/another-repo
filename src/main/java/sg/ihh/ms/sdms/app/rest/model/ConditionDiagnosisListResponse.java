package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ConditionDiagnosis;

import java.util.List;

@JsonPropertyOrder({"code", "message", "condition"})
public class ConditionDiagnosisListResponse extends BaseResponse{
    @JsonProperty("condition")
    private List<ConditionDiagnosis> list;

    public ConditionDiagnosisListResponse(List<ConditionDiagnosis> list) {
        super(HttpStatus.OK);
        this.list = list;
    }

    public List<ConditionDiagnosis> getList() {
        return list;
    }

    public void setList(List<ConditionDiagnosis> list) {
        this.list = list;
    }
}
