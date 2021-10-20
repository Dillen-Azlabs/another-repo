package sg.ihh.ms.sdms.app.rest.model;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import sg.ihh.ms.sdms.app.model.InsuranceProvider;

public class InsuranceProviderListResponse extends BaseResponse {

    @JsonProperty("insuranceProviders")
    private List<InsuranceProvider> list;

    @JsonProperty("count")
    private int count;


    public InsuranceProviderListResponse(List<InsuranceProvider> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public InsuranceProviderListResponse(List<InsuranceProvider> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<InsuranceProvider> getList() {
        return list;
    }

    public void setList(List<InsuranceProvider> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
