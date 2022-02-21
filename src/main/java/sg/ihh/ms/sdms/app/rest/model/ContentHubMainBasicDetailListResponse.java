package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ContentHubMainBasicDetail;

@JsonPropertyOrder({"code", "message", "contentHub"})
public class ContentHubMainBasicDetailListResponse extends BaseResponse{

    @JsonProperty("contentHub")
    private ContentHubMainBasicDetail contentHubMainBasicDetail;

    public ContentHubMainBasicDetailListResponse(ContentHubMainBasicDetail contentHubMainBasicDetail) {
        super(HttpStatus.OK);
        this.contentHubMainBasicDetail = contentHubMainBasicDetail;
    }

    public ContentHubMainBasicDetail getContentHubMainBasicDetail() {
        return contentHubMainBasicDetail;
    }

    public void setContentHubMainBasicDetail(ContentHubMainBasicDetail contentHubMainBasicDetail) {
        this.contentHubMainBasicDetail = contentHubMainBasicDetail;
    }
}
