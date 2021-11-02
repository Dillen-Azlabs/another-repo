package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "conditionDisease", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ConditionDisease extends BaseModel {

    @JsonProperty("conditionDisease")
    private String value;

    public ConditionDisease() {
        // Empty Constructor
    }

    public String getValue() {
        return value;
    }

    @ColumnName("condition_disease")
    public void setValue(String value) {
        this.value = value;
    }

}
