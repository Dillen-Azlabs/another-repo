package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.Pac;
import sg.ihh.ms.sdms.app.model.Treatment;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "country", "displayName", "pac"})
public class PacListResponse extends BaseResponse {

    @JsonProperty("pac")
    private List<Pac> list;
    @JsonProperty("count")
    private int count;
    @JsonProperty("country")
    private String country;
    @JsonProperty("displayName")
    private String displayName;

    public PacListResponse(List<Pac> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public PacListResponse(List<Pac> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }


    public List<Pac> getList() {
        return list;
    }

    public void setList(List<Pac> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
