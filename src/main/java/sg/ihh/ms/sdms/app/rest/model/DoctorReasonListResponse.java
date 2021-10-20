package sg.ihh.ms.sdms.app.rest.model;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import sg.ihh.ms.sdms.app.model.DoctorReason;

public class DoctorReasonListResponse extends BaseResponse {

    @JsonProperty("reasons")
    private List<DoctorReason> list;
    @JsonProperty("count")
    private int count;


    public DoctorReasonListResponse(List<DoctorReason> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public DoctorReasonListResponse(List<DoctorReason> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<DoctorReason> getList() {
        return list;
    }

    public void setList(List<DoctorReason> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
