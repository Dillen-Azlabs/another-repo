package sg.ihh.ms.sdms.app.rest.model;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sg.ihh.ms.sdms.app.model.Pac;

@JsonPropertyOrder({"code", "message", "country", "count", "pac"})
public class HPacListResponse extends BaseResponse {

    @JsonProperty("country")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String country;

    @JsonProperty("count")
    private int count;

    @JsonProperty("pac")
    private List<Pac> pacList;

    public HPacListResponse(List<Pac> pacList) {
        super(HttpStatus.OK);
        this.count = pacList.size();
        this.pacList = pacList;
    }

    public HPacListResponse(int count, List<Pac> pacList) {
        super(HttpStatus.OK);
        this.count = count;
        this.pacList = pacList;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Pac> getPacList() {
        return pacList;
    }

    public void setPacList(List<Pac> pacList) {
        this.pacList = pacList;
    }
}
