package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageBodySection;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "bodySections"})
public class StructuredPageBodySectionListResponse extends BaseResponse {

    @JsonProperty("bodySections")
    private List<StructuredPageBodySection> list;
    @JsonProperty("count")
    private int count;

    public StructuredPageBodySectionListResponse(List<StructuredPageBodySection> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public StructuredPageBodySectionListResponse(List<StructuredPageBodySection> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<StructuredPageBodySection> getList() {
        return list;
    }

    public void setList(List<StructuredPageBodySection> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
