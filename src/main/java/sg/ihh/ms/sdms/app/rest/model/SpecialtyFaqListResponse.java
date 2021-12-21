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
    private List<SpecialtyFaq> list;

    public SpecialtyFaqListResponse(List<SpecialtyFaq> list) {
        super(HttpStatus.OK);
        this.list = list;
    }

    public List<SpecialtyFaq> getList() {
        return list;
    }

    public void setList(List<SpecialtyFaq> list) {
        this.list = list;
    }

}
