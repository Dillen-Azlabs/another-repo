package sg.ihh.ms.sdms.app.rest.model;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import sg.ihh.ms.sdms.app.model.Country;

public class CountryListResponse extends BaseResponse {

    @JsonProperty("countries")
    private List<Country> list;
    @JsonProperty("count")
    private int count;


    public CountryListResponse(List<Country> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public CountryListResponse(List<Country> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<Country> getList() {
        return list;
    }

    public void setList(List<Country> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
