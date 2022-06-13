package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ContentHubSubBodySection;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "bodySections"})
public class ContentHubSubBodySectionListResponse extends BaseResponse{

    @JsonProperty("bodySections")
    private List<ContentHubSubBodySection> list;
    @JsonProperty("count")
    private int count;

    public ContentHubSubBodySectionListResponse(List<ContentHubSubBodySection> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ContentHubSubBodySectionListResponse(List<ContentHubSubBodySection> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }
}
