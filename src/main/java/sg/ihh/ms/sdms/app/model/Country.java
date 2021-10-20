package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Country extends BaseModel {

    @JsonProperty("value")
    private String value;

    public Country() {
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
