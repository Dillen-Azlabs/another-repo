package sg.ihh.ms.sdms.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "displayEnquiryCta", "displayApptCta", "addCtaLabel", "addCtaUrl", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredCampaignCTA extends BaseModel {

    @JsonProperty("displayEnquiryCta")
    private boolean displayEnquiryCta;

    @JsonProperty("displayApptCta")
    private boolean displayAppointmentCta;

    @JsonProperty("addCtaLabel")
    private String addCtaLabel;

    @JsonProperty("addCtaUrl")
    private String addCtaUrl;

    @JsonIgnore
    private int order;

    public StructuredCampaignCTA() {
    }

    public boolean isDisplayEnquiryCta() {
        return displayEnquiryCta;
    }

    public void setDisplayEnquiryCta(boolean displayEnquiryCta) {
        this.displayEnquiryCta = displayEnquiryCta;
    }

    public boolean isDisplayAppointmentCta() {
        return displayAppointmentCta;
    }

    public void setDisplayAppointmentCta(boolean displayAppointmentCta) {
        this.displayAppointmentCta = displayAppointmentCta;
    }

    public String getAddCtaLabel() {
        return addCtaLabel;
    }

    public void setAddCtaLabel(String addCtaLabel) {
        this.addCtaLabel = addCtaLabel;
    }

    public String getAddCtaUrl() {
        return addCtaUrl;
    }

    public void setAddCtaUrl(String addCtaUrl) {
        this.addCtaUrl = addCtaUrl;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public void setOrder(int order) {
        this.order = order;
    }
}
