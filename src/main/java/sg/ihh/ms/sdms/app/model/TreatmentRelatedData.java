package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "relatedConditions", "relatedTreatments", "order", "publishFlag", "createdDt", "modifiedDt"})
public class TreatmentRelatedData extends BaseModel {

    @JsonProperty("primaryTreatmentUid")
    private String primaryTreatmentUid;
    @JsonProperty("relatedConditions")
    private List<TreatmentRelatedDataCondition> relatedConditions;
    @JsonProperty("relatedTreatments")
    private List<TreatmentRelatedDataTreatment> relatedTreatments;


    public TreatmentRelatedData() {
        //Empty Constructor
    }

    public String getPrimaryTreatmentUid() {
        return primaryTreatmentUid;
    }

    public void setPrimaryTreatmentUid(String primaryTreatmentUid) {
        this.primaryTreatmentUid = primaryTreatmentUid;
    }

    public List<TreatmentRelatedDataCondition> getRelatedConditions() {
        return relatedConditions;
    }

    public void setRelatedConditions(List<TreatmentRelatedDataCondition> relatedConditions) {
        this.relatedConditions = relatedConditions;
    }

    public List<TreatmentRelatedDataTreatment> getRelatedTreatments() {
        return relatedTreatments;
    }

    public void setRelatedTreatments(List<TreatmentRelatedDataTreatment> relatedTreatments) {
        this.relatedTreatments = relatedTreatments;
    }
}
