package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.MDStaffProvider;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "providers"})
public class MDStaffProviderListResponse extends BaseResponse {

    @JsonProperty("providers")
    private List<MDStaffProvider> list;
    @JsonProperty("count")
    private int count;

    public MDStaffProviderListResponse(List<MDStaffProvider> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public MDStaffProviderListResponse(List<MDStaffProvider> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<MDStaffProvider> getList() {
        return list;
    }

    public void setList(List<MDStaffProvider> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
