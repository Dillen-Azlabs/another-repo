package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredCampaignDetails;


@JsonPropertyOrder({"code", "message", "structuredCampaign"})
public class StructuredCampaignResponse extends BaseResponse {

    @JsonProperty("structuredCampaign")
    private StructuredCampaignDetails structuredCampaignDetails;

    public StructuredCampaignResponse(StructuredCampaignDetails structuredCampaignDetails) {
        super(HttpStatus.OK);
        this.structuredCampaignDetails = structuredCampaignDetails;
    }

    public StructuredCampaignDetails getStructuredCampaignDetails() {
        return structuredCampaignDetails;
    }

    public void setStructuredCampaignDetails(StructuredCampaignDetails structuredCampaignDetails) {
        this.structuredCampaignDetails = structuredCampaignDetails;
    }
}
