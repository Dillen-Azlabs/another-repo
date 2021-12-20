package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "diagnosis", "diagnosisVideoUrl", "treatment","treatmentVideoUrl", "bodyContent", "bodyContentVideoUrl", "diagnosisMetaTitle", "diagnosisMetaDescription", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ConditionDiagnosis extends BaseModel{
    @JsonProperty("diagnosis")
    private String diagnosis;
    @JsonProperty("diagnosisVideoUrl")
    private String diagnosisVideoUrl;
    @JsonProperty("treatment")
    private String treatment;
    @JsonProperty("treatmentVideoUrl")
    private String treatmentVideoUrl;
    @JsonProperty("bodyContent")
    private String bodyContent;
    @JsonProperty("bodyContentVideoUrl")
    private String bodyContentVideoUrl;
    @JsonProperty("diagnosisMetaTitle")
    private String diagnosisMetaTitle;
    @JsonProperty("diagnosisMetaDescription")
    private String diagnosisMetaDesc;

    public ConditionDiagnosis() {
        //Empty Constructor
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosisVideoUrl() {
        return diagnosisVideoUrl;
    }

    public void setDiagnosisVideoUrl(String diagnosisVideoUrl) {
        this.diagnosisVideoUrl = diagnosisVideoUrl;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getTreatmentVideoUrl() {
        return treatmentVideoUrl;
    }

    public void setTreatmentVideoUrl(String treatmentVideoUrl) {
        this.treatmentVideoUrl = treatmentVideoUrl;
    }

    public String getBodyContent() {
        return bodyContent;
    }

    public void setBodyContent(String bodyContent) {
        this.bodyContent = bodyContent;
    }

    public String getBodyContentVideoUrl() {
        return bodyContentVideoUrl;
    }

    public void setBodyContentVideoUrl(String bodyContentVideoUrl) {
        this.bodyContentVideoUrl = bodyContentVideoUrl;
    }

    public String getDiagnosisMetaTitle() {
        return diagnosisMetaTitle;
    }

    @ColumnName("diagnosis_meta_title")
    public void setDiagnosisMetaTitle(String diagnosisMetaTitle) {
        this.diagnosisMetaTitle = diagnosisMetaTitle;
    }

    public String getDiagnosisMetaDesc() {
        return diagnosisMetaDesc;
    }
    @ColumnName("diagnosis_meta_desc")
    public void setDiagnosisMetaDesc(String diagnosisMetaDesc) {
        this.diagnosisMetaDesc = diagnosisMetaDesc;
    }
}
