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
    private SpecialtyOverview specialtyOverview;

    public SpecialtyOverviewListResponse(SpecialtyOverview specialtyOverview) {
        super(HttpStatus.OK);
        this.specialtyOverview = specialtyOverview;
    }

    public SpecialtyOverview getSpecialtyOverview() {
        return specialtyOverview;
    }

    public void setSpecialtyOverview(SpecialtyOverview specialtyOverview) {
        this.specialtyOverview = specialtyOverview;
    }
}
