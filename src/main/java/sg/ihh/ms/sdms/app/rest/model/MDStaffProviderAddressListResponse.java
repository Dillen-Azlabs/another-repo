package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.MDStaffProvider;
import sg.ihh.ms.sdms.app.model.MDStaffProviderAddress;
import sg.ihh.ms.sdms.app.model.MDStaffSite;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "mcrNumber", "MDStaffProvider"})
public class MDStaffProviderAddressListResponse extends BaseResponse {

    @JsonProperty("address")
    private List<MDStaffSite> list;
    @JsonProperty("count")
    private int count;
    @JsonProperty("mcrNumber")
    private String mcrNumber;

    public MDStaffProviderAddressListResponse(List<MDStaffSite> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public MDStaffProviderAddressListResponse(List<MDStaffSite> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<MDStaffSite> getList() {
        return list;
    }

    public void setList(List<MDStaffSite> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMcrNumber() {
        return mcrNumber;
    }

    public void setMcrNumber(String mcrNumber) {
        this.mcrNumber = mcrNumber;
    }
}
