package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ContentHubMainIconContent;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "contentHubM"})
public class ContentHubMainIconContentListResponse extends BaseResponse {

    @JsonProperty("contentHubM")
    private List<ContentHubMainIconContent> list;
    @JsonProperty("count")
    private int count;

    public ContentHubMainIconContentListResponse(List<ContentHubMainIconContent> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ContentHubMainIconContentListResponse(List<ContentHubMainIconContent> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<ContentHubMainIconContent> getList() {
        return list;
    }

    public void setList(List<ContentHubMainIconContent> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
