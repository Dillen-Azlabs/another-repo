package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ContentHubMainAward;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "awards"})
public class ContentHubMainAwardListResponse extends BaseResponse {

    @JsonProperty("awards")
    private List<ContentHubMainAward> list;
    @JsonProperty("count")
    private int count;

    public ContentHubMainAwardListResponse(List<ContentHubMainAward> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ContentHubMainAwardListResponse(List<ContentHubMainAward> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<ContentHubMainAward> getList() {
        return list;
    }

    public void setList(List<ContentHubMainAward> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
