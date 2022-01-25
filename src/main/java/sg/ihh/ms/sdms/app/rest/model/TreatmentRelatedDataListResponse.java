package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.TreatmentRelatedData;

@JsonPropertyOrder({"code", "message", "treatment"})
public class TreatmentRelatedDataListResponse extends BaseResponse{

    @JsonProperty("treatment")
    private TreatmentRelatedData treatmentRelatedData;

    public TreatmentRelatedDataListResponse(TreatmentRelatedData treatmentRelatedData) {
        super(HttpStatus.OK);
        this.treatmentRelatedData = treatmentRelatedData;
    }

    public TreatmentRelatedData getTreatmentRelatedData() {
        return treatmentRelatedData;
    }

    public void setTreatmentRelatedData(TreatmentRelatedData treatmentRelatedData) {
        this.treatmentRelatedData = treatmentRelatedData;
    }
}
