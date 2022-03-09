package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ContentHubSubCta;

@JsonPropertyOrder({"code", "message", "contentHub"})
public class ContentHubSubCtaListResponse extends BaseResponse{

    @JsonProperty("contentHub")
    private ContentHubSubCta contentHubSubCta;

    public ContentHubSubCtaListResponse(ContentHubSubCta contentHubSubCta) {
        super(HttpStatus.OK);
        this.contentHubSubCta = contentHubSubCta;
    }

    public ContentHubSubCta getContentHubSubCta() {
        return contentHubSubCta;
    }

    public void setContentHubSubCta(ContentHubSubCta contentHubSubCta) {
        this.contentHubSubCta = contentHubSubCta;
    }
}
