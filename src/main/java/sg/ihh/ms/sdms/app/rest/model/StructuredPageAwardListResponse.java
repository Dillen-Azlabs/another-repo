package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageAward;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "awards"})
public class StructuredPageAwardListResponse extends BaseResponse {

    @JsonProperty("awards")
    private List<StructuredPageAward> list;
    @JsonProperty("count")
    private int count;

    public StructuredPageAwardListResponse(List<StructuredPageAward> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public StructuredPageAwardListResponse(List<StructuredPageAward> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<StructuredPageAward> getList() {
        return list;
    }

    public void setList(List<StructuredPageAward> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
