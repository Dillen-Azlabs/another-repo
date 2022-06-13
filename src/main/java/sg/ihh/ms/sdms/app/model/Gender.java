
package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "gender", "order", "publishFlag", "createdDt", "modifiedDt"})
public class Gender extends BaseModel {

    @JsonProperty("gender")
    private String gender;

    public Gender() {
        // Empty Constructor
    }

    public String getGender() {
        return gender;
    }

    @ColumnName("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

}
