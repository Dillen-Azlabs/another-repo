package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.TreatmentFaq;

@JsonPropertyOrder({"code", "message", "treatment"})
public class TreatmentFaqListResponse extends BaseResponse{

    @JsonProperty("treatment")
    private TreatmentFaq treatmentFaq;

    public TreatmentFaqListResponse(TreatmentFaq treatmentFaq) {
        super(HttpStatus.OK);
        this.treatmentFaq = treatmentFaq;
    }

    public TreatmentFaq getTreatmentFaq() {
        return treatmentFaq;
    }

    public void setTreatmentFaq(TreatmentFaq treatmentFaq) {
        this.treatmentFaq = treatmentFaq;
    }
}
