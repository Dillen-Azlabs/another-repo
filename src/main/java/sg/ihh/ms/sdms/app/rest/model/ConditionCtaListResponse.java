package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ConditionCta;

import java.util.List;

@JsonPropertyOrder({"code", "message", "condition"})
public class ConditionCtaListResponse extends BaseResponse{

    @JsonProperty("condition")
    private ConditionCta conditionCta;

    public ConditionCtaListResponse(ConditionCta conditionCta) {
        super(HttpStatus.OK);
        this.conditionCta = conditionCta;
    }

    public ConditionCta getConditionCta() {
        return conditionCta;
    }

    public void setConditionCta(ConditionCta conditionCta) {
        this.conditionCta = conditionCta;
    }
}
