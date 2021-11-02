
package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "treatment", "order", "publishFlag", "createdDt", "modifiedDt"})
public class Treatment extends BaseModel {

    @JsonProperty("treatment")
    private String value;

    public Treatment() {
        // Empty Constructor
    }

    public String getValue() {
        return value;
    }

    @ColumnName("treatment")
    public void setValue(String value) {
        this.value = value;
    }

}
