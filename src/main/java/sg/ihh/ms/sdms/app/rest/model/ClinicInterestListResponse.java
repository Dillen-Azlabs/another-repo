package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ClinicInterest;


import java.util.List;

public class ClinicInterestListResponse extends BaseResponse{
    @JsonProperty("clinicInterest")
    private List<ClinicInterest> list;
    @JsonProperty("count")
    private int count;


    public ClinicInterestListResponse(List<ClinicInterest> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ClinicInterestListResponse(List<ClinicInterest> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<ClinicInterest> getList() {
        return list;
    }

    public void setList(List<ClinicInterest> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
