package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.MDStaffDemographic;


import java.util.List;

public class MDStaffDemographicListResponse extends BaseResponse{
    @JsonProperty("demographics")
    private List<MDStaffDemographic> list;
    @JsonProperty("count")
    private int count;



    public MDStaffDemographicListResponse(List<MDStaffDemographic> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public MDStaffDemographicListResponse(List<MDStaffDemographic> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }


    public List<MDStaffDemographic> getList() {
        return list;
    }

    public void setList(List<MDStaffDemographic> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
