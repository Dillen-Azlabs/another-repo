package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ConditionDetail;

import java.util.List;

@JsonPropertyOrder({"code", "message", "condition"})
public class ConditionDetailListResponse extends BaseResponse{
    @JsonProperty("condition")
    private List<ConditionDetail> list;


    public ConditionDetailListResponse(List<ConditionDetail> list) {
        super(HttpStatus.OK);
        this.list = list;
    }

    public List<ConditionDetail> getList() {
        return list;
    }

    public void setList(List<ConditionDetail> list) {
        this.list = list;
    }

}
