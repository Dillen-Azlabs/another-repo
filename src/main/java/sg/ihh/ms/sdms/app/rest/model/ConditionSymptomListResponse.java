package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ConditionSymptom;

import java.util.List;

@JsonPropertyOrder({"code", "message", "condition"})
public class ConditionSymptomListResponse extends BaseResponse{
    @JsonProperty("condition")
    private List<ConditionSymptom> list;

    public ConditionSymptomListResponse(List<ConditionSymptom> list) {
        super(HttpStatus.OK);
        this.list = list;
    }

    public List<ConditionSymptom> getList() {
        return list;
    }

    public void setList(List<ConditionSymptom> list) {
        this.list = list;
    }
}
