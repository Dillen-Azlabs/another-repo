package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.TreatmentCta;
import sg.ihh.ms.sdms.app.model.TreatmentWhatToExpect;

@JsonPropertyOrder({"code", "message", "treatment"})
public class TreatmentWhatToExpectListResponse extends BaseResponse{

    @JsonProperty("treatment")
    private TreatmentWhatToExpect treatmentWhatToExpect;

    public TreatmentWhatToExpectListResponse(TreatmentWhatToExpect treatmentWhatToExpect) {
        super(HttpStatus.OK);
        this.treatmentWhatToExpect = treatmentWhatToExpect;
    }

    public TreatmentWhatToExpect getTreatmentWhatToExpect() {
        return treatmentWhatToExpect;
    }

    public void setTreatmentWhatToExpect(TreatmentWhatToExpect treatmentWhatToExpect) {
        this.treatmentWhatToExpect = treatmentWhatToExpect;
    }
}
