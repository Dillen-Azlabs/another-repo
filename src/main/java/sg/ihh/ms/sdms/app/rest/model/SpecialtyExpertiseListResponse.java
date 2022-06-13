package sg.ihh.ms.sdms.app.rest.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.SpecialtyExpertise;
import sg.ihh.ms.sdms.app.rest.model.BaseResponse;

import java.util.List;

@JsonPropertyOrder({"code", "message", "specialty"})
public class SpecialtyExpertiseListResponse extends BaseResponse{
    @JsonProperty("specialty")
    private SpecialtyExpertise specialtyExpertise;

    public SpecialtyExpertiseListResponse(SpecialtyExpertise specialtyExpertise) {
        super(HttpStatus.OK);
        this.specialtyExpertise = specialtyExpertise;
    }

    public SpecialtyExpertise getSpecialtyExpertise() {
        return specialtyExpertise;
    }

    public void setSpecialtyExpertise(SpecialtyExpertise specialtyExpertise) {
        this.specialtyExpertise = specialtyExpertise;
    }
}
