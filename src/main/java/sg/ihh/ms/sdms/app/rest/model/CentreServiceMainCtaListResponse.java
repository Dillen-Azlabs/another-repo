package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.CentreServiceMainCta;

@JsonPropertyOrder({"code", "message", "centreService"})
public class CentreServiceMainCtaListResponse extends BaseResponse{
    @JsonProperty("centreService")
    private CentreServiceMainCta centreServiceMainCta;

    public CentreServiceMainCtaListResponse(CentreServiceMainCta centreServiceMainCta) {
        super(HttpStatus.OK);
        this.centreServiceMainCta = centreServiceMainCta;
    }

    public CentreServiceMainCta getCentreServiceMainCta() {
        return centreServiceMainCta;
    }

    public void setCentreServiceMainCta(CentreServiceMainCta centreServiceMainCta) {
        this.centreServiceMainCta = centreServiceMainCta;
    }
}
