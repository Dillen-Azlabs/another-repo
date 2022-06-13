package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.CountryOfCare;

import java.util.List;

public class CountryOfCareResponse extends BaseResponse{

    @JsonProperty("countries")
    private List<CountryOfCare> list;
    @JsonProperty("count")
    private int count;

    public CountryOfCareResponse(List<CountryOfCare> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public CountryOfCareResponse(List<CountryOfCare> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<CountryOfCare> getList() {
        return list;
    }

    public void setList(List<CountryOfCare> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
