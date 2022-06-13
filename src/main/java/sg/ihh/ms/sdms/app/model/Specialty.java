
package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "specialty", "order", "publishFlag", "createdDt", "modifiedDt"})
public class Specialty extends BaseModel {

    @JsonProperty("specialty")
    private String specialty;

    public Specialty() {
        // Empty Constructor
    }

    public String getSpecialty() {
        return specialty;
    }

    @ColumnName("specialty")
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

}
