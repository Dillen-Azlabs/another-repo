package sg.ihh.ms.sdms.app.rest.model;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import sg.ihh.ms.sdms.app.model.ServiceProviderMeta;

import java.util.List;

public class ServiceProviderMetaListResponse extends BaseResponse{
    @JsonProperty("serviceProvidersMeta")
    private List<ServiceProviderMeta> list;
    @JsonProperty("count")
    private int count;


    public ServiceProviderMetaListResponse(List<ServiceProviderMeta> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ServiceProviderMetaListResponse(List<ServiceProviderMeta> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<ServiceProviderMeta> getList() {
        return list;
    }

    public void setList(List<ServiceProviderMeta> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
