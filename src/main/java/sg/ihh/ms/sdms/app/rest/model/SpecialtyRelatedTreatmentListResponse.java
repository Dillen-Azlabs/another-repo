package sg.ihh.ms.sdms.app.rest.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.SpecialtyRelatedTreatment;
import sg.ihh.ms.sdms.app.rest.model.BaseResponse;

import java.util.List;

@JsonPropertyOrder({"code", "message", "specialty"})
public class SpecialtyRelatedTreatmentListResponse extends BaseResponse{
    @JsonProperty("specialty")
    private List<SpecialtyRelatedTreatment> list;

    public SpecialtyRelatedTreatmentListResponse(List<SpecialtyRelatedTreatment> list) {
        super(HttpStatus.OK);
        this.list = list;
    }

    public List<SpecialtyRelatedTreatment> getList() {
        return list;
    }

    public void setList(List<SpecialtyRelatedTreatment> list) {
        this.list = list;
    }

}
