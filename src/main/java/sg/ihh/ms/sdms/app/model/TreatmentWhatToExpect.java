package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "howToPrepare", "howToPrepareVideoUrl", "whatToExpect", "whatToExpectVideoUrl", "careAndRecovery",  "order", "publishFlag", "createdDt", "modifiedDt"})
public class TreatmentWhatToExpect extends BaseModel{

    @JsonProperty("howToPrepare")
    private String howPrepare;
    @JsonProperty("howToPrepareVideoUrl")
    private String howPrepareVideoUrl;
    @JsonProperty("whatToExpect")
    private String whatExpect;
    @JsonProperty("whatToExpectVideoUrl")
    private String whatExpectVideoUrl;
    @JsonProperty("careAndRecovery")
    private String careRecovery;

    public TreatmentWhatToExpect() {
        //Empty Constructor
    }

    public String getHowPrepare() {
        return howPrepare;
    }

    public void setHowPrepare(String howPrepare) {
        this.howPrepare = howPrepare;
    }

    public String getHowPrepareVideoUrl() {
        return howPrepareVideoUrl;
    }

    public void setHowPrepareVideoUrl(String howPrepareVideoUrl) {
        this.howPrepareVideoUrl = howPrepareVideoUrl;
    }

    public String getWhatExpect() {
        return whatExpect;
    }

    public void setWhatExpect(String whatExpect) {
        this.whatExpect = whatExpect;
    }

    public String getWhatExpectVideoUrl() {
        return whatExpectVideoUrl;
    }

    public void setWhatExpectVideoUrl(String whatExpectVideoUrl) {
        this.whatExpectVideoUrl = whatExpectVideoUrl;
    }

    public String getCareRecovery() {
        return careRecovery;
    }

    public void setCareRecovery(String careRecovery) {
        this.careRecovery = careRecovery;
    }
}
