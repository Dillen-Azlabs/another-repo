package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.TreatmentCta;
import sg.ihh.ms.sdms.app.rest.model.BaseResponse;

@JsonPropertyOrder({"code", "message", "treatment"})
public class TreatmentCtaListResponse extends BaseResponse{

    @JsonProperty("treatment")
    private TreatmentCta treatmentCta;

    public TreatmentCtaListResponse(TreatmentCta treatmentCta) {
        super(HttpStatus.OK);
        this.treatmentCta = treatmentCta;
    }

    public TreatmentCta getTreatmentCta() {
        return treatmentCta;
    }

    public void setTreatmentCta(TreatmentCta treatmentCta) {
        this.treatmentCta = treatmentCta;
    }
}
