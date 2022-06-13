package sg.ihh.ms.sdms.app.rest.model;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import sg.ihh.ms.sdms.app.model.Hospital;

public class HospitalListResponse extends BaseResponse {

    @JsonProperty("hospitals")
    private List<Hospital> list;
    @JsonProperty("count")
    private int count;


    public HospitalListResponse(List<Hospital> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public HospitalListResponse(List<Hospital> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<Hospital> getList() {
        return list;
    }

    public void setList(List<Hospital> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
