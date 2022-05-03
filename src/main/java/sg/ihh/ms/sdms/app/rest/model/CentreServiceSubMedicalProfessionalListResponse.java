package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.CentreServiceSubMedicalProfessionals;

@JsonPropertyOrder({"code", "message", "medicalProfessionals"})
public class CentreServiceSubMedicalProfessionalListResponse extends BaseResponse {
    @JsonProperty("medicalProfessionals")
    private CentreServiceSubMedicalProfessionals result;

    public CentreServiceSubMedicalProfessionalListResponse(CentreServiceSubMedicalProfessionals result) {
        super(HttpStatus.OK);
        this.result = result;
    }
}
