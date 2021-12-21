package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.SpecialtyDetail;

import java.util.List;

@JsonPropertyOrder({"code", "message", "specialty"})
public class SpecialtyDetailListResponse extends BaseResponse{
    @JsonProperty("specialty")
    private List<SpecialtyDetail> list;

    public SpecialtyDetailListResponse(List<SpecialtyDetail> list) {
        super(HttpStatus.OK);
        this.list = list;
    }


    public List<SpecialtyDetail> getList() {
        return list;
    }

    public void setList(List<SpecialtyDetail> list) {
        this.list = list;
    }
}
