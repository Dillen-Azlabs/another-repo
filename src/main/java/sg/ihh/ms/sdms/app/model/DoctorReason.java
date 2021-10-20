package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "value", "order", "publishFlag", "createdDt", "modifiedDt"})
public class DoctorReason extends BaseModel {

    @JsonProperty("value")
    private String value;

    public DoctorReason() {
        // Empty Constructor
    }

    public String getValue() {
        return value;
    }

    @ColumnName("value")
    public void setValue(String value) {
        this.value = value;
    }

}
