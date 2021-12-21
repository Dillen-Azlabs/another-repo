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
    private List<SpecialtyExpertise> list;

    public SpecialtyExpertiseListResponse(List<SpecialtyExpertise> list) {
        super(HttpStatus.OK);
        this.list = list;
    }

    public List<SpecialtyExpertise> getList() {
        return list;
    }

    public void setList(List<SpecialtyExpertise> list) {
        this.list = list;
    }

}
