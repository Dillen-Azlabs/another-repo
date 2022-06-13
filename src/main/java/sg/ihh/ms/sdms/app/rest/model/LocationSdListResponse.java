package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.LocationSd;

import java.util.List;


@JsonPropertyOrder({"code", "message", "count", "locations"})
public class LocationSdListResponse extends BaseResponse {
    @JsonProperty("locations")
    private List<LocationSd> list;
    @JsonProperty("count")
    private int count;

    public LocationSdListResponse(List<LocationSd> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public LocationSdListResponse(List<LocationSd> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<LocationSd> getList() {
        return list;
    }

    public void setList(List<LocationSd> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
