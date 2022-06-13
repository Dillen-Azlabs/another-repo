package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.Clinic;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "displayName", "clinics"})
public class ClinicListResponse extends BaseResponse {

    @JsonProperty("clinics")
    private List<Clinic> list;
    @JsonProperty("count")
    private int count;
    @JsonProperty("displayName")
    private String displayName;

    public ClinicListResponse(List<Clinic> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ClinicListResponse(List<Clinic> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<Clinic> getList() {
        return list;
    }

    public void setList(List<Clinic> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
