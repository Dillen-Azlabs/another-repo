package sg.ihh.ms.sdms.app.rest.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.CentreServiceSubCta;
import sg.ihh.ms.sdms.app.model.ContentHubSubCta;

@JsonPropertyOrder({"code", "message", "ctaSection"})
public class CentreServiceSubCtaResponse extends BaseResponse{
    @JsonProperty("ctaSection")
    private CentreServiceSubCta centreServiceSubCta;

    public CentreServiceSubCtaResponse(CentreServiceSubCta centreServiceSubCta) {
        super(HttpStatus.OK);
        this.centreServiceSubCta = centreServiceSubCta;
    }

    public CentreServiceSubCta getCentreServiceSubCta() {
        return centreServiceSubCta;
    }

    public void setCentreServiceSubCta(CentreServiceSubCta centreServiceSubCta) {
        this.centreServiceSubCta = centreServiceSubCta;
    }
}
