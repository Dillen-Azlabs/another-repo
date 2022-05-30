package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredCampaignCTASection;

public class StructuredCampaignCTASectionResponse extends BaseResponse{

    @JsonProperty("ctaSection")
    private StructuredCampaignCTASection campaignCTASection;

    public StructuredCampaignCTASectionResponse(StructuredCampaignCTASection campaignCTASection) {
        super(HttpStatus.OK);
        this.campaignCTASection = campaignCTASection;
    }

    public StructuredCampaignCTASection getCampaignCTASection() {
        return campaignCTASection;
    }

    public void setCampaignCTASection(StructuredCampaignCTASection campaignCTASection) {
        this.campaignCTASection = campaignCTASection;
    }
}
