package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ContentHubMainCta;

@JsonPropertyOrder({"code", "message", "contentHub"})
public class ContentHubMainCtaListResponse extends BaseResponse{

    @JsonProperty("contentHub")
    private ContentHubMainCta contentHubMainCta;

    public ContentHubMainCtaListResponse(ContentHubMainCta contentHubMainCta) {
        super(HttpStatus.OK);
        this.contentHubMainCta = contentHubMainCta;
    }

    public ContentHubMainCta getContentHubMainCta() {
        return contentHubMainCta;
    }

    public void setContentHubMainCta(ContentHubMainCta contentHubMainCta) {
        this.contentHubMainCta = contentHubMainCta;
    }
}
