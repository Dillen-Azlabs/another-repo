package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "overview", "overviewVideoUrl", "symptoms","symptomsVideoUrl", "noteHighlight", "causes", "causesVideoUrl", "riskFactors", "complications", "prevention", "symptomsMetaTitle", "symptomsMetaDescription", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ConditionSymptom extends BaseModel{

    @JsonProperty("overview")
    private String overview;
    @JsonProperty("overviewVideoUrl")
    private String overviewVideoUrl;
    @JsonProperty("symptoms")
    private String symptom;
    @JsonProperty("symptomsVideoUrl")
    private String symptomVideoUrl;
    @JsonProperty("noteHighlight")
    private String noteHighlight;
    @JsonProperty("causes")
    private String cause;
    @JsonProperty("causesVideoUrl")
    private String causeVideoUrl;
    @JsonProperty("riskFactors")
    private String riskFactor;
    @JsonProperty("complications")
    private String complication;
    @JsonProperty("prevention")
    private String prevention;
    @JsonProperty("symptomsMetaTitle")
    private String symptomsMetaTitle;
    @JsonProperty("symptomsMetaDescription")
    private String symptomsMetaDesc;

    public ConditionSymptom() {
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

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getSymptomVideoUrl() {
        return symptomVideoUrl;
    }

    public void setSymptomVideoUrl(String symptomVideoUrl) {
        this.symptomVideoUrl = symptomVideoUrl;
    }

    public String getNoteHighlight() {
        return noteHighlight;
    }

    public void setNoteHighlight(String noteHighlight) {
        this.noteHighlight = noteHighlight;
    }

    public String getPrevention() {
        return prevention;
    }

    public void setPrevention(String prevention) {
        this.prevention = prevention;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getCauseVideoUrl() {
        return causeVideoUrl;
    }

    public void setCauseVideoUrl(String causeVideoUrl) {
        this.causeVideoUrl = causeVideoUrl;
    }

    public String getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(String riskFactor) {
        this.riskFactor = riskFactor;
    }

    public String getComplication() {
        return complication;
    }

    public void setComplication(String complication) {
        this.complication = complication;
    }

    public String getSymptomsMetaTitle() {
        return symptomsMetaTitle;
    }

    public void setSymptomsMetaTitle(String symptomsMetaTitle) {
        this.symptomsMetaTitle = symptomsMetaTitle;
    }

    public String getSymptomsMetaDesc() {
        return symptomsMetaDesc;
    }

    public void setSymptomsMetaDesc(String symptomsMetaDesc) {
        this.symptomsMetaDesc = symptomsMetaDesc;
    }
}
