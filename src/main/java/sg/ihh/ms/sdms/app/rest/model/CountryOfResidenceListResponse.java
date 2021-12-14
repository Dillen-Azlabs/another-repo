package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.CountryOfResidence;


import java.util.List;

public class CountryOfResidenceListResponse extends BaseResponse{
    @JsonProperty("countries")
    private List<CountryOfResidence> list;
    @JsonProperty("count")
    private int count;


    public CountryOfResidenceListResponse(List<CountryOfResidence> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public CountryOfResidenceListResponse(List<CountryOfResidence> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<CountryOfResidence> getList() {
        return list;
    }

    public void setList(List<CountryOfResidence> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
