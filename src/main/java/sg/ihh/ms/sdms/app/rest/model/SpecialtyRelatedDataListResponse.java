package sg.ihh.ms.sdms.app.rest.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.SpecialtyRelatedData;

import java.util.List;

@JsonPropertyOrder({"code", "message", "specialty"})
public class SpecialtyRelatedDataListResponse extends BaseResponse{

    @JsonProperty("specialty")
    private SpecialtyRelatedData specialtyRelatedData;

    public SpecialtyRelatedDataListResponse(SpecialtyRelatedData specialtyRelatedData) {
        super(HttpStatus.OK);
        this.specialtyRelatedData = specialtyRelatedData;
    }

    public SpecialtyRelatedData getSpecialtyRelatedData() {
        return specialtyRelatedData;
    }

    public void setSpecialtyRelatedData(SpecialtyRelatedData specialtyRelatedData) {
        this.specialtyRelatedData = specialtyRelatedData;
    }
}
