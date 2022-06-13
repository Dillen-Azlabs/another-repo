package sg.ihh.ms.sdms.app.rest.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.SpecialtyCta;

import java.util.List;

@JsonPropertyOrder({"code", "message", "specialty"})
public class SpecialtyCtaListResponse extends BaseResponse{
    @JsonProperty("specialty")
    private SpecialtyCta specialtyCta;

    public SpecialtyCtaListResponse(SpecialtyCta specialtyCta) {
        super(HttpStatus.OK);
        this.specialtyCta = specialtyCta;
    }

    public SpecialtyCta getSpecialtyCta() {
        return specialtyCta;
    }

    public void setSpecialtyCta(SpecialtyCta specialtyCta) {
        this.specialtyCta = specialtyCta;
    }
}
