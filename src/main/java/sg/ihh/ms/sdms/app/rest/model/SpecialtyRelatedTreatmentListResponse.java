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
    private SpecialtyRelatedTreatment specialtyRelatedTreatment;

    public SpecialtyRelatedTreatmentListResponse(SpecialtyRelatedTreatment specialtyRelatedTreatment) {
        super(HttpStatus.OK);
        this.specialtyRelatedTreatment = specialtyRelatedTreatment;
    }

    public SpecialtyRelatedTreatment getSpecialtyRelatedTreatment() {
        return specialtyRelatedTreatment;
    }

    public void setSpecialtyRelatedTreatment(SpecialtyRelatedTreatment specialtyRelatedTreatment) {
        this.specialtyRelatedTreatment = specialtyRelatedTreatment;
    }
}
