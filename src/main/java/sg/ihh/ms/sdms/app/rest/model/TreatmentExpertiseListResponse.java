package sg.ihh.ms.sdms.app.rest.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.TreatmentExpertise;

@JsonPropertyOrder({"code", "message", "treatment"})
public class TreatmentExpertiseListResponse extends BaseResponse{

    @JsonProperty("treatment")
    private TreatmentExpertise treatmentExpertise;

    public TreatmentExpertiseListResponse(TreatmentExpertise treatmentExpertise) {
        super(HttpStatus.OK);
        this.treatmentExpertise = treatmentExpertise;
    }

    public TreatmentExpertise getTreatmentExpertise() {
        return treatmentExpertise;
    }

    public void setTreatmentExpertise(TreatmentExpertise treatmentExpertise) {
        this.treatmentExpertise = treatmentExpertise;
    }
}
