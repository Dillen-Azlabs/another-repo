package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Hospital extends BaseModel {

    @JsonProperty("name")
    private String name;

    public Hospital() {
        // Empty Constructor
    }

    public String getName() {
        return name;
    }

    @ColumnName("name")
    public void setName(String name) {
        this.name = name;
    }


}
