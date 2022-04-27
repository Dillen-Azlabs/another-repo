package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ContentHubMainItem;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count","contentHubMList"})
public class ContentHubMainItemListResponse extends BaseResponse {

    @JsonProperty("contentHubMList")
    private List<ContentHubMainItem> list;
    @JsonProperty("count")
    private int count;

    public ContentHubMainItemListResponse(List<ContentHubMainItem> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ContentHubMainItemListResponse(List<ContentHubMainItem> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<ContentHubMainItem> getList() {
        return list;
    }

    public void setList(List<ContentHubMainItem> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
