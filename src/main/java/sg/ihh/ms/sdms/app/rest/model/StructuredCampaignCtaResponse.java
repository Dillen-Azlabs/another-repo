package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredCampaignCTA;

public class StructuredCampaignCtaResponse extends BaseResponse{
    @JsonProperty("ctaSection")
    private StructuredCampaignCTA campaignCTA;

    public StructuredCampaignCtaResponse(StructuredCampaignCTA campaignCTA) {
        super(HttpStatus.OK);
        this.campaignCTA = campaignCTA;
    }


    public StructuredCampaignCTA getCampaignCTA() {
        return campaignCTA;
    }

    public void setCampaignCTA(StructuredCampaignCTA campaignCTA) {
        this.campaignCTA = campaignCTA;
    }
}
