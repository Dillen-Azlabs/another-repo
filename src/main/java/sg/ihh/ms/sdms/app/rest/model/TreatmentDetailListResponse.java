package sg.ihh.ms.sdms.app.rest.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.TreatmentDetail;

@JsonPropertyOrder({"code", "message", "treatment"})
public class TreatmentDetailListResponse extends BaseResponse{

    @JsonProperty("treatment")
    private TreatmentDetail treatmentDetail;

    public TreatmentDetailListResponse(TreatmentDetail treatmentDetail) {
        super(HttpStatus.OK);
        this.treatmentDetail = treatmentDetail;
    }

    public TreatmentDetail getTreatmentDetail() {
        return treatmentDetail;
    }

    public void setTreatmentDetail(TreatmentDetail treatmentDetail) {
        this.treatmentDetail = treatmentDetail;
    }
}
