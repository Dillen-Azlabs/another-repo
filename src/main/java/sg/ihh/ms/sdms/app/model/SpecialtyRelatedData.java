package sg.ihh.ms.sdms.app.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.List;
@JsonPropertyOrder({"uid", "languageCode", "relatedTreatments", "relatedConditions", "order", "publishFlag", "createdDt", "modifiedDt"})
public class SpecialtyRelatedData extends BaseModel{

    @JsonProperty("uid")
    private String specialtyUid;
    @JsonProperty("relatedTreatments")
    private List<SpecialtyRelatedDataTreatment> relatedTreatments;
    @JsonProperty("relatedConditions")
    private List<SpecialtyRelatedDataCondition> relatedConditions;

    public SpecialtyRelatedData() {
        //Empty Constructor
    }

    public String getSpecialtyUid() {
        return specialtyUid;
    }
    @ColumnName("specialty_uid")
    public void setSpecialtyUid(String specialtyUid) {
        this.specialtyUid = specialtyUid;
    }

    public List<SpecialtyRelatedDataTreatment> getRelatedTreatments() {
        return relatedTreatments;
    }

    public void setRelatedTreatments(List<SpecialtyRelatedDataTreatment> relatedTreatments) {
        this.relatedTreatments = relatedTreatments;
    }

    public List<SpecialtyRelatedDataCondition> getRelatedConditions() {
        return relatedConditions;
    }

    public void setRelatedConditions(List<SpecialtyRelatedDataCondition> relatedConditions) {
        this.relatedConditions = relatedConditions;
    }
}
