package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ContentHubMain;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count","contentHubMList"})
public class ContentHubMainsListResponse extends BaseResponse {

    @JsonProperty("contentHubMList")
    private List<ContentHubMain> list;
    @JsonProperty("count")
    private int count;

    public ContentHubMainsListResponse(List<ContentHubMain> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ContentHubMainsListResponse(List<ContentHubMain> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<ContentHubMain> getList() {
        return list;
    }

    public void setList(List<ContentHubMain> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
