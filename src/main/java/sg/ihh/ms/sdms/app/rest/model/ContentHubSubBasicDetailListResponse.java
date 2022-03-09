package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ContentHubSubBasicDetail;

@JsonPropertyOrder({"code", "message", "contentHub"})
public class ContentHubSubBasicDetailListResponse extends BaseResponse{

    @JsonProperty("contentHub")
    private ContentHubSubBasicDetail contentHubSubBasicDetail;

    public ContentHubSubBasicDetailListResponse(ContentHubSubBasicDetail contentHubSubBasicDetail) {
        super(HttpStatus.OK);
        this.contentHubSubBasicDetail = contentHubSubBasicDetail;
    }

    public ContentHubSubBasicDetail getContentHubSubBasicDetail() {
        return contentHubSubBasicDetail;
    }

    public void setContentHubSubBasicDetail(ContentHubSubBasicDetail contentHubSubBasicDetail) {
        this.contentHubSubBasicDetail = contentHubSubBasicDetail;
    }
}
