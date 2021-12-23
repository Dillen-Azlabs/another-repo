package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.SpecialtyFaq;
import sg.ihh.ms.sdms.app.rest.model.BaseResponse;

import java.util.List;

@JsonPropertyOrder({"code", "message", "specialty"})
public class SpecialtyFaqListResponse extends BaseResponse{

    @JsonProperty("specialty")
    private SpecialtyFaq specialtyFaq;

    public SpecialtyFaqListResponse(SpecialtyFaq specialtyFaq) {
        super(HttpStatus.OK);
        this.specialtyFaq = specialtyFaq;
    }

    public SpecialtyFaq getSpecialtyFaq() {
        return specialtyFaq;
    }

    public void setSpecialtyFaq(SpecialtyFaq specialtyFaq) {
        this.specialtyFaq = specialtyFaq;
    }
}
