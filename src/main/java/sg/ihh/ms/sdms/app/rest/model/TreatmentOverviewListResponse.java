package sg.ihh.ms.sdms.app.rest.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.SpecialtyOverview;
import sg.ihh.ms.sdms.app.model.TreatmentOverview;
import sg.ihh.ms.sdms.app.rest.model.BaseResponse;

@JsonPropertyOrder({"code", "message", "treatment"})
public class TreatmentOverviewListResponse extends BaseResponse{
    @JsonProperty("treatment")
    private TreatmentOverview treatmentOverview;

    public TreatmentOverviewListResponse(TreatmentOverview treatmentOverview) {
        super(HttpStatus.OK);
        this.treatmentOverview = treatmentOverview;
    }

    public TreatmentOverview getTreatmentOverview() {
        return treatmentOverview;
    }

    public void setTreatmentOverview(TreatmentOverview treatmentOverview) {
        this.treatmentOverview = treatmentOverview;
    }
}
