package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ContentHubMainCareAreaSpecialist;

@JsonPropertyOrder({"code", "message", "careAreaSpecialist"})
public class ContentHubMainCareAreaSpecialistListResponse extends BaseResponse{

    @JsonProperty("careAreaSpecialist")
    private ContentHubMainCareAreaSpecialist contentHubMainCareAreaSpecialist;

    public ContentHubMainCareAreaSpecialistListResponse(ContentHubMainCareAreaSpecialist contentHubMainCareAreaSpecialist) {
        super(HttpStatus.OK);
        this.contentHubMainCareAreaSpecialist = contentHubMainCareAreaSpecialist;
    }

    public ContentHubMainCareAreaSpecialist getContentHubMainCareAreaSpecialist() {
        return contentHubMainCareAreaSpecialist;
    }

    public void setContentHubMainCareAreaSpecialist(ContentHubMainCareAreaSpecialist contentHubMainCareAreaSpecialist) {
        this.contentHubMainCareAreaSpecialist = contentHubMainCareAreaSpecialist;
    }
}
