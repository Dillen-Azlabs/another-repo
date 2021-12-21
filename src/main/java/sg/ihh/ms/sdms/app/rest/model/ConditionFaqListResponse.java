package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ConditionFaq;

import java.util.List;

@JsonPropertyOrder({"code", "message", "condition"})
public class ConditionFaqListResponse extends BaseResponse{
    @JsonProperty("conditions")
    private List<ConditionFaq> list;

    public ConditionFaqListResponse(List<ConditionFaq> list) {
        super(HttpStatus.OK);
        this.list = list;
    }


    public List<ConditionFaq> getList() {
        return list;
    }

    public void setList(List<ConditionFaq> list) {
        this.list = list;
    }

}
