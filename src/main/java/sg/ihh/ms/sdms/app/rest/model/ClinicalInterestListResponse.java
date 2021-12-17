package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ClinicalInterest;


import java.util.List;

public class ClinicalInterestListResponse extends BaseResponse{
    @JsonProperty("clinicalInterest")
    private List<ClinicalInterest> list;
    @JsonProperty("count")
    private int count;


    public ClinicalInterestListResponse(List<ClinicalInterest> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ClinicalInterestListResponse(List<ClinicalInterest> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<ClinicalInterest> getList() {
        return list;
    }

    public void setList(List<ClinicalInterest> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
