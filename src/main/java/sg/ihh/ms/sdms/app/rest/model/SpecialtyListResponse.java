package sg.ihh.ms.sdms.app.rest.model;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import sg.ihh.ms.sdms.app.model.Specialty;

@JsonPropertyOrder({"code", "message", "count", "specialties"})
public class SpecialtyListResponse extends BaseResponse {

    @JsonProperty("specialties")
    private List<Specialty> list;
    @JsonProperty("count")
    private int count;


    public SpecialtyListResponse(List<Specialty> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public SpecialtyListResponse(List<Specialty> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<Specialty> getList() {
        return list;
    }

    public void setList(List<Specialty> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
