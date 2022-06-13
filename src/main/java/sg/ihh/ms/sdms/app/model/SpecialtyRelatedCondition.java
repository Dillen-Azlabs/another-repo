package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "relatedConditionsContent", "relatedConditionsMeta", "relatedConditionsMetaDesc", "order", "publishFlag", "createdDt", "modifiedDt"})
public class SpecialtyRelatedCondition extends BaseModel{

    @JsonProperty("relatedConditionsContent")
    private String relatedConditionContent;
    @JsonProperty("relatedConditionsMeta")
    private String relatedConditionMetaTitle;
    @JsonProperty("relatedConditionsMetaDesc")
    private String relatedConditionMetaDesc;

    public SpecialtyRelatedCondition() {
        //Empty Constructor
    }

    public String getRelatedConditionContent() {
        return relatedConditionContent;
    }

    public void setRelatedConditionContent(String relatedConditionContent) {
        this.relatedConditionContent = relatedConditionContent;
    }

    public String getRelatedConditionMetaTitle() {
        return relatedConditionMetaTitle;
    }

    public void setRelatedConditionMetaTitle(String relatedConditionMetaTitle) {
        this.relatedConditionMetaTitle = relatedConditionMetaTitle;
    }

    public String getRelatedConditionMetaDesc() {
        return relatedConditionMetaDesc;
    }

    public void setRelatedConditionMetaDesc(String relatedConditionMetaDesc) {
        this.relatedConditionMetaDesc = relatedConditionMetaDesc;
    }
}
