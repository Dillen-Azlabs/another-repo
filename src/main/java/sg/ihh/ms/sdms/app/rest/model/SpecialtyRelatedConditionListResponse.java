package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.SpecialtyRelatedCondition;
import sg.ihh.ms.sdms.app.rest.model.BaseResponse;

import java.util.List;

@JsonPropertyOrder({"code", "message", "specialty"})
public class SpecialtyRelatedConditionListResponse extends BaseResponse{
    @JsonProperty("specialty")
    private SpecialtyRelatedCondition specialtyRelatedCondition;

    public SpecialtyRelatedConditionListResponse(SpecialtyRelatedCondition specialtyRelatedCondition) {
        super(HttpStatus.OK);
        this.specialtyRelatedCondition = specialtyRelatedCondition;
    }

    public SpecialtyRelatedCondition getSpecialtyRelatedCondition() {
        return specialtyRelatedCondition;
    }

    public void setSpecialtyRelatedCondition(SpecialtyRelatedCondition specialtyRelatedCondition) {
        this.specialtyRelatedCondition = specialtyRelatedCondition;
    }
}
