package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.SpecialtyOverview;
import sg.ihh.ms.sdms.app.rest.model.BaseResponse;

import java.util.List;

@JsonPropertyOrder({"code", "message", "specialty"})
public class SpecialtyOverviewListResponse extends BaseResponse{

    @JsonProperty("specialty")
    private List<SpecialtyOverview> list;

    public SpecialtyOverviewListResponse(List<SpecialtyOverview> list) {
        super(HttpStatus.OK);
        this.list = list;
    }



    public List<SpecialtyOverview> getList() {
        return list;
    }

    public void setList(List<SpecialtyOverview> list) {
        this.list = list;
    }


}
