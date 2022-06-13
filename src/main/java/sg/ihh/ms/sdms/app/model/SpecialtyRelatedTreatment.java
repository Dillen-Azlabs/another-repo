package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "relatedTreatmentsContent", "relatedTreatmentsMeta", "relatedTreatmentsMetaDesc", "order", "publishFlag", "createdDt", "modifiedDt"})
public class SpecialtyRelatedTreatment extends BaseModel{

    @JsonProperty("relatedTreatmentsContent")
    private String relatedTreatmentContent;
    @JsonProperty("relatedTreatmentsMeta")
    private String relatedTreatmentMetaTitle;
    @JsonProperty("relatedTreatmentsMetaDesc")
    private String relatedTreatmentMetaDesc;

    public SpecialtyRelatedTreatment() {
        //Empty Constructor
    }

    public String getRelatedTreatmentContent() {
        return relatedTreatmentContent;
    }

    public void setRelatedTreatmentContent(String relatedTreatmentContent) {
        this.relatedTreatmentContent = relatedTreatmentContent;
    }

    public String getRelatedTreatmentMetaTitle() {
        return relatedTreatmentMetaTitle;
    }

    public void setRelatedTreatmentMetaTitle(String relatedTreatmentMetaTitle) {
        this.relatedTreatmentMetaTitle = relatedTreatmentMetaTitle;
    }

    public String getRelatedTreatmentMetaDesc() {
        return relatedTreatmentMetaDesc;
    }

    public void setRelatedTreatmentMetaDesc(String relatedTreatmentMetaDesc) {
        this.relatedTreatmentMetaDesc = relatedTreatmentMetaDesc;
    }
}
