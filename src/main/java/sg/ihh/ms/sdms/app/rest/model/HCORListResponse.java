package sg.ihh.ms.sdms.app.rest.model;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import sg.ihh.ms.sdms.app.model.CountryOfResidence;

public class HCORListResponse extends BaseResponse {
    @JsonProperty("countries")
    private List<CountryOfResidence> CORList;

    @JsonProperty("count")
    private int count;

    public HCORListResponse(List<CountryOfResidence> corList) {
        super(HttpStatus.OK);
        this.CORList = corList;
        this.count = corList.size();
    }

    public HCORListResponse(List<CountryOfResidence> corList, int count) {
        super(HttpStatus.OK);
        this.CORList = corList;
        this.count = count;
    }

    public List<CountryOfResidence> getCORList() {
        return CORList;
    }

    public void setCORList(List<CountryOfResidence> CORList) {
        this.CORList = CORList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
