package sg.ihh.ms.sdms.app.rest.model;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import sg.ihh.ms.sdms.app.model.Treatment;

@JsonPropertyOrder({"code", "message", "count", "treatements"})
public class TreatmentListResponse extends BaseResponse {

    @JsonProperty("treatments")
    private List<Treatment> list;
    @JsonProperty("count")
    private int count;


    public TreatmentListResponse(List<Treatment> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public TreatmentListResponse(List<Treatment> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<Treatment> getList() {
        return list;
    }

    public void setList(List<Treatment> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
