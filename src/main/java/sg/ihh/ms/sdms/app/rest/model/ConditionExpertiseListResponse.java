package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ConditionExpertise;

import java.util.List;

@JsonPropertyOrder({"code", "message", "condition"})
public class ConditionExpertiseListResponse extends BaseResponse {
    @JsonProperty("condition")
    private List<ConditionExpertise> list;

    public ConditionExpertiseListResponse(List<ConditionExpertise> list) {
        super(HttpStatus.OK);
        this.list = list;
    }

    public List<ConditionExpertise> getList() {
        return list;
    }

    public void setList(List<ConditionExpertise> list) {
        this.list = list;
    }
}
