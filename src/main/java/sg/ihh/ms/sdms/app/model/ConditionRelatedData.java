package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
@JsonPropertyOrder({"uid", "languageCode", "relatedTreatments", "relatedConditions", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ConditionRelatedData extends BaseModel{

    @JsonProperty("relatedTreatments")
    private List<ConditionRelatedDataTreatment> relatedTreatments;
    @JsonProperty("relatedConditions")
    private List<ConditionRelatedDataCondition> relatedConditions;

    public ConditionRelatedData() {
        //Empty Constructor
    }

    public List<ConditionRelatedDataTreatment> getRelatedTreatments() {
        return relatedTreatments;
    }

    public void setRelatedTreatments(List<ConditionRelatedDataTreatment> relatedTreatments) {
        this.relatedTreatments = relatedTreatments;
    }

    public List<ConditionRelatedDataCondition> getRelatedConditions() {
        return relatedConditions;
    }
    public void setRelatedCondition(List<ConditionRelatedDataCondition> relatedConditions) {
        this.relatedConditions = relatedConditions;
    }
}
