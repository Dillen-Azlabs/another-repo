package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "type", "order", "publishFlag", "createdDt", "modifiedDt"})
public class MedicalProfession extends BaseModel {

    @JsonProperty("type")
    private String type;

    public MedicalProfession() {
        // Empty Constructor
    }

    public String getType() {
        return type;
    }

    @ColumnName("type")
    public void setType(String type) {
        this.type = type;
    }


}
