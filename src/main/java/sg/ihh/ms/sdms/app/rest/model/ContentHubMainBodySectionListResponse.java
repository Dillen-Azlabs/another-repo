package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ContentHubMainBodySection;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "bodySections"})
public class ContentHubMainBodySectionListResponse extends BaseResponse {

    @JsonProperty("bodySections")
    private List<ContentHubMainBodySection> list;
    @JsonProperty("count")
    private int count;

    public ContentHubMainBodySectionListResponse(List<ContentHubMainBodySection> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ContentHubMainBodySectionListResponse(List<ContentHubMainBodySection> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<ContentHubMainBodySection> getList() {
        return list;
    }

    public void setList(List<ContentHubMainBodySection> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
