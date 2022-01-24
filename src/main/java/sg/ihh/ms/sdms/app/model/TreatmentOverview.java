package sg.ihh.ms.sdms.app.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "overview", "overviewVideoUrl", "whyItsDone","whyItsDoneVideoUrl","whoShouldNotDoIt","riskOrComplications", "order", "publishFlag", "createdDt", "modifiedDt"})
public class TreatmentOverview extends BaseModel{
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("overviewVideoUrl")
    private String overviewVideoUrl;
    @JsonProperty("whyItsDone")
    private String whyItsDone;
    @JsonProperty("whyItsDoneVideoUrl")
    private String whyItsDoneUrl;
    @JsonProperty("whoShouldNotDoIt")
    private String whoShouldNotDoIt;
    @JsonProperty("riskOrComplications")
    private String riskComplication;


    public TreatmentOverview() {
        //Empty Constructor
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOverviewVideoUrl() {
        return overviewVideoUrl;
    }

    public void setOverviewVideoUrl(String overviewVideoUrl) {
        this.overviewVideoUrl = overviewVideoUrl;
    }

    public String getWhyItsDone() {
        return whyItsDone;
    }

    public void setWhyItsDone(String whyItsDone) {
        this.whyItsDone = whyItsDone;
    }



    public String getWhoShouldNotDoIt() {
        return whoShouldNotDoIt;
    }

    public void setWhoShouldNotDoIt(String whoShouldNotDoIt) {
        this.whoShouldNotDoIt = whoShouldNotDoIt;
    }

    public String getWhyItsDoneUrl() {
        return whyItsDoneUrl;
    }

    public void setWhyItsDoneUrl(String whyItsDoneUrl) {
        this.whyItsDoneUrl = whyItsDoneUrl;
    }

    public String getRiskComplication() {
        return riskComplication;
    }

    public void setRiskComplication(String riskComplication) {
        this.riskComplication = riskComplication;
    }
}
