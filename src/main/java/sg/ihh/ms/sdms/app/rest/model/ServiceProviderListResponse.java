package sg.ihh.ms.sdms.app.rest.model;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import sg.ihh.ms.sdms.app.model.ServiceProvider;

@JsonPropertyOrder({"code", "message", "count", "serviceProviders"})
public class ServiceProviderListResponse extends BaseResponse {

    @JsonProperty("serviceProviders")
    private List<ServiceProvider> list;
    @JsonProperty("count")
    private int count;


    public ServiceProviderListResponse(List<ServiceProvider> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ServiceProviderListResponse(List<ServiceProvider> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<ServiceProvider> getList() {
        return list;
    }

    public void setList(List<ServiceProvider> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
