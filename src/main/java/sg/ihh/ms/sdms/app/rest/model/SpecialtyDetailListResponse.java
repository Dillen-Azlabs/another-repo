package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.SpecialtyDetail;

import java.util.List;

@JsonPropertyOrder({"code", "message", "specialty"})
public class SpecialtyDetailListResponse extends BaseResponse{
    @JsonProperty("specialty")
    private SpecialtyDetail specialtyDetail;

    public SpecialtyDetailListResponse(SpecialtyDetail specialtyDetail) {
        super(HttpStatus.OK);
        this.specialtyDetail = specialtyDetail;
    }

    public SpecialtyDetail getSpecialtyDetail() {
        return specialtyDetail;
    }

    public void setSpecialtyDetail(SpecialtyDetail specialtyDetail) {
        this.specialtyDetail = specialtyDetail;
    }
}
