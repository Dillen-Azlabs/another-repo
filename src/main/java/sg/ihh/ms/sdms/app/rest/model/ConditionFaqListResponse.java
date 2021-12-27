package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ConditionFaq;
import sg.ihh.ms.sdms.app.model.ConditionSdFaq;

import java.util.List;

@JsonPropertyOrder({"code", "message", "condition"})
public class ConditionFaqListResponse extends BaseResponse{
    @JsonProperty("conditions")
    private ConditionFaq conditionFaq;

    public ConditionFaqListResponse(ConditionFaq conditionFaq) {
        super(HttpStatus.OK);
        this.conditionFaq = conditionFaq;
    }

    public ConditionFaq getConditionFaq() {
        return conditionFaq;
    }

    public void setConditionFaq(ConditionFaq conditionFaq) {
        this.conditionFaq = conditionFaq;
    }
}
